package com.example.homework2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImageAdapter extends ArrayAdapter<String> {
    public ImageAdapter(Context context, String[] imgURLs)
    {
        super(context, 0, imgURLs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.content_layout, parent, false);
        }
        ImageView iv = convertView.findViewById(R.id.imageView);
        String s = getItem(position);
        Picasso.get().load(s).resize(400, 500).centerCrop().into(iv);
        return convertView;
    }
}
