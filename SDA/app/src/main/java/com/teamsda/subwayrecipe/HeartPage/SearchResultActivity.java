package com.teamsda.subwayrecipe.HeartPage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.teamsda.subwayrecipe.Custom.HeartCustomAdapter;
import com.teamsda.subwayrecipe.Custom.IngredientsClass;
import com.teamsda.subwayrecipe.Custom.RecipeClass;
import com.teamsda.subwayrecipe.MainActivity;
import com.teamsda.subwayrecipe.R;

import java.util.ArrayList;

public class SearchResultActivity extends AppCompatActivity {

    private ListView mListView;
    private ArrayList<RecipeClass> mRecipeArr;
    private HeartCustomAdapter mAdapter;
    RecipeClass ForRecipe;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchresult);

        Intent search_intent = getIntent();
        String bread = search_intent.getStringExtra("bread");

        Button back = (Button)findViewById(R.id.searchresult_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mListView = (ListView) findViewById(R.id.listView_heart);
        mRecipeArr = new ArrayList<RecipeClass>();

        mAdapter = new HeartCustomAdapter(getApplication(), mRecipeArr);
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

        IngredientsClass ingredientsClass1 = new IngredientsClass("허니오트",veg,cheese,sauce);
        IngredientsClass ingredientsClass2 = new IngredientsClass("플랫브래드",veg,cheese,sauce);

        RecipeClass recipeClass1 = new RecipeClass(0,"이탈리안 BMT",ingredientsClass1, "1000");
        RecipeClass recipeClass2 = new RecipeClass(1,"이탈리안 BMT",ingredientsClass2, "999");
        RecipeClass recipeClass3 = new RecipeClass(2,"이탈리안 BMT",ingredientsClass1, "998");
        RecipeClass recipeClass4 = new RecipeClass(3,"이탈리안 BMT",ingredientsClass2, "997");
        RecipeClass recipeClass5 = new RecipeClass(4,"이탈리안 BMT",ingredientsClass1, "996");
        RecipeClass recipeClass6 = new RecipeClass(5,"이탈리안 BMT",ingredientsClass2, "995");
        RecipeClass recipeClass7 = new RecipeClass(6,"이탈리안 BMT",ingredientsClass1, "994");
        RecipeClass recipeClass8 = new RecipeClass(7,"이탈리안 BMT",ingredientsClass2, "993");

        mRecipeArr.add(recipeClass1);
        mRecipeArr.add(recipeClass2);
        mRecipeArr.add(recipeClass3);
        mRecipeArr.add(recipeClass4);
        mRecipeArr.add(recipeClass5);
        mRecipeArr.add(recipeClass6);
        mRecipeArr.add(recipeClass7);
        mRecipeArr.add(recipeClass8);

        for(int i=0;i<mRecipeArr.size();i++) {
            if (!mRecipeArr.get(i).getIngredientsClass().getBread().equals(bread)){
                mRecipeArr.remove(i);
            }
        }

        mAdapter.notifyDataSetChanged();
        mListView.setSelection(0);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                ForRecipe = mRecipeArr.get(position);

                Intent recipe_intent = new Intent(getApplicationContext(), RecipeActivity.class);
                recipe_intent.putExtra("where","Result");
                recipe_intent.putExtra("mark","♥");
                recipe_intent.putExtra("title", ForRecipe.getTitle());
                recipe_intent.putExtra("ingredients", ForRecipe.getIngredientsClass().getIngredients());
                recipe_intent.putExtra("score", ForRecipe.getScore());

                startActivity(recipe_intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
