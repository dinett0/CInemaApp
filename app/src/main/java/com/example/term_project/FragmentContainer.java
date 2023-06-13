package com.example.term_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FragmentContainer extends AppCompatActivity implements BottomNavigationView.OnItemSelectedListener {
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_container);

        fragmentManager = getSupportFragmentManager();

        Bundle bundleReceive = getIntent().getExtras();
        Bundle bundleSend = new Bundle();

        System.out.println(bundleReceive.get("login").toString());
        bundleSend.putString("name", bundleReceive.get("name").toString());
        bundleSend.putString("login", bundleReceive.get("login").toString());
        bundleSend.putString("password", bundleReceive.get("password").toString());

        ProfileFragment fragment = new ProfileFragment();
        fragment.setArguments(bundleSend);

        // Set default fragment to HomeFragment
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout, fragment);
        transaction.commit();

        BottomNavigationView navigationView = findViewById(R.id.bottomNavigationView);
        navigationView.setOnItemSelectedListener(this); // <-- Set item selected listener
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        ProfileFragment fragment;
        switch (item.getItemId()) {
            case R.id.Profile:
                fragment = new ProfileFragment();
                break;
            default:
                fragment = new ProfileFragment();
        }

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout, fragment);
        transaction.commit();

        return true;
    }
}
