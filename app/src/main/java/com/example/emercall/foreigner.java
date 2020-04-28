package com.example.emercall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class foreigner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foreigner);

        this.setTitle("Foreigner EmerCalls");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
