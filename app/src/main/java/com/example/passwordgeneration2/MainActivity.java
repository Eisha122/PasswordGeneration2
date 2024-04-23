package com.example.passwordgeneration2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button passwordButton = findViewById(R.id.passwordButton);
        Button getPasswordButton = findViewById(R.id.getPasswordButton);
        Button databaseButton = findViewById(R.id.databaseButton);
        Button exitButton = findViewById(R.id.exitButton); // Added code to find Exit button

        passwordButton.setText("Generate Password");

        passwordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Generate a random password
                String password = generateRandomPassword(10); // Change 10 to desired length

                // Start MainActivity2 and pass the generated password
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("PASSWORD_EXTRA", password);
                startActivity(intent);
            }
        });

        // Add click listener for GetPassword button
        getPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start MainActivity3
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent);
            }
        });

        // Add click listener for Database button
        databaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start MainActivity4
                Intent intent = new Intent(MainActivity.this, MainActivity4.class);
                startActivity(intent);
            }
        });

        // Add click listener for Exit button
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Exit the app
                finish();
            }
        });
    }

    // Method to generate a random password
    private String generateRandomPassword(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = (int) (Math.random() * characters.length());
            password.append(characters.charAt(randomIndex));
        }

        return password.toString();
    }
}
