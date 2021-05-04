package com.example.myapp.data.Drinks;

public class Drink {

    private String title,price;
    private int image;

    public Drink(){

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public String getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }


}
