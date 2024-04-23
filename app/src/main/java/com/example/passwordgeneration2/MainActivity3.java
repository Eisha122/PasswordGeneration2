package com.example.passwordgeneration2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    EditText etEncryptedPassword;
    EditText etDecryptionKey;
    Button btnDecrypt;
    TextView tvOriginalPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // Initialize views
        etEncryptedPassword = findViewById(R.id.etEncryptedPassword);
        etDecryptionKey = findViewById(R.id.etDecryptionKey);
        btnDecrypt = findViewById(R.id.btnDecrypt);
        tvOriginalPassword = findViewById(R.id.tvOriginalPassword);

        // Set click listener for the "Decrypt" button
        btnDecrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the encrypted password and decryption key entered by the user
                String encryptedPassword = etEncryptedPassword.getText().toString();
                String decryptionKey = etDecryptionKey.getText().toString();

                // Perform decryption using the provided algorithm
                String originalPassword = decrypt(encryptedPassword, Integer.parseInt(decryptionKey));

                // Display the original password
                tvOriginalPassword.setText("Original Password: " + originalPassword);
            }
        });
    }

    // Decryption algorithm
    public String decrypt(String encryptedMessage, int shiftKey) {
        // Define the alphabet
        String alpha = "abcdefghijklmnopqrstuvwxyz";

        // Initialize original text
        StringBuilder originalText = new StringBuilder();

        // Decrypt each character in the message
        for (int i = 0; i < encryptedMessage.length(); i++) {
            char c = encryptedMessage.charAt(i);
            // Find the position of the character in the alphabet
            int charPosition = alpha.indexOf(c);
            // Apply the shift key and modulus to wrap around the alphabet
            int keyVal = (charPosition - shiftKey) % 26;
            if (keyVal < 0) {
                keyVal = alpha.length() + keyVal; // Handle negative values
            }
            // Replace the character with the decrypted character
            char replaceVal = alpha.charAt(keyVal);
            originalText.append(replaceVal);
        }

        // Return the original message
        return originalText.toString();
    }
}

