package com.example.fivepoints;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CitizenActivity extends AppCompatActivity {

    private ImageView ivBack;
    private Spinner spinnerReportType;
    private EditText etLocation;
    private EditText etDescription;
    private Button btnAddPhoto;
    private Button btnSubmitReport;
    private Button btnMyReports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_citizen);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.citizen), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initializeViews();
        setupClickListeners();
    }

    private void initializeViews() {
        ivBack = findViewById(R.id.ivBack);
        spinnerReportType = findViewById(R.id.spinnerReportType);
        etLocation = findViewById(R.id.etLocation);
        etDescription = findViewById(R.id.etDescription);
        btnAddPhoto = findViewById(R.id.btnAddPhoto);
        btnSubmitReport = findViewById(R.id.btnSubmitReport);
        btnMyReports = findViewById(R.id.btnMyReports);
    }

    private void setupClickListeners() {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // العودة إلى صفحة التوجيه
            }
        });

        btnAddPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // هنا سيتم إضافة كود لالتقاط أو اختيار صورة
                Toast.makeText(CitizenActivity.this, "سيتم فتح الكاميرا قريباً", Toast.LENGTH_SHORT).show();
            }
        });

        btnSubmitReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitReport();
            }
        });

        btnMyReports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // الانتقال إلى صفحة البلاغات السابقة
                Toast.makeText(CitizenActivity.this, "بلاغاتي السابقة", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void submitReport() {
        String location = etLocation.getText().toString().trim();
        String description = etDescription.getText().toString().trim();
        String reportType = spinnerReportType.getSelectedItem().toString();

        // التحقق من الحقول
        if (location.isEmpty()) {
            etLocation.setError("الرجاء إدخال الموقع");
            etLocation.requestFocus();
            return;
        }

        if (description.isEmpty()) {
            etDescription.setError("الرجاء إدخال الوصف");
            etDescription.requestFocus();
            return;
        }

        // هنا سيتم إضافة كود إرسال البلاغ إلى قاعدة البيانات
        Toast.makeText(this, "تم إرسال البلاغ بنجاح", Toast.LENGTH_LONG).show();
        
        // مسح الحقول بعد الإرسال
        clearForm();
    }

    private void clearForm() {
        etLocation.setText("");
        etDescription.setText("");
        spinnerReportType.setSelection(0);
    }
}
