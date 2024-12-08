package com.example.spotify_cloneapp.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


import java.util.ArrayList;

public class PlaylistSongDB extends SQLiteOpenHelper {
    public static final String TableName = "PairSongPlayList";
    public static final String IdSong = "idSong";
    public static final String IdPlaylist = "idPlaylist";
    public PlaylistSongDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreate = "Create table if not exists " + TableName + "("
                + IdPlaylist + " Integer, "
                + IdSong + " Integer)";

        db.execSQL(sqlCreate);
    }

    public ArrayList<Integer> getAllSongInPlaylist(int idPlaylist){
        ArrayList<Integer> list = new ArrayList<>();
        String sql = "Select idSong from " + TableName + " where idPlaylist = " + idPlaylist;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor != null){
            while (cursor.moveToNext()){
                int idSong = cursor.getInt(0);

                list.add(idSong);
            }
        }
        return list;
    }

    public void AddSongIntoPlaylist(int idSong, int idPlaylist){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(IdPlaylist, idPlaylist);
        values.put(IdSong, idSong);

        try {
            db.insert(TableName, null, values);
        }
        catch (Exception e){
            System.out.println(e);
        }
        db.close();
    }

    public void DeleteSongInPlaylist(int idSong, int idPlaylist){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "Delete from " + TableName + " Where idSong = " +
                idSong + " and idPlaylist = " + idPlaylist;
        db.execSQL(sql);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists " + TableName);
        onCreate(db);
    }
}
