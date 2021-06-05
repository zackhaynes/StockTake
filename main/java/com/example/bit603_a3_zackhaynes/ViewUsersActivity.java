package com.example.bit603_a3_zackhaynes;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ViewUsersActivity extends AppCompatActivity {

    ListView listViewUsers;
    ArrayList<User> usersArrayList;
    UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users);

        MainActivity.updateUserList();
        createListView();

    }

    public void createListView()
    {
        listViewUsers = findViewById(R.id.listViewUsers);

        usersArrayList = new ArrayList<>();
        usersArrayList.addAll(MainActivity.users);

        userAdapter = new UserAdapter(this, usersArrayList);

        listViewUsers.setAdapter(userAdapter);

    }


}