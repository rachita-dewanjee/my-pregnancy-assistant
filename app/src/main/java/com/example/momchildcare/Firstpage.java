package com.example.momchildcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
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
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Firstpage extends AppCompatActivity implements View.OnClickListener {
     EditText signInEmailEditText, signInPasswordEditText;
     TextView signUpTextView;
    Button signInButton;
     ProgressBar progressBar;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);
        this.setTitle("Sign in");
        mAuth = FirebaseAuth.getInstance();

        signInEmailEditText=findViewById(R.id.signInEmailEditTextId);
        signInPasswordEditText=findViewById(R.id.signInPasswordEditTextId);
        signInButton=findViewById(R.id.signInButtonId);
        signUpTextView=findViewById(R.id.signUpTextViewId);
        progressBar=findViewById(R.id.progressBarId);




        signUpTextView.setOnClickListener(this);
        signInButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signInButtonId:
                userLogin();
                break;


            case R.id.signUpTextViewId:
                Intent intent= new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(intent);

                break;
        }



    }

    private void userLogin() {
        String email=signInEmailEditText.getText().toString().trim();
        String password=signInPasswordEditText.getText().toString().trim();

        if(email . isEmpty()){
            signInEmailEditText.setError("enter an email address");
            signInEmailEditText.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            signInEmailEditText.setError("enter a valid email address");
            signInEmailEditText.requestFocus();
            return;
        }
        if(password.isEmpty()){
            signInPasswordEditText.setError("enter an password");
            signInPasswordEditText.requestFocus();
            return;
        }
        if(password.length()<6){
            signInPasswordEditText.setError("Minimum length of a password should be 6");
            signInPasswordEditText.requestFocus();
            return;


        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                progressBar.setVisibility(View.GONE);

                if(task.isSuccessful()){
                    finish();
                    Intent intent=new Intent(getApplicationContext(),front.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                }
                else{
                    Toast.makeText(getApplicationContext(),"Login unsuccesfull",Toast.LENGTH_SHORT).show();

                }


            }
        });



    }
}
