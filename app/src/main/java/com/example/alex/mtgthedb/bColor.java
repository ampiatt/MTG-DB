package com.example.alex.mtgthedb;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class bColor extends AppCompatActivity {
    private DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_color);
        this.setTitle("Browse By Color");
        db = Room.databaseBuilder(this, DatabaseHandler.class, "cards")
                .allowMainThreadQueries()
                .build();
    }

    protected void bRedClicked(View view) {
        List<Card> red = db.cardDao().getAllRed();
    }

    protected void bBlueClicked(View view) {
        List<Card> blue = db.cardDao().Sanji();
    }

    protected void bGreenClicked(View view) {
        List<Card> green = db.cardDao().getAllGreen();
    }

    protected void bBlackClicked(View view) {
        List<Card> black = db.cardDao().getAllBlack();
    }

    protected void bWhiteClicked(View view) {
        List<Card> white = db.cardDao().getAllWhite();
    }

    protected void bColorlessClicked(View view) {
        List<Card> colorless = db.cardDao().getAllColorless();
    }
}
