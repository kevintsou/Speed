package com.kai.speed.room;

import androidx.room.*;

import java.util.List;

@Dao
public interface ResultItemDao {
    @Query("SELECT * FROM ResultItem")
    List<ResultItem> getAllItems();
    @Insert
    void insert(ResultItem... data);
    @Update
    void update(ResultItem... data);
    @Delete
    void delete(ResultItem... data);
    @Query("delete from ResultItem")
    void deleteAll();
}
