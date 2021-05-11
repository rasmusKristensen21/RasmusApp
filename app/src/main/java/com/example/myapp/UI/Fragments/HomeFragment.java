package com.example.myapp.UI.Fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapp.R;
import com.example.myapp.UI.Activity.MainActivity;
import com.example.myapp.UI.ViewModels.HomeViewModel;
import com.example.myapp.data.Database.FavoriteDrinks;
import com.example.myapp.data.Drinks.RecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
//import com.google.firebase.referencecode.database.models.Post;

import java.util.List;
import java.util.zip.Inflater;


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

        viewModel= ViewModelProviders.of(this).get(HomeViewModel.class);
        /*viewModel.getAllItems().observe(getViewLifecycleOwner(), new Observer<List<FavoriteDrinks>>() {
            @Override
            public void onChanged(List<FavoriteDrinks> favoriteDrinks) {

                //adapter.setDrinks(favoriteDrinks);

            }
        });*/
        return inflate;

    }


}