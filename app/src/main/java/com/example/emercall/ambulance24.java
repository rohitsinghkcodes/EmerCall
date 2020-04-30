package com.example.emercall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ambulance24 extends AppCompatActivity {
    GridView grid_amb24;
    MyAdapter myAdapter;
    ArrayList<String> text = new ArrayList<>();
    ArrayList<String> num = new ArrayList<>();

    private static final int REQUEST_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance24);

        grid_amb24 = findViewById(R.id.grid_amb24);
        myAdapter = new MyAdapter();
        grid_amb24.setAdapter(myAdapter);

        //To change toolbar title
        this.setTitle("24-HOUR AMBULANCE");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Numbers
        text.add("AIIMS");
        text.add("AIIMS (2)");
        text.add("Centralised Accident Trauma Service");

        text.add("Escort Hospital");
        text.add("National Heart Institute");
        text.add("Max Emergency Ambulance");

        text.add("Rajiv Gandhi National Institute");

        //Numbers
        num.add("26594405");
        num.add("011 26588766");
        num.add("1099");

        num.add("011 26825000");
        num.add("011 26441293");
        num.add("00140554055");

        num.add("011 27055011");



        grid_amb24.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                makeCall(position);
            }
        });

    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return text.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = LayoutInflater.from(getApplicationContext()).inflate(R.layout.layout_categories,null);
            ImageView itemIcon = v.findViewById(R.id.itemIcon);
            TextView itemName = v.findViewById(R.id.itemName);
            TextView itemNo = v.findViewById(R.id.itemNum);

            itemIcon.setBackgroundColor(getResources().getColor(R.color.PinkCard));
            itemName.setBackgroundColor(getResources().getColor(R.color.PinkCard));
            itemNo.setBackgroundColor(getResources().getColor(R.color.PinkCard));
            itemName.setText(text.get(position));
            itemNo.setText(num.get(position));
            itemIcon.setImageResource(R.drawable.ambulance);
            return v;
        }
    }

    //Code for making a checking permission and making phone call from the app
    void makeCall(int position)
    {
        String no = num.get(position);

        //code for checking permission for making phone calls
        if(no.trim().length() > 0){
            if(ContextCompat.checkSelfPermission(ambulance24.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){

                //Code for checking manifest permission
                ActivityCompat.requestPermissions(ambulance24.this,
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);

            }else{

                //Code for making call
                String dial =  "tel:" + no;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }else{
            Toast.makeText(ambulance24.this,"Error!\nNumber no exists",Toast.LENGTH_LONG).show();
        }
    }


    //To check id permission is already granted or not
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CALL){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            }else{
                Toast.makeText(ambulance24.this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
