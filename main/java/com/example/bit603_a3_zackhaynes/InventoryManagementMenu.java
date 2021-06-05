package com.example.bit603_a3_zackhaynes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class InventoryManagementMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_management_menu);

        Button buttonAddItem = findViewById(R.id.buttonAddItemActivity);
        Button buttonInventoryStatus = findViewById(R.id.buttonInventoryStatusActivity);
        Button buttonClearItems = findViewById(R.id.buttonClearItems);
        Button buttonTestItems = findViewById(R.id.buttonTestItems);
        Button buttonLogout = findViewById(R.id.buttonLogout);

        buttonAddItem.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), AddItemActivity.class);
            startActivity(i);
        });

        buttonInventoryStatus.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), InventoryStatusActivity.class);
            startActivity(i);
        });

        buttonClearItems.setOnClickListener(v -> {
            AlertDialog.Builder alert = new AlertDialog.Builder(InventoryManagementMenu.this);

            alert.setMessage(getString(R.string.clear_all)).setTitle(getString(R.string.delete));
            alert.setPositiveButton(getString(R.string.yes), (dialog, which) -> {
                MainActivity.updateStockList();
                for(Stock stock : MainActivity.stockList){
                    MainActivity.stockDatabase.stockDao().deleteStock(stock);}
                    MainActivity.updateStockList();
            });
            alert.setNegativeButton(getString(R.string.no), (dialog, which) -> {
            });

            AlertDialog dialog = alert.create();
            dialog.show();
        });

        buttonTestItems.setOnClickListener(v -> {
            AlertDialog.Builder alert = new AlertDialog.Builder(InventoryManagementMenu.this);

            alert.setMessage(getString(R.string.add_items)).setTitle(getString(R.string.confirm));
            alert.setPositiveButton(getString(R.string.yes), (dialog, which) -> {
                MainActivity.updateStockList();
                 addStock("Flour", "Bag", 6);
                 addStock("White Sugar", "Bag", 8);
                 addStock("Cups", "Sleeve", 3);
                 addStock("Olive Oil", "Tin", 5);
                 addStock("Butter", "Block", 10);
                 addStock("Cocoa Powder", "Bag", 7);
                 addStock("Milk Chocolate", "Block", 8);
                 addStock("Icing Sugar", "Bag", 5);
                 addStock("Brown Sugar", "Bag", 4);
                 addStock("Milk", "Bottle", 10);
                 addStock("Baking Power", "Tin", 3);
                 addStock("Cup Cake Cups", "Sleeve", 6);
                 addStock("Boxes", "Sleeve", 7);
                 addStock("Sprinkles", "Bag", 3);
                 addStock("White Chocolate", "Block", 6);
                 addStock("Marshmallows", "Bag", 3);
                 addStock("Cream", "Bottle", 5);
                 addStock("Eggs", "Carton", 8);
                 addStock("Cooking Paper", "Roll", 3);
                 addStock("Foil", "Roll", 1);
            });
            alert.setNegativeButton(getString(R.string.no), (dialog, which) -> {

            });

            AlertDialog dialog = alert.create();
            dialog.show();
        });

        buttonLogout.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        });

    }

    private void addStock(String name, String type, int quantity)
    {
        Stock stock = new Stock();
        stock.setStock(name);
        stock.setType(type);
        stock.setQuantity(quantity);
        MainActivity.addStock(stock);
    }

}