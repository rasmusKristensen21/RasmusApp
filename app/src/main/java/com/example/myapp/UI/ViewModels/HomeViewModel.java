package com.example.myapp.UI.ViewModels;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapp.data.Database.FavoriteDrinks;
import com.example.myapp.data.Repository.DrinkRepository;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    DrinkRepository repo;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        //repo= DrinkRepository.getGetInstance(application);

    }

    /*public LiveData<List<FavoriteDrinks>> getAllItems(){
      return repo.getAllDrinks();

    }*/


}
