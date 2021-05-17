package com.example.myapp.data.Repository;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapp.R;
import com.example.myapp.data.Drinks.Drink;
import com.example.myapp.data.databaseNew.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DrinkRepository  {// interface

    private static DrinkRepository instance;

    private MutableLiveData<List<Drink>> allDrinks = new MutableLiveData<>();
    private MutableLiveData<List<Drink>> data = new MutableLiveData<>();
    private MutableLiveData<String> clubChange = new MutableLiveData<>();
    private ExecutorService executor;
    private ArrayList<Drink> datas = new ArrayList<>();
    private String club;
    private List<Drink> listen;
    private List<Drink> listen2;
    private List<Drink> listen3;

    private DrinkRepository(){

    }
    /*private DrinkRepository(Application app){
        FavoriteDrinkDatabase database = FavoriteDrinkDatabase.getInstance(app);
        drinks = database.dao();//databasen
        allDrinks= drinks.getAllDrinks();

        executor = Executors.newFixedThreadPool(2);
    }*/


    public static DrinkRepository getGetInstance(){
        if(instance==null){

            instance = new DrinkRepository();
        }

        return instance;
    }

   /* public static synchronized DrinkRepository getGetInstance(Application app){

        if(instance==null){

            instance = new DrinkRepository(app);
        }
        return instance;
    }*/

    public MutableLiveData<String> getClub(){
        return clubChange;
    }

    public void setClub(String clubId){
        clubChange.setValue(clubId);
    }

    public void setData(String clubId){


        switch (clubId){
            case "Chad's Cocktail Empire":

                listen = new ArrayList<>();
                listen.add(new Drink("Bloody Mary","48 kr.",R.mipmap.bloody_mary_round,48,clubId));
                listen.add(new Drink("Cosmopolitan","38 kr.",R.mipmap.cosmopolita_round,38,clubId));
                listen.add(new Drink("Daiquiri","45 kr.",R.mipmap.daiq_round,45,clubId));
                listen.add(new Drink("Sex on the Beach","45 kr.",R.mipmap.sex_on_the_beach_round,45,clubId));
                listen.add(new Drink("Mojito","68 kr.",R.mipmap.mojito_round,68,clubId));
                listen.add(new Drink("Sidecar","35 kr.",R.mipmap.side_car_round,35,clubId));
                listen.add(new Drink("Piña Colada","50 kr.",R.mipmap.pina_round,50,clubId));
                listen.add(new Drink("Frozen Margharita","70 kr.",R.mipmap.frozen_margarita_round,70,clubId));
                listen.add(new Drink("Tequila Sunrise","65 kr.",R.mipmap.tequila_sunrise_round,65,clubId));
                listen.add(new Drink("Manhattan","53 kr.",R.mipmap.manhattan_round,53,clubId));

                data.setValue(listen);

                break;
            case "Café Mojo":

                listen2 = new ArrayList<>();
                listen2.add(new Drink("peter","48 kr.",R.mipmap.bloody_mary_round,48,clubId));
                listen2.add(new Drink("ingo","38 kr.",R.mipmap.cosmopolita_round,38,clubId));
                listen2.add(new Drink("jens","45 kr.",R.mipmap.daiq_round,45,clubId));
                listen2.add(new Drink("bro","45 kr.",R.mipmap.sex_on_the_beach_round,45,clubId));
                listen2.add(new Drink("ndsa","68 kr.",R.mipmap.mojito_round,68,clubId));
                listen2.add(new Drink("ikka","35 kr.",R.mipmap.side_car_round,35,clubId));
                listen2.add(new Drink("sendds","50 kr.",R.mipmap.pina_round,50,clubId));
                listen2.add(new Drink("zenzyg","70 kr.",R.mipmap.frozen_margarita_round,70,clubId));
                listen2.add(new Drink("nowa","65 kr.",R.mipmap.tequila_sunrise_round,65,clubId));
                listen2.add(new Drink("bryt","53 kr.",R.mipmap.manhattan_round,53,clubId));

                List<Drink> listen1 = new ArrayList<>();


                data.setValue(listen2);
                break;
            case "Club Zenzyg":


                listen3= new ArrayList<>();
                listen3.add(new Drink("venus","48 kr.",R.mipmap.bloody_mary_round,48,clubId));
                listen3.add(new Drink("merkur","38 kr.",R.mipmap.cosmopolita_round,38,clubId));
                listen3.add(new Drink("mars","45 kr.",R.mipmap.daiq_round,45,clubId));
                listen3.add(new Drink("jorden","45 kr.",R.mipmap.sex_on_the_beach_round,45,clubId));
                listen3.add(new Drink("saturn","68 kr.",R.mipmap.mojito_round,68,clubId));
                listen3.add(new Drink("Jupiter","35 kr.",R.mipmap.side_car_round,35,clubId));
                listen3.add(new Drink("Neptun","50 kr.",R.mipmap.pina_round,50,clubId));
                listen3.add(new Drink("pluto","70 kr.",R.mipmap.frozen_margarita_round,70,clubId));
                listen3.add(new Drink("solen","65 kr.",R.mipmap.tequila_sunrise_round,65,clubId));
                listen3.add(new Drink("stjernene","53 kr.",R.mipmap.manhattan_round,53,clubId));



                data.setValue(listen3);
                break;

        }

    }
    public MutableLiveData<List<Drink>> fetchData(){

/*
        datas.add(new Drink("Bloody Mary","48 kr.",R.mipmap.bloody_mary_round,48));
        datas.add(new Drink("Cosmopolitan","38 kr.",R.mipmap.cosmopolita_round,38));
        datas.add(new Drink("Daiquiri","45 kr.",R.mipmap.daiq_round,45));
        datas.add(new Drink("Sex on the Beach","45 kr.",R.mipmap.sex_on_the_beach_round,45));
        datas.add(new Drink("Mojito","68 kr.",R.mipmap.mojito_round,68));
        datas.add(new Drink("Sidecar","35 kr.",R.mipmap.side_car_round,35));
        datas.add(new Drink("Piña Colada","50 kr.",R.mipmap.pina_round,50));
        datas.add(new Drink("Frozen Margharita","70 kr.",R.mipmap.frozen_margarita_round,70));
        datas.add(new Drink("Tequila Sunrise","65 kr.",R.mipmap.tequila_sunrise_round,65));
        datas.add(new Drink("Manhattan","53 kr.",R.mipmap.manhattan_round,53));

         data = new MutableLiveData<>();

        data.setValue(datas);*/
        return data;

    }

    public MutableLiveData<List<Drink>> getAllDrinks(Context context) {
        DatabaseHelper db = new DatabaseHelper(context);
        List<Drink> listen = db.getAllDrinks();
        Log.d("dsa",listen.toString()+"");
        allDrinks.setValue(listen);
        return allDrinks;

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

/*
    @Override
    public void insert(Drink drink) {
        new InsertDrinkAsync(drinks).execute(drink);
    }



    @Override
    public void update(Drink drink) {
        new UpdateDrinkAsync(drinks).execute(drink);
    }

    @Override
    public void delete(Drink drink) {
       // new DeleteDrinkAsync(drinks).execute(drink);
    }





    @Override
    public void deleteAllDrinks() {
        allDrinks.getValue().clear();
    }

    private static class InsertDrinkAsync extends AsyncTask<Drink,Void,Void>{

        private DrinkDao drinks;

        private InsertDrinkAsync(DrinkDao fDrink){
            this.drinks=fDrink;
        }
        @Override
        protected Void doInBackground(Drink... drink) {
            drinks.insert(drink[0]);
            return null;
        }
}

    private static class UpdateDrinkAsync extends AsyncTask<Drink,Void,Void>{

        private DrinkDao drinks;

        private UpdateDrinkAsync(DrinkDao fDrink){
            this.drinks=fDrink;
        }
        @Override
        protected Void doInBackground(Drink... drink) {

            drinks.update(drink[0]);
            return null;
        }
    }
    private static class DeleteDrinkAsync extends AsyncTask<Void,Void,Void>{

        private DrinkDao drinks;

        private DeleteDrinkAsync(DrinkDao fDrink){
            this.drinks=fDrink;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            drinks.deleteAllDrinks();
            return null;
        }
    }*/



}
