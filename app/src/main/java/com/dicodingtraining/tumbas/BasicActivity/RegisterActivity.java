package com.dicodingtraining.tumbas.BasicActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dicodingtraining.tumbas.Helper.SQLiteHelper;
import com.dicodingtraining.tumbas.Model.UserClass;
import com.dicodingtraining.tumbas.R;
import com.google.android.material.snackbar.Snackbar;

import java.awt.font.TextAttribute;

public class RegisterActivity extends AppCompatActivity {
    EditText editTextUserName;
    EditText editTextEmail;
    EditText editTextPassword;

    Button buttonRegister;

    SQLiteHelper SQLh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        SQLh = new SQLiteHelper(this);

        initTextViewLogin();
        initViews();

        EditText passwordhint = (EditText) findViewById(R.id.editTextPassword);
        passwordhint.setTransformationMethod(new PasswordTransformationMethod());

        buttonRegister = findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    String UserName = editTextUserName.getText().toString();
                    String Email = editTextEmail.getText().toString();
                    String Password = editTextPassword.getText().toString();

                    if (!SQLh.isEmailExists(Email)){
                        SQLh.addUser(new UserClass(null, UserName, Email, Password));
                        Snackbar.make(buttonRegister, "Register Successful! Please return to the Login Page.", Snackbar.LENGTH_LONG).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                finish();

                            }
                        },Snackbar.LENGTH_LONG);
                    }else {
                        Snackbar.make(buttonRegister, "User already exists with same email ", Snackbar.LENGTH_LONG).show();
                    }
                }

            }
        });

    }

    private void initTextViewLogin(){
        TextView textViewLogin = findViewById(R.id.textViewLogin);
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void initViews() {
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextUserName = findViewById(R.id.editTextUserName);
        buttonRegister = findViewById(R.id.buttonRegister);
    }

    public boolean validate() {
        boolean valid;
        valid = false;

        String UserName = editTextUserName.getText().toString();
        String Email = editTextEmail.getText().toString();
        String Password = editTextPassword.getText().toString();

        if (UserName.isEmpty()) {
            valid = false;
            editTextUserName.setError("Please enter valid username!");
        } else {
            if (UserName.length() > 5) {
                valid = true;
                editTextUserName.setError(null);
            } else {
                valid = false;
                editTextUserName.setError("Username is to short!");
            }
        }


        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            editTextEmail.setError("Please enter valid email!");
        } else {
            editTextEmail.setError(null);
        }


        if (Password.isEmpty()) {
            valid = false;
            editTextPassword.setError("Please enter valid password!");
        } else {
            if (Password.length() > 5) {
                valid = true;
                editTextPassword.setError(null);
            } else {
                valid = false;
                editTextPassword.setError("Password is to short!");
            }
        }

        return valid;

    }
}
