package com.teamsda.subwayrecipe.HeartPage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.teamsda.subwayrecipe.MainActivity;
import com.teamsda.subwayrecipe.R;

public class SearchActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

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

        Button search = (Button)findViewById(R.id.search_active);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //검색 결과 가지고 갱신
                Intent refresh_intent = new Intent(getApplicationContext(), SearchResultActivity.class);
                startActivity(refresh_intent);
                finish();
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
