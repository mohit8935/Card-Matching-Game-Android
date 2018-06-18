package com.example.mohitnihalani.softengiproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DisplayScore extends AppCompatActivity {

    /* Datbase to load scores from*/
    DatabaseHelper db = new DatabaseHelper(this);

    TextView displayhighscore, displaycurrentscore;

    /*button for starting game again*/
    Button playagain;

    /* display points*/
    int displaypoints;

    List<Integer> highpoints;

    int d;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_score);

        displaypoints = getIntent().getIntExtra("points",0);
        displaycurrentscore = (TextView) findViewById(R.id.display);
        /** will display your current score */
        displaycurrentscore.setText("Hey you did Well"+"\n" + "your score is " + displaypoints);

        displayhighscore = (TextView) findViewById(R.id.display1);

        playagain = (Button) findViewById(R.id.b1);

        /* will start game again*/
        playagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        /* will get highest score from the database*/
        highpoints = new ArrayList<>();
        List<HighScore> scores = db.getALLscore();

        for (HighScore score: scores){

           String p = score.getScore();
            d = Integer.parseInt(p);
            highpoints.add(d);

        }
        int b = Collections.max(highpoints);
        /* will display your highest score*/
        displayhighscore.setText("Your Highest Score is:  " + b);

    }

    /* when back button is pressed it wil take you to main activity and finsh this current activity*/
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }
}

