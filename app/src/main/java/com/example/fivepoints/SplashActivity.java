package com.example.fivepoints;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashActivity extends AppCompatActivity {

    private CardView cardCitizen;
    private CardView cardEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.splash), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initializeViews();
        setupClickListeners();
    }

    private void initializeViews() {
        cardCitizen = findViewById(R.id.cardCitizen);
        cardEmployee = findViewById(R.id.cardEmployee);
    }

    private void setupClickListeners() {
        cardCitizen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // الانتقال إلى صفحة المواطن
                Intent citizenIntent = new Intent(SplashActivity.this, CitizenActivity.class);
                startActivity(citizenIntent);
            }
        });

        cardEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // الانتقال إلى صفحة موظف البلدية
                Intent employeeIntent = new Intent(SplashActivity.this, EmployeeActivity.class);
                startActivity(employeeIntent);
            }
        });
    }
}
