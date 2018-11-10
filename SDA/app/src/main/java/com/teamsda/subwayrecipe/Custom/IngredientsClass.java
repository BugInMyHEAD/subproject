package com.teamsda.subwayrecipe.Custom;

import java.util.ArrayList;

public class IngredientsClass {
    String bread;
    ArrayList<String> veg;
    ArrayList<String> cheese;
    ArrayList<String> sauce;

    public IngredientsClass(){}

    public IngredientsClass(String bread, ArrayList<String> veg, ArrayList<String> cheese, ArrayList<String> sauce){

        this.bread = bread;
        this.veg = veg;
        this.cheese = cheese;
        this.sauce = sauce;
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public ArrayList<String> getVeg() {
        return veg;
    }

    public void setVeg(ArrayList<String> veg) {
        this.veg = veg;
    }

    public ArrayList<String> getCheese() {
        return cheese;
    }

    public void setCheese(ArrayList<String> cheese) {
        this.cheese = cheese;
    }

    public ArrayList<String> getSauce() {
        return sauce;
    }

    public void setSauce(ArrayList<String> sauce) {
        this.sauce = sauce;
    }

    public String getIngredients(){
        return bread+"/ "+veg+"/ "+cheese+"/ "+sauce;
    }
}
