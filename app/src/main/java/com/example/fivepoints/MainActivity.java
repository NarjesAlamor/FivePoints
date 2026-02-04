package com.example.fivepoints;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // الانتقال مباشرة إلى صفحة التوجيه
        Intent splashIntent = new Intent(MainActivity.this, SplashActivity.class);
        startActivity(splashIntent);
        finish(); // إغلاق MainActivity حتى لا يعود المستخدم إليها
    }
}