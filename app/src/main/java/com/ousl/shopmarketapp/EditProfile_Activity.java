package com.ousl.shopmarketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditProfile_Activity extends AppCompatActivity {

    DatabaseHelper AllUsersDB;

    // Assign Variables
    EditText editName, editEmail, editPassword;
    TextView updateDetailsBTN, deleteAccountBTN, editUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.edit_profile_activity);

        // Create Object
        AllUsersDB = new DatabaseHelper(this);

        //Assign Variables from Designed EditTexts and Buttons
        editUsername = findViewById(R.id.editUserNameId);
        editName = findViewById(R.id.editUserName);
        editEmail = findViewById(R.id.editUserEmail);
        editPassword = findViewById(R.id.editUserPassword);

        updateDetailsBTN = findViewById(R.id.updateUserDetailsBTN);
        deleteAccountBTN = findViewById(R.id.deleteUserAccountBTN);

        // Call Methods update and delete Data
        updateData();
        deleteData();

    }

    //Method For UPDATE User Profile Details
    public void updateData(){
        updateDetailsBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdate = AllUsersDB.updateData(editUsername.getText().toString(), editName.getText().toString(), editEmail.getText().toString(),
                        editPassword.getText().toString());

                //Check Update or Not Task Data to Database
                if (isUpdate == true)
                    Toast.makeText(EditProfile_Activity.this, "Success!! Profile Details Updated", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(EditProfile_Activity.this, "Error!! Profile Details Not Updated", Toast.LENGTH_LONG).show();
            }
        });

    }

    //Method For DELETE User Profile From Database
    public void deleteData(){
        deleteAccountBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deleteDataRows = AllUsersDB.deleteData(editUsername.getText().toString());

                //Check Delete or Not Task Data in Database
                if(deleteDataRows>0){
                    Toast.makeText(EditProfile_Activity.this, "Success!! Your Profile Was Deleted", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), Login_Activity.class);
                    startActivity(intent);

                }else{
                    Toast.makeText(EditProfile_Activity.this, "Error!! Your Profile Not Deleted", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
