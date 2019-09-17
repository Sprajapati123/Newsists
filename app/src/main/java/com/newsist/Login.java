package com.newsist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.newsist.Utils.BottomNavigationViewHelper;

public class Login extends AppCompatActivity {
    private EditText login_email, login_password;
    private Button btn_login;
    private TextView link_signup;

    private FirebaseAuth firebaseAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_email = findViewById(R.id.login_email);
        login_password = findViewById(R.id.login_password);
        btn_login = findViewById(R.id.btn_login);
        link_signup = findViewById(R.id.link_signup);
        progressBar = findViewById(R.id.progressBar);

        //get firebase authinstance
        firebaseAuth = FirebaseAuth.getInstance();

        link_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
                return;
            }


        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = login_email.getText().toString();
                final String password = login_password.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    login_email.setError("Enter email address");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    login_password.setError("Enter password");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                //authenticate user
                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
//                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(), "Login successful!", Toast.LENGTH_LONG).show();
                                    progressBar.setVisibility(View.GONE);

                                    Intent intent = new Intent(Login.this, HomeActivity.class);
                                    startActivity(intent);
                                    finish();

                                }
                                else {
                                    Toast.makeText(getApplicationContext(), "Login failed! Please try again", Toast.LENGTH_LONG).show();
                                    progressBar.setVisibility(View.GONE);
                                }
                            }
                        });
            }
        });


    }
}