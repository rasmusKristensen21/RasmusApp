package com.example.myapp.UI.Fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapp.UI.ViewModels.DrinkViewModel;
import com.example.myapp.UI.ViewModels.MainActivityViewModel;
import com.example.myapp.data.Drinks.Drink;
import com.example.myapp.data.Drinks.FragmentCommunication;
import com.example.myapp.R;
import com.example.myapp.data.Drinks.RecyclerAdapter;
import com.example.myapp.UI.Activity.MainActivity;
import com.example.myapp.data.Repository.DrinkMenu;

import java.util.ArrayList;
import java.util.List;


public class DrinksFragment extends Fragment {


    RecyclerView drinksList;
    Class<MainActivity> activity = MainActivity.class;
    private DrinkViewModel viewModel;

    @Override public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // init ViewModel
        viewModel = ViewModelProviders.of(requireActivity()).get(DrinkViewModel.class);
       /* viewModel.getDrink().observe(this, new Observer<DrinkMenu>() {
            @Override
            public void onChanged(DrinkMenu drinkMenu) {
                drinksList.notify();
            }
        });*/
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_drinks, container, false);
        drinksList = rootView.findViewById(R.id.recycler);
        drinksList.setHasFixedSize(true);

        drinksList.setLayoutManager(new GridLayoutManager(getActivity(),2));



        FragmentCommunication communication=new FragmentCommunication() {
            @Override
            public void respons(String title, String price, int image) {
                OrderFragment order=new OrderFragment();
                Bundle bundle=new Bundle();
                bundle.putString("Title",title);
                bundle.putString("price",price);
                bundle.putInt("image",image);
                order.setArguments(bundle);

                Navigation.findNavController(getView()).navigate(R.id.order);

            }


        };



        RecyclerAdapter adapter  = new RecyclerAdapter(getData(),communication);
        drinksList.setAdapter(adapter);
        drinksList.setItemAnimator(new DefaultItemAnimator());




        return rootView;

    }

    /*private void initRecycler(){
        RecyclerAdapter adapter  = new RecyclerAdapter(getData(),viewModel.getDrink().getValue());
        drinksList.setAdapter(adapter);
        drinksList.setItemAnimator(new DefaultItemAnimator());
    }*/


    public static List<Drink> getData() {
        List<Drink>data=new ArrayList<>();
        String[] title={"Bloody marry","Cosmopolitan"};
        String[] price={"48 kr.","38 kr."};
        int[] image={R.drawable.ic_iv_calculator,R.drawable.ic_moves};

        for (int i=0;i<title.length;i++){
            Drink current=new Drink();
            current.setImage(image[i]);
            current.setTitle(title[i]);
            current.setPrice(price[i]);
            data.add(current);
        }
        return data;
    }




}