package com.example.bit603_a3_zackhaynes;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Stock")
public class Stock {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "Stock")
    private String stock;

    @ColumnInfo(name = "Quantity")
    private int quantity;

    @ColumnInfo(name = "Type")
    private String type;


    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
