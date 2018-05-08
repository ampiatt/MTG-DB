package com.example.alex.mtgthedb;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity
{
    int life = 20;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView Life = findViewById(R.id.lifeTextView);
        Life.setText(String.valueOf(life));

    }

    public void cardButtonClick(View v)
    {
        Intent i = new Intent(this, AddCard.class);
        startActivity(i);
    }

    public void deleteButtonClick(View v)
    {
        Intent i = new Intent(this, DeleteCard.class);
        startActivity(i);
    }

    public void browseButtonClick(View v)
    {
        Intent i = new Intent(this, reBrowse.class);
        startActivity(i);
    }

    public void deckManagerClick(View v) {
        Intent i = new Intent(this, DeckManager.class);
        startActivity(i);
    }

    public void upClicked(View v) {
        ++life;
        TextView Life = findViewById(R.id.lifeTextView);
        Life.setText(String.valueOf(life));
    }

    public void downClicked(View v) {
        --life;
        TextView Life = findViewById(R.id.lifeTextView);
        Life.setText(String.valueOf(life));
    }
}










