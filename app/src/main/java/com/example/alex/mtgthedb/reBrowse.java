package com.example.alex.mtgthedb;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class reBrowse extends AppCompatActivity {
    private DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_browse);
        this.setTitle("Browse Collection");
        db = Room.databaseBuilder(this, DatabaseHandler.class, "newCards")
                .allowMainThreadQueries()
                .build();
        Spinner typeSpinner = (Spinner) findViewById(R.id.typSpinner);
        ArrayAdapter<CharSequence> typeAdapter = ArrayAdapter.createFromResource(this,
                R.array.type_array, android.R.layout.simple_spinner_dropdown_item);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(typeAdapter);
    }

    public void browseByType(View view) {
        Spinner browseType = findViewById(R.id.typSpinner);
        String bType = browseType.getSelectedItem().toString();
        //List<Card> typeCards = db.cardDao().getAllCardsType(bType);
        Intent i = new Intent(this, typeBrowseResults.class);
        i.putExtra("type_key", bType);
        startActivity(i);

    }

    public void browseByColor(View view) {
        Intent i = new Intent(this, bColor.class);
        startActivity(i);
    }

    public void browseByNote(View view) {

        final EditText bNote = findViewById(R.id.NoteText);
        String nResults = bNote.getText().toString().toUpperCase();

        Intent i = new Intent(this, noteBrowseResults.class);
        i.putExtra("note_key", nResults);
        startActivity(i);
    }

}
