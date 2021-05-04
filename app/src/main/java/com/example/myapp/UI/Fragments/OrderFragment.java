package com.example.myapp.UI.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.myapp.R;

import org.w3c.dom.Text;

public class OrderFragment extends Fragment {


    TextView titlen;
    TextView prisen;
    String title;
    String price;
    int image;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_order, container, false);

        titlen = (TextView) view.findViewById(R.id.textView3);

        titlen.setText(title);

        // Inflate the layout for this fragment
        return view;


    }



}


