package com.example.bit603_a3_zackhaynes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


public class UserManagementMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_managment_menu);

        Button buttonAddUser = findViewById(R.id.buttonAddUserActivity);
        Button buttonViewUser = findViewById(R.id.buttonViewUsersActivity);
        Button buttonDeleteUser = findViewById(R.id.buttonDeleteUserActivity);
        Button buttonLogout = findViewById(R.id.buttonLogoutUser);

        buttonAddUser.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), AddUserActivity.class);
            startActivity(i);
        });

        buttonViewUser.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), ViewUsersActivity.class);
            startActivity(i);
        });

        buttonDeleteUser.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), DeleteUsersActivity.class);
            startActivity(i);
        });

        buttonLogout.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        });

    }

}
