package com.example.bit603_a3_zackhaynes;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class UserAdapter extends ArrayAdapter<User> {

    public UserAdapter(Activity context, ArrayList<User> users)
    {
        super(context, 0, users);
    }

    // User adapter to set ListView on ViewUsers activity

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View listItemView = convertView;
        if(listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.view_user_list, parent, false);
        }
        User currentUser = getItem(position);

        TextView textViewID = listItemView.findViewById(R.id.textViewListID);
        TextView textViewUsername = listItemView.findViewById(R.id.textViewListUsername);
        Button buttonViewUser = listItemView.findViewById(R.id.buttonViewUser);

        textViewUsername.setText(currentUser.getUsername());
        textViewID.setText(String.valueOf(currentUser.getId()));

        buttonViewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a layout to display to ListView
                Context c = getContext();
                LinearLayout layout = new LinearLayout(c);
                layout.setOrientation(LinearLayout.VERTICAL);

                // Dialog to view more Employee information
                AlertDialog.Builder alert = new AlertDialog.Builder(c);

                final TextView TextID = new TextView(c);
                final TextView TextUsername = new TextView(c);
                final TextView TextPassword = new TextView(c);
                final TextView TextPhone = new TextView(c);
                final TextView TextAddress = new TextView(c);
                final TextView TextDOB = new TextView(c);

                TextID.setText(getContext().getResources().getString(R.string.view_employee, String.valueOf(currentUser.getId())));
                TextUsername.setText(getContext().getResources().getString(R.string.view_username, currentUser.getUsername()));
                TextPassword.setText(getContext().getResources().getString(R.string.view_password, currentUser.getPassword()));
                TextPhone.setText(getContext().getResources().getString(R.string.view_phone, String.valueOf(currentUser.getPhoneNumber())));
                TextAddress.setText(getContext().getResources().getString(R.string.view_address, currentUser.getAddress()));
                TextDOB.setText(getContext().getResources().getString(R.string.view_dob, currentUser.getDob()));

                layout.addView(TextID);
                layout.addView(TextUsername);
                layout.addView(TextPassword);
                layout.addView(TextPhone);
                layout.addView(TextAddress);
                layout.addView(TextDOB);

                alert.setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                    }
                });

                // Set Dialog view as layout
                alert.setView(layout);
                alert.show();
            }
        });
        return listItemView;

    }


}
