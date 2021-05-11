package com.example.myapp.data.Drinks;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "drinks")
public class Drink {

    @PrimaryKey(autoGenerate = true)
    private String title,price;
    private int image;
    private int popularity;

    public Drink(String title, String price, int image){
        this.title=title;
        this.image=image;
        this.price=price;

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

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }
}
