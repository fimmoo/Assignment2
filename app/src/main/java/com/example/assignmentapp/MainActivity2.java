package com.example.assignmentapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    CheckBox potatoCheckBox, tomatoCheckBox, eggplantCheckBox, spinachCheckBox;
    Button incrementButton, decrementButton, orderButton;
    TextView quantityTextView, priceTextView, vegetableVarietiesTextView, ratingTextView;
    RatingBar ratingBar;
    int quantity = 0;
    int pricePerKg = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        potatoCheckBox = findViewById(R.id.potato);
        tomatoCheckBox = findViewById(R.id.tomato);
        eggplantCheckBox = findViewById(R.id.eggplant);
        spinachCheckBox = findViewById(R.id.spinach);

        quantityTextView = findViewById(R.id.quantityTextView);
        priceTextView = findViewById(R.id.priceTextView);
        vegetableVarietiesTextView = findViewById(R.id.vegetable_varieties);
        ratingTextView = findViewById(R.id.rating);
        ratingBar = findViewById(R.id.ratingBar);

        incrementButton = findViewById(R.id.increment);
        decrementButton = findViewById(R.id.decrement);
        orderButton = findViewById(R.id.order_btn);

        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity++;
                updateQuantityAndPrice();
            }
        });

        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity > 0) {
                    quantity--;
                    updateQuantityAndPrice();
                }
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingTextView.setText("Rating: " + rating);
            }
        });

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedVegetables = getSelectedVegetables();
                if (!selectedVegetables.isEmpty()) {
                    String orderSummary = "Vegetables: " + selectedVegetables + "\nQuantity: " + quantity + " kg\nTotal Price: BDT " + (quantity * pricePerKg);
                    Toast.makeText(MainActivity2.this, orderSummary, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity2.this, "Please select at least one vegetable!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void updateQuantityAndPrice() {
        quantityTextView.setText(String.valueOf(quantity));
        priceTextView.setText("BDT " + (quantity * pricePerKg));
    }

    private String getSelectedVegetables() {
        StringBuilder selectedVegetables = new StringBuilder();
        if (potatoCheckBox.isChecked()) {
            selectedVegetables.append("Potato ");
        }
        if (tomatoCheckBox.isChecked()) {
            selectedVegetables.append("Tomato ");
        }
        if (eggplantCheckBox.isChecked()) {
            selectedVegetables.append("Eggplant ");
        }
        if (spinachCheckBox.isChecked()) {
            selectedVegetables.append("Spinach ");
        }
        vegetableVarietiesTextView.setText(selectedVegetables.toString().trim().toUpperCase());
        return selectedVegetables.toString().trim();
    }
}
