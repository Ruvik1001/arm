package com.ruvik1001.arm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.ruvik1001.arm.menu.MenuCreator;

public class Employees extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employees);



        MenuCreator.make(this, (View) findViewById(R.id.root_layout));
    }
}