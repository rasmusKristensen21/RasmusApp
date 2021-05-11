package com.example.myapp.data.Repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.myapp.R;
import com.example.myapp.UI.ViewModels.OrderViewModel;
import com.example.myapp.data.Database.FavoriteDrinks;
import com.example.myapp.data.Drinks.Drink;
import com.example.myapp.data.models.DrinkModel;

import java.util.ArrayList;
import java.util.List;

public class ClickedDrinkRepository {

    private static ClickedDrinkRepository instance;
    private String name;
    private String price;
    private int image;
    private ArrayList<DrinkModel> array = new ArrayList<>();
    MutableLiveData<List<FavoriteDrinks>> data = new MutableLiveData<>();



    public static ClickedDrinkRepository getGetInstance() {
        if (instance == null) {
            instance = new ClickedDrinkRepository();
        }
        return instance;
    }

    public MutableLiveData<List<FavoriteDrinks>> getOnClickedItem() {

        return data;

    }

    public void setArray(String price, String name, int img) {
        List<FavoriteDrinks> drink = new ArrayList<>();
        drink.add(new FavoriteDrinks(price,name,img));
        data.setValue(drink);




    }

}






