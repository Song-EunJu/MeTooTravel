package com.example.metootravel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.metootravel.navigation.CommunityFragment;
import com.example.metootravel.navigation.HomeFragment;
import com.example.metootravel.navigation.LetterFragment;
import com.example.metootravel.navigation.LibraryFragment;
import com.example.metootravel.navigation.MessageFragment;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    Fragment homeFragment;
    Fragment messageFragment;
    Fragment letterFragment;
    Fragment communityFragment;
    Fragment libraryFragment;

    BottomAppBar bab;


    private BottomNavigationView.OnNavigationItemSelectedListener m
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_content, homeFragment).commit();
                    return true;
                case R.id.action_message:
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_content, messageFragment).commit();
                    return true;
//                case R.id.action_letter:
//                    getSupportFragmentManager().beginTransaction().replace(R.id.main_content, letterFragment).commit();
//                    return true;
                case R.id.action_community:
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_content, communityFragment).commit();
                    return true;
                case R.id.action_library:
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_content, libraryFragment).commit();
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView nav = findViewById(R.id.navigation_bar); // activity_main ??? ??????????????? ??? id
        nav.setOnNavigationItemSelectedListener(m);

//        bab = findViewById(R.id.navigation_bar);
//        setSupportActionBar(bab);

        homeFragment = new HomeFragment();
        messageFragment = new MessageFragment();
        letterFragment = new LetterFragment();
        communityFragment = new CommunityFragment();
        libraryFragment = new LibraryFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, homeFragment).commit();

    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_content, fragment).commit();      // Fragment??? ????????? MainActivity?????? layout????????? ???x???
    }
}
