package com.example.myapp.UI.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
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
import android.widget.TextView;

import com.example.myapp.R;
import com.example.myapp.UI.ViewModels.HomeViewModel;
import com.example.myapp.data.Drinks.Drink;
import com.example.myapp.data.Drinks.FragmentCommunication;
import com.example.myapp.data.Drinks.RecyclerAdapter;
import com.example.myapp.data.databaseNew.DatabaseHelper;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.referencecode.database.models.Post;

import java.util.List;


public class HomeFragment extends Fragment {
TextView placeholder;

    private DatabaseReference databaseReference;
    private DatabaseReference logReference;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    private HomeViewModel viewModel;
    private RecyclerView drinksList;


    private RecyclerAdapter adapter;


    View inflate;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        inflate = inflater.inflate(R.layout.fragment_home, container, false);

        drinksList = inflate.findViewById(R.id.recycler_fave);

        drinksList.setHasFixedSize(true);

        drinksList.setLayoutManager(new GridLayoutManager(getActivity(),2));

        FragmentCommunication communication=new FragmentCommunication() {
            @Override
            public void respons(String title, String price, int image) {


                Navigation.findNavController(getView()).navigate(R.id.order);


            }

        };

        viewModel= ViewModelProviders.of(this).get(HomeViewModel.class);

        DatabaseHelper databaseHelper = new DatabaseHelper(getContext());


        //Delete all rows
       /*if(databaseHelper.deleteAll()){
            Log.d("all", "Deleted");
        }*/



        //RecyclerAdapter adapter  = new RecyclerAdapter(communication,databaseHelper.getAllDrinks());

        


        /*databaseHelper.getAllDrinks().observe(getViewLifecycleOwner(), new Observer<List<Drink>>() {
            @Override
            public void onChanged(List<Drink> drinks) {
                //adapter.setDrinks(drinks);
            }
        });*/

        viewModel.getCurrentClub().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {


            }
        });
        //update when ever there is a change in database
        viewModel.getAllItems(getContext()).observe(getViewLifecycleOwner(), new Observer<List<Drink>>() {
            @Override
            public void onChanged(List<Drink> drinks) {


                Log.d("dsagee",drinks.get(0).getClubId());
                Log.d("dsagee",drinks.get(1).getClubId());

                RecyclerAdapter adapter  = new RecyclerAdapter(communication,drinks);

                drinksList.setAdapter(adapter);
                drinksList.setItemAnimator(new DefaultItemAnimator());

            }
        });



        return inflate;

    }


}