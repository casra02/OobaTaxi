package com.google.ar.core.examples.java.accountControl;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.ar.core.examples.java.MainActivity;
import com.google.ar.core.examples.java.dbManagement.AccountDB;
import com.google.ar.core.examples.java.helloar.R;

public class LoginPage extends AppCompatActivity {

    private EditText inputPassword;
    private EditText inputEmail;
    private Button loginButton;
    private Button createAccountButton;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        loginButton = findViewById(R.id.loginPageLogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                inputEmail = (EditText) findViewById(R.id.emailInput);
                inputPassword = (EditText) findViewById(R.id.passwordInput);

                if(!AccountDB.checkLogin(inputEmail.getText().toString(), inputPassword.getText().toString())){
                    Toast.makeText(LoginPage.this, "Incorrect login information", Toast.LENGTH_SHORT).show();
                }
                else {
                    AccountDB.loggedIn = true;
                    Intent intent = new Intent(LoginPage.this, MainActivity.class);
                    LoginPage.this.startActivity(intent);
                }
            }
        });

        createAccountButton = findViewById(R.id.createAccountButton);
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                inputEmail = (EditText) findViewById(R.id.emailInput);
                inputPassword = (EditText) findViewById(R.id.passwordInput);

                if(AccountDB.checkAccountExists(inputEmail.getText().toString())){
                    Toast.makeText(LoginPage.this, "Email already in use", Toast.LENGTH_SHORT).show();
                }
                else {
                    AccountDB.loggedIn = true;
                    AccountDB.addAccount(inputEmail.getText().toString(),inputPassword.getText().toString());
                    Intent intent = new Intent(LoginPage.this, MainActivity.class);
                    LoginPage.this.startActivity(intent);
                }
            }
        });

    }

}
