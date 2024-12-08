package com.example.spotify_cloneapp.Models;

import java.io.Serializable;

public class Song implements Serializable {
    private int ID_Song;
    private String Thumbnail;
    private String URLmp3;
    private String nameSong;
    private String Duration;
    private String Category;
    private int TotalPlayTime;
    private int Like;
    private int Disliked;
    private int ViewCount;
    private String Description;
    private String Lyrics;
    private String nameAuthor;
    private String nameArtist;

    public int getID_Song() {
        return ID_Song;
    }

    public String getThumbnail() {
        return Thumbnail;
    }

    public String getURLmp3() {
        return URLmp3;
    }

    public String getNameSong() {
        return nameSong;
    }

    public String getDuration() {
        return Duration;
    }

    public String getCategory() {
        return Category;
    }

    public int getTotalPlayTime() {
        return TotalPlayTime;
    }

    public int getLike() {
        return Like;
    }

    public int getDisliked() {
        return Disliked;
    }

    public int getViewCount() {
        return ViewCount;
    }

    public String getDescription() {
        return Description;
    }

    public String getLyrics() {
        return Lyrics;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public String getNameArtist() {
        return nameArtist;
    }

    public void setID_Song(int ID_Song) {
        this.ID_Song = ID_Song;
    }

    public void setThumbnail(String thumbnail) {
        Thumbnail = thumbnail;
    }

    public void setURLmp3(String URLmp3) {
        this.URLmp3 = URLmp3;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public void setTotalPlayTime(int totalPlayTime) {
        TotalPlayTime = totalPlayTime;
    }

    public void setLike(int like) {
        Like = like;
    }

    public void setDisliked(int disliked) {
        Disliked = disliked;
    }

    public void setViewCount(int viewCount) {
        ViewCount = viewCount;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setLyrics(String lyrics) {
        Lyrics = lyrics;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public void setNameArtist(String nameArtist) {
        this.nameArtist = nameArtist;
    }
}
