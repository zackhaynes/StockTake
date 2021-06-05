package com.example.bit603_a3_zackhaynes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddUserActivity extends AppCompatActivity {

    EditText editTextUsername;
    EditText editTextEmployeeID;
    EditText editTextDay;
    EditText editTextMonth;
    EditText editTextYear;
    String DOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        Button buttonAddUser = findViewById(R.id.buttonAddUser);
        editTextUsername = findViewById(R.id.editTextAddUserUsername);
        EditText editTextPassword = findViewById(R.id.editTextAddUserPassword);
        EditText editTextPhoneNumber = findViewById(R.id.editTextPhone);
        EditText editTextAddress = findViewById(R.id.editTextAddress);
        editTextEmployeeID = findViewById(R.id.editTextEmployeeID);
        editTextDay = findViewById(R.id.editTextDay);
        editTextMonth = findViewById(R.id.editTextMonth);
        editTextYear = findViewById(R.id.editTextYear);

        buttonAddUser.setOnClickListener(v -> {
            User newUser = new User();
            // Error check if all info has been entered
            if (editTextUsername.getText().toString().equals("") || editTextPassword.getText().toString().equals("") || editTextPhoneNumber.getText().toString().equals("") || editTextAddress.getText().toString().equals("") || editTextEmployeeID.getText().toString().equals("")) {
                // Error any text box is empty
                Toast.makeText(AddUserActivity.this, getString(R.string.text_box_error_message), Toast.LENGTH_SHORT).show();
            }
            else if(userExists() && checkDOB())
            {
                // No errors continue
                newUser.setId(Integer.parseInt(editTextEmployeeID.getText().toString()));
                newUser.setUsername(editTextUsername.getText().toString());
                newUser.setPassword(editTextPassword.getText().toString());
                newUser.setDob(DOB);
                newUser.setPhoneNumber(Integer.parseInt(editTextPhoneNumber.getText().toString()));
                newUser.setAddress(editTextAddress.getText().toString());

                MainActivity.userDatabase.userDao().addUser(newUser);
                Toast.makeText(AddUserActivity.this, getString(R.string.user_added_message), Toast.LENGTH_SHORT).show();
                editTextUsername.setText("");
                editTextPassword.setText("");
                editTextPhoneNumber.setText("");
                editTextAddress.setText("");
                editTextEmployeeID.setText("");
                editTextDay.setText("");
                editTextMonth.setText("");
                editTextYear.setText("");
            }
        });


    }

    private boolean checkDOB()
    {
        if(editTextDay.getText().toString().length() != 2 || editTextMonth.getText().toString().length() != 2 || editTextYear.getText().toString().length() != 4)
        {
            Toast.makeText(this, getString(R.string.dob_format), Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(Integer.parseInt(editTextMonth.getText().toString()) > 12 || Integer.parseInt(editTextDay.getText().toString()) > 31 || Integer.parseInt(editTextYear.getText().toString()) > 2020 || Integer.parseInt(editTextYear.getText().toString()) < 1900)
        {
            Toast.makeText(this, getString(R.string.valid_date), Toast.LENGTH_SHORT).show();
            return false;
        }
        else
        {
            DOB = editTextDay.getText().toString() + "/" + editTextMonth.getText().toString() + "/" + editTextYear.getText().toString();
            return true;
        }
    }

    private boolean userExists()
    {
        // Check if ID or username exists already
        for(User user : MainActivity.users)
        {
            if(Integer.parseInt(editTextEmployeeID.getText().toString()) == (user.getId()))
            {
                Toast.makeText(AddUserActivity.this, getString(R.string.id_found), Toast.LENGTH_SHORT).show();
                editTextEmployeeID.setText("");
                return false;
            }
            if(editTextUsername.getText().toString().equals(user.getUsername()))
            {
                Toast.makeText(AddUserActivity.this, getString(R.string.username_found), Toast.LENGTH_SHORT).show();
                editTextUsername.setText("");
                return false;
            }
        }
        return true;
    }


}