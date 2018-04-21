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

    @Query("SELECT * FROM cards WHERE blue_mana > 0")
    List<Card> Sanji();

    @Query("SELECT * FROM cards WHERE red_mana > 0")
    List<Card> getAllRed();

    @Query("SELECT * FROM cards WHERE white_mana > 0")
    List<Card> getAllWhite();

    @Query("SELECT * FROM cards WHERE black_mana > 0")
    List<Card> getAllBlack();

    @Query("SELECT * FROM cards WHERE colorless_mana > 0")
    List<Card> getAllColorless();

    @Query("SELECT * FROM cards WHERE green_mana")
    List<Card> getAllGreen();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCard(Card card);

    @Delete
    void delete(Card card);

    @Update()
    void updateCard(Card card);

}
