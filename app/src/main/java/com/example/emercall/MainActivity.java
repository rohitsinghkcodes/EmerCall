package com.example.emercall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridMain;
    Myadapter myAdap;
    ArrayList<String> data = new ArrayList<>();
    ArrayList<Integer> colors = new ArrayList<>();
    ArrayList<Integer> Icons = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridMain = findViewById(R.id.gridMain);
        myAdap = new Myadapter();

        data.add("PRIMARY");
        data.add("ENQUIRY");
        data.add("ACCIDENTS");
        data.add("WOMEN SAFETY");
        data.add("CHILD SAFETY");
        data.add("FOREIGN");


        //COLORS
        colors.add(R.color.OrangeCard);
        colors.add(R.color.PinkCard);
        colors.add(R.color.Yellow);
        colors.add(R.color.greenCard);
        colors.add(R.color.flora);
        colors.add(R.color.LightYellow);

        //ICONS
        Icons.add(R.drawable.nat_emer_no);
        Icons.add(R.drawable.default_avatar);
        Icons.add(R.drawable.default_avatar);
        Icons.add(R.drawable.women_helpline_no);
        Icons.add(R.drawable.default_avatar);
        Icons.add(R.drawable.default_avatar);

        gridMain.setAdapter(myAdap);

    }

    class Myadapter extends BaseAdapter{

        @Override
        public int getCount() {
            return data.size();
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
            View v = LayoutInflater.from(getApplicationContext()).inflate(R.layout.layout_main,null);
            ImageView cateIcon = v.findViewById(R.id.cateIcon);
            TextView cateName = v.findViewById(R.id.cateName);
            int pos = position%colors.size();
            cateIcon.setBackgroundColor(getResources().getColor(colors.get(pos)));
            cateName.setBackgroundColor(getResources().getColor(colors.get(pos)));
            cateName.setText(data.get(position));
            cateIcon.setImageResource(Icons.get(position));
            return v;


        }
    }
}
