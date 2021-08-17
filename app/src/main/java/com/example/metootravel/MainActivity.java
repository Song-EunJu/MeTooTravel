package com.example.metootravel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.metootravel.navigation.LetterFragment;
import com.example.metootravel.navigation.MessageFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    Fragment messageFragment;
    Fragment letterFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener m = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
            switch (item.getItemId()) {
//            case R.id.action_home:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_letter, )

                case R.id.action_message:
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_content, messageFragment).commit();
                    return true;
                case R.id.action_letter:
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_content, letterFragment).commit();
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavigationBarView navbar = findViewById(R.id.navigation_bar); // activity_main 에 네비게이션 바 id
        navbar.setOnItemSelectedListener(m);
        messageFragment = new MessageFragment();
        letterFragment = new LetterFragment();
    }

}
//    @Override
//    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
//        switch(item.getItemId()){
////            case R.id.action_home:
////                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_letter, )
//
//            case R.id.action_message:
//                getSupportFragmentManager().beginTransaction().replace(R.id.main_content, messageFragment).commit();
//                return true;
//            case R.id.action_letter:
//                getSupportFragmentManager().beginTransaction().replace(R.id.main_content, letterFragment).commit();
//                return true;
//
//        }
//        return false;
//    }
