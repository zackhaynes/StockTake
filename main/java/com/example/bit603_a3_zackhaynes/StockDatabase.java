package com.example.bit603_a3_zackhaynes;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Stock.class}, version = 1)
public abstract class StockDatabase extends RoomDatabase {

    public abstract StockDao stockDao();

}
