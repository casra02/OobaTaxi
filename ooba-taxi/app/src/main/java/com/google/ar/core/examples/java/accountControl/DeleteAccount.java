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

public class DeleteAccount extends AppCompatActivity {

    private Button delete;
    private Button cancel;
    private EditText deleteEmail;
    private EditText deletePassword;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_page);

        cancel = findViewById(R.id.cancelDelete);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DeleteAccount.this, AccountOptions.class);
                DeleteAccount.this.startActivity(intent);
            }
        });

        delete = findViewById(R.id.finalDelete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AccountDB.loggedIn = false;
                deleteEmail = (EditText) findViewById(R.id.deleteEmailAddress);
                deletePassword = (EditText) findViewById(R.id.deletePassword);
                boolean deleteSuccess = AccountDB.deleteAccount(deleteEmail.getText().toString(),deletePassword.getText().toString());
                if(deleteSuccess){
                    Intent intent = new Intent(DeleteAccount.this, MainActivity.class);
                    DeleteAccount.this.startActivity(intent);
                }
                else {
                    Toast.makeText(DeleteAccount.this, "Inputted login information is incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
