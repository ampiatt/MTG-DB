package com.example.alex.mtgthedb;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface CardDao
{
    @Query("SELECT * FROM newCards")
    List<Card> getAllCards();

    @Query("SELECT * FROM newCards WHERE card_name = :name")
    Card findCard(String name);

    @Query("SELECT * FROM newCards WHERE card_type = :type")
    List<Card> getAllCardsType(String type);

    @Query("SELECT * FROM newCards WHERE blue_mana > 0")
    List<Card> Sanji();

    @Query("SELECT * FROM newCards WHERE red_mana > 0")
    List<Card> getAllRed();

    @Query("SELECT * FROM newCards WHERE white_mana > 0")
    List<Card> getAllWhite();

    @Query("SELECT * FROM newCards WHERE black_mana > 0")
    List<Card> getAllBlack();

    @Query("SELECT * FROM newCards WHERE colorless_mana > 0")
    List<Card> getAllColorless();

    @Query("SELECT * FROM newCards WHERE green_mana")
    List<Card> getAllGreen();

    @Query("SELECT * FROM newCards WHERE note = :cNote")
    List<Card> getAllNote(String cNote);

    @Query("SELECT * FROM newCards WHERE deck_quantity > 0")
    List<Card> getAllInDeck();
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCard(Card card);

    @Delete
    void delete(Card card);

    @Update()
    void updateCard(Card card);
}
