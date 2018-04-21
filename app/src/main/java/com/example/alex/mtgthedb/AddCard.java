package com.example.alex.mtgthedb;


import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import org.w3c.dom.Text;

import java.lang.reflect.InvocationTargetException;

public class AddCard extends AppCompatActivity
{
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
    private DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        this.setTitle("Add Card");
        db = Room.databaseBuilder(this, DatabaseHandler.class, "cards")
            .allowMainThreadQueries()
            .build();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        this.setTitle("Add New Card");
        Save = (Button) findViewById(R.id.saveButton);

        Spinner typeSpinner = (Spinner) findViewById(R.id.typeSpinner);
        ArrayAdapter<CharSequence> typeAdapter = ArrayAdapter.createFromResource(this,
                R.array.type_array, android.R.layout.simple_spinner_dropdown_item);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(typeAdapter);

    }

    public void saveClicked(View view)
    {
        final Spinner editType = findViewById(R.id.typeSpinner);
        String cType = editType.getSelectedItem().toString();

        Card check = new Card();

        final EditText edit = findViewById(R.id.nameField);
        cName = edit.getText().toString();

        final EditText editNote = findViewById(R.id.noteField);
        cNote = editNote.getText().toString();

        final EditText editRed = findViewById(R.id.redMana);
        cRM =  editRed.getText().toString();

        final EditText editBlue = findViewById(R.id.blueMana);
        cBM = editBlue.getText().toString();

        final EditText editGreen = findViewById(R.id.greenMana);
        cGM = editGreen.getText().toString();

        final EditText editBlack = findViewById(R.id.blackMana);
        cBlkM = editBlack.getText().toString();

        final EditText editWhite = findViewById(R.id.whiteMana);
        cWM = editWhite.getText().toString();

        final EditText editColorless = findViewById(R.id.colorlessField);
        cCM = editColorless.getText().toString();

        final EditText editQuantity = findViewById(R.id.quantityField);
        cQuant = editQuantity.getText().toString();

        final int selection = editType.getSelectedItemPosition();

        if (cName.equals(""))
        {
            AlertDialog.Builder brokeDialog = new AlertDialog.Builder(this);
            brokeDialog.setMessage("Card name required to add to database.");
            brokeDialog.setPositiveButton("OK", null);
            AlertDialog showD = brokeDialog.create();

            showD.show();
            return;
        }

        Card Push = createCard(cName, cType, cNote, cRM, cBM, cGM, cBlkM, cWM, cCM, cQuant);

        AlertDialog.Builder dialogbuild = new AlertDialog.Builder(this);
        dialogbuild.setMessage("Card Info:\n" + "Name: " + Push.getName() + "\nType: " + Push.getType() + "\nNote: " + Push.getNote() + "\nRed: "
                + String.valueOf(Push.getRedMana()) + "\nBlue: " + String.valueOf(Push.getBlueMana()) + "\nGreen: " + String.valueOf(Push.getGreenMana())
                + "\nBlack: " + String.valueOf(Push.getBlackMana()) + "\nWhite: " + String.valueOf(Push.getWhiteMana()) + "\nColorless: " + String.valueOf(Push.getColorlessMana())
                + "\nQuantity: " + String.valueOf(Push.getQuantity()));
        dialogbuild.setPositiveButton("OK", null);
        dialogbuild.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                edit.setText(cName);
                editType.setSelection(selection);
                editNote.setText(cNote);
                editRed.setText(cRM);
                editBlue.setText(cBM);
                editGreen.setText(cGM);
                editBlack.setText(cBlkM);
                editWhite.setText(cWM);
                editColorless.setText(cCM);
                editQuantity.setText(cQuant);

                return;
            }
        });

        AlertDialog show = dialogbuild.create();
        show.show();

        editType.setSelection(0);
        edit.setText("");
        editNote.setText("");
        editRed.setText("");
        editBlue.setText("");
        editGreen.setText("");
        editBlack.setText("");
        editWhite.setText("");
        editColorless.setText("");
        editQuantity.setText("");

        check = db.cardDao().findCard(cName);
        if (check != null)
        {
            check.setQuantity(check.getQuantity() + Integer.parseInt(cQuant));
            db.cardDao().insertCard(check);
            AlertDialog.Builder existsDialog = new AlertDialog.Builder(this);
            existsDialog.setMessage("A card with that name already exists in the database.  Updating quantity of original card.");
            existsDialog.setPositiveButton("OK", null);
            AlertDialog showE = existsDialog.create();

            showE.show();
        }

        else
        {
            db.cardDao().insertCard(Push);
        }
    }

    public Card createCard(String Name, String Type, String Note, String Red, String Blue, String Green, String Black, String White, String Colorless, String Quantity)
    {
        Card Add = new Card();

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
        return Add;
    }
}
