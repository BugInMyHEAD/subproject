package com.teamsda.subwayrecipe.HeartPage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import com.teamsda.subwayrecipe.MainActivity;
import com.teamsda.subwayrecipe.R;

public class SearchActivity extends AppCompatActivity {

    Spinner bread;
    String sp_bread,st_veg,st_cheese,st_sauce;

    CheckBox checkveg0,checkveg1,checkveg2,checkveg3,checkveg4,checkveg5,checkveg6,checkveg7,checkveg8;
    CheckBox checkcheese0,checkcheese1;
    CheckBox checksauce0,checksauce1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        bread = (Spinner)findViewById(R.id.spinner_bread);
        bread.setSelected(false);

        checkveg0 = (CheckBox)findViewById(R.id.lettuce);
        checkveg1 = (CheckBox)findViewById(R.id.tomatoes);
        checkveg2 = (CheckBox)findViewById(R.id.cucumbers);
        checkveg3 = (CheckBox)findViewById(R.id.peppers);
        checkveg4 = (CheckBox)findViewById(R.id.red_onions);
        checkveg5 = (CheckBox)findViewById(R.id.pickles);
        checkveg6 = (CheckBox)findViewById(R.id.olives);
        checkveg7 = (CheckBox)findViewById(R.id.jalapenos);
        checkveg8 = (CheckBox)findViewById(R.id.avocado);

        checkcheese0 = (CheckBox)findViewById(R.id.american_cheese);
        checkcheese1 = (CheckBox)findViewById(R.id.shredded_cheese);

        checksauce0 = (CheckBox)findViewById(R.id.honey_mustard);
        checksauce1 = (CheckBox)findViewById(R.id.ranch);

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
                st_veg="";
                st_cheese="";
                st_sauce="";

                if(checkveg0.isChecked()) st_veg+=checkveg0.getText()+",";
                if(checkveg1.isChecked()) st_veg+=checkveg1.getText()+",";
                if(checkveg2.isChecked()) st_veg+=checkveg2.getText()+",";
                if(checkveg3.isChecked()) st_veg+=checkveg3.getText()+",";
                if(checkveg4.isChecked()) st_veg+=checkveg4.getText()+",";
                if(checkveg5.isChecked()) st_veg+=checkveg5.getText()+",";
                if(checkveg6.isChecked()) st_veg+=checkveg6.getText()+",";
                if(checkveg7.isChecked()) st_veg+=checkveg7.getText()+",";
                if(checkveg8.isChecked()) st_veg+=checkveg8.getText()+",";

                if(checkcheese0.isChecked()) st_cheese+=checkcheese0.getText()+",";
                if(checkcheese1.isChecked()) st_cheese+=checkcheese1.getText()+",";

                if(checksauce0.isChecked()) st_sauce+=checksauce0.getText()+",";
                if(checksauce1.isChecked()) st_sauce+=checksauce1.getText()+",";

                Intent search_intent = new Intent(getApplicationContext(), SearchResultActivity.class);
                search_intent.putExtra("bread",sp_bread);
                search_intent.putExtra("veg",st_veg);
                search_intent.putExtra("cheese",st_cheese);
                search_intent.putExtra("sauce",st_sauce);

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
