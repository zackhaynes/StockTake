package com.example.bit603_a3_zackhaynes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class InventoryStatusActivity extends AppCompatActivity {

    TextView textViewStock;
    TextView textViewType;
    TextView textViewQuantity;
    int displayCount;
    ArrayList<String> displayProduct = new ArrayList<>();
    ArrayList<String> displayType = new ArrayList<>();
    ArrayList<String> displayQuantity = new ArrayList<>();

    @SuppressLint("StringFormatMatches")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_status);

        textViewStock = findViewById(R.id.textViewStockProductName);
        textViewType = findViewById(R.id.textViewStockProductType);
        textViewQuantity = findViewById(R.id.textViewStockProductQuantity);
        Button buttonPrevious = findViewById(R.id.buttonPrevious);
        Button buttonNext = findViewById(R.id.buttonNext);

        MainActivity.updateStockList();


        displayCount = 0;

        if(!MainActivity.stockList.isEmpty())
        {
            displayStockName();
            displayStockType();
            displayStockQuantity();
            displayStock();
        }

        // If displayCount is not equal to the max length of the List it will not increase
        buttonNext.setOnClickListener(v -> {
            if (!MainActivity.stockList.isEmpty()) {
                if ((displayCount + 1) != displayProduct.size()) {
                    textViewStock.setText("");
                    textViewType.setText("");
                    textViewQuantity.setText("");
                    displayCount++;
                    displayStock();
                }
            }
        });

        // If displayCount is greater than 0 it may decrease
        buttonPrevious.setOnClickListener(v -> {
            if (displayCount > 0) {
                textViewStock.setText("");
                displayCount--;
                displayStock();
            }
        });

    }

    // Display stock at displayCount
    private void displayStock() {
            textViewStock.setText(displayProduct.get(displayCount));
            textViewType.setText(displayType.get(displayCount));
            textViewQuantity.setText(displayQuantity.get(displayCount));
    }

    // Creates a list of stock with 5 entries each or however many are left
    private void displayStockName() {
        String stockName = "";
        int i = 0;
        int count = 0;
        for (Stock stock : MainActivity.stockList) {
            stockName += stock.getStock() + "\n";
            i++;
            count++;
            if (i == 5) {
                displayProduct.add(stockName);
                i = 0;
                stockName = "";
            } else if (count == MainActivity.stockList.size()) {
                displayProduct.add(stockName);
            }
        }
    }

    private void displayStockType() {
        String stockType = "";
        int i = 0;
        int count = 0;
        for (Stock stock : MainActivity.stockList) {
            stockType += stock.getType() + "\n";
            i++;
            if (i == 5) {
                displayType.add(stockType);
                i = 0;
                stockType = "";
            } else if (count == MainActivity.stockList.size()) {
                displayType.add(stockType);
            }
        }

    }

    private void displayStockQuantity() {
        String stockQuantity = "";
        int i = 0;
        int count = 0;
        for (Stock stock : MainActivity.stockList) {
            stockQuantity += String.valueOf(stock.getQuantity()) + "\n";
            i++;
            if (i == 5) {
                displayQuantity.add(stockQuantity);
                i = 0;
                stockQuantity = "";
            } else if (count == MainActivity.stockList.size()) {
                displayQuantity.add(stockQuantity);
            }
        }


    }
}