package com.ruvik1001.arm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ruvik1001.arm.login.LoginHandler;
import com.ruvik1001.arm.menu.MenuCreator;

public class Chat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        ((ImageButton) findViewById(R.id.btn_send)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText msg = (EditText) findViewById(R.id.edit_msg);
                String text = msg.getText().toString();
                if (text.length() == 0)
                    return;
                msg.setText("");
                TextView info = new TextView(Chat.this);
                info.setText((String)("@" + LoginHandler.name + ": " + text));
                ((LinearLayout) findViewById(R.id.msg_liner)).addView(
                        info
                );
            }
        });

        MenuCreator.make(this, findViewById(R.id.root_layout));
    }
}