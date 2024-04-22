package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText username, password;
    Button signin, signup;
    DataBaseHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.editTextText2);
        password = findViewById(R.id.editTextTextPassword);
        signin = findViewById(R.id.button6);
        signup = findViewById(R.id.button4);
        DB = new DataBaseHelper(this);

        signin.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) {
            String user = username.getText().toString();
            String pass = password.getText().toString();
            if(user.equals("")||pass.equals(""))
                Toast.makeText(Login.this, "Please fill all the required fields", Toast.LENGTH_SHORT).show();
            else{
                Boolean check = DB.checkUsernamePassword(user, pass);
                if (check){
                    Toast.makeText(Login.this, "successful login in ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),categorieshomepage.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Login.this, "Wrong username or password", Toast.LENGTH_SHORT).show(); }
            } }
        });

        signup.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), Signup.class);
            startActivity(intent);
        } });


    }
}