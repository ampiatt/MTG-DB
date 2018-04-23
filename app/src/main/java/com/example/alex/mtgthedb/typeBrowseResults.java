package com.example.alex.mtgthedb;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class typeBrowseResults extends AppCompatActivity {

    RecyclerView typeViewList;
    RecyclerView.Adapter typeAdapter;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String passedType = "";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_browse_results);

        this.setTitle("Cards by type");

        db = Room.databaseBuilder(this, DatabaseHandler.class, "newCards")
                .allowMainThreadQueries()
                .build();

        Bundle passed = getIntent().getExtras();
        if (passed != null) {
            passedType = passed.getString("type_key");
        }

        List<Card> typeResults = db.cardDao().getAllCardsType(passedType);

        typeViewList = findViewById(R.id.recyclerview);
        typeViewList.setLayoutManager(new LinearLayoutManager(this));
        typeAdapter = new CardAdapter(typeResults);
        typeViewList.setAdapter(typeAdapter);
    }
}
