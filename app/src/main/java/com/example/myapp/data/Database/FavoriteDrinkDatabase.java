package com.example.myapp.data.Database;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.myapp.R;
import com.example.myapp.data.Drinks.Drink;

import java.util.ArrayList;
import java.util.List;

@Database(entities = {FavoriteDrinks.class},version = 1)
public abstract class FavoriteDrinkDatabase extends RoomDatabase {

    private static FavoriteDrinkDatabase instance;

    public abstract DrinkDao dao();

    public static synchronized FavoriteDrinkDatabase getInstance(Context context){
        if(instance == null) {

            instance = Room.databaseBuilder(context.getApplicationContext(),
                    FavoriteDrinkDatabase.class, "Drinks_table")
                    .fallbackToDestructiveMigration().addCallback(callback)
                    .build();
        }

        return instance;

    }

    private static RoomDatabase.Callback callback = new RoomDatabase.Callback(){

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new CreateDummyForDB(instance).execute();
        }
    };

        private static class CreateDummyForDB extends AsyncTask<Void,Void,Void>{

            private DrinkDao dao;

            private CreateDummyForDB(FavoriteDrinkDatabase db){
                dao = db.dao();
            }
            @Override
            protected Void doInBackground(Void... voids) {
                dao.insert(new FavoriteDrinks("48kr.","Bloody Mary",R.drawable.ic_iv_calculator));
                dao.insert(new FavoriteDrinks("38kr.","Cosmopolitan",R.drawable.ic_settings));

                return null;
            }
        }
   /* List<Drink> data=new ArrayList<>();
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
        return data;*/
}
