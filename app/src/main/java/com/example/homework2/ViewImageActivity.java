package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ViewImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_image);
        Intent intent = getIntent();
        String src = intent.getStringExtra("imgSrc");
        ImageView imageView = findViewById(R.id.imageView2);
        Picasso.get().load(src).resize(1050, 1600).centerCrop().into(imageView);
    }
}