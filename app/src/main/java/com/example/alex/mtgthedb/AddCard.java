package com.example.alex.mtgthedb;


import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

import java.lang.reflect.InvocationTargetException;

public class AddCard extends AppCompatActivity {
    private Button Save;
    private String cName;
    private String cType;
    private String cNote;
    private String cRM;
    private String cBM;
    private String cGM;
    private String cWM;
    private String cBlkM;
    private String cCM;
    private String cQuant;
    private DatabaseHandler db = Room.databaseBuilder(this, DatabaseHandler.class, "cards")
            .allowMainThreadQueries()
            .build();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        this.setTitle("Add New Card");
        Save = (Button) findViewById(R.id.saveButton);

    }

    public void saveClicked(View view) {
        Card Add = new Card();

        EditText edit = findViewById(R.id.nameField);
        cName = edit.getText().toString();

        EditText editType = findViewById(R.id.typeField);
        cType = editType.getText().toString();

        EditText editNote = findViewById(R.id.noteField);
        cNote = editNote.getText().toString();

        EditText editRed = findViewById(R.id.redMana);
        cRM =  editRed.getText().toString();

        EditText editBlue = findViewById(R.id.blueMana);
        cBM = editBlue.getText().toString();

        EditText editGreen = findViewById(R.id.greenMana);
        cGM = editGreen.getText().toString();

        EditText editBlack = findViewById(R.id.blackMana);
        cBlkM = editBlack.getText().toString();

        EditText editWhite = findViewById(R.id.whiteMana);
        cWM = editWhite.getText().toString();

        EditText editColorless = findViewById(R.id.colorlessField);
        cCM = editColorless.getText().toString();

        EditText editQuantity = findViewById(R.id.quantityField);
        cQuant = editQuantity.getText().toString();

        Add.setName(cName);
        Add.setType(cType);
        Add.setNote(cNote);

        if (!cRM.equals(""))
        {
            Add.setRedMana(Integer.parseInt(cRM));
        }

        if(!cBM.equals(""))
        {
            Add.setBlueMana(Integer.parseInt(cBM));
        }

        if(!cGM.equals(""))
        {
            Add.setGreenMana(Integer.parseInt(cGM));
        }

        if(!cBlkM.equals(""))
        {
            Add.setBlackMana(Integer.parseInt(cBlkM));
        }

        if(!cWM.equals(""))
        {
            Add.setWhiteMana(Integer.parseInt(cWM));
        }

        if(!cCM.equals(""))
        {
            Add.setColorlessMana(Integer.parseInt(cCM));
        }

        if(!cQuant.equals(""))
        {
            Add.setQuantity(Integer.parseInt(cQuant));
        }

        AlertDialog.Builder dialogbuild = new AlertDialog.Builder(this);
        dialogbuild.setMessage("Card Info:\n" + "Name: " + Add.getName() + "\nType: " + Add.getType() + "\nNote: " + Add.getNote() + "\nRed: "
                + String.valueOf(Add.getRedMana()) + "\nBlue: " + String.valueOf(Add.getBlueMana()) + "\nGreen: " + String.valueOf(Add.getGreenMana())
                + "\nBlack: " + String.valueOf(Add.getBlackMana()) + "\nWhite: " + String.valueOf(Add.getWhiteMana()) + "\nColorless: " + String.valueOf(Add.getColorlessMana())
                + "\nQuantity: " + String.valueOf(Add.getQuantity()));
        dialogbuild.setPositiveButton("OK", null);

        AlertDialog show = dialogbuild.create();
        show.show();

        edit.setText("");
        editType.setText("");
        editNote.setText("");
        editRed.setText("");
        editBlue.setText("");
        editGreen.setText("");
        editBlack.setText("");
        editWhite.setText("");
        editColorless.setText("");
        editQuantity.setText("");
        try {
                db.cardDao().insertCard(Add);
        }
        catch(NullPointerException e){
            e.printStackTrace();
        }
    }




}
