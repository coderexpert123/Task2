package com.example.sparktask2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class dasboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dasboard);
        getSupportActionBar().hide();
    }
}