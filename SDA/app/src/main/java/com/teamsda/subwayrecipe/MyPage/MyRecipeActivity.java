package com.teamsda.subwayrecipe.MyPage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.teamsda.subwayrecipe.MainActivity;
import com.teamsda.subwayrecipe.R;

public class MyRecipeActivity extends AppCompatActivity {

    TextView myrecipe_title,myrecipe_ingredients;
    String st_title,st_ingredients;
    Button myrecipe_back;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myrecipe);

        myrecipe_back = (Button)findViewById(R.id.myrecipe_back);
        myrecipe_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

      /*  myrecipe_title = (TextView)findViewById(R.id.recipe_title);
        myrecipe_ingredients = (TextView)findViewById(R.id.recipe_ingredients);

        Intent recipe_intent = getIntent();
        st_title = recipe_intent.getStringExtra("title");
        st_ingredients = recipe_intent.getStringExtra("ingredients");*/
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
