package com.example.spotify_cloneapp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.spotify_cloneapp.APIs.Service;
import com.example.spotify_cloneapp.Models.Song;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MusicPlayerActivity extends AppCompatActivity {
    private Song song;
    int position = 0;
    private TextView albumName, songName, artistName, lyrics, durationPlayed, durationTotal;
    private ImageView imgSong, playPauseBtn, nextBtn, prevBtn;
    private SeekBar seekBar;
    static MediaPlayer mediaPlayer;
    private Handler handler = new Handler();
    private Thread playThread;
    private ImageView imgBack;
    private boolean isContinue = false;
    private boolean apiCalled = false;
    private MusicService musicService;
    private boolean isServiceBound;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MusicService.LocalBinder binder = (MusicService.LocalBinder) service;
            musicService = binder.getService();
            isServiceBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isServiceBound = false;
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, MusicService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (isServiceBound) {
            unbindService(serviceConnection);
            isServiceBound = false;
        }
    }


    private List<Song> queue;
    private Runnable updateSeekBar = new Runnable() {
        @Override
        public void run() {
            if (mediaPlayer != null) {
                int mCurrentPosition = mediaPlayer.getCurrentPosition() / 1000;
                seekBar.setProgress(mCurrentPosition);
                durationPlayed.setText(formattedTime(mCurrentPosition));
            }
            handler.postDelayed(this, 1000);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musicplayer_view);
        loadComponent();

        serviceConnection=new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                MusicService.LocalBinder binder=(MusicService.LocalBinder) service;
                musicService=binder.getService();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };

        Intent intent = getIntent();
        if (intent != null) {
            if("ACTION_PREVIOUS".equals(intent.getAction())){
                prevSong();
            }
            else if("ACTION_NEXT".equals(intent.getAction())){
                nextSong();
            }
            else {
                int idSong = intent.getIntExtra("idSong", position);
                String albumName = intent.getStringExtra("albumName");
                isContinue=intent.getBooleanExtra("isContinue",false);

                this.albumName.setText(albumName);
                queue = getQueue(albumName);
                if (!apiCalled) {
                    Service.api.getSongsById(idSong).enqueue(new Callback<List<Song>>() {
                        @Override
                        public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                            if(response.body().size()>0) {
                                if(song==null){
                                    song = response.body().get(position);
                                }
                                loadData();
                                getMusicPlayer(isContinue);
                                createService(song);
                                apiCalled = true;
                            }
                        }
                        @Override
                        public void onFailure(Call<List<Song>> call, Throwable t) {

                        }
                    });
                    if(queue==null){
                        queue=new ArrayList<>();
                        queue.add(song);
                    }
                    if(queue.size()>1){
                        for (int i = 0; i < queue.size(); i++) {
                            if (queue.get(i).getID_Song() == idSong) {
                                song = queue.get(i);
                                break;
                            }
                        }
                    }
                }

                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if (fromUser && mediaPlayer != null) {
                            mediaPlayer.seekTo(progress * 1000);
                        }
                        if(progress==seekBar.getMax()){
                            nextSong();
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
            }

        }

    }

    @Override
    protected void onResume() {
        playThreadBtn();
        super.onResume();
    }

    public List<Song> getQueue(String key) {
        SharedPreferences prefs = getSharedPreferences(key, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString(key, null);
        Type type = new TypeToken<List<Song>>() {
        }.getType();
        return gson.fromJson(json, type);
    }

    private void setBtnNextandPre() {
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextSong();
            }
        });
        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prevSong();
            }
        });
    }

    private void playThreadBtn() {
        playThread = new Thread() {
            @Override
            public void run() {
                super.run();
                playPauseBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        playPauseBtnClicked();
                    }
                });
            }
        };
        playThread.start();
    }

    private void playPauseBtnClicked() {
        if (mediaPlayer.isPlaying()) {
            playPauseBtn.setImageResource(R.drawable.play2_icon);
            musicService.pauseMusic();
            seekBar.setMax(mediaPlayer.getDuration() / 1000);
            MusicPlayerActivity.this.runOnUiThread(updateSeekBar);
        } else {
            playPauseBtn.setImageResource(R.drawable.pause_icon);
            musicService.continueMusic();
            seekBar.setMax(mediaPlayer.getDuration() / 1000);
            MusicPlayerActivity.this.runOnUiThread(updateSeekBar);
        }


    }

    private void createService(Song song) {
        Intent intent = new Intent(this, MusicService.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("song", song);
        intent.putExtras(bundle);
        startService(intent);
    }

    protected void loadComponent() {
        albumName = findViewById(R.id.MV_txtAlbumName);
        imgSong = findViewById(R.id.MV_imgSong);
        songName = findViewById(R.id.MV_txtNameSong);
        artistName = findViewById(R.id.MV_txtNameArtist);
        lyrics = findViewById(R.id.MV_playlist);
        playPauseBtn = findViewById(R.id.MV_playIcon);
        nextBtn = findViewById(R.id.MV_nextIcon);
        prevBtn = findViewById(R.id.MV_prevIcon);
        seekBar = findViewById(R.id.MV_seekBar);
        durationPlayed = findViewById(R.id.MV_durationPlayed);
        durationTotal = findViewById(R.id.MV_durationTotal);
        lyrics.setMovementMethod(new ScrollingMovementMethod());
        imgBack = findViewById(R.id.MV_iconBack);
        setBtnNextandPre();
        setImgBack();

    }

    private void setImgBack() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle=new Bundle();
                bundle.putSerializable("curSong",song);
                if(albumName.getText().toString().length()!=0){
                    bundle.putString("albumName",albumName.getText().toString());
                }
                intent.putExtras(bundle);
                setResult(118, intent);
                finish();
            }
        });
    }
    private void nextSong() {
        int pos = queue.indexOf(song) + 1;
        pos %= queue.size();
        song = queue.get(pos);
        loadData();
        getMusicPlayer(false);
        createService(song);
    }

    private void prevSong() {
        int pos = queue.indexOf(song) - 1;
        pos = pos == -1 ? queue.size() - 1 : pos % queue.size();
        song = queue.get(pos);
        loadData();
        getMusicPlayer(false);
        createService(song);
    }

    protected void loadData() {
        songName.setText(this.song.getNameSong());
        artistName.setText(this.song.getNameArtist());
        if (this.song.getThumbnail() != null) {
            Picasso.get().load(this.song.getThumbnail()).placeholder(R.drawable.hinhnen).into(imgSong);
        }
        lyrics.setText(this.song.getLyrics());
        lyrics.invalidate();
    }

    protected void getMusicPlayer(boolean isContinue) {
        if(isContinue){
            mediaPlayer = musicService.getMusicPlayer();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    seekBar.setMax(mediaPlayer.getDuration() / 1000);
                    MusicPlayerActivity.this.runOnUiThread(updateSeekBar);
                    handler.postDelayed(updateSeekBar, 0);
                }
            });
        }
        else {
            mediaPlayer = musicService.getMusicPlayer(song);
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mediaPlayer.start();
                    seekBar.setMax(mediaPlayer.getDuration() / 1000);
                    MusicPlayerActivity.this.runOnUiThread(updateSeekBar);
                    handler.postDelayed(updateSeekBar, 0); // Start updating the SeekBar
                }
            });


        }
        durationTotal.setText(song.getDuration());
        MusicPlayerActivity.this.runOnUiThread(updateSeekBar);

    }

    private String formattedTime(int mCurrentPosition) {
        String totalOut = "";
        String totalNew = "";
        String seconds = String.valueOf(mCurrentPosition % 60);
        String minutes = String.valueOf(mCurrentPosition / 60);
        totalOut = minutes + ":" + seconds;
        totalNew = minutes + ":0" + seconds;

        if (seconds.length() == 1) {
            return totalNew;
        } else {
            return totalOut;
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        Bundle bundle=new Bundle();
        bundle.putSerializable("curSong",song);
        if(albumName.getText().toString().length()!=0){
            bundle.putString("albumName",albumName.getText().toString());
        }
        intent.putExtras(bundle);
        setResult(118, intent);
        super.onBackPressed();
    }
}
