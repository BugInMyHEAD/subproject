package com.teamsda.subwayrecipe.HeartPage;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.teamsda.subwayrecipe.Custom.HeartCustomAdapter;
import com.teamsda.subwayrecipe.Custom.IngredientsClass;
import com.teamsda.subwayrecipe.Custom.RecipeClass;
import com.teamsda.subwayrecipe.R;

import java.util.ArrayList;

public class Heart extends Fragment {
    private ListView mListView;
    private ArrayList<RecipeClass> mRecipeArr;
    private HeartCustomAdapter mAdapter;
    RecipeClass ForRecipe;

    public static Heart newInstance() {
        return new Heart();
    }

    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        view =  inflater.inflate(R.layout.fragment_heart, container, false);


        //검색
        Button search = (Button)view.findViewById(R.id.search_heart);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent search_intent = new Intent(getContext(),SearchActivity.class);
                search_intent.putExtra("mark","♥");

                startActivity(search_intent);
                getActivity().finish();
            }
        });

        mListView = (ListView) view.findViewById(R.id.listView_heart);
        mRecipeArr = new ArrayList<RecipeClass>();

        mAdapter = new HeartCustomAdapter(getContext(), mRecipeArr);
        mListView.setAdapter(mAdapter);

        mRecipeArr.clear();
        //테스트용 하드코딩
        ArrayList<String> veg = new ArrayList<String>();
        veg.add("토마토");
        veg.add("피클");
        veg.add("양상추");
        ArrayList<String> cheese = new ArrayList<String>();
        cheese.add("아메리칸 치즈");
        ArrayList<String> sauce = new ArrayList<String>();
        sauce.add("렌치");

        IngredientsClass ingredientsClass = new IngredientsClass("허니오트",veg,cheese,sauce);
        RecipeClass recipeClass1 = new RecipeClass(0,"이탈리안 BMT",ingredientsClass, "1000");
        RecipeClass recipeClass2 = new RecipeClass(1,"이탈리안 BMT",ingredientsClass, "999");
        RecipeClass recipeClass3 = new RecipeClass(2,"이탈리안 BMT",ingredientsClass, "998");
        RecipeClass recipeClass4 = new RecipeClass(3,"이탈리안 BMT",ingredientsClass, "997");
        RecipeClass recipeClass5 = new RecipeClass(4,"이탈리안 BMT",ingredientsClass, "996");
        RecipeClass recipeClass6 = new RecipeClass(5,"이탈리안 BMT",ingredientsClass, "995");
        RecipeClass recipeClass7 = new RecipeClass(6,"이탈리안 BMT",ingredientsClass, "994");
        RecipeClass recipeClass8 = new RecipeClass(7,"이탈리안 BMT",ingredientsClass, "993");

        mRecipeArr.add(recipeClass1);
        mRecipeArr.add(recipeClass2);
        mRecipeArr.add(recipeClass3);
        mRecipeArr.add(recipeClass4);
        mRecipeArr.add(recipeClass5);
        mRecipeArr.add(recipeClass6);
        mRecipeArr.add(recipeClass7);
        mRecipeArr.add(recipeClass8);


        mAdapter.notifyDataSetChanged();
        mListView.setSelection(0);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
               ForRecipe = mRecipeArr.get(position);

                Intent recipe_intent = new Intent(getContext(), RecipeActivity.class);
                recipe_intent.putExtra("where","Heart");
                recipe_intent.putExtra("mark","♥");
                recipe_intent.putExtra("title", ForRecipe.getTitle());
                recipe_intent.putExtra("ingredients", ForRecipe.getIngredientsClass().getIngredients());
                recipe_intent.putExtra("score", ForRecipe.getScore());

                startActivity(recipe_intent);
                getActivity().finish();
            }
        });
        return view;
    }
}
