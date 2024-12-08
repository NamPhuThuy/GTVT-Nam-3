package com.example.spotify_cloneapp.Models;

public class Album {
    private int ID_Album;
    private String Name;
    private String Description;
    private String Duration;
    private String Thumbnail;
    private  String Type;
    private int SongCount;
    private String NgayPhatHanh;
    private String InLibrary;
    private int Liked;
    private int DownloadState;

    public int getID_Album() {
        return ID_Album;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

    public String getDuration() {
        return Duration;
    }

    public String getThumbnail() {
        return Thumbnail;
    }

    public String getType() {
        return Type;
    }

    public int getSongCount() {
        return SongCount;
    }

    public String getNgayPhatHanh() {
        return NgayPhatHanh;
    }

    public String getInLibrary() {
        return InLibrary;
    }

    public int getLiked() {
        return Liked;
    }

    public int getDownloadState() {
        return DownloadState;
    }
}
