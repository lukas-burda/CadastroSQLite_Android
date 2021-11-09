package com.aula.cadastrosqlite.database.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.aula.cadastrosqlite.database.dao.ItemDAO;
import com.aula.cadastrosqlite.entities.Item;

@Database(entities = {Item.class}, version= 1, exportSchema = false)
public abstract class ItemDB extends RoomDatabase {

    private static ItemDB instance;

    public static ItemDB getInstance(Context context){

        if(instance == null){
            instance = Room.databaseBuilder(context, ItemDB.class, "ItemDB")
                    .allowMainThreadQueries()
                    .build();
        }

        return instance;
    }

    public abstract ItemDAO getItemDAO();

}
