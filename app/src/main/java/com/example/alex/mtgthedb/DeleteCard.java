package com.example.alex.mtgthedb;

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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_card);

        this.setTitle("Delete Card");
    }

    protected void searchDatabase(View view)
    {
        String cardName = "";
        final EditText editSearch = findViewById(R.id.nameSearch);
        cardName = editSearch.getText().toString();

        returnedCard = db.cardDao().findCard(cardName);
        String output = "Card information: \nName: " + returnedCard.getName() + "\nType: " + returnedCard.getType();

        TextView display =(TextView)findViewById(R.id.cardInformation);
        display.setText(output);

    }


}
