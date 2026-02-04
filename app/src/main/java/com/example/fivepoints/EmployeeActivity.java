package com.example.fivepoints;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EmployeeActivity extends AppCompatActivity {

    private ImageView ivBack;
    private TextView tvPendingCount;
    private TextView tvInProgressCount;
    private RecyclerView rcReports;
    private Button btnRefresh;
    private Button btnGenerateReport;
    private Button btnViewAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_employee);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.employee), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initializeViews();
        setupClickListeners();
        setupRecyclerView();
        loadReportsData();
    }

    private void initializeViews() {
        ivBack = findViewById(R.id.ivBack);
        tvPendingCount = findViewById(R.id.tvPendingCount);
        tvInProgressCount = findViewById(R.id.tvInProgressCount);
        rcReports = findViewById(R.id.rcReports);
        btnRefresh = findViewById(R.id.btnRefresh);
        btnGenerateReport = findViewById(R.id.btnGenerateReport);
        btnViewAll = findViewById(R.id.btnViewAll);
    }

    private void setupClickListeners() {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // العودة إلى صفحة التوجيه
            }
        });

        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadReportsData();
                Toast.makeText(EmployeeActivity.this, "تم تحديث البيانات", Toast.LENGTH_SHORT).show();
            }
        });

        btnGenerateReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // إنشاء تقرير إحصائي
                Toast.makeText(EmployeeActivity.this, "جاري إنشاء التقرير", Toast.LENGTH_SHORT).show();
            }
        });

        btnViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // عرض جميع البلاغات
                Toast.makeText(EmployeeActivity.this, "عرض جميع البلاغات", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupRecyclerView() {
        rcReports.setLayoutManager(new LinearLayoutManager(this));
    }

    private void loadReportsData() {
        // هنا سيتم تحميل البيانات من قاعدة البيانات
        // حالياً نستخدم بيانات وهمية للعرض
        
        // تحديث الأرقام الإحصائية
        tvPendingCount.setText("12");
        tvInProgressCount.setText("8");
        
        // إنشاء قائمة وهمية من البلاغات
        ArrayList<Report> reports = new ArrayList<>();
        reports.add(new Report("بلاغ رقم 1", "أوساخ في الشارع", "قيد الانتظار", "2024/02/04"));
        reports.add(new Report("بلاغ رقم 2", "ضرر في الإضاءة", "قيد المعالجة", "2024/02/03"));
        reports.add(new Report("بلاغ رقم 3", "تسريب مياه", "قيد الانتظار", "2024/02/03"));
        reports.add(new Report("بلاغ رقم 4", "حفرة في الطريق", "قيد المعالجة", "2024/02/02"));
        
        // إعداد الـ Adapter
        ReportAdapter adapter = new ReportAdapter(reports);
        rcReports.setAdapter(adapter);
    }

    // كلاس داخلي لتمثيل البلاغ
    public static class Report {
        private String title;
        private String description;
        private String status;
        private String date;

        public Report(String title, String description, String status, String date) {
            this.title = title;
            this.description = description;
            this.status = status;
            this.date = date;
        }

        // Getters
        public String getTitle() { return title; }
        public String getDescription() { return description; }
        public String getStatus() { return status; }
        public String getDate() { return date; }
    }
}
