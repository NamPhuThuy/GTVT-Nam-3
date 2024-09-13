package com.example.spotify_cloneapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.spotify_cloneapp.APIs.Service;
import com.example.spotify_cloneapp.Adapters.AlbumAdapter;
import com.example.spotify_cloneapp.Adapters.SongAdapter;
import com.example.spotify_cloneapp.Models.Album;
import com.example.spotify_cloneapp.Models.Song;
import com.example.spotify_cloneapp.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private EditText searchEditText;
    private RecyclerView searchSongRV;
    private RecyclerView searchAlbumRV;
    private SongAdapter songAdapter;
    private AlbumAdapter albumAdapter;
    private List<Song> songList;
    private List<Album> albumList;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public SearchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
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
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_search, container, false);
        loadComponents(v);
        return v;
    }
    private void loadComponents(View v){
        searchEditText = v.findViewById(R.id.idEdtSearch);
        searchSongRV = v.findViewById(R.id.idRVSongs);
        searchAlbumRV = v.findViewById(R.id.idRVAblums);
        songAdapter = new SongAdapter();
        songAdapter.setContext(getActivity());
        albumAdapter = new AlbumAdapter();


        songList = songAdapter.getSongList();
        albumList = albumAdapter.getAlbumList();


        searchSongRV.setAdapter(songAdapter);
        searchAlbumRV.setAdapter(albumAdapter);

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                songAdapter.notifyDataSetChanged();
                albumAdapter.notifyDataSetChanged();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                songAdapter.notifyDataSetChanged();
                albumAdapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable s) {
                String searchText = searchEditText.getText().toString();
                songList.clear();
                albumList.clear();
                if(!searchText.isEmpty()){
                    System.out.println(searchText);

                    Service.api.getSongByName(searchText).enqueue(new Callback<List<Song>>() {
                        @Override
                        public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                            if(response.body()!=null){
                                System.out.println(response.body().size());
                                songList.addAll(response.body());
                                songAdapter.notifyDataSetChanged();
                            }
                        }

                        @Override
                        public void onFailure(Call<List<Song>> call, Throwable t) {

                        }
                    });
                    Service.api.getAlbumByName(searchText).enqueue(new Callback<List<Album>>() {
                        @Override
                        public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                            if(response.body()!=null){
                                albumList.addAll(response.body());
                                albumAdapter.notifyDataSetChanged();
                            }
                        }

                        @Override
                        public void onFailure(Call<List<Album>> call, Throwable t) {

                        }
                    });
                }
            }
        });
    }
}