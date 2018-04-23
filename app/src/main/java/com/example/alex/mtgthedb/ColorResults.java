package com.example.alex.mtgthedb;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class ColorResults extends AppCompatActivity {
    RecyclerView colorViewList;
    RecyclerView.Adapter colorAdapter;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_results);

        int passedColorInd = 99;
        db = Room.databaseBuilder(this, DatabaseHandler.class, "newCards")
                .allowMainThreadQueries()
                .build();

        Bundle colorExtras = getIntent().getExtras();

        if (colorExtras != null) {
            passedColorInd = colorExtras.getInt("color_value");
        }

        //red
        //blue
        //green
        //black
        //white
        //colorless
        switch (passedColorInd) {
            case 1:
                List<Card> redResults = db.cardDao().getAllRed();
                colorViewList = findViewById(R.id.recyclerview);
                colorViewList.setLayoutManager(new LinearLayoutManager(this));
                colorAdapter = new CardAdapter(redResults);
                colorViewList.setAdapter(colorAdapter);
                break;
            case 2:
                List<Card> blueResults = db.cardDao().Sanji();
                colorViewList = findViewById(R.id.recyclerview);
                colorViewList.setLayoutManager(new LinearLayoutManager(this));
                colorAdapter = new CardAdapter(blueResults);
                colorViewList.setAdapter(colorAdapter);
                break;
            case 3:
                List<Card> greenResults = db.cardDao().getAllGreen();
                colorViewList = findViewById(R.id.recyclerview);
                colorViewList.setLayoutManager(new LinearLayoutManager(this));
                colorAdapter = new CardAdapter(greenResults);
                colorViewList.setAdapter(colorAdapter);
                break;
            case 4:
                List<Card> blackResults = db.cardDao().getAllBlack();
                colorViewList = findViewById(R.id.recyclerview);
                colorViewList.setLayoutManager(new LinearLayoutManager(this));
                colorAdapter = new CardAdapter(blackResults);
                colorViewList.setAdapter(colorAdapter);
                break;
            case 5:
                List<Card> whiteResults = db.cardDao().getAllWhite();
                colorViewList = findViewById(R.id.recyclerview);
                colorViewList.setLayoutManager(new LinearLayoutManager(this));
                colorAdapter = new CardAdapter(whiteResults);
                colorViewList.setAdapter(colorAdapter);
                break;
            case 6:
                List<Card> colorlessResults = db.cardDao().getAllColorless();
                colorViewList = findViewById(R.id.recyclerview);
                colorViewList.setLayoutManager(new LinearLayoutManager(this));
                colorAdapter = new CardAdapter(colorlessResults);
                colorViewList.setAdapter(colorAdapter);
                break;
            default:
                return;
        }
    }
}
