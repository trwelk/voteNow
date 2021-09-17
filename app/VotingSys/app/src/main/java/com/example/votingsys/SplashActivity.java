package com.example.votingsys;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.splashactivity);
        progressBar=findViewById( R.id.progressid );
        progressBar.setVisibility( View.VISIBLE  );

        new Handler(  ).postDelayed(new Runnable() {
            @Override
            public void run() {

                progressBar.setVisibility( View.INVISIBLE  );
                Intent myIntent = new Intent(SplashActivity.this, LoginActivity.class);
                SplashActivity.this.startActivity(myIntent);
                finish();
            }
        },4000 );


    }
}