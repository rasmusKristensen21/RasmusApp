package com.example.myapp.data.Drinks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapp.R;

public class DrinkSelectedFragment extends Fragment {

    TextView titlen;
    TextView prisen;
    String title;
    String price;
    int image;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title=getArguments().getString("Title");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_drink_selected, container, false);

        titlen = (TextView) view.findViewById(R.id.textView3);

        titlen.setText(title);

        // Inflate the layout for this fragment
        return view;


    }
}
