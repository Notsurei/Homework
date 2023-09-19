package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity implements MenuFrag.IFragmentClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onMenuItemClick(int position) {
        ContentFrag contentFrag = (ContentFrag) getSupportFragmentManager().findFragmentById(R.id.ContentFrag);
        if (contentFrag != null)
        {
            contentFrag.updateContent(position);
        }
    }
}