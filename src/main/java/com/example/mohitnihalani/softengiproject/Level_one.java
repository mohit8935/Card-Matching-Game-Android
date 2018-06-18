package com.example.mohitnihalani.softengiproject;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Mohit Nihalani} on 12thMarch2017.
 */

public class Level_one extends AppCompatActivity {


    /** Textview to display score */
    TextView score;

    /* Textview level to display the score*/
    TextView level;

    /* Imageview for different cards in game*/
    ImageView card00, card01, card02, card03;

    /* Database to store level name and its points*/
    DatabaseHelper db = new DatabaseHelper(this);

    /* exit button to exit game any time*/
    Button exitButton;

    /* Integer array to store values of card*/
    Integer[] cards;

    /* varibale to check sub level of game*/
    int m = 0;


    int image01, image02, image03, image04;
    /* varaibale to score points*/
    int points = 0;
    int chance = 1;
    /* first and second card whcih are selected*/
    int select1, select2;
    int position1, position2;

    /* oncreate method of the level 1*/
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadActivity(m,points);


    }
    /* METHOD TO START level 1 of THE GAME*/
    private void loadActivity(int d,int p) {
        setContentView(R.layout.level_one);

        points = p;

        cards = getCards(d);
        /* VIEWS OF DIFFERENT THINSGS IN GAME*/
        score = (TextView) findViewById(R.id.score);
        score.setText("Score:  " + points);
        card00 = (ImageView) findViewById(R.id.card00);
        card01 = (ImageView) findViewById(R.id.card01);
        card02 = (ImageView) findViewById(R.id.card02);
        card03 = (ImageView) findViewById(R.id.card03);

        level = (TextView) findViewById(R.id.level);
        level.setText("LEVEL 1-" + (1+m));

        exitButton = (Button) findViewById(R.id.b1);

        /* setting tag for all imageviews in card whcih are bascally their positoin*/
        card00.setTag("0");
        card01.setTag("1");
        card02.setTag("2");
        card03.setTag("3");

        /*get actual images of card*/
        actualImages(d);
        /* shuffle the cards*/
        Collections.shuffle(Arrays.asList(cards));

        /* on click methods for cards*/
        card00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tag = Integer.parseInt((String) v.getTag());
                action(card00, tag);
            }
        });
        card01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tag = Integer.parseInt((String) v.getTag());
                action(card01, tag);
            }
        });
        card02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tag = Integer.parseInt((String) v.getTag());
                action(card02, tag);
            }
        });
        card03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tag = Integer.parseInt((String) v.getTag());
                action(card03, tag);
            }
        });
        /* when exit button is pressed score is saved in database and then the player is taken to display score.class*/
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s = Integer.toString(points);
                db.addScore(new HighScore("LEVEL 1",s));

                Intent intent = new Intent(getApplicationContext(),DisplayScore.class);
                intent.putExtra("points",points);
                startActivity(intent);
                finish();
            }
        });

    }
        /* to give values to card to match then*/
        private Integer[] getCards (int c) {
            Integer[] cards = new Integer[0];
            if (c == 0) {
                cards = new Integer[]{1, 2, 11, 12};
            }
            if (c == 1) {
                cards = new Integer[]{1, 2, 11, 12};
            }
            if (c==2){
                cards = new Integer[]{1, 2, 11, 12};
            }
            return cards;
        }

        /* it will check the value of card by checking the positon of card whcih is its tag and call calculate function*/
    private void action(ImageView card, int tag) {
        /* assigning images to card based on their tag values*/
        if (cards[tag] == 1) {
            card.setImageResource(image01);
        } else if (cards[tag] == 2) {
            card.setImageResource(image02);
        } else if (cards[tag] == 11) {
            card.setImageResource(image03);
        } else if (cards[tag] == 12) {
            card.setImageResource(image04);
        }
        /* chance one first card clicked*/
        if (chance == 1) {
            select1 = cards[tag];
            if (select1 > 10) {
                select1 = select1 - 10;
            }
            chance = 2;
            position1 = tag;
        } else if (chance == 2) {
            select2 = cards[tag];
            if (select2 > 10) {
                select2 = select2 - 10;
            }
            chance = 1;
            position2 = tag;

            card00.setEnabled(false);
            card01.setEnabled(false);
            card02.setEnabled(false);
            card03.setEnabled(false);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    calculate();
                }
            }, 1000);
        }

    }

    /* actual images of cards*/
    private void actualImages(int d) {
        if (d==0){
        image01 = R.drawable.img1;
        image02 = R.drawable.img2;
        image03 = R.drawable.img11;
        image04 = R.drawable.img12;}
        else if(d==1){
            image01=R.drawable.img3;
            image02=R.drawable.img14;
            image03=R.drawable.img13;
            image04=R.drawable.img4;
        }
        if (d==2){
            image01 = R.drawable.img5;
            image02 = R.drawable.img6;
            image03 = R.drawable.img15;
            image04 = R.drawable.img16;
        }




    }
    /* calculate if cards are same*/
    private void calculate() {

        /* if cards are same then score 5 points*/
        if (select1 == select2) {
            if (position1 == 0) {
                card00.setVisibility(View.INVISIBLE);
            } else if (position1 == 1) {
                card01.setVisibility(View.INVISIBLE);
            } else if (position1 == 2) {
                card02.setVisibility(View.INVISIBLE);
            } else if (position1 == 3) {
                card03.setVisibility(View.INVISIBLE);
            }
            if (position2 == 0) {
                card00.setVisibility(View.INVISIBLE);
            } else if (position2 == 1) {
                card01.setVisibility(View.INVISIBLE);
            } else if (position2 == 2) {
                card02.setVisibility(View.INVISIBLE);
            } else if (position2 == 3) {
                card03.setVisibility(View.INVISIBLE);
            }

            points = points + 5;
            score.setText("Score:  " + points);


        } else {
            card00.setImageResource(R.drawable.back);
            card01.setImageResource(R.drawable.back);
            card02.setImageResource(R.drawable.back);
            card03.setImageResource(R.drawable.back);


        }
        /*if cards are not same then score is reduced by 2 points*/
        if (select1 != select2){
            points = points -2;
            score.setText("Score:  " + points);
        } else {
            card00.setImageResource(R.drawable.back);
            card01.setImageResource(R.drawable.back);
            card02.setImageResource(R.drawable.back);
            card03.setImageResource(R.drawable.back);
        }
        card00.setEnabled(true);
        card01.setEnabled(true);
        card02.setEnabled(true);
        card03.setEnabled(true);

        gameOver();

    }

    /* will check is gave is over */
    private void gameOver() {
        /* if sublevel is 3 then it will proceed to next level*/
        if (card00.getVisibility() == View.INVISIBLE &&
                card01.getVisibility() == View.INVISIBLE &&
                card02.getVisibility() == View.INVISIBLE &&
                card03.getVisibility() == View.INVISIBLE && m == 2) {




            Intent startLevelTwo = new Intent(getApplicationContext(), Level_two.class);
            startLevelTwo.putExtra("points", points);
            startActivity(startLevelTwo);
            finish();

        }
        /* will start next sub level*/
        else if (card00.getVisibility() == View.INVISIBLE &&
                card01.getVisibility() == View.INVISIBLE &&
                card02.getVisibility() == View.INVISIBLE &&
                card03.getVisibility() == View.INVISIBLE && (m==0 || m==1)) {
            m++;
            loadActivity(m,points);

        }


    }
    /* if back pressed then it takes you to main activity class and finish the present activity*/
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }

}

