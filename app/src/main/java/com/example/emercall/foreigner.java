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

public class foreigner extends AppCompatActivity {
    GridView grid_foreign;
    MyAdapter myAdapter;
    ArrayList<String> text = new ArrayList<>();
    ArrayList<Integer> colors = new ArrayList<>();
    ArrayList<Integer> Icons = new ArrayList<>();
    ArrayList<String> number = new ArrayList<>();
    public static final int REQUEST_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foreigner);

        this.setTitle("FOREIGN AFFAIR EMERCALLS");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        grid_foreign = findViewById(R.id.grid_foreign);
        myAdapter = new MyAdapter();
        grid_foreign.setAdapter(myAdapter);

        //Numbers
        text.add("");
        text.add("");
        text.add("");
        text.add("");
        text.add("");
        text.add("");

        //Numbers
        number.add("#");
        number.add("#");
        number.add("#");
        number.add("#");
        number.add("#");
        number.add("#");

        //COLORS
        colors.add(R.color.PinkCard);
        colors.add(R.color.OrangeCard);
        colors.add(R.color.greenCard);
        colors.add(R.color.Yellow);
        colors.add(R.color.flora);
        colors.add(R.color.LightYellow);

        //ICONS
        Icons.add(R.drawable.foreigner);
        Icons.add(R.drawable.foreigner);
        Icons.add(R.drawable.foreigner);
        Icons.add(R.drawable.foreigner);
        Icons.add(R.drawable.foreigner);
        Icons.add(R.drawable.foreigner);

        //PhoneCall on click
        grid_foreign.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                makeCall(position);
            }
        });


    }

    class MyAdapter extends BaseAdapter{

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
            int pos = position%colors.size();
            itemIcon.setBackgroundColor(getResources().getColor(colors.get(pos)));
            itemName.setBackgroundColor(getResources().getColor(colors.get(pos)));
            itemNo.setBackgroundColor(getResources().getColor(colors.get(pos)));
            itemName.setText(text.get(position));
            itemNo.setText(number.get(position));
            itemIcon.setImageResource(Icons.get(position));
            return v;
        }
    }

    //Code for making a checking permission and making phone call from the app
    void makeCall(int position)
    {
        String no = number.get(position);

        //code for checking permission for making phone calls
        if(no.trim().length() > 0){
            if(ContextCompat.checkSelfPermission(foreigner.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){

                //Code for checking manifest permission
                ActivityCompat.requestPermissions(foreigner.this,
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);

            }else{

                //Code for making call
                String dial =  "tel:" + no;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }else{
            Toast.makeText(foreigner.this,"Error!\nNumber not exists",Toast.LENGTH_LONG).show();
        }
    }


    //To check id permission is already granted or not
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CALL){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            }else{
                Toast.makeText(foreigner.this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
