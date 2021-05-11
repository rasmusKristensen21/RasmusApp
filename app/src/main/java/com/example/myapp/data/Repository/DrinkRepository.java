package com.example.myapp.data.Repository;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapp.R;
import com.example.myapp.data.Database.DrinkDao;
import com.example.myapp.data.Database.FavoriteDrinkDatabase;
import com.example.myapp.data.Database.FavoriteDrinks;
import com.example.myapp.data.Drinks.Drink;
import com.example.myapp.data.models.DrinkModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DrinkRepository implements DrinkDao {// interface

    private static DrinkRepository instance;
    private DrinkDao drinks;
    private LiveData<List<FavoriteDrinks>> allDrinks;
    private ExecutorService executor;
    private ArrayList<Drink> datas = new ArrayList<>();

    private DrinkRepository(){

    }
    private DrinkRepository(Application app){
        FavoriteDrinkDatabase database = FavoriteDrinkDatabase.getInstance(app);
        drinks = database.dao();//databasen
        allDrinks = drinks.getAllDrinks();
        executor = Executors.newFixedThreadPool(2);
    }


    public static DrinkRepository getGetInstance(){
        if(instance==null){
            instance = new DrinkRepository();
        }

        return instance;
    }

    /*public static synchronized DrinkRepository getGetInstance(Application app){

        if(instance==null){
            instance = new DrinkRepository(app);
        }
        return instance;
    }*/

    public MutableLiveData<List<Drink>> fetchData(){

        datas.add(new Drink("Bloody Mary","48 kr.",R.mipmap.bloody_mary_round));
        datas.add(new Drink("Cosmopolitan","38 kr.",R.mipmap.cosmopolita_round));
        datas.add(new Drink("Daiquiri","45 kr.",R.mipmap.daiq_round));

        MutableLiveData<List<Drink>> data = new MutableLiveData<>();
        data.setValue(datas);

        return  data;

    }



    public List<Drink> getData() {
        List<Drink>data=new ArrayList<>();
        String[] title={"Bloody marry","Cosmopolitan","Daiquiri"/*"Sex on the beach","Mojito","Sidecar","Piña Colada","Frozen Margarita","Tequila Sunrise","Manhattan"*/};
        String[] price={"48 kr.","38 kr.","45 kr."/*,"45 kr.","68 kr.","35 kr.","48 kr.","70 kr.","65 kr.","50 kr."*/};
        int[] image={R.mipmap.bloody_mary_round,R.mipmap.cosmopolita_round,R.mipmap.daiq_round};

        /*for (int i=0;i<title.length;i++){
            Drink current=new Drink();
            current.setImage(image[i]);
            current.setTitle(title[i]);
            current.setPrice(price[i]);
            data.add(current);
        }*/
        return data;
    }
    /*public MutableLiveData<List<FavoriteDrinks>> getData() {
        MutableLiveData<List<FavoriteDrinks>>data=new MutableLiveData<>();
        List<FavoriteDrinks> list = new List<FavoriteDrinks>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(@Nullable Object o) {
                return false;
            }

            @NonNull
            @Override
            public Iterator<FavoriteDrinks> iterator() {
                return null;
            }

            @NonNull
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @NonNull
            @Override
            public <T> T[] toArray(@NonNull T[] a) {
                return null;
            }

            @Override
            public boolean add(FavoriteDrinks favoriteDrinks) {
                return false;
            }

            @Override
            public boolean remove(@Nullable Object o) {
                return false;
            }

            @Override
            public boolean containsAll(@NonNull Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(@NonNull Collection<? extends FavoriteDrinks> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, @NonNull Collection<? extends FavoriteDrinks> c) {
                return false;
            }

            @Override
            public boolean removeAll(@NonNull Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(@NonNull Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public FavoriteDrinks get(int index) {
                return null;
            }

            @Override
            public FavoriteDrinks set(int index, FavoriteDrinks element) {
                return null;
            }

            @Override
            public void add(int index, FavoriteDrinks element) {

            }

            @Override
            public FavoriteDrinks remove(int index) {
                return null;
            }

            @Override
            public int indexOf(@Nullable Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(@Nullable Object o) {
                return 0;
            }

            @NonNull
            @Override
            public ListIterator<FavoriteDrinks> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<FavoriteDrinks> listIterator(int index) {
                return null;
            }

            @NonNull
            @Override
            public List<FavoriteDrinks> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        list.add(new FavoriteDrinks("48","Bloody Mary",R.drawable.ic_iv_calculator));
        list.add(new FavoriteDrinks("38","Cosmopolitan",R.drawable.ic_settings));
        data.postValue(list);
        return data;
    }*/

    @Override
    public void insert(FavoriteDrinks drink) {
        new InsertDrinkAsync(drinks).execute(drink);
    }

    @Override
    public void update(FavoriteDrinks drink) {
        new UpdateDrinkAsync(drinks).execute(drink);
    }

    @Override
    public void delete(FavoriteDrinks drink) {
        new DeleteDrinkAsync(drinks).execute(drink);
    }



    @Override
    public LiveData<List<FavoriteDrinks>> getAllDrinks() {

        return allDrinks;

    }

    private static class InsertDrinkAsync extends AsyncTask<FavoriteDrinks,Void,Void>{

        private DrinkDao drinks;

        private InsertDrinkAsync(DrinkDao fDrink){
            this.drinks=fDrink;
        }
        @Override
        protected Void doInBackground(FavoriteDrinks... favoriteDrinks) {

            drinks.insert(favoriteDrinks[0]);
            return null;
        }
}

    private static class UpdateDrinkAsync extends AsyncTask<FavoriteDrinks,Void,Void>{

        private DrinkDao drinks;

        private UpdateDrinkAsync(DrinkDao fDrink){
            this.drinks=fDrink;
        }
        @Override
        protected Void doInBackground(FavoriteDrinks... favoriteDrinks) {

            drinks.update(favoriteDrinks[0]);
            return null;
        }
    }
    private static class DeleteDrinkAsync extends AsyncTask<FavoriteDrinks,Void,Void>{

        private DrinkDao drinks;

        private DeleteDrinkAsync(DrinkDao fDrink){
            this.drinks=fDrink;
        }
        @Override
        protected Void doInBackground(FavoriteDrinks... favoriteDrinks) {

            drinks.delete(favoriteDrinks[0]);
            return null;
        }
    }



}
