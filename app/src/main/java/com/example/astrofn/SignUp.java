package com.example.astrofn;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.astro.R;

public class SignUp extends AppCompatActivity {
EditText Username,Password,nom,prenom,age ;
Button Signup;
DataB DB;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Username = (EditText) findViewById(R.id.username);
        Password = (EditText) findViewById(R.id.password);
        nom = (EditText) findViewById(R.id.Nom);
        Signup = (Button) findViewById(R.id.signup);
        prenom=findViewById(R.id.prenom);
        age=findViewById(R.id.Age);
        DB = new DataB(this);

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Prenom = prenom.getText().toString();
                String Nom = nom.getText().toString();
                String user = Username.getText().toString();
                String pass = Password.getText().toString();
                String Age = age.getText().toString();

                if (user.equals("") | pass.equals("") | Age.equals("") | Prenom.equals("") | Nom.equals(""))
                    Toast.makeText(SignUp.this, "Remplissez tous les champs ! ", Toast.LENGTH_SHORT).show();
                    if(Age.matches("^[a-zA-Z]+$")) {
                        Toast.makeText(SignUp.this, "Entrez un nombre dans la case age", Toast.LENGTH_SHORT).show();
                    }


                else {

                    Boolean checkuser = DB.checkusername(user);
                    if (checkuser == false) {
                        Boolean insert = DB.insertdata(user, pass);
                        if (insert == true) {
                            Toast.makeText(SignUp.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), listePlanet.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(SignUp.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(SignUp.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });


    }
}






