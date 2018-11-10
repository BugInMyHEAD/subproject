package com.teamsda.subwayrecipe.HeartPage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.teamsda.subwayrecipe.MainActivity;
import com.teamsda.subwayrecipe.R;

public class RecipeActivity extends AppCompatActivity {

    TextView recipe_title,recipe_bread,recipe_veg,recipe_cheese,recipe_sauce,recipe_mark,recipe_score;
    String st_where,st_title,st_ingredients,st_mark,st_score;
    Button recipe_back,recipe_save,recipe_smart,recipe_qr;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        recipe_title = (TextView)findViewById(R.id.recipe_title);
        recipe_bread = (TextView)findViewById(R.id.recipe_bread);
        recipe_veg = (TextView)findViewById(R.id.recipe_veg);
        recipe_cheese = (TextView)findViewById(R.id.recipe_cheese);
        recipe_sauce = (TextView)findViewById(R.id.recipe_sauce);
        recipe_mark = (TextView)findViewById(R.id.recipe_mark);
        recipe_score = (TextView)findViewById(R.id.recipe_score);

        Intent recipe_intent = getIntent();
        st_where = recipe_intent.getStringExtra("where");
        st_title = recipe_intent.getStringExtra("title");
        st_ingredients = recipe_intent.getStringExtra("ingredients");
        String[] ingredients = st_ingredients.split("/");
        st_mark = recipe_intent.getStringExtra("mark");
        st_score = recipe_intent.getStringExtra("score");

        recipe_title.setText(st_title);
        recipe_bread.setText(ingredients[0]);
        recipe_veg.setText(ingredients[1]);
        recipe_cheese.setText(ingredients[2]);
        recipe_sauce.setText(ingredients[3]);
        recipe_mark.setText(st_mark);
        recipe_score.setText(st_score);

        recipe_back = (Button)findViewById(R.id.recipe_back);
        recipe_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(st_where.equals("Heart")) {
                    Intent refresh_intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(refresh_intent);
                    finish();
                }
                else if(st_where.equals("Result")){
                    finish();
                }
            }
        });
        recipe_save = (Button)findViewById(R.id.recipe_save);
        recipe_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"저장되었습니다.",Toast.LENGTH_SHORT).show();
            }
        });

        recipe_smart = (Button)findViewById(R.id.recipe_smart);
        recipe_smart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"스마트 오더 준비중",Toast.LENGTH_SHORT).show();
            }
        });

        recipe_qr = (Button)findViewById(R.id.recipe_qr);
        recipe_qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"qr코드 오더 준비중",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        // 오는 곳에 따라 나가는 곳 수정
        if(st_where.equals("Heart")) {
            Intent refresh_intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(refresh_intent);
            finish();
        }
        else if(st_where.equals("Result")){
            finish();
        }
    }
}
