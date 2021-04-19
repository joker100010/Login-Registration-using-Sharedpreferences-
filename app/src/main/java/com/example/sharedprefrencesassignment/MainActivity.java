package com.example.sharedprefrencesassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Registration(View view)
    {
        EditText Name = findViewById(R.id.ED1);
        EditText Email = findViewById(R.id.ED2);
        EditText Password = findViewById(R.id.Pass);

        String Namestring = Name.getText().toString();
        String Emailstring = Email.getText().toString();
        String Passwordstring = Password.getText().toString();

        if(Namestring.equals("") || Emailstring.equals("") || Passwordstring.equals(""))
        {
            Toast.makeText(this, "PLease fill the all fields", Toast.LENGTH_SHORT).show();
        }
        else
        {
            SharedPreferences sp = getSharedPreferences("criedntial", MODE_PRIVATE);
            SharedPreferences.Editor Speditor = sp.edit();

            Speditor.putString("name", Namestring);
            Speditor.putString("email", Emailstring);
            Speditor.putString("Password", Passwordstring);

            boolean check = false;
            check = Speditor.commit();

            if(check)
            {
                Toast.makeText(this,"Register successfull",Toast.LENGTH_SHORT).show();
                Intent in = new Intent(this, MainActivity2.class);
                startActivity(in);
            }
        }

    }
}