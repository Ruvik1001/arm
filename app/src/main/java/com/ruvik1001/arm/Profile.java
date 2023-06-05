package com.ruvik1001.arm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ruvik1001.arm.login.LoginHandler;
import com.ruvik1001.arm.menu.MenuCreator;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        String fio = "Undefined";
        if (LoginHandler.name.equals("Viktor"))
            fio = "ИКБО-06-21 Руднев В.В.";
        if (LoginHandler.name.equals("Gerard"))
            fio = "ИКБО-33-21 Маслов Г.А.";
        if (LoginHandler.name.equals("Vlad"))
            fio = "ИКБО-33-21 Усов В.Д.";

        ((TextView) findViewById(R.id.name)).setText(LoginHandler.name);
        ((TextView) findViewById(R.id.role)).setText("Role: Admin");
        ((TextView) findViewById(R.id.number)).setText("Serial number: 001-A777/96742254931");
        ((TextView) findViewById(R.id.fio)).setText("FCs: " + fio);
        ((TextView) findViewById(R.id.phone)).setText("Phone number: +1(111)111-11-11");
        ((TextView) findViewById(R.id.mail)).setText("Email: test@mail.com");
        ((TextView) findViewById(R.id.level)).setText("Level access: 9");

        MenuCreator.make(this, (View) findViewById(R.id.root_layout));
    }
}