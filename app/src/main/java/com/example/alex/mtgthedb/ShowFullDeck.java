package com.example.alex.mtgthedb;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class ShowFullDeck extends AppCompatActivity {
    RecyclerView deckViewList;
    RecyclerView.Adapter deckAdapter;
    DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_full_deck);
        this.setTitle("View Full Deck");

        db = Room.databaseBuilder(this, DatabaseHandler.class, "newCards")
                .allowMainThreadQueries()
                .build();

        List<Card> deck = db.cardDao().getAllInDeck();

        deckViewList = findViewById(R.id.deckRecyclerview);
        deckViewList.setLayoutManager(new LinearLayoutManager(this));
        deckAdapter = new CardAdapter(deck);
        deckViewList.setAdapter(deckAdapter);
    }
}
