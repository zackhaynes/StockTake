package com.example.bit603_a3_zackhaynes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteUsersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_users);

        Button buttonDeleteUser = findViewById(R.id.buttonDeleteUser);
        EditText editTextDeleteUser = findViewById(R.id.editTextDeleteUser);

        buttonDeleteUser.setOnClickListener(v -> {
            // Error
            Boolean found = false;
            if(editTextDeleteUser.getText().toString().equals(""))
            {
                Toast.makeText(DeleteUsersActivity.this, getString(R.string.text_box_error_message), Toast.LENGTH_SHORT).show();
            }
            else
            {
                // No errors
                String username = editTextDeleteUser.getText().toString();
                for(User user : MainActivity.users)
                {
                    if(user.getUsername().equals(username))
                    {
                        // User found delete from database
                        MainActivity.userDatabase.userDao().deleteUser(user);
                        Toast.makeText(this, getString(R.string.user_deleted), Toast.LENGTH_SHORT).show();
                        editTextDeleteUser.setText("");
                        found = true;
                        break;
                    }
                }
                if(found == false)
                {
                    {
                        // User not found clear text field
                        Toast.makeText(DeleteUsersActivity.this, getString(R.string.user_not_found), Toast.LENGTH_SHORT).show();
                        editTextDeleteUser.setText("");
                    }
                }
            }

        });

    }
}