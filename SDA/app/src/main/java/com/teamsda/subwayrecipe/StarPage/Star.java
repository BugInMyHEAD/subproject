package com.teamsda.subwayrecipe.StarPage;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.teamsda.subwayrecipe.Custom.HeartCustomAdapter;
import com.teamsda.subwayrecipe.Custom.RecipeClass;
import com.teamsda.subwayrecipe.Custom.StarCustomAdapter;
import com.teamsda.subwayrecipe.R;

import java.util.ArrayList;

public class Star extends Fragment {
    private ListView mListView;
    private ArrayList<RecipeClass> mRecipeArr;
    private StarCustomAdapter mAdapter;

    public static Star newInstance() {
        return new Star();
    }
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        view =  inflater.inflate(R.layout.fragment_star, container, false);

        mListView = (ListView) view.findViewById(R.id.listView_star);
        mRecipeArr = new ArrayList<RecipeClass>();

        mAdapter = new StarCustomAdapter(getContext(), mRecipeArr);
        mListView.setAdapter(mAdapter);

        mRecipeArr.clear();
        //테스트용 하드코딩
        RecipeClass recipeClass1 = new RecipeClass("우진 레시피","우진 우진", "1000");
        RecipeClass recipeClass2 = new RecipeClass("보협 레시피","보협 보협", "100");
        RecipeClass recipeClass3 = new RecipeClass("건우 레시피","건우 건우", "10");
        RecipeClass recipeClass4 = new RecipeClass("호준 레시피","호준 호준", "1");

        mRecipeArr.add(recipeClass1);
        mRecipeArr.add(recipeClass2);
        mRecipeArr.add(recipeClass3);
        mRecipeArr.add(recipeClass4);

        mAdapter.notifyDataSetChanged();
        mListView.setSelection(0);
        return view;
    }
}

