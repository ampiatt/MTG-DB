package com.example.alex.mtgthedb;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.Database;
import android.content.Context;

@Database(entities = {Card.class}, version = 1)
public abstract class DatabaseHandler extends RoomDatabase {
    //private static DatabaseHandler INSTANCE;

    public abstract CardDao cardDao();

    //public static DatabaseHandler getDb(Context context) {
          //  INSTANCE = Room.databaseBuilder(context, DatabaseHandler.class, "cards")
          //          .build();
   //     return INSTANCE;
    //}
}
