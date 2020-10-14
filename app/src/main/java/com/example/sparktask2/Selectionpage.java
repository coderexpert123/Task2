package com.example.sparktask2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class Selectionpage extends AppCompatActivity {
    CarouselView carouselView;
    int[] sampleImages = {R.drawable.b,R.drawable.atn };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectionpage);
        getSupportActionBar().hide();

      carouselView = findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);

    }

     ImageListener imageListener = new ImageListener() {
       @Override
       public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

    public void viewuser(View view) {
        Intent i =new Intent(Selectionpage.this,dasboard.class);
        startActivity(i);
    }

    public void creditUser(View view) {
        Intent i =new Intent(Selectionpage.this,CreditUser.class);
        startActivity(i);
    }
}