package com.example.astrofn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.astro.R;

public class SignUp extends AppCompatActivity {
EditText Username,Password,Email ;
Button Signin ,Signup;
DataB DB;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Username = (EditText) findViewById(R.id.username);
        Password = (EditText) findViewById(R.id.password);
        Email = (EditText) findViewById(R.id.email);
        Signin = (Button) findViewById(R.id.signin);
        Signup = (Button) findViewById(R.id.signup);
        DB = new DataB(this);

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user =Username.getText().toString();
                String pass =Password.getText().toString();

                if(user.equals("")|pass.equals(""));

                    Toast.makeText(SignUp.this, "Remplissez tous les champs ! ", Toast.LENGTH_SHORT).show();
                    Boolean checkuser = DB.checkusername(user);

                    if (checkuser == false) {
                        Boolean insert = DB.insertdata(user, pass);
                        if (insert == true) {
                            Toast.makeText(SignUp.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(SignUp.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(SignUp.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                    }

                }

        });









    }
}