package com.ruvik1001.arm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ruvik1001.arm.menu.MenuCreator;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        ((TextView) findViewById(R.id.text_about)).setText(getResources().getText(R.string.about_app).toString());
        MenuCreator.make(this, (View) findViewById(R.id.root_layout));
    }
}