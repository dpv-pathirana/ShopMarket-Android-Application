package com.ousl.shopmarketapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ousl.shopmarketapp.databinding.SignupActivityBinding;

public class SignUp_Activity extends AppCompatActivity implements View.OnClickListener {

    private SignupActivityBinding binding;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = SignupActivityBinding.inflate(getLayoutInflater());
        getSupportActionBar().hide(); // Hide Action Bar
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        binding.SignUpBTN2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = binding.signupUserName.getText().toString().trim();
                String name = binding.signupName.getText().toString().trim();
                String email = binding.signupEmail.getText().toString().trim();
                String password = binding.signupPassword.getText().toString().trim();
                String confirmPassword = binding.signupConformPassword.getText().toString().trim();

                // Sign Up Validation
                if (username.isEmpty() || name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(SignUp_Activity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                } else if (!isValidEmail(email)) {
                    Toast.makeText(SignUp_Activity.this, "Invalid email format", Toast.LENGTH_SHORT).show();
                } else if (password.length() < 8) {
                    Toast.makeText(SignUp_Activity.this, "Password should be minimum 8 characters", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(confirmPassword)) {
                    Toast.makeText(SignUp_Activity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                } else {
                    boolean checkUsernameDB = databaseHelper.checkUsername(username);
                    if (!checkUsernameDB) {
                        boolean insert = databaseHelper.insertData(username, name, email, password);
                        if (insert) {
                            Toast.makeText(SignUp_Activity.this, "Signup Successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), Login_Activity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(SignUp_Activity.this, "Signup Failed", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(SignUp_Activity.this, "User already exists. Please log in", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        // Handle button clicks if needed
    }

    private boolean isValidEmail(CharSequence email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
