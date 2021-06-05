
package com.example.bit603_a3_zackhaynes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        MainActivity.updateStockList();

        Button buttonAddItem = findViewById(R.id.buttonAddItem);
        EditText editTextStock = findViewById(R.id.editTextProductName);
        EditText editTextType = findViewById(R.id.editTextProductType);
        EditText editTextQuantity = findViewById(R.id.editTextProductQuantity);


        buttonAddItem.setOnClickListener(v -> {
            // Error check
            if(editTextStock.getText().toString().equals("") || editTextType.getText().toString().equals("") || editTextQuantity.getText().toString().equals(""))
            {
                Toast.makeText(AddItemActivity.this, getString(R.string.text_box_error_message), Toast.LENGTH_SHORT).show();
            }
            else
            {
                // No errors
                Stock stock = new Stock();
                stock.setStock(editTextStock.getText().toString());
                stock.setType(editTextType.getText().toString());
                stock.setQuantity(Integer.parseInt(editTextQuantity.getText().toString()));

                MainActivity.addStock(stock);

                editTextStock.setText("");
                editTextType.setText("");
                editTextQuantity.setText("");

                Toast.makeText(AddItemActivity.this, getString(R.string.product_added), Toast.LENGTH_LONG).show();
            }
        });


    }
}