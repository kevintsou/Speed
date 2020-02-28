package com.kai.speed.room;

import androidx.room.*;

import java.util.List;

@Dao
public interface ItemDataDao {
    @Query("SELECT * FROM ItemData")
    List<ItemData> getAllItems();
    @Insert
    void insert(ItemData... data);
    @Update
    void update(ItemData... data);
    @Delete
    void delete(ItemData... data);
    @Query("delete from ItemData")
    void deleteAll();
}
