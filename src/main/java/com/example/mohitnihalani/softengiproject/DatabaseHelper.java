package com.example.mohitnihalani.softengiproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MohitNihalani on 10/05/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "HighScoreManage";
    private static final String TABLE_SCORE = "highscore";
    private static final String KEY_ID = "id";
    private static final String KEY_LEVEL = "level";
    private static final String KEY_SCORE = "score";

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_HIGHSCORE_TABLE = "CREATE TABLE " + TABLE_SCORE+ "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_LEVEL + " TEXT,"
                + KEY_SCORE + " TEXT" + ")";
        db.execSQL(CREATE_HIGHSCORE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCORE);
        onCreate(db);
    }

    void addScore(HighScore score){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_LEVEL,score.getLevel() );
        values.put(KEY_SCORE,score.getScore());

        db.insert(TABLE_SCORE,null,values);
        db.close();
    }

    HighScore highScore(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_SCORE, new String[] {KEY_ID,KEY_LEVEL,KEY_SCORE}, KEY_ID + "=?",
                new String[] {String.valueOf(id)},null,null,null,null);
        if (cursor!=null){
            cursor.moveToFirst();
        }

        HighScore highScore = new HighScore(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2));
        return highScore;
    }

    public List<HighScore> getALLscore(){
        List<HighScore> scoreList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_SCORE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        if (cursor.moveToFirst()){
            do{
                HighScore highScore = new HighScore();
                highScore.setId(Integer.parseInt(cursor.getString(0)));
                highScore.setLevel(cursor.getString(1));
                highScore.setScore(cursor.getString(2));

                scoreList.add(highScore);

            } while (cursor.moveToNext());
        }

        return scoreList;

    }

    public int updateScore(HighScore highScore){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(KEY_LEVEL,highScore.getLevel() );
        contentValues.put(KEY_SCORE,highScore.getScore());

        return db.update(TABLE_SCORE, contentValues, KEY_ID + "=?",
                new String[]{String.valueOf(highScore.getId())});
    }


}
