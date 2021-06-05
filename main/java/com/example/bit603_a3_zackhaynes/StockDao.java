package com.example.bit603_a3_zackhaynes;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao
public interface StockDao {

    @Insert
    void addStock(Stock stock);

    @Query("SELECT * FROM Stock")
    List<Stock> getStock();

    @Delete
    void deleteStock(Stock stock);

    @Update
    void updateStock(Stock stock);

}
