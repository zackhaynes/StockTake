package com.example.bit603_a3_zackhaynes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public User user;

    // Create the database references
    public static UserDatabase userDatabase;
    public static StockDatabase stockDatabase;

    // Create the database list references
    public static List<User> users;
    public static List<Stock> stockList;

    private final String adminUser = "Admin";
    private final String adminPassword = "CookieManagement84";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // link to the database
        userDatabase = Room.databaseBuilder(getApplicationContext(), UserDatabase.class, "userdb").allowMainThreadQueries().build();
        stockDatabase = Room.databaseBuilder(getApplicationContext(), StockDatabase.class, "stockdb").allowMainThreadQueries().build();

        updateUserList();
        updateStockList();

        Button buttonLogin = findViewById(R.id.buttonLogin);
        EditText editTextUsername = findViewById(R.id.editTextUsername);
        EditText editTextPassword = findViewById(R.id.editTextPassword);


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();
                // Login correct go to menu page
                if(username.equals(adminUser) && password.equals(adminPassword))
                {
                    editTextUsername.setText("");
                    editTextPassword.setText("");
                    Intent i = new Intent(getApplicationContext(), UserManagementMenu.class);
                    startActivity(i);
                }
                else if(checkLogin(username, password))
                {
                    editTextUsername.setText("");
                    editTextPassword.setText("");
                    Intent i = new Intent(getApplicationContext(), InventoryManagementMenu.class);
                    startActivity(i);
                }
                // Login incorrect toast error message/reset password EditText
                else
                {
                    editTextPassword.setText("");
                    Toast.makeText(MainActivity.this, "Username or Password was incorrect, please enter a valid login", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    public boolean checkLogin(String username, String password)
    {
        for(User user : users)
        {
            if(username.equals(user.getUsername()))
            {
                if(password.equals(user.getPassword()))
                {
                    this.user = user;
                    return true;
                }
            }
        }
        return false;
    }

    // Adds all users from database to the users list
    public static void updateUserList()
    {
        users = userDatabase.userDao().getUsers();
    }

    // Add all stock from database to the stock list
    public static void updateStockList()
    {
        stockList = stockDatabase.stockDao().getStock();
    }


    public static void addStock(Stock newStock)
    {
        // If stock of the same is added will update to new Type and Quantity values
        boolean update = false;
            for (Stock stock : stockList) {
                if (stock.getStock().equals(newStock.getStock())) {
                    stockDatabase.stockDao().updateStock(newStock);
                    update = true;
                    break;
                }
            }
            if (update == false) {
                stockDatabase.stockDao().addStock(newStock);
            }

    }
}