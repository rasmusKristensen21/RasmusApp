package com.example.myapp.UI.ViewModels;




import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapp.data.Repository.DrinkMenu;

import java.util.List;


public class DrinkViewModel extends ViewModel {
    private MutableLiveData<List<DrinkMenu>> drinks;


    public LiveData<List<DrinkMenu>> getDrink(){
        return drinks;
    }






}
