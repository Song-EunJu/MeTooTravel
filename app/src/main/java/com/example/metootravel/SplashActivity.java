package com.example.metootravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TextView tv;
        tv = findViewById(R.id.sp_tv);
        Animation anim = AnimationUtils.loadAnimation(this,R.anim.spin);
        tv.setAnimation(anim);

        Handler hd = new Handler();
        hd.postDelayed(new SplashHandler(),3000);

    }

    private class SplashHandler implements Runnable {
        public void run() {
            startActivity(new Intent(getApplication(), MainActivity.class));
            SplashActivity.this.finish();
        }
    }

}
