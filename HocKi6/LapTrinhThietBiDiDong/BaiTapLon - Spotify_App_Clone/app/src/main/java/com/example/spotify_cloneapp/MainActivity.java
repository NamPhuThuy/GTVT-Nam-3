package com.example.spotify_cloneapp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.Manifest;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.spotify_cloneapp.APIs.Service;
import com.example.spotify_cloneapp.Database.PlayListDB;
import com.example.spotify_cloneapp.Database.PlaylistSongDB;
import com.example.spotify_cloneapp.Fragments.AlbumDetailFragment;
import com.example.spotify_cloneapp.Fragments.FavoriteFragment;
import com.example.spotify_cloneapp.Fragments.HomeFragment;
import com.example.spotify_cloneapp.Fragments.SearchFragment;
import com.example.spotify_cloneapp.Models.Album;
import com.example.spotify_cloneapp.Models.Playlist;
import com.example.spotify_cloneapp.Models.Song;
import com.example.spotify_cloneapp.databinding.ActivityMainBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    final int MENU_HOME_ID = R.id.mnuHome;
    final int MENU_SEARCH_ID = R.id.mnuSearch;
    final int MENU_FAVOURITE_ID = R.id.mnuFavorite;
    ActivityMainBinding binding;
    private HomeFragment homeFragment;
    private SearchFragment searchFragment;
    private FavoriteFragment favoriteFragment;
    private AlbumDetailFragment albumDetailFragment;
    private static final int PERMISSION_REQUEST_CODE = 1001;
    private RelativeLayout layoutPlayerBottom;
    private ImageView imgSong, iconLove, iconPlay;
    private TextView txtSongName, txtSongArtist;
    AudioManager audioManager;
    PlayListDB playlisttbl;
    PlaylistSongDB playlistSongtbl;
    private Song currentSong;
    private String albumName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        homeFragment= new HomeFragment();
        loadDataRecommendAlbum();
        replaceFragment(homeFragment);

        searchFragment=new SearchFragment();
        favoriteFragment=new FavoriteFragment();

        // Bottom Navigation View
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == MENU_HOME_ID) {
                loadDataRecommendAlbum();
                homeFragment.notifyDataChange();
                replaceFragment(homeFragment);
            }
            if (itemId == MENU_SEARCH_ID) {
                replaceFragment(searchFragment);
            }
            if (itemId == MENU_FAVOURITE_ID) {
                replaceFragment(favoriteFragment);
            }
            return true;
        });

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.FOREGROUND_SERVICE,
                        Manifest.permission.POST_NOTIFICATIONS}, PERMISSION_REQUEST_CODE);

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        setupPlayerBottom();
        InitDB();
    }

    private void InitDB() {
        playlisttbl = new PlayListDB(this,"playlist", null, 1);
        playlistSongtbl = new PlaylistSongDB(this, "playlistSong", null, 1);

        //add playlist
//        playlisttbl.addPlaylist(new Playlist(1, "My playlist1", "Nhạc nhẹ", ""));
//        playlisttbl.addPlaylist(new Playlist(2, "My playlist2", "Nhạc nấu cơm", ""));
//        playlisttbl.addPlaylist(new Playlist(3, "My playlist3", "Nhạc nghe vui", ""));

//        playlistSongtbl.AddSongIntoPlaylist(8, 1);
//        playlistSongtbl.AddSongIntoPlaylist(9, 1);
//        playlistSongtbl.AddSongIntoPlaylist(11, 1);
//        playlistSongtbl.AddSongIntoPlaylist(11, 2);
//        playlistSongtbl.AddSongIntoPlaylist(15, 2);

        ArrayList<Playlist> playlists = playlisttbl.getAllPlaylist();
        for (Playlist p: playlists){
            System.out.println(p.getName());
        }
        ArrayList<Integer> index = playlistSongtbl.getAllSongInPlaylist(1);
        for (int i : index){
            System.out.println(i);
        }
    }

    private void setupPlayerBottom() {
        layoutPlayerBottom = findViewById(R.id.layout_player_bottom);
        imgSong = findViewById(R.id.imgSong);
        iconLove = findViewById(R.id.iconLove);
        iconPlay = findViewById(R.id.iconPlay);
        txtSongName = findViewById(R.id.txtSongName);
        txtSongArtist = findViewById(R.id.txtSongArtist);

        iconPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (audioManager.isMusicActive()) {
                    // Tạm ngừng phát nhạc
                    Intent pauseIntent = new Intent(getApplicationContext(), MusicService.class);
                    pauseIntent.setAction("com.example.spotify_cloneapp.ACTION_PAUSE_MUSIC");
                    startService(pauseIntent);
                    iconPlay.setImageResource(R.drawable.play_icon);
                } else {
                    Intent continueIntent = new Intent(getApplicationContext(), MusicService.class);
                    continueIntent.setAction("com.example.spotify_cloneapp.ACTION_CONTINUE_MUSIC");
                    startService(continueIntent);
                    iconPlay.setImageResource(R.drawable.pause2_icon);
                }
            }
        });

        layoutPlayerBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // MusicService không phát nhạc, khởi động MusicPlayerActivity
                Intent intent = new Intent(v.getContext(), MusicPlayerActivity.class);
                intent.putExtra("idSong",currentSong.getID_Song());
                intent.putExtra("albumName", albumName);
                intent.putExtra("isContinue",true);
                startActivityForResult(intent,103);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        updatePlayerVisibility();
    }

    private void updatePlayerVisibility() {
        if (audioManager != null && audioManager.isMusicActive()) {
            layoutPlayerBottom.setVisibility(View.VISIBLE);
            iconPlay.setImageResource(R.drawable.pause2_icon);
        } else {
            layoutPlayerBottom.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_REQUEST_CODE) {
            // Xử lý phản hồi từ yêu cầu quyền ở đây
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }

    private void loadDataRecommendAlbum() {

        Service.api.getAllAlbum().enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                if(response.isSuccessful()){
                    List<Album> data= response.body();
                    homeFragment.loadData(data);
                    homeFragment.notifyDataChange();
                }
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent intent = new Intent(this, MusicService.class);
        stopService(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==118 && requestCode==103){
            Bundle bundle= data.getExtras();
            if(bundle!=null) {
                currentSong= (Song) bundle.getSerializable("curSong");
                if(currentSong!=null){
                    txtSongName.setText(currentSong.getNameSong());
                    txtSongArtist.setText(currentSong.getNameArtist());
                    Picasso.get().load(currentSong.getThumbnail()).into(imgSong);

                }
                albumName= data.getStringExtra("albumName");
            }
        }
    }
    public void callAlbumDetailFragment(int idAlbum){
        albumDetailFragment=new AlbumDetailFragment();
        Bundle bundle=new Bundle();
        bundle.putInt("idAlbum",idAlbum);
        albumDetailFragment.setArguments(bundle);
        replaceFragment(albumDetailFragment);
    }
}