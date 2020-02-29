package com.kai.speed.room;

import android.content.Context;
import android.widget.Toast;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = { ResultItem.class }, version = 1,exportSchema = false)
@TypeConverters({ResultItemTypeConverters.class})
public abstract class ResultItembase extends RoomDatabase {
    private static final String DB_NAME = "ResultItemDatabase.db";
    private static volatile ResultItembase instance;
    public static synchronized ResultItembase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
            if(instance == null){
                Toast.makeText(context, "Fail", Toast.LENGTH_SHORT).show();
            }
        }
        return instance;
    }
    private static ResultItembase create(final Context context) {
        return Room.databaseBuilder(
                context,
                ResultItembase.class,
                DB_NAME).build();
    }
    public abstract ResultItemDao getItemDataDao();
}

