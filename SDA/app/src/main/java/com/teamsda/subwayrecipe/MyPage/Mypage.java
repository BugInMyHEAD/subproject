package com.teamsda.subwayrecipe.MyPage;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.teamsda.subwayrecipe.R;

public class Mypage extends Fragment {

    Button myrecipe;

    public static Mypage newInstance() {
        return new Mypage();
    }
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        view =  inflater.inflate(R.layout.fragment_mypage, container, false);

       myrecipe = (Button)view.findViewById(R.id.mypage_myrecipe);
        myrecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myrecipe_intent = new Intent(getContext(),MyRecipeActivity.class);
                startActivity(myrecipe_intent);
            }
        });

        return view;
    }
}
