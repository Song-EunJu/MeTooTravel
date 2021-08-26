package com.example.metootravel.navigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.metootravel.R;
import com.example.metootravel.view.MainData;


public class CommunityFragment extends Fragment {

    TextView tv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_community, container, false);
        tv = (TextView)view.findViewById(R.id.write);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

//        btn_add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                MainData mainData = new MainData(R.mipmap.ic_launcher, "하영보미", "리사이클러뷰1");
//                arrayList.add(mainData);
//                mainAdapter.notifyDataSetChanged();
//            }
//        });

        return view;
    }

}