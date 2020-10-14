package com.example.sparktask2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class sp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp);
        getSupportActionBar().hide();
    }

    public void nexPae(View view) {

        Intent intent= new Intent(sp.this,Selectionpage.class);
        startActivity(intent);

    }
}