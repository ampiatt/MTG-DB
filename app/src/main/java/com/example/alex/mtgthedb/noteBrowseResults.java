package com.example.alex.mtgthedb;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class noteBrowseResults extends AppCompatActivity {
    RecyclerView noteViewList;
    RecyclerView.Adapter noteAdapter;
    DatabaseHandler db;

    protected void onCreate(Bundle savedInstanceState) {
        String passedNote = "";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_browse_results);
        this.setTitle("Note Results");

        db = Room.databaseBuilder(this, DatabaseHandler.class, "newCards")
                .allowMainThreadQueries()
                .build();

        Bundle passed = getIntent().getExtras();
        if (passed != null) {
            passedNote = passed.getString("note_key");
        }

        try {
            List<Card> noteResults = db.cardDao().getAllNote(passedNote);
            noteViewList = findViewById(R.id.recyclerview);
            noteViewList.setLayoutManager(new LinearLayoutManager(this));
            noteAdapter = new CardAdapter(noteResults);
            noteViewList.setAdapter(noteAdapter);
        }
        catch (Exception e) {
            e.getCause();
        }
    }
}
