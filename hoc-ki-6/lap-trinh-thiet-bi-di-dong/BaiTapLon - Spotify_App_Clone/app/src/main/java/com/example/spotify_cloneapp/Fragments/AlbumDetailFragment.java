package com.example.spotify_cloneapp.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spotify_cloneapp.APIs.Service;
import com.example.spotify_cloneapp.Adapters.SongAdapter;
import com.example.spotify_cloneapp.Models.Album;
import com.example.spotify_cloneapp.Models.Song;
import com.example.spotify_cloneapp.MusicPlayerActivity;
import com.example.spotify_cloneapp.R;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AlbumDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlbumDetailFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Album album;
    private ImageView albumImageView;
    private RecyclerView songsOfAlbumRV;
    private SongAdapter songsOfAlbumAdapter;
    private TextView albumNameTV;
    private TextView albumDescriptionTV;
    private ImageView playAllSongs;
    public AlbumDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AlbumDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AlbumDetailFragment newInstance(String param1, String param2) {
        AlbumDetailFragment fragment = new AlbumDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            int idAlbum = getArguments().getInt("idAlbum", 0);
            // Sử dụng idAlbum để lấy dữ liệu album và bài hát
            loadAlbumData(idAlbum);
            loadSongsData(idAlbum);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_album_detail, container, false);
        loadComponent(v);
        return v;
    }

    private void loadAlbumData(int idAlbum) {
        Service.api.getAlbumById(idAlbum).enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                if(response.body().size() > 0) {
                    album = response.body().get(0);
                    loadData();
                }
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {
                // Xử lý lỗi
            }
        });
    }

    private void loadSongsData(int idAlbum) {
        Service.api.getSongsByAlbum(idAlbum).enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                List<Song> songs = response.body();
                songsOfAlbumAdapter.setSongList(songs);
                saveQueueofSongs(songs);
                songsOfAlbumAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {
                // Xử lý lỗi
            }
        });
    }

    public void setPlayAllSongs(){
        playAllSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), MusicPlayerActivity.class);
                intent.putExtra("idSong",songsOfAlbumAdapter.getSongList().get(0).getID_Song());
                intent.putExtra("albumName",album.getName());
                getActivity().startActivityForResult(intent,103);
            }
        });
    }
    protected void loadComponent(View view){
        albumImageView=view.findViewById(R.id.imgViewAlbum);
        songsOfAlbumRV=view.findViewById(R.id.idRVSongs);
        albumNameTV=view.findViewById(R.id.txtAlbumName);
        albumDescriptionTV=view.findViewById(R.id.txtArtistName);
        playAllSongs=view.findViewById(R.id.idFaPlay); // Sửa lại ID của ImageView
        songsOfAlbumAdapter=new SongAdapter();

        songsOfAlbumRV.setAdapter(songsOfAlbumAdapter);
        songsOfAlbumAdapter.setContext(getActivity());

        setPlayAllSongs();
    }
    protected void loadData(){
        albumNameTV.setText(this.album.getName());
        albumDescriptionTV.setText(this.album.getDescription());
        if(this.album.getThumbnail()!=null){
            Picasso.get().load(this.album.getThumbnail()).into(albumImageView);
        }
        songsOfAlbumAdapter.setAlbumName(album.getName());

    }
    private void saveQueueofSongs(List<Song> list){
        if (getActivity() != null && album != null) {
            SharedPreferences prefs = getActivity().getSharedPreferences(album.getName(), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            Gson gson = new Gson();
            String json = gson.toJson(list);
            editor.putString(album.getName(), json);
            editor.apply();
        } else {
            Toast.makeText(getActivity(), "Album null", Toast.LENGTH_SHORT).show();
        }
    }

}