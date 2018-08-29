package com.example.pc.loginapp.view.ui;

import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pc.loginapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private PendingIntent pendingIntent;
    //private ProgressBar progressBar;
    private Button btnSignup;
    private FirebaseAuth auth;
    private Button btnReset;
    private ProgressDialog pg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        auth=FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(MainActivity.this, SActivity.class));
            finish();
        }
        setContentView(R.layout.activity_main);
        context=MainActivity.this;


      pg= new ProgressDialog(context);
      pg.setProgressStyle(ProgressDialog.STYLE_SPINNER);
      pg.setMessage("Loading!Please Wait....");
      pg.setCancelable(false);
      pg.setIndeterminate(true);

         final EditText inputEmail = (EditText) findViewById(R.id.ett);
        final EditText inputPassword=(EditText) findViewById(R.id.et);

        Button button = (Button)findViewById(R.id.bx);
        btnSignup = (Button) findViewById(R.id.regi);
        //progressBar=(ProgressBar)findViewById(R.id.pbHeaderProgress);
        btnReset = (Button)findViewById(R.id.fp);

        auth = FirebaseAuth.getInstance();

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Signup.class));
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ResetPasswordActivity.class));
            }
        });
        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                String email = inputEmail.getText().toString();
                final String password = inputPassword.getText().toString();
                //progressBar.setVisibility(View.VISIBLE);
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{

               pg.show();
                //authenticate user
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {

                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {


                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                               // progressBar.setVisibility(View.GONE);
                                if (!task.isSuccessful()) {
                                    pg.dismiss();
                                    // there was an error
                                    if (password.length() < 6) {
                                        inputPassword.setError(getString(R.string.minimum_password));
                                    } else {
                                        Toast.makeText(MainActivity.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
                                    }
                                } else {

                                    Intent intent = new Intent(MainActivity.this, SActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });
            }}
        });
    }
}