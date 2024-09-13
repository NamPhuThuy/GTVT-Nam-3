package com.example.spotify_cloneapp.Fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.spotify_cloneapp.APIs.Service;
import com.example.spotify_cloneapp.Adapters.AlbumAdapter;
import com.example.spotify_cloneapp.MainActivity;
import com.example.spotify_cloneapp.Models.Album;
import com.example.spotify_cloneapp.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private CircleImageView avatar;

    private Service service;
    private RecyclerView recommendedAlbumRView;
    private RecyclerView popularAlbumRView;
    private RecyclerView trendingAlbum;

    private AlbumAdapter recommendedAlbumAdapter;
    private AlbumAdapter popularAlbumAdapter;
    private AlbumAdapter trendingAlbumAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        this.loadComponent(view);
        // Inflate the layout for this fragment
        return view;

    }

    public void loadComponent(View view){
        recommendedAlbumRView =view.findViewById(R.id.idRVAlbums);
        popularAlbumRView =view.findViewById(R.id.idRVPopularAlbums);
        trendingAlbum =view.findViewById(R.id.idRVTrendingAlbums);

        recommendedAlbumAdapter= new AlbumAdapter();
        popularAlbumAdapter=new AlbumAdapter();
        trendingAlbumAdapter=new AlbumAdapter();

        recommendedAlbumAdapter.setContext((MainActivity)getActivity());
        popularAlbumAdapter.setContext((MainActivity)getActivity());
        trendingAlbumAdapter.setContext((MainActivity)getActivity());

        recommendedAlbumRView.setAdapter(recommendedAlbumAdapter);
        popularAlbumRView.setAdapter(popularAlbumAdapter);
        trendingAlbum.setAdapter(trendingAlbumAdapter);

    }

    public void loadData(List<Album> albumList){
        recommendedAlbumAdapter.setAlbumList(albumList);
        popularAlbumAdapter.setAlbumList(albumList);
        trendingAlbumAdapter.setAlbumList(albumList);
    }
    public void notifyDataChange(){
        recommendedAlbumAdapter.notifyDataSetChanged();
        popularAlbumAdapter.notifyDataSetChanged();
        trendingAlbumAdapter.notifyDataSetChanged();
    }
}