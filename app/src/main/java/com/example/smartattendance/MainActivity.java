package com.example.smartattendance;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseApp.initializeApp(this);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference("LoginInfo");

        EditText emailEditText = findViewById(R.id.email);
        EditText passwordEditText = findViewById(R.id.password);

        MaterialButton signupButton = findViewById(R.id.signupbutton);
        MaterialButton loginButton = findViewById(R.id.loginbutton);


        signupButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(MainActivity.this, "Enter both email and password", Toast.LENGTH_SHORT).show();
            } else {
                // Check if the email already exists in the database
                databaseReference.orderByChild("email").equalTo(email).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            // Email already exists, show error message
                            Toast.makeText(MainActivity.this, "Email already exists", Toast.LENGTH_SHORT).show();
                        } else {
                            // Email does not exist, proceed with signup
                            LoginInfo loginInfo = new LoginInfo(email, password);
                            databaseReference.push().setValue(loginInfo);
                            Toast.makeText(MainActivity.this, "Signup Successful", Toast.LENGTH_SHORT).show();
                            emailEditText.setText("");
                            passwordEditText.setText("");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(MainActivity.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


        loginButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    boolean found = false;
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        LoginInfo loginInfo = dataSnapshot.getValue(LoginInfo.class);
                        if (loginInfo != null && loginInfo.getEmail().equals(email) && loginInfo.getPassword().equals(password)) {
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        // Login successful, navigate to the new screen
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Wrong Email or Password", Toast.LENGTH_LONG).show();
                    }
                    emailEditText.setText("");
                    passwordEditText.setText("");
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(MainActivity.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });

    }
}
