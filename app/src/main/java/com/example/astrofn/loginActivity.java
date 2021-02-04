package com.example.astrofn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.astro.MainActivity;
import com.example.astro.R;

public class loginActivity extends AppCompatActivity {
  EditText Username,Password;
  TextView Cliquezici;
  Button signin;
  DataB DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Username= (EditText)findViewById(R.id.username1);
        Password=(EditText)findViewById(R.id.password1);
        signin=(Button)findViewById(R.id.Signin1);
        Cliquezici=findViewById(R.id.Cliquezici);


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = Username.getText().toString();
                String pass = Password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(loginActivity.this, "Remplissez Tous les champs ! ", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass =  DB.checkpassword(user, pass);
                    if(checkuserpass==true){
                        Toast.makeText(loginActivity.this, "Succes", Toast.LENGTH_SHORT).show();
                        Intent intent  = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(loginActivity.this, "L'utilisateur n'existe pas ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        Cliquezici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUp.class);
                startActivity(intent );

            }
        });
    }
}