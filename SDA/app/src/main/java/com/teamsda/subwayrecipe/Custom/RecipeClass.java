package com.teamsda.subwayrecipe.Custom;

import android.graphics.drawable.Drawable;

public class RecipeClass {

    Drawable drawable;
    int position;
    String title;
    IngredientsClass ingredientsClass;
    String score;

    public RecipeClass(){}

    public RecipeClass(Drawable drawable,int position, String title, IngredientsClass ingredientsClass, String score){
        this.drawable = drawable;
        this.position = position;
        this.title = title;
        this.ingredientsClass = ingredientsClass;
        this.score = score;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public IngredientsClass getIngredientsClass() {
        return ingredientsClass;
    }

    public void setIngredientsClass(IngredientsClass ingredientsClass) {
        this.ingredientsClass = ingredientsClass;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
