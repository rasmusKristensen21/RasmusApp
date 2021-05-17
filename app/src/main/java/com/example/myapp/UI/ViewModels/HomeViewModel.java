package com.example.myapp.UI.ViewModels;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapp.data.Drinks.Drink;
import com.example.myapp.data.Repository.DrinkRepository;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    static DrinkRepository repo;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        if(repo==null){
            repo = DrinkRepository.getGetInstance();
        }

    }

    public LiveData<List<Drink>> getAllItems(Context context){

      return repo.getAllDrinks(context);

    }
    public MutableLiveData<String> getCurrentClub(){
        return repo.getClub();
    }


}
