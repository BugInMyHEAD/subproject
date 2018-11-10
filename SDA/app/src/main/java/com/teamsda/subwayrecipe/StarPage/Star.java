package com.teamsda.subwayrecipe.StarPage;

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
import com.teamsda.subwayrecipe.Custom.RecipeClass;
import com.teamsda.subwayrecipe.Custom.StarCustomAdapter;
import com.teamsda.subwayrecipe.HeartPage.RecipeActivity;
import com.teamsda.subwayrecipe.HeartPage.SearchActivity;
import com.teamsda.subwayrecipe.R;

import java.util.ArrayList;

public class Star extends Fragment {
    private ListView mListView;
    private ArrayList<RecipeClass> mRecipeArr;
    private StarCustomAdapter mAdapter;

    RecipeClass ForRecipe;

    public static Star newInstance() {
        return new Star();
    }
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        view =  inflater.inflate(R.layout.fragment_star, container, false);

        Button search = (Button)view.findViewById(R.id.search_star);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent search_intent = new Intent(getContext(),SearchActivity.class);
                search_intent.putExtra("mark","★");
                startActivity(search_intent);
                getActivity().finish();
            }
        });

        mListView = (ListView) view.findViewById(R.id.listView_star);
        mRecipeArr = new ArrayList<RecipeClass>();

        mAdapter = new StarCustomAdapter(getContext(), mRecipeArr);
        mListView.setAdapter(mAdapter);

        mRecipeArr.clear();
        //테스트용 하드코딩
       /* RecipeClass recipeClass1 = new RecipeClass(0,"터키 베이컨 아보카도","허니오트, 아보카도", "1000");
        RecipeClass recipeClass2 = new RecipeClass(1,"폴드 포크","플랫 브래드, 아메리칸 치즈", "100");
        RecipeClass recipeClass3 = new RecipeClass(2,"치킨 데리야끼","플랫 브래드, 체다 치즈", "10");
        RecipeClass recipeClass4 = new RecipeClass(3,"이탈리안 BMT","허니오트, 아메리칸 치즈", "1");

        mRecipeArr.add(recipeClass1);
        mRecipeArr.add(recipeClass2);
        mRecipeArr.add(recipeClass3);
        mRecipeArr.add(recipeClass4);*/

        mAdapter.notifyDataSetChanged();
        mListView.setSelection(0);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                ForRecipe = mRecipeArr.get(position);

                Intent recipe_intent = new Intent(getContext(), RecipeActivity.class);
                recipe_intent.putExtra("mark","★");
                recipe_intent.putExtra("title", ForRecipe.getTitle());
               // recipe_intent.putExtra("ingredients", ForRecipe.getIngredients());
                recipe_intent.putExtra("score", ForRecipe.getScore());

                startActivity(recipe_intent);
                getActivity().finish();
            }
        });
        return view;
    }
}

