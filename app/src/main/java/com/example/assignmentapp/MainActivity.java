package com.example.assignmentapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText etCustomerName, etEmail, etPhoneNumber, etAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCustomerName = findViewById(R.id.etCustomerName);
        etEmail = findViewById(R.id.etEmail);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        etAddress = findViewById(R.id.etAddress);
    }

    public void submitForm(View view) {
        String customerName = etCustomerName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String phoneNumber = etPhoneNumber.getText().toString().trim();
        String address = etAddress.getText().toString().trim();

        if (validateCustomerName(customerName) && validateEmail(email) && validatePhoneNumber(phoneNumber)) {
            Toast.makeText(this, "Form Submitted Successfully!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Please check your inputs.", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validateCustomerName(String customerName) {
        String namePattern = "^[a-zA-Z\\s]+$";

        if (TextUtils.isEmpty(customerName)) {
            etCustomerName.setError("Customer name is required");
            return false;
        } else if (!Pattern.matches(namePattern, customerName)) {
            etCustomerName.setError("Only letters and spaces are allowed");
            return false;
        }
        return true;
    }

    private boolean validateEmail(String email) {
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        if (TextUtils.isEmpty(email)) {
            etEmail.setError("Email is required");
            return false;
        } else if (!Pattern.matches(emailPattern, email)) {
            etEmail.setError("Invalid email format");
            return false;
        }
        return true;
    }

    private boolean validatePhoneNumber(String phoneNumber) {
        String phonePattern = "^[0-9]{10}$";

        if (TextUtils.isEmpty(phoneNumber)) {
            etPhoneNumber.setError("Phone number is required");
            return false;
        } else if (!Pattern.matches(phonePattern, phoneNumber)) {
            etPhoneNumber.setError("Phone number must be 10 digits");
            return false;
        }
        return true;
    }
}
