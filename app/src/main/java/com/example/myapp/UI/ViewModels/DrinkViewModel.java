package com.example.myapp.UI.ViewModels;




import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapp.R;
import com.example.myapp.data.Database.FavoriteDrinks;
import com.example.myapp.data.Drinks.Drink;
import com.example.myapp.data.Repository.DrinkRepository;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class DrinkViewModel extends ViewModel {
    private MutableLiveData<List<Drink>> drinks;
    private DrinkRepository repository;


    public DrinkViewModel(){

    }



    public MutableLiveData<List<Drink>> getData(){

        repository = DrinkRepository.getGetInstance();
        return repository.fetchData();
    }
}


    /*public DrinkViewModel(@NonNull Application application) {
        super(application);
        repository= DrinkRepository.getGetInstance(application);

    }*/

   /* public LiveData<List<FavoriteDrinks>> getDrinks(){
        return repository.getAllDrinks();
    }*/










