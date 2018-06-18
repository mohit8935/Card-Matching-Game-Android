package com.example.mohitnihalani.softengiproject;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;

public class Level_three extends AppCompatActivity {

    /** Textview to display score */
    TextView score;

    /* points of level three*/
    int pointsLevelThree=0;

    /* Imageview for different cards in game*/
    ImageView card00,card01,card02,card03,card04,card05,card06,card07,card08,card09,card10,card11;

    /* Integer array to store values of card*/
    Integer [] cards
            ;
    int image1,image2,image11,image12,image3,image13,image4,image14,image5,image6,image15,image16;

    int chance =1;

    int select1,select2;

    int position1,position2;
    /* varibale to check sub level of game*/
    int m=1;
    /* exit button to exit game any time*/
    Button exitButton;
    /* Textview level to display the score*/
    TextView level;
    /* Database to store level name and its points*/
    DatabaseHelper db = new DatabaseHelper(this);

    /* oncreate method of the level 3*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pointsLevelThree = getIntent().getIntExtra("Points",0);
        loadActivity(m,pointsLevelThree);
    }

    /* METHOD TO START level 3 of THE GAME*/
    private void loadActivity(int d, int p) {
        setContentView(R.layout.level_three);
        /* VIEWS OF DIFFERENT THINSGS IN GAME*/
        score = (TextView) findViewById(R.id.score);

        cards = getCards(d);
        pointsLevelThree = p;
        score.setText("Score:  " + pointsLevelThree);

        exitButton = (Button) findViewById(R.id.exit);

        level = (TextView) findViewById(R.id.level);
        level.setText("LEVEL 3-" + (m));



        card00 = (ImageView) findViewById(R.id.card00);
        card01 = (ImageView) findViewById(R.id.card01);
        card02 = (ImageView) findViewById(R.id.card02);
        card03 = (ImageView) findViewById(R.id.card03);
        card04 = (ImageView) findViewById(R.id.card04);
        card05 = (ImageView) findViewById(R.id.card05);
        card06 = (ImageView) findViewById(R.id.card06);
        card07 = (ImageView) findViewById(R.id.card07);
        card08 = (ImageView) findViewById(R.id.card08);
        card09 = (ImageView) findViewById(R.id.card09);
        card10 = (ImageView) findViewById(R.id.card10);
        card11 = (ImageView) findViewById(R.id.card11);


        /* setting tag for all imageviews in card whcih are bascally their positoin*/
        card00.setTag("0");
        card01.setTag("1");
        card02.setTag("2");
        card03.setTag("3");
        card04.setTag("4");
        card05.setTag("5");
        card06.setTag("6");
        card07.setTag("7");
        card08.setTag("8");
        card09.setTag("9");
        card10.setTag("10");
        card11.setTag("11");

        /*get actual images of card*/
        actualImages(d);
        /* shuffle the cards*/
        Collections.shuffle(Arrays.asList(cards));

        /* on click methods for cards*/
        card00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tag = Integer.parseInt((String)v.getTag());
                action(card00,tag);
            }
        });
        card01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tag = Integer.parseInt((String)v.getTag());
                action(card01,tag);
            }
        });
        card02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tag = Integer.parseInt((String)v.getTag());
                action(card02,tag);
            }
        });
        card03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tag = Integer.parseInt((String)v.getTag());
                action(card03,tag);
            }
        });
        card03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tag = Integer.parseInt((String)v.getTag());
                action(card03,tag);
            }
        });
        card04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tag = Integer.parseInt((String)v.getTag());
                action(card04,tag);
            }
        });
        card05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tag = Integer.parseInt((String)v.getTag());
                action(card05,tag);
            }
        });
        card06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tag = Integer.parseInt((String)v.getTag());
                action(card06,tag);
            }
        });
        card07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tag = Integer.parseInt((String)v.getTag());
                action(card07,tag);
            }
        });
        card08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tag = Integer.parseInt((String)v.getTag());
                action(card08,tag);
            }
        });
        card09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tag = Integer.parseInt((String)v.getTag());
                action(card09,tag);
            }
        });
        card10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tag = Integer.parseInt((String)v.getTag());
                action(card10,tag);
            }
        });
        card11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tag = Integer.parseInt((String)v.getTag());
                action(card11,tag);
            }
        });

        /* when exit button is pressed score is saved in database and then the player is taken to display score.class*/
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s = Integer.toString(pointsLevelThree);
                db.addScore(new HighScore("LEVEL",s));

                Intent intent = new Intent(getApplicationContext(),DisplayScore.class);
                intent.putExtra("points",pointsLevelThree);
                startActivity(intent);
                finish();
            }
        });
    }
    /* to give values to card to match then*/
    private Integer[] getCards(int c) {
        Integer[] cards = new Integer[0];
        if (c == 1) {
            cards = new Integer[]{1, 2, 3, 4, 5, 6, 11, 12, 13, 14, 15, 16};
        }

        return cards;
    }
    /* it will check the value of card by checking the positon of card whcih is its tag and call calculate function*/
    private void action(ImageView card, int tag) {
        /* assigning images to card based on their tag values*/
        if (cards[tag]==1){
            card.setImageResource(image1);
        }else if (cards[tag]==2){
            card.setImageResource(image2);
        }
        else if (cards[tag]==11){
            card.setImageResource(image11);
        }
        else if (cards[tag]==12){
            card.setImageResource(image12);
        }
        else if (cards[tag]==3){
            card.setImageResource(image3);
        }
        else if (cards[tag]==13){
            card.setImageResource(image13);
        }
        else if (cards[tag]==4){
            card.setImageResource(image4);
        }
        else if (cards[tag]==14){
            card.setImageResource(image14);
        }
        else if (cards[tag]==5){
            card.setImageResource(image5);
        }
        else if (cards[tag]==6){
            card.setImageResource(image6);
        }
        else if (cards[tag]==15){
            card.setImageResource(image15);
        }
        else if (cards[tag]==16){
            card.setImageResource(image16);
        }


        if (chance==1){
            select1=cards[tag];
            if (select1>10){
                select1 = select1-10;
            }
            chance = 2;
            position1 = tag;
        }else if (chance==2){
            select2=cards[tag];
            if (select2>10){
                select2 = select2-10;
            }
            chance = 1;
            position2 = tag;

            card00.setEnabled(false);
            card01.setEnabled(false);
            card02.setEnabled(false);
            card03.setEnabled(false);
            card04.setEnabled(false);
            card05.setEnabled(false);
            card06.setEnabled(false);
            card07.setEnabled(false);
            card08.setEnabled(false);
            card09.setEnabled(false);
            card10.setEnabled(false);
            card11.setEnabled(false);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    calculate();
                }
            }, 1000);
        }

    }
    /* calculate if cards are same*/
    private void calculate() {

            /* if cards are same then score 5 points*/

        if (select1==select2){
            if (position1==0){
                card00.setVisibility(View.INVISIBLE);
            }
            else if (position1==1){
                card01.setVisibility(View.INVISIBLE);
            }
            else if (position1==2){
                card02.setVisibility(View.INVISIBLE);
            }
            else if (position1==3){
                card03.setVisibility(View.INVISIBLE);
            }
            else if (position1==4){
                card04.setVisibility(View.INVISIBLE);
            }
            else if (position1==5){
                card05.setVisibility(View.INVISIBLE);
            }
            else if (position1==6){
                card06.setVisibility(View.INVISIBLE);
            }
            else if (position1==7){
                card07.setVisibility(View.INVISIBLE);
            }
            else if (position1==8){
                card08.setVisibility(View.INVISIBLE);
            }
            else if (position1==9){
                card09.setVisibility(View.INVISIBLE);
            }
            else if (position1==10){
                card10.setVisibility(View.INVISIBLE);
            }
            else if (position1==11){
                card11.setVisibility(View.INVISIBLE);
            }
            if (position2==0){
                card00.setVisibility(View.INVISIBLE);
            }
            else if (position2==1){
                card01.setVisibility(View.INVISIBLE);
            }
            else if (position2==2){
                card02.setVisibility(View.INVISIBLE);
            }
            else if (position2==3){
                card03.setVisibility(View.INVISIBLE);
            }
            else if (position2==4){
                card04.setVisibility(View.INVISIBLE);
            }
            else if (position2==5){
                card05.setVisibility(View.INVISIBLE);
            }
            else if (position2==6){
                card06.setVisibility(View.INVISIBLE);
            }
            else if (position2==7){
                card07.setVisibility(View.INVISIBLE);
            }
            else if (position2==8){
                card08.setVisibility(View.INVISIBLE);
            }
            else if (position2==9){
                card09.setVisibility(View.INVISIBLE);
            }
            else if (position2==10){
                card10.setVisibility(View.INVISIBLE);
            }
            else if (position2==11){
                card11.setVisibility(View.INVISIBLE);
            }

            pointsLevelThree = pointsLevelThree+5;
            score.setText("Score:  "+pointsLevelThree);


        }else {
            card00.setImageResource(R.drawable.back);
            card01.setImageResource(R.drawable.back);
            card02.setImageResource(R.drawable.back);
            card03.setImageResource(R.drawable.back);
            card04.setImageResource(R.drawable.back);
            card05.setImageResource(R.drawable.back);
            card06.setImageResource(R.drawable.back);
            card07.setImageResource(R.drawable.back);
            card08.setImageResource(R.drawable.back);
            card09.setImageResource(R.drawable.back);
            card10.setImageResource(R.drawable.back);
            card11.setImageResource(R.drawable.back);


        }
        /*if cards are not same then score is reduced by 2 points*/
        if (select1 != select2){
            pointsLevelThree = pointsLevelThree -2;
            score.setText("Score:  " + pointsLevelThree);
        }else{
            card00.setImageResource(R.drawable.back);
            card01.setImageResource(R.drawable.back);
            card02.setImageResource(R.drawable.back);
            card03.setImageResource(R.drawable.back);
            card04.setImageResource(R.drawable.back);
            card05.setImageResource(R.drawable.back);
            card06.setImageResource(R.drawable.back);
            card07.setImageResource(R.drawable.back);
            card08.setImageResource(R.drawable.back);
            card09.setImageResource(R.drawable.back);
            card10.setImageResource(R.drawable.back);
            card11.setImageResource(R.drawable.back);

        }
        card00.setEnabled(true);
        card01.setEnabled(true);
        card02.setEnabled(true);
        card03.setEnabled(true);
        card04.setEnabled(true);
        card05.setEnabled(true);
        card06.setEnabled(true);
        card07.setEnabled(true);
        card08.setEnabled(true);
        card09.setEnabled(true);
        card10.setEnabled(true);
        card11.setEnabled(true);

        gameOver();
    }

    /* will check is gave is over */
    private void gameOver() {
        if (card00.getVisibility()==View.INVISIBLE&&
                card01.getVisibility()==View.INVISIBLE&&
                card02.getVisibility()==View.INVISIBLE&&
                card03.getVisibility()==View.INVISIBLE&&
                card04.getVisibility()==View.INVISIBLE&&
                card05.getVisibility()==View.INVISIBLE&&
                card06.getVisibility()==View.INVISIBLE&&
                card07.getVisibility()==View.INVISIBLE&&
                card08.getVisibility()==View.INVISIBLE&&
                card09.getVisibility()==View.INVISIBLE&&
                card10.getVisibility()==View.INVISIBLE&&
                card11.getVisibility()==View.INVISIBLE){

            String s = Integer.toString(pointsLevelThree);
            db.addScore(new HighScore("LEVEL",s));

            Intent intent = new Intent(getApplicationContext(),DisplayScore.class);
            intent.putExtra("points",pointsLevelThree);
            startActivity(intent);

            finish();
        }
    }

    /* actual images of cards*/
    private void actualImages(int d) {
        if (d==1){
            image1 = R.drawable.img1;
            image2 = R.drawable.img2;
            image11 = R.drawable.img11;
            image12 = R.drawable.img12;
            image3 = R.drawable.img3;
            image4 = R.drawable.img4;
            image13 = R.drawable.img13;
            image14 = R.drawable.img14;
            image5 = R.drawable.img5;
            image15 = R.drawable.img15;
            image6 = R.drawable.img6;
            image16 = R.drawable.img16;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    /* if back pressed then it takes you to main activity class and finish the present activity*/
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }
}
