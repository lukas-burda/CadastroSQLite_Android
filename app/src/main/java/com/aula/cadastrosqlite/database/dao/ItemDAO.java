package com.aula.cadastrosqlite.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.aula.cadastrosqlite.entities.Item;

import java.util.List;

@Dao
public interface ItemDAO {

    @Insert
    void Insert(Item item);

    @Update
    void Update(Item item);

    @Delete
    void Delete(Item item);

    @Query("SELECT * FROM Item")
    List<Item> GetAll();
}
