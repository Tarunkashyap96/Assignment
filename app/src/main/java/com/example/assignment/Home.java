package com.example.assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseUser;

public class Home extends AppCompatActivity {

    TextView tvName, tvEmail, sig;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sig = findViewById(R.id.signup_screen);
        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);

        sig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, SignUp.class);
                startActivity(intent);
            }
        });
    }

    public void logout(View view) {
        ProgressBar progressBar = new ProgressBar(this);
        progressBar.isShown();
        ParseUser.logOut();
        Intent intent = new Intent(Home.this, Login.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.dashboard) {

            Intent intent = new Intent(Home.this,Login.class);
            startActivity(intent);
            return true;
        }
        else{
            Toast.makeText(this, "Account is Logout", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Home.this,Login.class);
            startActivity(intent);
        }
        return true;
    }
}
