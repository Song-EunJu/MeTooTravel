package com.example.metootravel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView tv = findViewById(R.id.login_btn); // 회원가입창에서 로그인 화면으로 넘어가고 싶을 때 로그인 클릭
        // 버튼 클릭 시 동작
//        tv.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v){
//                // TextView 클릭될 시 작동할 코드작성
//                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
//                startActivity(intent);
//                overridePendingTransition(R.anim.in_left, R.anim.in_right);
//            }
//        });

        Button register_form_move = findViewById(R.id.register_form_move); // 회원가입 폼 화면으로 넘어가는 버튼

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_btn:
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.in_left, R.anim.in_right);
                break;
            case R.id.register_form_move:
                Intent intent2 = new Intent(RegisterActivity.this, RegisterFormActivity.class);
                startActivity(intent2);
                break;
        }
    }
}