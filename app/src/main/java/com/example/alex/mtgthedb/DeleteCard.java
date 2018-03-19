package com.example.alex.mtgthedb;

import android.arch.persistence.room.Room;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DeleteCard extends AppCompatActivity
{
    DatabaseHandler db;
    Card returnedCard;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        this.setTitle("Delete Card");
        db = Room.databaseBuilder(this, DatabaseHandler.class, "cards")
            .allowMainThreadQueries()
            .build();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_card);
    }

    protected void searchDatabase(View view)
    {
        String cardName = "";
        final EditText editSearch = findViewById(R.id.nameSearch);
        cardName = editSearch.getText().toString();

        try
        {
            returnedCard = db.cardDao().findCard(cardName);
        }

        catch(Exception e)
        {
            e.getCause();
        }

        if (returnedCard != null)
        {
            String output = "Card information: \nName: " + returnedCard.getName() + "\nType: " + returnedCard.getType() + "\nPersonal Note: " + returnedCard.getNote()
                    + "\nRed Mana: " + returnedCard.getRedMana() + "\nBlue Mana: " + returnedCard.getBlueMana() + "\nGreen Mana: " + returnedCard.getGreenMana() + "\nBlack Mana: "
                    + returnedCard.getBlackMana() + "\nWhite Mana: " + returnedCard.getWhiteMana() + "\nColorless Mana: " + returnedCard.getColorlessMana() + "\nQuantity: " + returnedCard.getQuantity();

            TextView display = findViewById(R.id.cardInformation);
            display.setText(output);

            editSearch.setText("");
        }

        if (returnedCard == null)
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

    protected void deleteCard(View view)
    {
        db.cardDao().delete(returnedCard);
        TextView resetDisplay = (TextView) findViewById(R.id.cardInformation);
        resetDisplay.setText("");

        if (db.cardDao().findCard(returnedCard.getName()) == null)
        {
            AlertDialog.Builder deleteSuccess = new AlertDialog.Builder(this);
            deleteSuccess.setMessage("Card deleted successfully.");
            deleteSuccess.setPositiveButton("OK", null);
            AlertDialog showC = deleteSuccess.create();

            showC.show();
        }
        else
        {
            AlertDialog.Builder deleteFailed = new AlertDialog.Builder(this);
            deleteFailed.setMessage("Unable to delete cared.");
            deleteFailed.setPositiveButton("OK", null);
            AlertDialog showP = deleteFailed.create();

            showP.show();
        }

        return;
    }
}
