package com.example.vizsgarremek;

import com.google.gson.annotations.Expose;

import java.util.List;

public class Etel {
    @Expose
    private int food_id;
    @Expose
    private String food_name;
    @Expose
    private String food_description;
    @Expose
    private String food_category;
    @Expose
    private int food_price;
    @Expose
    private String food_image;

    public Etel(int id, String nev, String leiras, String kategoria, int ar,String food_image){
        this.food_id = id;
        this.food_name = nev;
        this.food_description =leiras;
        this.food_category =kategoria;
        this.food_price = ar;
        this.food_image = food_image;

    }
    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getFood_description() {
        return food_description;
    }

    public void setFood_description(String food_description) {
        this.food_description = food_description;
    }

    public String getFood_category() {
        return food_category;
    }

    public void setFood_category(String food_category) {
        this.food_category = food_category;
    }

    public int getFood_price() {
        return food_price;
    }

    public void setFood_price(int food_price) {
        this.food_price = food_price;
    }

    public String getFood_image() {
        return food_image;
    }

    public void setFood_image(String food_image) {
        this.food_image = food_image;
    }


}
class MenuHelper {
    private List<Etel> menu;

    public List<Etel> getEtelList() {
        return menu;
    }
}