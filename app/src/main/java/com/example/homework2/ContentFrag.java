package com.example.homework2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class ContentFrag extends Fragment {
    GridView gridView;
    ImageAdapter adapter;
    public ContentFrag() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_frag, container, false);
        gridView = view.findViewById(R.id.gridview);
        updateContent(0);
        return view;
    }
    public void updateContent(int position)
    {
        adapter = new ImageAdapter(getActivity(), getImgUrls(position));
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), ViewImageActivity.class);
                intent.putExtra("imgSrc", getImgUrls(position)[i]);
                startActivity(intent);
            }
        });
    }

    public String[] getImgUrls(int pos)
    {
        switch (pos)
        {
            case 0:
                return new String[] {
                        "https://cdn.pixabay.com/photo/2023/08/15/16/55/motorcycle-8192323_1280.jpg",
                        "https://cdn.pixabay.com/photo/2021/07/29/11/40/super-cub-6507024_1280.jpg",
                        "https://cdn.pixabay.com/photo/2013/07/04/15/24/motorcycle-143174_1280.jpg"
                };
            case 1:
                return new String[] {
                        "https://cdn.pixabay.com/photo/2020/01/26/18/52/porsche-4795517_1280.jpg",
                        "https://cdn.pixabay.com/photo/2013/02/21/19/08/red-84593_1280.jpg",
                        "https://cdn.pixabay.com/photo/2015/01/19/13/51/car-604019_1280.jpg",
                };
            case 2:
                return new String[] {
                        "https://cdn.pixabay.com/photo/2016/08/24/12/47/road-bike-1616959_1280.jpg",
                        "https://cdn.pixabay.com/photo/2016/11/18/12/49/bicycle-1834265_1280.jpg",
                        "https://cdn.pixabay.com/photo/2020/05/24/09/36/bike-gravel-5213352_1280.jpg"
                };
            default: return new String[] {
                    "https://cdn.pixabay.com/photo/2023/08/15/16/55/motorcycle-8192323_1280.jpg",
                    "https://cdn.pixabay.com/photo/2021/07/29/11/40/super-cub-6507024_1280.jpg",
                    "https://cdn.pixabay.com/photo/2013/07/04/15/24/motorcycle-143174_1280.jpg"

            };
        }
    }
}