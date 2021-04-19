package com.example.sharedprefrencesassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void Login(View view)
    {
        EditText Email = findViewById(R.id.ED03);
        EditText Password = findViewById(R.id.ED04);

        String EmailString = Email.getText().toString();
        String PasswordString = Password.getText().toString();

        SharedPreferences sp = getSharedPreferences("criedntial", MODE_PRIVATE);


        String EmailStored = sp.getString("email","Not Found");
        String PasswordStored = sp.getString("Password","Not Found");

        if(EmailStored.equals(EmailString) && PasswordStored.equals(PasswordString))
        {
            Toast.makeText(this,"Login successful", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"Wromg information stored",Toast.LENGTH_SHORT).show();
        }
    }
}