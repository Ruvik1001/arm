package com.ruvik1001.arm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class EmployeeCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_card);

        ((TextView) findViewById(R.id.name)).setText(getIntent().getStringExtra("role"));
        ((TextView) findViewById(R.id.role)).setText(getIntent().getStringExtra("dep"));
        ((TextView) findViewById(R.id.number)).setText(getIntent().getStringExtra("number"));
        ((TextView) findViewById(R.id.fio)).setText(getIntent().getStringExtra("fio"));
        ((TextView) findViewById(R.id.phone)).setText(getIntent().getStringExtra("phone"));
        ((TextView) findViewById(R.id.mail)).setText(getIntent().getStringExtra("mail"));
        ((TextView) findViewById(R.id.level)).setText(getIntent().getStringExtra("level"));
    }
}