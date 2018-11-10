package com.teamsda.subwayrecipe.HeartPage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.teamsda.subwayrecipe.MainActivity;
import com.teamsda.subwayrecipe.R;

public class SearchActivity extends AppCompatActivity {

    Spinner bread;
    String sp_bread;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        bread = (Spinner)findViewById(R.id.spinner_bread);
        bread.setSelected(false);

        Button back = (Button)findViewById(R.id.search_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent refresh_intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(refresh_intent);
                finish();
            }
        });

        Button save = (Button)findViewById(R.id.search_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"저장되었습니다.",Toast.LENGTH_SHORT).show();
            }
        });

        //검색 동작 버튼
        Button search = (Button)findViewById(R.id.search_active);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp_bread = bread.getSelectedItem().toString();
                Intent search_intent = new Intent(getApplicationContext(), SearchResultActivity.class);
                search_intent.putExtra("bread",sp_bread);

                startActivity(search_intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent refresh_intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(refresh_intent);
        finish();
    }
}
