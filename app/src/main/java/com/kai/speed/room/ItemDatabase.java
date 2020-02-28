package com.kai.speed.room;

import android.content.Context;
import android.widget.Toast;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = { ItemData.class }, version = 1,exportSchema = false)
@TypeConverters({ItemDataTypeConverters.class})
public abstract class ItemDatabase extends RoomDatabase {
    private static final String DB_NAME = "ItemDatabase.db";
    private static volatile ItemDatabase instance;
    public static synchronized ItemDatabase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
            if(instance == null){
                Toast.makeText(context, "Fail", Toast.LENGTH_SHORT).show();
            }
        }
        return instance;
    }
    private static ItemDatabase create(final Context context) {
        return Room.databaseBuilder(
                context,
                ItemDatabase.class,
                DB_NAME).build();
    }
    public abstract ItemDataDao getItemDataDao();
}

