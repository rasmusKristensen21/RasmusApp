package com.example.myapp.UI.ViewModels;

import com.example.myapp.data.Repository.ClickedDrinkRepository;

public class AdapterViewModel {

    private String name;
    private String price;
    private int image;
    private ClickedDrinkRepository repo;



    public void setBundle(String name,String price,int image){
       repo = ClickedDrinkRepository.getGetInstance();
       repo.setArray(price,name,image);
    }

}
