package com.example.emercall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class about_section extends AppCompatActivity {
TextView copyright;
String copy;
ImageView twitter,ld_in,github;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_section);

        this.setTitle("About");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        copyright = findViewById(R.id.copyright);
        copy = "\u00a9 ROHIT KUMAR SINGH";
        copyright.setText(copy);

        twitter = findViewById(R.id.twitter);
        ld_in = findViewById(R.id.ld_in);
        github = findViewById(R.id.git);


        ld_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click("https://www.linkedin.com/in/rohit-singh-702a451a4/");
            }
        });

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click("https://twitter.com/rohit_ka_tweet");
            }
        });

        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click("https://github.com/rohitsinghkcodes");
            }
        });


    }

    //this function will open the link in mobile default browser
    public void click(String url)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}
