package com.example.fbla_final;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Map extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
    }
}