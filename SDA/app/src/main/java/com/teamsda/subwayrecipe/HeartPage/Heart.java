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
        ArrayList<String> veg1 = new ArrayList<String>();
        veg1.add("토마토");
        veg1.add("피클");
        veg1.add("양상추");
        ArrayList<String> cheese1 = new ArrayList<String>();
        cheese1.add("아메리칸 치즈");
        ArrayList<String> sauce1 = new ArrayList<String>();
        sauce1.add("렌치");

        ArrayList<String> veg2 = new ArrayList<String>();
        veg2.add("할라피뇨");
        veg2.add("오이");
        veg2.add("올리브");
        ArrayList<String> cheese2 = new ArrayList<String>();
        cheese2.add("슈레드 치즈");
        ArrayList<String> sauce2 = new ArrayList<String>();
        sauce2.add("허니 머스타드");

        IngredientsClass ingredientsClass1 = new IngredientsClass("허니오트",veg1,cheese1,sauce1);
        IngredientsClass ingredientsClass2 = new IngredientsClass("허니오트",veg2,cheese2,sauce2);
        IngredientsClass ingredientsClass3 = new IngredientsClass("플랫브래드",veg1,cheese1,sauce1);
        IngredientsClass ingredientsClass4 = new IngredientsClass("플랫브래드",veg2,cheese2,sauce2);

        RecipeClass recipeClass1 = new RecipeClass(0,"이탈리안 BMT",ingredientsClass1, "1000");
        RecipeClass recipeClass2 = new RecipeClass(1,"이탈리안 BMT",ingredientsClass2, "999");
        RecipeClass recipeClass3 = new RecipeClass(2,"이탈리안 BMT",ingredientsClass3, "998");
        RecipeClass recipeClass4 = new RecipeClass(3,"이탈리안 BMT",ingredientsClass4, "997");
        RecipeClass recipeClass5 = new RecipeClass(4,"이탈리안 BMT",ingredientsClass1, "996");
        RecipeClass recipeClass6 = new RecipeClass(5,"이탈리안 BMT",ingredientsClass2, "995");
        RecipeClass recipeClass7 = new RecipeClass(6,"이탈리안 BMT",ingredientsClass3, "994");
        RecipeClass recipeClass8 = new RecipeClass(7,"이탈리안 BMT",ingredientsClass4, "993");

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
