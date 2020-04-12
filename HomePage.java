package com.example.sendthro;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class HomePage extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

       mAuth = FirebaseAuth.getInstance();



        BottomNavigationView bottomNavigationView = findViewById(R.id.bnview);
        bottomNavigationView.setOnNavigationItemSelectedListener(NavLi);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new scheduledmsg()).commit();

    }

        BottomNavigationView.OnNavigationItemSelectedListener NavLi =
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;

                        switch (item.getItemId()) {
                            case R.id.nav_time:
                                selectedFragment = new scheduledmsg();
                                break;

                            case R.id.nav_archive:
                                selectedFragment = new archivedmsg();
                                break;

                            case R.id.nav_calendar:
                                selectedFragment = new CalendarFragment();
                                break;

                            case R.id.nav_setting:
                                selectedFragment = new settings();
                                break;
                        }

                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                selectedFragment).commit();

                        return true;
                    }
                };
    }


//        BottomNavigationView bottomNavigationView = findViewById(R.id.bnview);
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//
//                    switch (item.getItemId()){
//                                case R.id.nav_time:
//                                    Intent N1 = new Intent(HomePage.this, ScheduledmsgActivity.class);
//                                    startActivity(N1);
//                                    break;
//
//                                case R.id.nav_archive:
//                                    Intent N2 = new Intent(HomePage.this, archivedmsgActivity.class);
//                                    startActivity(N2);
//                                    break;
//
//                                case R.id.nav_calendar:
//                                    Intent N3 = new Intent(HomePage.this, calenderActivity.class);
//                                    startActivity(N3);
//                                    break;
//
//                                case R.id.nav_setting:
//                                    Intent N4 = new Intent(HomePage.this, settingsActivity.class);
//                                    startActivity(N4);
//                                    break;
//                            }
//
//                            return false;
//                        }
//                    });
//    }}