package com.example.metootravel.navigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.metootravel.R;
import com.example.metootravel.view.MainData;


public class CommunityWriteFragment extends Fragment {

    EditText editContent;
    Button writeRegister;

    public static CommunityWriteFragment newInstance() {
        return new CommunityWriteFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_community_write, container, false);
        editContent = view.findViewById(R.id.writeContent);
        writeRegister = view.findViewById(R.id.writeRegister);

        writeRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // 여기서 서버로 보내고 community_home 에서 서버에서 정보를 받아와서 띄워주어야 함
                Toast myToast = Toast.makeText(view.getContext(), editContent.getText(), Toast.LENGTH_SHORT);
                myToast.show();
            }
        });

        return view;
    }
}