package com.teamsda.subwayrecipe.Custom;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.teamsda.subwayrecipe.R;

import java.util.ArrayList;

public class HeartCustomAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private ArrayList<RecipeClass> RecipeArr;
    private ViewHolder holder;

    public HeartCustomAdapter(Context c, ArrayList<RecipeClass> array) {
        mInflater = LayoutInflater.from(c);
        RecipeArr = array;
    }

    @Override
    public int getCount() {
        return RecipeArr.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(v == null) {
            v = mInflater.inflate(R.layout.listview_custom_heart, null);
            holder = new ViewHolder();
            holder.img = (ImageView)v.findViewById(R.id.heart_img);
            holder.crown = (TextView)v.findViewById(R.id.heart_crown);
            holder.title = (TextView)v.findViewById(R.id.heart_title);
            holder.ingredients = (TextView)v.findViewById(R.id.heart_ingredients);
            holder.score = (TextView)v.findViewById(R.id.heart_score);
            v.setTag(holder);
        }else{
            holder = (ViewHolder)v.getTag();
        }

        //InfoClass를 생성하여 각 뷰의 포지션에 맞는 데이터를 가져옴
        RecipeClass recipe = RecipeArr.get(position);
        //디비에 이미지 저장형태에 따라 수정
        holder.img.setImageDrawable(recipe.drawable);
        holder.crown.setText(String.valueOf(recipe.position));
        holder.crown.setTag(recipe.position);
        holder.title.setText(recipe.title);
        holder.ingredients.setText(recipe.ingredientsClass.getIngredients());
        holder.score.setText(recipe.score);

        return v;
    }

    //ArrayList Getter And Setter
    public void setArrayList(ArrayList<RecipeClass> arrays) {
        this.RecipeArr = arrays;
    }

    public ArrayList<RecipeClass> getArrayList(){
        return RecipeArr;
    }


    /**
     * ViewHolder Class 생성
     */
    private class ViewHolder {
        ImageView img;
        TextView crown;
        TextView title;
        TextView ingredients;
        TextView score;
    }
}