package com.example.alex.mtgthedb;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "cards")
public class Card
{

    @PrimaryKey(autoGenerate = true)
    public int cardID;

    @ColumnInfo(name = "card_name")
    public String Name;

    @ColumnInfo(name = "card_type")
    public String Type;

    @ColumnInfo(name = "note")
    public String Note;

    @ColumnInfo(name = "blue_mana")
    public int blueMana;

    @ColumnInfo(name = "black_mana")
    public int blackMana;

    @ColumnInfo(name = "green_mana")
    public int greenMana;

    @ColumnInfo(name = "red_mana")
    public int redMana;

    @ColumnInfo(name = "white_mana")
    public int whiteMana;

    @ColumnInfo(name = "colorless_mana")
    public int colorlessMana;

    @ColumnInfo(name = "quantity")
    public int Quantity;

    public Card()
    {

        Name = "";
        Type = "";
        Note = "";
        blueMana = 0;
        blackMana = 0;
        greenMana = 0;
        redMana = 0;
        whiteMana = 0;
        colorlessMana = 0;
        Quantity = 0;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getCardID() {
        return cardID;
    }

    public void setCardID(int cardID) {
        this.cardID = cardID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() { return Type; }

    public void setType(String type) {
        Type = type;
    }

    public int getBlueMana() {
        return blueMana;
    }

    public void setBlueMana(int blueMana) {
        this.blueMana = blueMana;
    }

    public int getBlackMana() {
        return blackMana;
    }

    public void setBlackMana(int blackMana) {
        this.blackMana = blackMana;
    }

    public int getGreenMana() {
        return greenMana;
    }

    public void setGreenMana(int greenMana) {
        this.greenMana = greenMana;
    }

    public int getRedMana() {
        return redMana;
    }

    public void setRedMana(int redMana) {
        this.redMana = redMana;
    }

    public int getWhiteMana() {
        return whiteMana;
    }

    public void setWhiteMana(int whiteMana) {
        this.whiteMana = whiteMana;
    }

    public int getColorlessMana() {
        return colorlessMana;
    }

    public void setColorlessMana(int colorlessMana) {
        this.colorlessMana = colorlessMana;
    }

}
