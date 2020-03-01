package com.kai.speed;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import android.view.Menu;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kai.speed.async.AsyncTaskSample;
import com.kai.speed.async.AsyncTaskWriteFile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Calendar;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Tool bar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //toolbar.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.primary_light));
        //toolbar.setTitleTextColor(ContextCompat.getColor(getApplicationContext(), R.color.primary));
        //toolbar.getNavigationIcon().setTint(ContextCompat.getColor(getApplicationContext(), R.color.primary_text));
        //toolbar.setSubtitleTextColor(ContextCompat.getColor(getApplicationContext(), R.color.primary_light));

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_test, R.id.navigation_history, R.id.navigation_settings)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        //new AsyncTaskWriteFile(this, 1, 64*1024).executeOnExecutor(Executors.newCachedThreadPool(), 2000);
        //new AsyncTaskSample(this, 2).executeOnExecutor(Executors.newCachedThreadPool(), 2000);

        // single thread
        //new AsyncTaskSample(this, 1).executeOnExecutor(Executors.newSingleThreadExecutor(), 2000);
        //new AsyncTaskSample(this, 2).executeOnExecutor(Executors.newSingleThreadExecutor(), 2000);

        // single thread
        //new AsyncTaskWriteFile(this, 1).execute(5000);
        //new AsyncTaskSample(this, 2).execute(5000);
    }

    // Add OK button on the AppBar
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

}
