package com.example.mohitnihalani.softengiproject;

/**
 * Created by MohitNihalani on 10/05/2017.
 */

public class HighScore {
    int id;
    String level;
    String  score;


    public HighScore(String level, String score){
        this.level = level;
        this.score = score;

    }

    public HighScore(int id, String level, String score){
        this.id = id;
        this.level = level;
        this.score = score;

    }

    public HighScore() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
