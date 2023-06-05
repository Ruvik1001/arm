package com.ruvik1001.arm;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.ruvik1001.arm.menu.MenuCreator;

public class MenuSettings extends AppCompatActivity {
    private SwitchCompat  themeSwitch;
    private SwitchCompat fontSizeSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_settings);

        themeSwitch = findViewById(R.id.theme_switch);
        fontSizeSwitch = findViewById(R.id.font_size_switch);

        themeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MenuSettings.this, "Темная тема включена", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MenuSettings.this, "Светлая тема включена", Toast.LENGTH_SHORT).show();
                }
            }
        });

        fontSizeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Обработка выбора большого размера шрифта
                    Toast.makeText(MenuSettings.this, "Большой размер шрифта выбран", Toast.LENGTH_SHORT).show();
                    // Дополнительные действия при выборе большого размера шрифта
                } else {
                    // Обработка выбора обычного размера шрифта
                    Toast.makeText(MenuSettings.this, "Обычный размер шрифта выбран", Toast.LENGTH_SHORT).show();
                    // Дополнительные действия при выборе обычного размера шрифта
                }
            }
        });

        MenuCreator.make(this, (View) findViewById(R.id.root_layout));
    }
}
