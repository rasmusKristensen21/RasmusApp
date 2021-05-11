package com.example.myapp.data.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapp.data.models.DrinkModel;

import java.util.List;

@Dao
public interface DrinkDao {
@Insert
    void insert(FavoriteDrinks drink);

@Update
    void update(FavoriteDrinks drink);

@Delete
    void delete(FavoriteDrinks drink);

@Query("SELECT * FROM Drinks_table ORDER BY popularity DESC")
    LiveData<List<FavoriteDrinks>> getAllDrinks();


}
