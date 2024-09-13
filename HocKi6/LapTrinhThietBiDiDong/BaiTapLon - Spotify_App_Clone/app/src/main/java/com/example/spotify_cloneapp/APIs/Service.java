package com.example.spotify_cloneapp.APIs;

import com.example.spotify_cloneapp.Models.Album;
import com.example.spotify_cloneapp.Models.Song;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Service {
    String BASE_SONG_URL = "https://spotifybygoats.000webhostapp.com/Server/";
    Gson gson = new GsonBuilder()
            .setDateFormat("dd-MM-yyyy")
            .create();

    Service api= new Retrofit.Builder()
            .baseUrl(BASE_SONG_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(Service.class);

    @GET("Song.php")
    Call<List<Song>> getAllSong();
    @GET("Album.php")
    Call<List<Album>> getAllAlbum();
    @GET("Song.php")
    Call<List<Song>> getSongsByAlbum(@Query("idAlbum") int idAlbum);
    @GET("Album.php")
    Call<List<Album>> getAlbumById(@Query("idAlbum") int idAlbum);
    @GET("Song.php")
    Call<List<Song>> getSongsById(@Query("idSong") int idSong);
    @GET("Song.php")
    Call<List<Song>> getSongByName(@Query("Name") String name);
    @GET("Album.php")
    Call<List<Album>> getAlbumByName(@Query("Name") String name);
}
