package com.ousl.shopmarketapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.Executor;

public class Welcome_Activity extends AppCompatActivity implements View.OnClickListener {

    // For Fingerprint Sensor
    BiometricPrompt biometricPrompt;
    BiometricPrompt.PromptInfo promptInfo;
    ConstraintLayout mMainLayout;

    private TextView LoginButtonTXT;
    private TextView SignupButtonTXT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Hide Action Bar
        setContentView(R.layout.welcome_activity);

        // Implement Fingerprint Sensor on Start up Welcome page
        mMainLayout=findViewById(R.id.main_layout);

        BiometricManager biometricManager=BiometricManager.from(this);

        // Check Fingerprint Sensor
        switch (biometricManager.canAuthenticate())
        {

            case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                Toast.makeText(getApplicationContext(),"Device Doesn't have fingerprint",Toast.LENGTH_SHORT);

            case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                Toast.makeText(getApplicationContext(),"Not Working",Toast.LENGTH_SHORT);

            case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                Toast.makeText(getApplicationContext(),"No Fingerprint Assigned",Toast.LENGTH_SHORT);
        }

        Executor executor= ContextCompat.getMainExecutor(this);


        // Check Fingerprint Sensor working or not and log in
        biometricPrompt=new BiometricPrompt(Welcome_Activity.this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(getApplicationContext(),"Log in Success",Toast.LENGTH_SHORT);
                mMainLayout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
            }
        });

        promptInfo=new BiometricPrompt.PromptInfo.Builder().setTitle("Shop Market")
                .setDescription("Use Fingerprint to Login To The App").setDeviceCredentialAllowed(true).build();

        biometricPrompt.authenticate(promptInfo);

        //Navigation Implementation
        LoginButtonTXT = (TextView) findViewById(R.id.LoginBTN);
        LoginButtonTXT.setOnClickListener(this);

        SignupButtonTXT = (TextView) findViewById(R.id.SignUpBTN);
        SignupButtonTXT.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.LoginBTN:
                Intent intentLogin = new Intent(getApplicationContext(), Login_Activity.class);
                startActivity(intentLogin);
                break;

            case R.id.SignUpBTN:
                Intent intentSignup = new Intent(getApplicationContext(), SignUp_Activity.class);
                startActivity(intentSignup);
                break;
        }
    }
}
