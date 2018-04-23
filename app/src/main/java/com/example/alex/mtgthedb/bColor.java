package com.example.alex.mtgthedb;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class bColor extends AppCompatActivity {
    private DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_color);
        this.setTitle("Browse By Color");
        db = Room.databaseBuilder(this, DatabaseHandler.class, "newCards")
                .allowMainThreadQueries()
                .build();
    }

    protected void bRedClicked(View view) {
        Intent i = new Intent(this, ColorResults.class);
        i.putExtra("color_value", 1);
        startActivity(i);
    }

    protected void bBlueClicked(View view) {
        Intent i = new Intent(this, ColorResults.class);
        i.putExtra("color_value", 2);
        startActivity(i);
    }

    protected void bGreenClicked(View view) {
        Intent i = new Intent(this, ColorResults.class);
        i.putExtra("color_value", 3);
        startActivity(i);
    }

    protected void bBlackClicked(View view) {
        Intent i = new Intent(this, ColorResults.class);
        i.putExtra("color_value", 4);
        startActivity(i);
    }

    protected void bWhiteClicked(View view) {
        Intent i = new Intent(this, ColorResults.class);
        i.putExtra("color_value", 5);
        startActivity(i);
    }

    protected void bColorlessClicked(View view) {
        Intent i = new Intent(this, ColorResults.class);
        i.putExtra("color_value", 6);
        startActivity(i);
    }
}
