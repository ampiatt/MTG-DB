package com.example.alex.mtgthedb;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface CardDao
{
    @Query("SELECT * FROM cards")
    List<Card> getAllCards();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCard(Card card);

    @Query("SELECT * FROM cards WHERE card_name = :name")
        Card findCard(String name);

}
