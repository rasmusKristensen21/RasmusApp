package com.example.myapp.UI.ViewModels;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapp.data.Database.FavoriteDrinks;
import com.example.myapp.data.Repository.ClickedDrinkRepository;
import com.example.myapp.data.Repository.DrinkRepository;
import com.example.myapp.data.models.DrinkModel;

import java.util.List;

public class OrderViewModel extends ViewModel {

    private MutableLiveData<List<FavoriteDrinks>> drink;
    private MutableLiveData<Boolean> updating = new MutableLiveData<>();
    private ClickedDrinkRepository repository;






    public void init(){
        if(drink!=null){
            return;//we have set the drinks list to something already
        }
        repository= ClickedDrinkRepository.getGetInstance();
        drink=repository.getOnClickedItem();

    }

    public void addDrinkToFavorite(){

    }

    public void addOnClickedItem( DrinkModel drink){
        updating.setValue(true);
    }


    public LiveData<List<FavoriteDrinks>> getClickedItem(){
        return drink;
    }

}
