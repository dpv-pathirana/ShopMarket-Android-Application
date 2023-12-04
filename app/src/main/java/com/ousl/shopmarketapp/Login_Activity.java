package com.ousl.shopmarketapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ousl.shopmarketapp.databinding.LoginActivityBinding;

public class Login_Activity extends AppCompatActivity implements View.OnClickListener {

    LoginActivityBinding binding;
    DatabaseHelper databaseHelper;

    TextView notYetRegButtonTXT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Hide Action Bar
        binding = LoginActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        // log in Validation from Database
        binding.LogInBTN2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.LoginUserName.getText().toString();
                String password = binding.loginPassword.getText().toString();

                if(email.equals("") || password.equals(""))
                    Toast.makeText(Login_Activity.this, "All fields are Mandatory", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkCredentials = databaseHelper.checkUsernamePassword(email, password);

                    if(checkCredentials == true){
                        Toast.makeText(Login_Activity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Dashboard_Activity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(Login_Activity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // For Navigation
        notYetRegButtonTXT = (TextView) findViewById(R.id.NotYetRegTXT);
        notYetRegButtonTXT.setOnClickListener(this);

    }

    // setOnClickListener Method
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.NotYetRegTXT:
                Intent intentNotYetRegTXT = new Intent(getApplicationContext(), SignUp_Activity.class);
                startActivity(intentNotYetRegTXT);
                break;

        }
    }
}
