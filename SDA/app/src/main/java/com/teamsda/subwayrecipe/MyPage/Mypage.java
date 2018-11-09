package com.teamsda.subwayrecipe.MyPage;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teamsda.subwayrecipe.R;

public class Mypage extends Fragment {
    public static Mypage newInstance() {
        return new Mypage();
    }
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        view =  inflater.inflate(R.layout.fragment_mypage, container, false);

        return view;
    }
}
