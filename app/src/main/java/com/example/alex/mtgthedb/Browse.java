package com.example.alex.mtgthedb;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.List;

public class Browse extends AppCompatActivity {
    private DatabaseHandler db;
    private List<Card> FoundCards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        this.setTitle("Browse Collection");

        db = Room.databaseBuilder(this, DatabaseHandler.class, "cards")
                .allowMainThreadQueries()
                .build();

        Spinner typeSpinner = (Spinner) findViewById(R.id.typeSpinner);
        ArrayAdapter<CharSequence> typeAdapter = ArrayAdapter.createFromResource(this,
                R.array.type_array, android.R.layout.simple_spinner_dropdown_item);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(typeAdapter);
    }

    protected void browseClicked(View view)
    {
        browseData();
    }

    protected void browseData()
    {
        String bName;
        String bNote;
        String bType;
        int white = -1;
        int black = -1;
        int blue = -1;
        int red = -1;
        int green = -1;
        int colorless = -1;

        final EditText browseName = findViewById(R.id.nameBrowse);
        bName = browseName.getText().toString();

        final EditText browseNote = findViewById(R.id.noteBrowse);
        bNote = browseNote.getText().toString();

        Spinner browseType = findViewById(R.id.typeSpinner);
        bType = browseType.getSelectedItem().toString();

        if (bType.equals("None"))
        {
            bType = "";
        }

        CheckBox browseWhite = findViewById(R.id.checkWhite);
        CheckBox browseBlack = findViewById(R.id.checkBlack);
        CheckBox browseRed = findViewById(R.id.checkRed);
        CheckBox browseGreen = findViewById(R.id.checkGreen);
        CheckBox browseBlue = findViewById(R.id.checkBlue);
        CheckBox browseColorless = findViewById(R.id.checkColorless);

        if (browseWhite.isChecked())
        {
            white = 1;
        }

        if (browseBlack.isChecked())
        {
            black = 1;
        }

        if (browseRed.isChecked())
        {
            red = 1;
        }

        if (browseGreen.isChecked())
        {
            green = 1;
        }

        if (browseBlue.isChecked())
        {
            blue = 1;
        }

        if (browseColorless.isChecked())
        {
            colorless = 1;
        }

        FoundCards = db.cardDao().getAllCardsNameNote(bName, bNote, bType, red, blue, green, black, white, colorless);

        Intent i = new Intent(this, Results.class);
        startActivity(i);
    }

    protected String[] printFoundCards()
    {

        String[] results = new String[FoundCards.size()];
        for (int i = 0; i < FoundCards.size(); ++i)
        {
            results[i] = "Card Info: \nName: " +  FoundCards.get(i).getName() + "\nType: " + FoundCards.get(i).getType() + "\nNote: " + FoundCards.get(i).getNote();
        }

        return results;
    }
}
