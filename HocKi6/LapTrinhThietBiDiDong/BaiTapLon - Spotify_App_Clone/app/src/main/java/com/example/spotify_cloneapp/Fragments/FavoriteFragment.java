package com.example.spotify_cloneapp.Fragments;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import android.widget.Toast;

import com.example.spotify_cloneapp.Adapters.PlaylistAdapter;
import com.example.spotify_cloneapp.Database.PlayListDB;
import com.example.spotify_cloneapp.Database.PlaylistSongDB;
import com.example.spotify_cloneapp.Models.Playlist;
import com.example.spotify_cloneapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FavoriteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FavoriteFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView idRVPlaylist;
    private PlaylistAdapter playlistAdapter;
    private PlayListDB playlisttbl;
    private PlaylistSongDB playlistSongtbl;

    private ArrayList<Playlist> playlists = new ArrayList<>();
    private LinearLayout btnAddPlaylist;


    public FavoriteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FavoriteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FavoriteFragment newInstance(String param1, String param2) {
        FavoriteFragment fragment = new FavoriteFragment();
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
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);;
        this.loadComponent(view);
        return view;

    }

    private void loadComponent(View view) {
        idRVPlaylist = view.findViewById(R.id.idRVPlaylist);
        btnAddPlaylist = view.findViewById(R.id.btnAddPlaylist);
        playlisttbl = new PlayListDB(this.getContext(),"playlist", null, 1);
        playlistSongtbl = new PlaylistSongDB(this.getContext(), "playlistSong", null, 1);

        // Khởi tạo playlistAdapter
        playlistAdapter = new PlaylistAdapter(view.getContext(), playlists);
        idRVPlaylist.setAdapter(playlistAdapter);

        LoadRV();
        btnAddPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddPlaylist();
            }
        });

    }

    private void LoadRV() {
        playlists.clear();
        System.out.println(playlists.size());
        playlists.addAll(playlisttbl.getAllPlaylist());
        System.out.println(playlists.size());
        playlistAdapter.notifyDataSetChanged();
       // Toast.makeText(view.getContext(), "" + playlists.size(), Toast.LENGTH_SHORT).show();
    }

    private void AddPlaylist() {
        // Tạo LayoutInflater và View mới để chứa các EditText
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View dialogView = inflater.inflate(R.layout.dialog_add_playlist, null);

        // Tìm các EditText trong dialogView
        final EditText etName = dialogView.findViewById(R.id.etName);
        final EditText etDescription = dialogView.findViewById(R.id.etDescription);

        // Tạo AlertDialog.Builder và thiết lập các thuộc tính cần thiết cho dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Add Playlist");
        builder.setView(dialogView); // Sử dụng dialogView đã tạo

        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Lấy dữ liệu từ các trường nhập liệu
                String name = etName.getText().toString();
                String description = etDescription.getText().toString();

                // Thêm playlist mới vào cơ sở dữ liệu (giả định đã có phương thức addPlaylist)
                String sql = "insert into playlist('namePlaylist', 'description') " +
                        "values ('" + name + "', '" + description + "')";
//                System.out.println(sql);
                playlisttbl.RunSQL(sql);
                LoadRV();
            }
        });

        // Xử lý sự kiện khi người dùng nhấn nút "Hủy"
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        // Hiển thị AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }


}