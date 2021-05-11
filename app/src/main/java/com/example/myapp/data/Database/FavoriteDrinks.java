package com.example.myapp.data.Database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Drinks_table")
public class FavoriteDrinks {
        @PrimaryKey(autoGenerate = true)
        private int image;
        private String price;
        private String name;
        private int popularity;

        public FavoriteDrinks(String price,String name, int image){
            this.image=image;
            this.name=name;
            this.price=price;
        }

        public String getName() {
            return name;
        }

        public int getImage() {
            return image;
        }

        public String getPrice() {
            return price;
        }

    public int getPopularity() {
        return popularity;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setPopularity(int point) {
        this.popularity++;
    }


}
