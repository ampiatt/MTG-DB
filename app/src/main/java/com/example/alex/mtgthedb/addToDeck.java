package com.example.alex.mtgthedb;

import android.arch.persistence.room.Room;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class addToDeck extends AppCompatActivity {
    DatabaseHandler db;
    Card foundCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_deck);

        db = Room.databaseBuilder(this, DatabaseHandler.class, "newCards")
                .allowMainThreadQueries()
                .build();

    }

    public void deckSearchForCard(View view) {
        String cardName = "";
        final EditText editSearch = findViewById(R.id.deckNameSearch);
        cardName = editSearch.getText().toString().toUpperCase();

        try
        {
            foundCard = db.cardDao().findCard(cardName);
        }

        catch(Exception e)
        {
            e.getCause();
        }

        if (foundCard != null)
        {
            String output = "Card information: \nName: " + foundCard.getName() + "\nType: " + foundCard.getType() + "\nPersonal Note: " + foundCard.getNote()
                    + "\nRed Mana: " + foundCard.getRedMana() + "\nBlue Mana: " + foundCard.getBlueMana() + "\nGreen Mana: " + foundCard.getGreenMana() + "\nBlack Mana: "
                    + foundCard.getBlackMana() + "\nWhite Mana: " + foundCard.getWhiteMana() + "\nColorless Mana: " + foundCard.getColorlessMana() + "\nQuantity: " + foundCard.getQuantity()
                    + "\nDeck Quantity: " + foundCard.getDeckQuantity();

            TextView display = findViewById(R.id.deckCardInformation);
            display.setText(output);

            editSearch.setText("");
        }

        if (foundCard == null)
        {
            AlertDialog.Builder noCard = new AlertDialog.Builder(this);
            noCard.setMessage("Card does not exist in the database.");
            noCard.setPositiveButton("OK", null);
            AlertDialog showA = noCard.create();

            showA.show();
            editSearch.setText("");
            return;
        }
    }

    public void addCardToDeck(View view) {
        foundCard.setQuantity(foundCard.getQuantity() - 1);
        foundCard.setDeckQuantity(foundCard.getDeckQuantity() + 1);

        db.cardDao().updateCard(foundCard);

        AlertDialog.Builder cardAdded = new AlertDialog.Builder(this);
        cardAdded.setMessage("Card added to deck!");
        cardAdded.setPositiveButton("OK", null);
        AlertDialog mShow = cardAdded.create();

        mShow.show();
    }
}
