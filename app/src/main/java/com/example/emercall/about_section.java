package com.example.emercall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class about_section extends AppCompatActivity {
TextView copyright;
String copy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_section);

        this.setTitle("About");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        copyright = findViewById(R.id.copyright);
        copy = "\u00a9 ROHIT KUMAR SINGH";
        copyright.setText(copy);
    }
}
