package com.example.metootravel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView tv = findViewById(R.id.login_btn);

        // 버튼 클릭 시 동작
        tv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                // TextView 클릭될 시 작동할 코드작성
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.in_left, R.anim.in_right);
            }
        });
    }
}