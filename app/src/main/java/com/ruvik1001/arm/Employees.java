package com.ruvik1001.arm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ruvik1001.arm.menu.MenuCreator;

import java.util.Arrays;
import java.util.Random;

public class Employees extends AppCompatActivity {
    private final static String[] employeeNames = {
            "Иванов Иван Иванович",
            "Петров Петр Петрович",
            "Сидорова Анна Игоревна",
            "Смирнова Елена Александровна",
            "Кузнецов Алексей Владимирович",
            "Васильева Ольга Николаевна",
            "Попов Дмитрий Сергеевич",
            "Алексеева Екатерина Алексеевна",
            "Александров Андрей Викторович",
            "Лебедева Мария Ивановна",
            "Соколов Сергей Александрович",
            "Козлова Наталья Викторовна",
            "Ильин Илья Михайлович",
            "Ушакова Анастасия Андреевна",
            "Егоров Егор Егорович",
            "Ковалева Юлия Сергеевна",
            "Федоров Федор Федорович",
            "Морозова Алена Павловна",
            "Петухов Павел Владимирович",
            "Никитина Елена Ивановна",
            "Андреев Андрей Андреевич",
            "Лазарева Дарья Александровна",
            "Громов Иван Федорович",
            "Волкова Анастасия Петровна",
            "Кузьмина Марина Викторовна",
            "Орлов Олег Владимирович",
            "Макарова Виктория Сергеевна",
            "Миронов Александр Александрович",
            "Фролова Елизавета Дмитриевна",
            "Семенов Семен Семенович",
            "Жукова Алла Алексеевна",
            "Калинин Кирилл Александрович",
            "Сорокина Ирина Васильевна",
            "Тимофеев Михаил Павлович",
            "Григорьева Валерия Игоревна",
            "Архипов Артем Олегович",
            "Герасимова Татьяна Сергеевна",
            "Белов Владислав Михайлович",
            "Крылова Алиса Владимировна",
            "Куликов Денис Андреевич",
            "Максимова Екатерина Павловна",
            "Сидоров Сергей Васильевич",
            "Осипова Анастасия Дмитриевна",
            "Кузьмин Константин Сергеевич",
            "Ефимова Ольга Викторовна",
            "Медведев Даниил Андреевич",
            "Антонова Валентина Николаевна",
            "Щербаков Анатолий Васильевич",
            "Шилова Евгения Сергеевна",
            "Романов Роман Владимирович",
            "Рыбакова Людмила Алексеевна"
    };

    private static final String[] departments = {
            "Отдел разработки",
            "Отдел маркетинга",
            "Отдел продаж",
            "Отдел финансов",
            "Отдел кадров",
            "Отдел логистики",
            "Отдел качества",
            "Отдел снабжения",
            "Отдел исследований и разработок",
            "Отдел клиентского обслуживания",
            "Отдел информационной безопасности",
            "Отдел производства",
            "Отдел закупок",
            "Отдел PR и связей с общественностью",
            "Отдел аналитики",
    };

    private static final String[] positions = {
            "Разработчик плат",
            "Менеджер по продажам",
            "Инженер-программист",
            "Финансовый аналитик",
            "HR-специалист",
            "Логист",
            "Контролер качества",
            "Снабженец",
            "Исследователь",
            "Специалист по клиентскому обслуживанию",
            "Специалист по информационной безопасности",
            "Начальник производства",
            "Закупщик",
            "PR-менеджер",
            "Аналитик данных",
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employees);
        LinearLayout content = (LinearLayout) findViewById(R.id.content_empl);

        for (int i = 0, j = 0, k = 0; i < employeeNames.length; i++) {
            if (i % 3 == 0) {
                j++;
                k++;
            }

            j %= 15;
            k %= 15;

            int dob = i + j + k + 111;
            String serial;

            String employee = employeeNames[i];
            String space = departments[j];
            String role = positions[k];

            serial = Integer.toString(dob) + '-' + space.charAt(space.indexOf(' ') + 1) +
                    Integer.toString(dob + (int) Math.pow(i + 4, j) % 900) + '/';

            for (int m = 0; m < 11; m++) {
                serial += (String) Integer.toString((int) Math.abs(Math.random() * 10));
            }

            LinearLayout inner = new LinearLayout(Employees.this);
            TextView FCs, dep, pos;

            FCs = new TextView(Employees.this);
            dep = new TextView(Employees.this);
            pos = new TextView(Employees.this);

            FCs.setText(((String)"ФИО: " + (String) employee));
            dep.setText(((String)"Отдел: " + (String) space));
            pos.setText(((String)"Роль: " + (String) role));

            FCs.setTextSize(16);
            dep.setTextSize(16);
            pos.setTextSize(16);

            FCs.setTextColor(getResources().getColor(R.color.black));
            dep.setTextColor(getResources().getColor(R.color.black));
            pos.setTextColor(getResources().getColor(R.color.black));


            inner.setOrientation(LinearLayout.VERTICAL);
            inner.addView(dep);
            inner.addView(pos);
            inner.addView(FCs);

            inner.setBackgroundColor(getResources().getColor(R.color.btn));

            String finalSerial = serial;
            inner.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Employees.this, EmployeeCard.class);
                    intent.putExtra("role", pos.getText().toString());
                    intent.putExtra("dep", dep.getText().toString());
                    intent.putExtra("number", "Серийный номер: " + finalSerial);
                    intent.putExtra("fio", FCs.getText().toString());
                    intent.putExtra("phone", "Номер: +7(499)000-00-00 (внут. " + ((String) Integer.toString(dob)) + ")");
                    intent.putExtra("mail", "Почта: " + ((String) Integer.toString(dob)) + "work@asdsa.edu.work");
                    intent.putExtra("level", "Уровень доступа: " + (String) Integer.toString(4));
                    startActivity(intent);
                }
            });

            content.addView(inner);
        }

        MenuCreator.make(this, (View) findViewById(R.id.root_layout));
    }
}