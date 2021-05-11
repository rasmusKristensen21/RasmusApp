package com.example.myapp.UI.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.myapp.R;
import com.example.myapp.UI.ViewModels.OrderViewModel;
import com.example.myapp.data.models.DrinkModel;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.List;

import javax.xml.namespace.QName;

public class OrderFragment extends Fragment implements Serializable {
    private static final long serialVersionUID = -2163051469151804394L;


    private OrderViewModel viewModel;
    TextView name;
    TextView price;
    ImageView image;

    String navn;
    String prisen;
    int billed;
    Button enterButton;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_order, container, false);

        name = view.findViewById(R.id.drink_name);
        image = view.findViewById(R.id.app_bar_image);
        price = view.findViewById(R.id.price);


        viewModel = ViewModelProviders.of(this).get(OrderViewModel.class);
        viewModel.init();

            viewModel.getClickedItem().observe(getViewLifecycleOwner(), drinkModels -> {

                navn = drinkModels.get(0).getName();
                billed = drinkModels.get(0).getImage();
                prisen = drinkModels.get(0).getPrice();
                enterButton= view.findViewById(R.id.sendDrink);

                name.setText(navn);
                image.setImageResource(billed);
                price.setText(prisen);
            });

        //Bundle bundle =this.getArguments();
        /*if(bundle!=null){
            navn = bundle.getString("drinkName");
            billed = bundle.getInt("image");
            prisen= bundle.getString("price");
        }*/

        /*enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // viewModel
            }
        });*/






        // Inflate the layout for this fragment
        return view;


    }



    /*@Override
    public void onPause() {
        super.onPause();
        SharedPreferences preferences = this.getActivity().getSharedPreferences("drinkSelected", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =preferences.edit();
        editor
    }*/
}


