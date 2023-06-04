package com.ruvik1001.arm;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


import com.google.android.material.navigation.NavigationView;
import com.ruvik1001.arm.login.LoginHandler;
import com.ruvik1001.arm.menu.MenuCreator;

import java.util.Random;

public class MainMenu extends AppCompatActivity {
    TableLayout table;

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        table = (TableLayout) findViewById(R.id.task_table);
        for (int i = 0; i < 15; i++) {
            TableLayout data = new TableLayout(MainMenu.this);
            TextView task = new TextView(MainMenu.this);
            TextView to = new TextView(MainMenu.this);
            TextView date = new TextView(MainMenu.this);
            TextView stat = new TextView(MainMenu.this);
            TextView stat2 = new TextView(MainMenu.this);
            TextView disc = new TextView(MainMenu.this);

            int num = new Random(i).nextInt();
            task.setText((String) ("Задача #" + (String) Integer.toString(Math.abs(num))));

            to.setText((String)("Исполнитель: " + LoginHandler.name));

            //int num_date = Math.abs(new Random(i + 1987).nextInt() % 15) + 10;
            date.setText((String)("Исполнить до: " + (String) Integer.toString(10) + ".06.23"));

            stat.setText("Статус: ");
            stat2.setText("В работе");

            disc.setText("Описание: Пожалуйста, обработайте данный документ.");

            TableRow row1 = new TableRow(MainMenu.this);
            TableRow row2 = new TableRow(MainMenu.this);
            TableRow row3 = new TableRow(MainMenu.this);
            TableRow row4 = new TableRow(MainMenu.this);
            TableRow row5 = new TableRow(MainMenu.this);
            row5.setLayoutParams(new TableLayout.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));


            row1.addView(task);
            row2.addView(to);
            row3.addView(date);
            row4.addView(stat);
            row4.addView(stat2);
            row5.addView(disc);

            TableLayout table_in = new TableLayout(MainMenu.this);
            table_in.addView(row1);
            table_in.addView(row2);
            table_in.addView(row3);
            table_in.addView(row4);
            table_in.addView(row5);

            TableRow row = new TableRow(MainMenu.this);
            row.setLayoutParams(new TableLayout.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));
            row.addView(table_in);
            row.setBackgroundResource(R.color.tasks);
            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainMenu.this, Task.class);
                    intent.putExtra("task", task.getText());
                    intent.putExtra("to", to.getText());
                    intent.putExtra("date", date.getText());
                    intent.putExtra("stat", stat2.getText());
                    intent.putExtra("disc", disc.getText());
                    startActivity(intent);
                }
            });
            table.addView(row);


            MenuCreator.make(MainMenu.this, findViewById(R.id.root_layout));
        }
    }
}