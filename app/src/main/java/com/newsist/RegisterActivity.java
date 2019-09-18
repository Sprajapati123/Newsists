package com.newsist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.newsist.Home.HomeActivity;

import java.util.regex.Pattern;


public class RegisterActivity extends AppCompatActivity {

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +

                    "(?=.*[a-z])" +
                    "(?=.*[A-Z])" +
                    "(?=.*[@#$%+=])" +
                    ".{6,}" +
                    "$");

    private EditText reg_email, reg_password, reg_confirmpassword;
    private Button btn_register;
    private ProgressBar ProgressBar;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuth = FirebaseAuth.getInstance();

        btn_register = findViewById(R.id.btn_register);
        reg_email = findViewById(R.id.reg_email);
        reg_password = findViewById(R.id.reg_password);
        reg_confirmpassword=findViewById(R.id.regconfirm);
        ProgressBar = findViewById(R.id.progressBar);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = reg_email.getText().toString();
                final String password = reg_password.getText().toString();
                final String confirm = reg_confirmpassword.getText().toString();


                if (TextUtils.isEmpty(password)) {
                    reg_password.setError("Enter password");
                    return;
                }

                if ((!PASSWORD_PATTERN.matcher(password).matches())) {
                    Toast.makeText(RegisterActivity.this, "password must contain A-Z,a-z,0-9,@#$%+=]", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!confirm.equals(password)){
                    reg_confirmpassword.setError("password not matched");
                    return;
                }

                ProgressBar.setVisibility(View.VISIBLE);
                //create user
                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(RegisterActivity.this, "Registered Successfully:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                        ProgressBar.setVisibility(View.GONE);
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, "Registration Failed:" + task.getException(), Toast.LENGTH_SHORT).show();
                        } else {
                            startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
                            finish();
                        }
                    }
                });
            }

        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        ProgressBar.setVisibility(View.GONE);
    }

}
