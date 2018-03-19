package com.example.alex.mtgthedb;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface CardDao
{
    @Query("SELECT * FROM cards")
    List<Card> getAllCards();

    @Query("SELECT * FROM cards WHERE card_name = :name")
    Card findCard(String name);

    @Query("SELECT * FROM cards WHERE card_type = :type")
    List<Card> getAllCardsType(String type);

    //@Query("SELECT * FROM cards WHERE note LIKE '%bNote%'")
    //List<Card> getAllCardsNote(String bNote);

    @Query("SELECT * FROM cards WHERE card_name LIKE '%name%'" + "AND note LIKE '%bNote%' " + "AND card_type LIKE '%bType%'" +
            "AND red_mana  < 'red'" + " AND blue_mana < 'blue'" + " AND green_mana < 'green'" + " AND black_mana < 'black'" + "AND white_mana < 'white'" + " AND colorless_mana < 'colorless'")
    List<Card> getAllCardsNameNote(String name, String bNote, String bType, int red, int blue, int green, int black, int white, int colorless);



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCard(Card card);

    @Delete
    void delete(Card card);

    @Update()
    void updateCard(Card card);

}
