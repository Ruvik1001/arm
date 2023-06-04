package com.ruvik1001.arm;

import static com.ruvik1001.arm.login.LoginHandler.logIn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    TextView welcome;
    EditText login;
    EditText password;
    Button btn_in;
    TextView forgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcome = (TextView) findViewById(R.id.welcome_title);
        login = (EditText) findViewById(R.id.login);
        password = (EditText) findViewById(R.id.password);
        btn_in = (Button) findViewById(R.id.btn_enter);
        forgot = (TextView) findViewById(R.id.forgot_btn);

        welcome.setText("Добро полжаловать в АСДОД!\n Пожалуйста, водите.");

        btn_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (logIn(login.getText().toString(), password.getText().toString())) {
                    Intent intent = new Intent(MainActivity.this, MainMenu.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Snackbar.make((RelativeLayout)findViewById(R.id.main_layout), "Wrong username or password", Snackbar.LENGTH_LONG).show();
                }
            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com/viktor_rudnev"));
                startActivity(browserIntent);
            }
        });
    }
}