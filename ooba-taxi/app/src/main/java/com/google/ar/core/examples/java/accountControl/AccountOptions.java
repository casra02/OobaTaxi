package com.google.ar.core.examples.java.accountControl;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.ar.core.examples.java.MainActivity;
import com.google.ar.core.examples.java.dbManagement.AccountDB;
import com.google.ar.core.examples.java.helloar.R;
import com.google.ar.core.examples.java.requestRide.RequestRideActivity;

public class AccountOptions extends AppCompatActivity {

    private Button editAccountButton;
    private Button logoutButton;
    private Button deleteAccountButton;
    private ImageButton exitAccountOptions;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_options);

        exitAccountOptions = findViewById(R.id.account_options_exit);
        exitAccountOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountOptions.this, MainActivity.class);
                AccountOptions.this.startActivity(intent);
            }
        });

        logoutButton = findViewById(R.id.logout_button);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AccountDB.loggedIn = false;
                Intent intent = new Intent(AccountOptions.this, MainActivity.class);
                AccountOptions.this.startActivity(intent);
            }
        });

        // add edit account page
        editAccountButton = findViewById(R.id.edit_account);
        editAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountOptions.this, EditAccount.class);
                AccountOptions.this.startActivity(intent);
            }
        });

        // add delete account page with functionality
        deleteAccountButton = findViewById(R.id.delete_account);
        deleteAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountOptions.this, DeleteAccount.class);
                AccountOptions.this.startActivity(intent);
            }
        });

    }
}
