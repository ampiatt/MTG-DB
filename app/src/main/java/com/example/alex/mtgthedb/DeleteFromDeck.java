package com.example.alex.mtgthedb;

import android.arch.persistence.room.Room;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DeleteFromDeck extends AppCompatActivity {
    DatabaseHandler db;
    Card deleteCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_from_deck);
        this.setTitle("Delete From Deck");

        db = Room.databaseBuilder(this, DatabaseHandler.class, "newCards")
                .allowMainThreadQueries()
                .build();
    }

    public void deckDeleteSearchForCard(View view) {
        String cardName = "";
        final EditText editSearch = findViewById(R.id.deckDeleteNameSearch);
        cardName = editSearch.getText().toString().toUpperCase();

        try
        {
            deleteCard = db.cardDao().findCard(cardName);
        }

        catch(Exception e)
        {
            e.getCause();
        }

        if (deleteCard != null && deleteCard.getDeckQuantity() > 0)
        {
            String output = "Card information: \nName: " + deleteCard.getName() + "\nType: " + deleteCard.getType() + "\nPersonal Note: " + deleteCard.getNote()
                    + "\nRed Mana: " + deleteCard.getRedMana() + "\nBlue Mana: " + deleteCard.getBlueMana() + "\nGreen Mana: " + deleteCard.getGreenMana() + "\nBlack Mana: "
                    + deleteCard.getBlackMana() + "\nWhite Mana: " + deleteCard.getWhiteMana() + "\nColorless Mana: " + deleteCard.getColorlessMana() + "\nQuantity: " + deleteCard.getQuantity()
                    + "\nDeck Quantity: " + deleteCard.getDeckQuantity();

            TextView display = findViewById(R.id.deckCardInformation);
            display.setText(output);

            editSearch.setText("");
        }

        if (deleteCard == null || deleteCard.getDeckQuantity() == 0)
        {
            AlertDialog.Builder noCard = new AlertDialog.Builder(this);
            noCard.setMessage("Card is not in the deck.");
            noCard.setPositiveButton("OK", null);
            AlertDialog showA = noCard.create();

            showA.show();
            editSearch.setText("");
            return;
        }
    }

    public void deleteCardFromDeck(View view) {
        deleteCard.setQuantity(deleteCard.getQuantity() + deleteCard.getDeckQuantity());
        deleteCard.setDeckQuantity(0);
        db.cardDao().updateCard(deleteCard);

        AlertDialog.Builder deleteSuccess = new AlertDialog.Builder(this);
        deleteSuccess.setMessage("Card deleted from deck");
        deleteSuccess.setPositiveButton("OK", null);
        AlertDialog showM = deleteSuccess.create();

        showM.show();
    }
}
