package com.example.emercall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridMain;
    Myadapter myAdap;
    ArrayList<String> data = new ArrayList<>();
    //ArrayList<Integer> colors = new ArrayList<>();
    ArrayList<Integer> Icons = new ArrayList<>();
    private long backPressedTime ;
    private  Toast backToast;

    //Exit from the app if back pressed from home screen
    @Override
    public void onBackPressed() {
        if(backPressedTime + 2000 > System.currentTimeMillis() )
        {
            backToast.cancel();
            super.onBackPressed();
            return;
        }
        else
        {
           backToast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
           backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.setting_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.exit:
                MainActivity.super.onBackPressed();
                return true;
            case R.id.about:
                Intent i =new Intent(MainActivity.this,about_section.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridMain = findViewById(R.id.gridMain);
        myAdap = new Myadapter();
        gridMain.setAdapter(myAdap);

        //To change toolbar title
        this.setTitle("EmerCall Categories");

        //CATEGORIES
        data.add("BASIC EMERCALLS");
        data.add("ENQUIRY");
        data.add("ACCIDENTS");
        data.add("WOMEN SAFETY");
        data.add("CHILD SAFETY");
        data.add("FOREIGNERS");

        //COLORS
        //colors.add(R.color.flora);
//        colors.add(R.color.greenCard);
//        colors.add(R.color.Yellow);
//        colors.add(R.color.OrangeCard);
//        colors.add(R.color.PinkCard);
//        colors.add(R.color.LightYellow);

        //ICONS
        Icons.add(R.drawable.primary);
        Icons.add(R.drawable.icon_enquiry);
        Icons.add(R.drawable.accidents);
        Icons.add(R.drawable.women_safety);
        Icons.add(R.drawable.child);
        Icons.add(R.drawable.foreigner);

        //onclick
        gridMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position)
                {
                    case 0:
                        Intent i = new Intent(getApplicationContext(),categ_basic.class);
                        startActivity(i);
                        break;
                    case 1:
                        Intent j = new Intent(MainActivity.this,enquiry.class);
                        startActivity(j);
                        break;
                    case 2:
                        Intent k = new Intent(MainActivity.this,accidents.class);
                        startActivity(k);
                        break;
                    case 3:
                        Intent l = new Intent(MainActivity.this,categ_women.class);
                        startActivity(l);
                        break;
                    case 4:
                        Intent m = new Intent(MainActivity.this,children.class);
                        startActivity(m);
                        break;
                    case 5:
                        Intent n = new Intent(MainActivity.this,foreigner.class);
                        startActivity(n);
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Select a valid category", Toast.LENGTH_LONG).show();
                }
            }
        });

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
            cateIcon.setBackgroundColor(getResources().getColor(R.color.flora));
            cateName.setBackgroundColor(getResources().getColor(R.color.flora));
            cateName.setText(data.get(position));
            cateIcon.setImageResource(Icons.get(position));
            return v;


        }
    }
}
