package com.example.spotify_cloneapp.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spotify_cloneapp.Models.Song;
import com.example.spotify_cloneapp.MusicPlayerActivity;
import com.example.spotify_cloneapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {

    private List<Song> songList;
    private Activity context;
    private String albumName;

    public SongAdapter() {
        this.songList = new ArrayList<>();
    }
    public void setSongList(List<Song> songList) {
        this.songList.addAll(songList);
    }
    public void setContext(Activity context) {
        this.context = context;
    }
    public List<Song> getSongList() {
        return songList;
    }

    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.song_item, parent, false);
        return new SongViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SongViewHolder holder, int position) {
        Song song = songList.get(position);
        // Đặt hình ảnh và các sự kiện khác ở đây
        holder.name.setText(song.getNameSong());
        holder.artist.setText(song.getNameArtist());
        if (songList.get(position).getThumbnail() != null) {
            Picasso.get().load(song.getThumbnail()).placeholder(R.drawable.hinhnen).into(holder.thumbnail);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MusicPlayerActivity.class);
                intent.putExtra("idSong",song.getID_Song());
                intent.putExtra("albumName", albumName);
                context.startActivityForResult(intent,103);
            }
        });
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    public class SongViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView artist;
        public ImageView thumbnail;

        public SongViewHolder(View view) {
            super(view);
            // Khởi tạo các thành phần giao diện người dùng khác ở đây
            name=view.findViewById(R.id.txtSongName);
            artist=view.findViewById(R.id.txtSongArtist);
            thumbnail=view.findViewById(R.id.idImgSong);
        }
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }
}
