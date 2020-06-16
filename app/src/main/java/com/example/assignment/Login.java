package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class Login extends AppCompatActivity {

    EditText edEmail, edPassword;
    TextView Sign;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edEmail = findViewById(R.id.email);
        Sign = findViewById(R.id.signup_screen);
        edPassword = findViewById(R.id.password);
        login = findViewById(R.id.Go);

        Sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();

            }
        });
    }

        public void login(){
        if(TextUtils.isEmpty((edEmail.getText()))){
            edEmail.setError("Email is required!");
        }else if (TextUtils.isEmpty((edPassword.getText()))){
                edPassword.setError("Email is required!");
        }else {
            ParseUser.logInInBackground(edEmail.getText().toString(), edPassword.getText().toString(), new LogInCallback() {
                @Override
                public void done(ParseUser parseUser, ParseException e) {
                    if (parseUser != null) {
                        Toast.makeText(Login.this, "Welcome back!", Toast.LENGTH_SHORT).show();
                    } else {
                        ParseUser.logOut();
                        Toast.makeText(Login.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });

        }
            if(ParseUser.getCurrentUser()!=null) {
                Intent intent = new Intent(Login.this, Home.class);
                startActivity(intent);
                finish();
            }

    }

    public void signup(View view){

    }


}
