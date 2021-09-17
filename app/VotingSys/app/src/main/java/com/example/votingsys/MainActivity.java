package com.example.votingsys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LinearLayout tab_1,tab_2,tab_3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboardactivity);
        tab_1=findViewById(R.id.tab1);
        tab_2=findViewById(R.id.tab2);
        tab_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Team List page loading... .", Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(MainActivity.this, TeamListActivity.class);
                MainActivity.this.startActivity(myIntent);
                finish();
            }
        });

        tab_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Result List page loading... .", Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(MainActivity.this, ResultActivity.class);
                MainActivity.this.startActivity(myIntent);
                finish();
            }
        });
    }
}