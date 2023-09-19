package com.example.homework2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<String> {
    public CustomAdapter(Context context, ArrayList<String> menu)
    {
        super(context, 0, menu);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.menu_layout, parent, false);
        }
        TextView tv = convertView.findViewById(R.id.textView);
        String s = getItem(position);
        tv.setText(s);
        return convertView;
    }
}
