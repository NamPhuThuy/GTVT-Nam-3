package com.example.spotify_cloneapp.Adapters;



import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spotify_cloneapp.Database.PlayListDB;
import com.example.spotify_cloneapp.Models.Playlist;
import com.example.spotify_cloneapp.Models.Song;
import com.example.spotify_cloneapp.MusicPlayerActivity;
import com.example.spotify_cloneapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder> {
    private ArrayList<Playlist> playlists;
    private String namePlaylist;
    private Context mContext;


    public PlaylistAdapter(Context mContext, ArrayList<Playlist> mData) {
        this.mContext = mContext;
        this.playlists = mData;
    }

    @NonNull
    @Override
    public PlaylistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_add_playlist, parent, false);
        return new PlaylistViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaylistViewHolder holder, int position) {
        Playlist playlist = playlists.get(position);
        // Đặt hình ảnh và các sự kiện khác ở đây
        holder.namePlaylist.setText(playlist.getName());
        holder.description.setText(playlist.getDescription());


        try{
            Picasso.get().load(playlist.getThumbnail()).placeholder(R.drawable.hinhnen).into(holder.thumbnail);
        }
        catch (Exception e){
            holder.thumbnail.setImageResource(R.drawable.hinhnen);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "" + playlist.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return playlists.size();
    }

    public class PlaylistViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {
        public TextView namePlaylist;
        public TextView description;
        public ImageView thumbnail;

        private static final String TAG = "MyViewHolder";
        ImageButton imageButton;


        public PlaylistViewHolder(View view) {
            super(view);
            namePlaylist = view.findViewById(R.id.item_namePlaylist);
            description = view.findViewById(R.id.item_SLBaiHat);
            thumbnail = view.findViewById(R.id.item_imgPlaylist);
            imageButton = view.findViewById(R.id.imageButton);
            imageButton.setOnClickListener(this);
        }

        void blindView(String name) {
            namePlaylist.setText(name);
        }

        @Override
        public void onClick(View v) {
            showPopupMenu(v);
        }

        private void showPopupMenu(View view) {
            PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
            popupMenu.inflate(R.menu.popup_menu); // Ensure this file exists
            popupMenu.setOnMenuItemClickListener(this);
            popupMenu.show();
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {

            if(item.getItemId() == R.id.popup_edit){
                // Lấy vị trí của playlist trong danh sách
                int position = getAdapterPosition();
                // Kiểm tra xem vị trí có hợp lệ không
                if (position != RecyclerView.NO_POSITION) {
                    // Lấy playlist tương ứng với vị trí
                    Playlist playlist = playlists.get(position);
                    // Hiển thị dialog chỉnh sửa playlist
                    showEditPlaylistDialog(playlist);
                }
                return true;
            }else if(item.getItemId() == R.id.popup_delete)
            {
                showDeleteConfirmationDialog();
                return true;
            }
            return false;
        }
        private void showEditPlaylistDialog(Playlist playlist) {
            AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
            View dialogView = LayoutInflater.from(mContext).inflate(R.layout.activity_up_date_playlist, null);
            builder.setView(dialogView);

            EditText editTextName = dialogView.findViewById(R.id.update_Name);
            EditText edmota = dialogView.findViewById(R.id.update_Mota);
            // Tìm các View khác và thiết lập giá trị tương ứng của playlist

            builder.setPositiveButton("Lưu", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // Lấy thông tin mới từ giao diện chỉnh sửa
                    String newName = editTextName.getText().toString();
                    String mott = edmota.getText().toString();
                    // Lấy thông tin khác tương ứng với các View khác

                    // Cập nhật thông tin mới vào cơ sở dữ liệu
                    playlist.setName(newName);
                    playlist.setDescription(mott);
                    // Cập nhật thông tin khác
                }
            });

            builder.setNegativeButton("Hủy", null);

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
        private void showDeleteConfirmationDialog() {
            AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
            builder.setTitle("Thông báo");
            builder.setMessage("Bạn có chắc chắn muốn xóa?");
            builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // Xóa phần tử được chọn từ danh sách và cập nhật RecyclerView
                    deletePlaylist(getAdapterPosition());
                }
            });
            builder.setNegativeButton("Không", null);
            builder.create().show();
        }
        private void deletePlaylist(int position) {
            playlists.remove(position);
            notifyDataSetChanged(); // Cập nhật RecyclerView
        }
    }

}
