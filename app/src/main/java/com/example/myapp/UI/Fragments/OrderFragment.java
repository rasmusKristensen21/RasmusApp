package com.example.myapp.UI.Fragments;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.myapp.R;
import com.example.myapp.UI.Activity.MainActivity;
import com.example.myapp.UI.ViewModels.OrderViewModel;
import com.example.myapp.data.Drinks.Drink;
import com.example.myapp.data.databaseNew.DatabaseHelper;
import com.example.myapp.data.models.DrinkModel;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

public class OrderFragment extends Fragment implements Serializable {
    private static final long serialVersionUID = -2163051469151804394L;


    private OrderViewModel viewModel;
    TextView name;
    TextView price;
    ImageView image;
    TextView grandTotal;
    Drink drink1;
    Drink drink2;
    Drink drink3;

    ArrayList<Drink> drinksTO = new ArrayList<>();

    TextView name2;
    TextView price2;

    TextView name3;
    TextView price3;



    int total=0;
    String navn;
    String prisen;
    String navn2;
    String prisen2;
    String navn3;
    String prisen3;
    int billed;
    int billed2;
    int billed3;
    Button enterButton;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_order, container, false);



        grandTotal = view.findViewById(R.id.total_price);
        name = view.findViewById(R.id.drink_name);
        image = view.findViewById(R.id.app_bar_image);
        price = view.findViewById(R.id.price);
        name2 = view.findViewById(R.id.drink_name2);
        price2=view.findViewById(R.id.price2);
        name3 = view.findViewById(R.id.drink_name3);
        price3=view.findViewById(R.id.price3);



        enterButton= view.findViewById(R.id.sendDrink);

        //DatabaseHelper dbh = new DatabaseHelper(getContext());
        //dbh.deleteAll();

        viewModel = ViewModelProviders.of(this).get(OrderViewModel.class);


            viewModel.getClickedItem().observe(getViewLifecycleOwner(), drinkModels -> {



                switch (drinkModels.size()){
                    case 1:

                        grandTotal.setText(drinkModels.get(0).getPricetag()+"");
                        break;
                    case 2:

                        grandTotal.setText((drinkModels.get(0).getPricetag()+drinkModels.get(1).getPricetag())+"");
                        break;
                    case 3:

                        grandTotal.setText((drinkModels.get(0).getPricetag()+drinkModels.get(1).getPricetag()+drinkModels.get(2).getPricetag())+"");
                        break;
                }



                if(drinkModels.size()>0) {

                    drink1= drinkModels.get(0);
                    navn = drinkModels.get(0).getTitle();
                    billed = drinkModels.get(0).getImage();
                    prisen = drinkModels.get(0).getPrice();
                    Log.d("Rasmussss",drinkModels.get(0).getClubId());
                    name.setText(navn);
                    image.setImageResource(billed);
                    price.setText(prisen);

                }




                if(drinkModels.size()>1) {

                    drink2=drinkModels.get(1);
                            navn2 = drinkModels.get(1).getTitle();
                            billed2 = drinkModels.get(1).getImage();
                            prisen2 = drinkModels.get(1).getPrice();

                            name2.setText(navn2);
                            image.setImageResource(billed2);
                            price2.setText(prisen2);


                }

                if(drinkModels.size()>2) {
                    drink3=drinkModels.get(2);
                    navn3 = drinkModels.get(2).getTitle();
                    billed3 = drinkModels.get(2).getImage();
                    prisen3 = drinkModels.get(2).getPrice();

                    name3.setText(navn3);
                    image.setImageResource(billed3);
                    price3.setText(prisen3);


                }






            });



        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewModel.clearDrinks();
                grandTotal.setText("");
                name.setText("");
                price.setText("");
                price2.setText("");
                name2.setText("");
                price3.setText("");
                name3.setText("");




                //viewModel.addDrinkToFavorite(drinken);
                if(drink1==null){
                    Toast.makeText(getContext(),"please go to the drinks and select one to order",Toast.LENGTH_SHORT);
                }
                else {

                    try  {

                        DatabaseHelper dbh = new DatabaseHelper(getContext());
                        boolean adding1 = dbh.addOneRow(drink1);
                        Log.d("dbs",adding1+"calling1");
                        DatabaseHelper dbh2 = new DatabaseHelper(getContext());
                        boolean adding2 = dbh2.addOneRow(drink2);
                        Log.d("dbs",adding2+"calling2");
                        DatabaseHelper dbh3 = new DatabaseHelper(getContext());
                        boolean adding3 = dbh3.addOneRow(drink3);
                        Log.d("dbs",adding3+"calling3");

                    }
                    catch(Exception e){

                        Toast.makeText(getContext(),"something is wrong",Toast.LENGTH_SHORT);
                    }






                }


            }
        });






        // Inflate the layout for this fragment
        return view;


    }



    /*@Override
    public void onPause() {
        super.onPause();
        SharedPreferences preferences = this.getActivity().getSharedPreferences("drinkSelected", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =preferences.edit();
        editor
    }*/
}


