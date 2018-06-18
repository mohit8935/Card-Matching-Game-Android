package com.example.mohitnihalani.softengiproject;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView text;

    Button howto;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.start);
        text = (TextView) findViewById(R.id.gamename);
        howto = (Button) findViewById(R.id.howtoplay);


        /* button to start the game*/
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(),Level_one.class);
               startActivity(intent);
               finish();
           }
       });

        howto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Game_help.class);
                startActivity(intent);
                finish();
            }
        });


    }

    /* wil finish the activity if pressed back button*/
    @Override
    public void onBackPressed() {
        finish();
    }
}
