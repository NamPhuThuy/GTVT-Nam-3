package com.example.spotify_cloneapp.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.spotify_cloneapp.Models.Playlist;

import java.util.ArrayList;

public class PlayListDB extends SQLiteOpenHelper {
    public static final String TableName = "PlayList";
    public static final String Id = "id";
    public static final String Name = "namePlaylist";
    public static final String Description = "description";
    public static final String Thumbnail = "thumbnail";
    public PlayListDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreate = "Create table if not exists " + TableName + "("
                + Id + " Integer primary key autoincrement, "
                + Name + " Text, "
                + Description + " Text, "
                + Thumbnail + " Text)";

        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists " + TableName);
        onCreate(db);
    }

    public ArrayList<Playlist> getAllPlaylist(){
        ArrayList<Playlist> list = new ArrayList<>();
        String sql = "Select * from " + TableName;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor != null){
            while (cursor.moveToNext()){
                Playlist p = new Playlist(cursor.getInt(0), cursor.getString(1),
                        cursor.getString(2), cursor.getString(3));

                list.add(p);
            }
        }
        return list;
    }

    public void addPlaylist(Playlist playlist){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Id, playlist.getId());
        values.put(Name, playlist.getName());
        values.put(Description, playlist.getDescription());
        values.put(Thumbnail, playlist.getThumbnail());

        try {
            db.insert(TableName, null, values);
        }
        catch (Exception e){
            System.out.println(e);
        }
        db.close();
    }

    public void UpdatePlaylist(Playlist playlist, int id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Id, playlist.getId());
        values.put(Name, playlist.getName());
        values.put(Description, playlist.getDescription());
        values.put(Thumbnail, playlist.getThumbnail());

        db.update(TableName, values, Id + "=?",
                new String[]{String.valueOf(id)});
        db.close();
    }

    public void DeletePlaylist(int id){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "Delete from " + TableName + " Where Id = " + id;
        db.execSQL(sql);
        db.close();
    }

    public void RunSQL(String sql){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }    public void addSampleData() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Id, "1");
        values.put(Name, "playlist chill");
        values.put(Description, "vu vơ");
        values.put(Thumbnail, "https://i.pinimg.com/originals/9e/2c/19/9e2c199ae5136a42e56d5ae417109353.jpg");
        db.insert(TableName, null, values);
        values.clear();

        values.put(Id, "2");
        values.put(Name, "cahoihoang");
        values.put(Description, "khong co gi ca");
        values.put(Thumbnail, "https://i.pinimg.com/originals/74/11/13/7411134a17df554cd7c20cdb9781e177.jpg");
        db.insert(TableName, null, values);
        values.clear();

        values.put(Id, "3");
        values.put(Name, "cahoihoang");
        values.put(Description, "khong co gi ca");
        values.put(Thumbnail, "https://i.pinimg.com/originals/00/f9/ec/00f9ec978a6910a1347544233954a9d2.jpg");
        db.insert(TableName, null, values);
        db.close();
    }
}
