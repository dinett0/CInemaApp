package com.example.term_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {

    private Button signUp;
    private EditText fieldName, fieldEmail, fieldPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signUp = findViewById(R.id.buttonSignUp);
        fieldName = findViewById(R.id.editTextName);
        fieldEmail = findViewById(R.id.editTextEmail);
        fieldPassword = findViewById(R.id.editTextPassword);
    }
    public void onBack(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void onSignUp(View view) {
        Intent intent = new Intent();
        intent.putExtra("name", fieldName.getText().toString())
                .putExtra("email", fieldEmail.getText().toString())
                .putExtra("password", fieldPassword.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}