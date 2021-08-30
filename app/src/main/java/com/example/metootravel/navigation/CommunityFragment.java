package com.example.metootravel.navigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.metootravel.MainActivity;
import com.example.metootravel.R;
import com.example.metootravel.view.MainData;

import java.util.zip.Inflater;


public class CommunityFragment extends Fragment {

    TextView write;

    public static CommunityFragment newInstance() {
        return new CommunityFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_community, container, false);
        write = (TextView)view.findViewById(R.id.write);
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(CommunityWriteFragment.newInstance());
            }
        });
        return view;
    }
}

