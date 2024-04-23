package com.example.passwordgeneration2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity {

    TextView tvEncryptedPassword;
    EditText etEmail, etRefName;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        // Initialize views
        tvEncryptedPassword = findViewById(R.id.tvEncryptedPassword);
        etEmail = findViewById(R.id.etEmail);
        etRefName = findViewById(R.id.etRefName);
        btnSave = findViewById(R.id.btnSave);

        // Retrieve encrypted password from MainActivity2
        String encryptedPassword = getIntent().getStringExtra("ENCRYPTED_PASSWORD_EXTRA");
        tvEncryptedPassword.setText("Encrypted Password: " + encryptedPassword);

        // Set click listener for the "Save" button
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get email and reference name entered by the user
                String email = etEmail.getText().toString();
                String refName = etRefName.getText().toString();

                // Save the password (or perform any other action)

                // Open MainActivity6
                Intent intent = new Intent(MainActivity5.this, MainActivity6.class);
                startActivity(intent);
            }
        });
    }
}
