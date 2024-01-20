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

public class EditAccount extends AppCompatActivity {

    private Button cancel;
    private Button saveChanges;
    private EditText newEmail;
    private EditText newPassword;

    private EditText currentEmail;
    private EditText currentPassword;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_page);

        cancel = findViewById(R.id.cancelButton);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditAccount.this, AccountOptions.class);
                EditAccount.this.startActivity(intent);
            }
        });

        saveChanges = findViewById(R.id.saveChangesButton);
        saveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newEmail = (EditText) findViewById(R.id.editEmailAddress);
                newPassword = (EditText) findViewById(R.id.editPassword);
                currentEmail = (EditText) findViewById(R.id.currentEmailAddress);
                currentPassword = (EditText) findViewById(R.id.currentPassword);
                boolean editSuccess = AccountDB.editAccount(currentEmail.getText().toString(),currentPassword.getText().toString(),newEmail.getText().toString(),newPassword.getText().toString());
                if(editSuccess){
                    Intent intent = new Intent(EditAccount.this, AccountOptions.class);
                    EditAccount.this.startActivity(intent);
                }
                else {
                    Toast.makeText(EditAccount.this, "Inputted login information is incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
