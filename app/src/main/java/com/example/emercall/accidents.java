package com.example.emercall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class accidents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accidents);

        this.setTitle("Accidents EmerCalls");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
