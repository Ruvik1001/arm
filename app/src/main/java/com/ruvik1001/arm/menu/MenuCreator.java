package com.ruvik1001.arm.menu;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.ruvik1001.arm.About;
import com.ruvik1001.arm.Chat;
import com.ruvik1001.arm.MainMenu;
import com.ruvik1001.arm.MenuSettings;
import com.ruvik1001.arm.Profile;
import com.ruvik1001.arm.R;

public class MenuCreator {
    public static void make(Context context, View root) {
        // Для меню
        ImageButton menu_btn = (ImageButton) root.findViewById(R.id.btn_menu);
        DrawerLayout drawerLayout = (DrawerLayout) root.findViewById(R.id.root_layout);

        DrawerLayout finalDrawerLayout = drawerLayout;
        menu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (finalDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                    finalDrawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    finalDrawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        drawerLayout = root.findViewById(R.id.root_layout);
        NavigationView navigationView;
        navigationView = root.findViewById(R.id.navigation_view);

        // Установка обработчика нажатия на пункты меню
        DrawerLayout finalDrawerLayout1 = drawerLayout;
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                // Обработка нажатия на пункт меню
                Intent intent = null;
                switch (menuItem.getItemId()) {
                    case R.id.menu_home:
                        // Действие при выборе пункта "Главная"
                        break;

                    case R.id.menu_tasks:
                        if (context.getClass().equals(MainMenu.class))
                            break;
                        intent = new Intent(context, MainMenu.class);
                        context.startActivity(intent);
                        break;

                    case R.id.menu_chat:
                        if (context.getClass().equals(Chat.class))
                            break;
                        intent = new Intent(context, Chat.class);
                        context.startActivity(intent);
                        break;

                    case R.id.menu_employees:
                        // Действие при выборе пункта "Сотрудники"
                        break;

                    case R.id.menu_profile:
                        if (context.getClass().equals(Profile.class))
                            break;
                        intent = new Intent(context, Profile.class);
                        context.startActivity(intent);
                        break;

                    case R.id.menu_settings:
                        if (context.getClass().equals(MenuSettings.class))
                            break;
                        intent = new Intent(context, MenuSettings.class);
                        context.startActivity(intent);
                        break;

                    case R.id.menu_about:
                        if (context.getClass().equals(About.class))
                            break;
                        intent = new Intent(context, About.class);
                        context.startActivity(intent);
                        break;

                }

                // Закрытие меню после выбора пункта
                finalDrawerLayout1.closeDrawer(GravityCompat.START);

                if (intent != null)
                    ((Activity) context).finish();
               return true;
            }
        });
    }
}
