package com.example.homework2;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MenuFrag extends Fragment {

    String[] menu = {"Motobike", "Car", "Bicycle"};
    private IFragmentClickListener itemFragment;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            itemFragment = (IFragmentClickListener) context;
        }
        catch (ClassCastException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.menu_frag, container, false);
        ListView listView = view.findViewById(R.id.list);
        CustomAdapter adapter = new CustomAdapter(view.getContext(), new ArrayList<String>(Arrays.asList(menu)));
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                itemFragment.onMenuItemClick(i);
            }
        });
        return view;
    }

    public interface IFragmentClickListener
    {
        public void onMenuItemClick(int position);
    }
}