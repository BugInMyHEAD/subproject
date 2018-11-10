package com.teamsda.subwayrecipe.Custom;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.teamsda.subwayrecipe.R;

import java.util.ArrayList;

public class StarCustomAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private ArrayList<RecipeClass> RecipeArr;
    private ViewHolder holder;

    public StarCustomAdapter(Context c, ArrayList<RecipeClass> array) {
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
            v = mInflater.inflate(R.layout.listview_custom_star, null);
            holder = new ViewHolder();
            holder.title = (TextView)v.findViewById(R.id.star_title);
            holder.ingredients = (TextView)v.findViewById(R.id.star_ingredients);
            holder.score = (TextView)v.findViewById(R.id.star_score);

            v.setTag(holder);
        }else{
            holder = (ViewHolder)v.getTag();
        }

        //InfoClass를 생성하여 각 뷰의 포지션에 맞는 데이터를 가져옴
        RecipeClass recipe = RecipeArr.get(position);

        //리스트뷰의 아이템에 맞는 String값을 입력
        holder.title.setText(recipe.title);
        //holder.ingredients.setText(recipe.ingredients);
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
        TextView title;
        TextView ingredients;
        TextView score;

    }
}