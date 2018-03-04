package com.example.alex.mtgthedb;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.Database;
import android.content.Context;

@Database(entities = {Card.class}, version = 1)
public abstract class DatabaseHandler extends RoomDatabase
{
    public abstract CardDao cardDao();

}
