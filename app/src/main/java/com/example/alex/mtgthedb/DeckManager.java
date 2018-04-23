package com.example.alex.mtgthedb;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DeckManager extends AppCompatActivity {
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck_manager);
        this.setTitle("Deck Manager");

        db = Room.databaseBuilder(this, DatabaseHandler.class, "newCards")
                .allowMainThreadQueries()
                .build();

    }

    public void addToDeckButton(View view) {
        Intent i = new Intent(this, addToDeck.class);
        startActivity(i);
    }

    public void deleteFromDeckButton(View view) {
        Intent i = new Intent(this, DeleteFromDeck.class);
        startActivity(i);
    }

    public void viewDeckButton(View view) {
        Intent i = new Intent(this, ShowFullDeck.class);
        startActivity(i);
    }
}
