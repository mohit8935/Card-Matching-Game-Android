package com.example.mohitnihalani.softengiproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
/* help screen for game*/
public class Game_help extends AppCompatActivity {

    TextView textView;

    Button playgame,back;

    ImageView card00,card01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_help);

        /* different views of layout*/
        card00 = (ImageView) findViewById(R.id.help1);
        textView = (TextView) findViewById(R.id.gamehelp);
        card01 = (ImageView) findViewById(R.id.help2);
        back = (Button) findViewById(R.id.back);
        playgame = (Button) findViewById(R.id.help_play);
        /* textview for instructions*/
        textView.setText("Touch the icons to flip them over, "+"\n"+"if they match 5 points are rewarded and if they don't match 2 points are reduced.");

        /* sample of hame*/
        card00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card00.setImageResource(R.drawable.img20);
            }
        });
        card01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card01.setImageResource(R.drawable.img20);
            }
        });

        /* button will take to main screen*/
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });
        /* button will take to level one of game*/
        playgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Level_one.class);
                startActivity(intent);
                finish();

            }
        });

    }
    /* on back presses home page of game will be shown*/
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();

    }
}
