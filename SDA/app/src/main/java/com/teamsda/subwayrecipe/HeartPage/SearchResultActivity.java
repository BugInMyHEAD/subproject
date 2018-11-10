package com.teamsda.subwayrecipe.HeartPage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.teamsda.subwayrecipe.MainActivity;
import com.teamsda.subwayrecipe.R;

public class SearchResultActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchresult);

    }

    @Override
    public void onBackPressed() {
        Intent back_intent = new Intent(getApplicationContext(), SearchActivity.class);
        startActivity(back_intent);
        finish();
    }
}
