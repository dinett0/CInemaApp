package com.example.term_project;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Button button1, button2;
    private EditText field1, field2;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button_login);
        button2 = findViewById(R.id.button_signup);
        field1 = findViewById(R.id.editTextTextEmailAddress);
        field2 = findViewById(R.id.editTextTextPassword);
    }

    public void onClickSignUp(View v) {
        Intent intent = new Intent(this, SignUpActivity.class);
        SignUpActivity.launch(intent);
    }

    ActivityResultLauncher<Intent> SignUpActivity = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        field1.setText(data.getStringExtra("email"));
                        field2.setText(data.getStringExtra("password"));
                        name = data.getStringExtra("name");
                    }
                }
            });

}