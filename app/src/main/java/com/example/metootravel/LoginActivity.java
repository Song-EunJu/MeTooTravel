package com.example.metootravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView tv = findViewById(R.id.register_btn);

        // 버튼 클릭 시 동작
        tv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                // TextView 클릭될 시 할 코드작성
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.in_left, R.anim.in_right);
            }
        });
    }
}