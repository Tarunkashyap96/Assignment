package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUp extends AppCompatActivity {

    EditText edName, edEmail, edPassword, edConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edName = findViewById(R.id.edName);
        edEmail = findViewById(R.id.edEmail);
        edPassword = findViewById(R.id.edPassword);
        edConfirmPassword = findViewById(R.id.edConfirmPassword);
    }

    public void signup(View view) {
        Toast.makeText(this, "please wait few second", Toast.LENGTH_SHORT).show();
        if (TextUtils.isEmpty((edName.getText()))) {
            edName.setError("Name is required!");
        } else if (TextUtils.isEmpty((edEmail.getText()))) {
            edEmail.setError("Email is required!");
        } else if (TextUtils.isEmpty((edPassword.getText()))) {
            edPassword.setError("password is required!");
        } else if (TextUtils.isEmpty((edConfirmPassword.getText()))) {
            edConfirmPassword.setError("Confirm password is required!");
        } else if (!edPassword.getText().toString().equals(edConfirmPassword.getText().toString())){
            Toast.makeText(this, "Password is not match", Toast.LENGTH_SHORT).show();}
        else{
            ParseUser user = new ParseUser();
// Set the user's username and password, which can be obtained by a forms
            user.setUsername(edEmail.getText().toString());
            user.setPassword(edPassword.getText().toString());
            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        Toast.makeText(SignUp.this, "Account create successful!", Toast.LENGTH_SHORT).show();
                    } else {
                        ParseUser.logOut();
                        Toast.makeText(SignUp.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
     }
  }
}
