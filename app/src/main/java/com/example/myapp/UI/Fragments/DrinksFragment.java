package com.example.myapp.UI.Fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapp.UI.ViewModels.DrinkViewModel;
import com.example.myapp.UI.ViewModels.HomeViewModel;
import com.example.myapp.data.Database.FavoriteDrinks;
import com.example.myapp.data.Drinks.Drink;
import com.example.myapp.data.Drinks.FragmentCommunication;
import com.example.myapp.R;
import com.example.myapp.data.Drinks.RecyclerAdapter;
import com.example.myapp.UI.Activity.MainActivity;

import java.util.ArrayList;
import java.util.List;


public class DrinksFragment extends Fragment {


    RecyclerView drinksList;
    Class<MainActivity> activity = MainActivity.class;
    private DrinkViewModel viewModel;
    private RecyclerAdapter adapter;

    @Override public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // init ViewModel

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_drinks, container, false);
        drinksList = rootView.findViewById(R.id.recycler);
        drinksList.setHasFixedSize(true);

        drinksList.setLayoutManager(new GridLayoutManager(getActivity(),2));


        viewModel = ViewModelProviders.of(this).get(DrinkViewModel.class);

        FragmentCommunication communication=new FragmentCommunication() {
            @Override
            public void respons(String title, String price, int image) {
                /*OrderFragment order = new OrderFragment();
                Bundle bundle=new Bundle();

                bundle.putString("drinkName",title);
                bundle.putString("price",price);
                bundle.putInt("image",image);
                order.setArguments(bundle);*/

                Navigation.findNavController(getView()).navigate(R.id.order);

                //Navigation.findNavController(getView()).navigate(R.id.order);
            }

        };


        /*viewModel.getData().observe(getViewLifecycleOwner(), new Observer<List<Drink>>() {
            @Override
            public void onChanged(List<Drink> drinks) {
                Log.d("ds",drinks.get(0).getTitle());

            }
        });*/
        /*viewModel.observe(getViewLifecycleOwner(), new Observer<List<FavoriteDrinks>>() {
            @Override
            public void onChanged(List<FavoriteDrinks> favoriteDrinks) {

                if(favoriteDrinks!=null) {

                    Log.d("ds",favoriteDrinks.get(0).getName());
                    adapter.setDrinks(favoriteDrinks);

                }

            }
        });*/


        RecyclerAdapter adapter  = new RecyclerAdapter(communication,viewModel.getData().getValue());

        drinksList.setAdapter(adapter);
        drinksList.setItemAnimator(new DefaultItemAnimator());

        return rootView;

    }




    /*private LiveData<List<FavoriteDrinks>> getDrinks(){
        return viewModel.getDrinks();
    }*/

    /*public static List<Drink> getData() {
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
    }*/




}