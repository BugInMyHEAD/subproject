package com.teamsda.subwayrecipe.Custom;

public class RecipeClass {

    int position;
    String title;
    IngredientsClass ingredientsClass;
    String score;

    public RecipeClass(){}

    public RecipeClass(int position, String title, IngredientsClass ingredientsClass, String score){
        this.position = position;
        this.title = title;
        this.ingredientsClass = ingredientsClass;
        this.score = score;
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
