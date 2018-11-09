package com.teamsda.subwayrecipe.Custom;

public class RecipeClass {

    String title;
    String ingredients;
    String score;

    public RecipeClass(){}

    public RecipeClass(String title, String ingredients, String score){
        this.title = title;
        this.ingredients = ingredients;
        this.score = score;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
