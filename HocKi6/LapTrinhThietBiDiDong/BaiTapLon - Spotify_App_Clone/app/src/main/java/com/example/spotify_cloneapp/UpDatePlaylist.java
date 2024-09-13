package com.example.spotify_cloneapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class UpDatePlaylist extends AppCompatActivity {
    EditText name;
    EditText name2;

    ImageView img;
    String imagePath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_date_playlist);
        name = findViewById(R.id.update_Name);
        img = findViewById(R.id.update_img);
        name2 = findViewById(R.id.update_Mota);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            String name_up = bundle.getString("name");
            String img_path = bundle.getString("Image");
            imagePath = img_path;
            name.setText(name_up);
            Log.d("l", "onCreate: " + img_path);
            Glide.with(UpDatePlaylist.this)
                    .load(img_path)
                    .into(img);
        }

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 130);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 130 && resultCode == RESULT_OK && data != null){
            Uri img_uri = data.getData();
            img.setImageURI(img_uri);
            imagePath = img_uri.toString();
        }
    }

}