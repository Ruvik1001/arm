package com.ruvik1001.arm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.ruvik1001.arm.login.LoginHandler;

import java.io.File;


public class Task extends AppCompatActivity {
    TextView task_title, date, worker, description;
    EditText msg;
    ImageButton btn_send;
    Spinner spin;

    String status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        task_title = (TextView) findViewById(R.id.task_title) ;
        date = (TextView) findViewById(R.id.date_to);
        spin = (Spinner) findViewById(R.id.spin);
        worker = (TextView) findViewById(R.id.worker);
        description = (TextView) findViewById(R.id.description);
        msg = (EditText) findViewById(R.id.edit_msg);
        btn_send = (ImageButton) findViewById(R.id.btn_send);

        String[] arr = getResources().getStringArray(R.array.status_spin);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arr);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);

        Intent extras = getIntent();
        task_title.setText(extras.getStringExtra("task"));
        worker.setText(extras.getStringExtra("to"));
        date.setText(extras.getStringExtra("date"));
        status = extras.getStringExtra("stat");
        description.setText(extras.getStringExtra("disc"));

        int i = 0;
        for (String elem : arr) {
            if (elem.equals(status)) {
                spin.setSelection(i);
                break;
            }
            i++;
        }

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = msg.getText().toString();
                if (text.length() == 0)
                    return;
                msg.setText("");
                TextView info = new TextView(Task.this);
                info.setText((String)("@" + LoginHandler.name + ": " + text));
                ((LinearLayout) findViewById(R.id.msg_liner)).addView(
                        info
                );
            }
        });

        LinearLayout spec = (LinearLayout) findViewById(R.id.spec);
        //get by DB
        for (i = 0; i < 20; i++) {
            ImageView img = new ImageView(Task.this);
            img.setImageResource(R.drawable.ic_doc);
            img.setClickable(true);
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Create doc
//                    Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
//                    intent.addCategory(Intent.CATEGORY_OPENABLE);
//                    intent.setType("application/docx");
//                    intent.putExtra(Intent.EXTRA_TITLE, "invoice.docx");
//                    intent.putExtra(DocumentsContract.EXTRA_INITIAL_URI, 1);
//                    startActivity(intent);

                    //Open doc
//                    Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
//                    intent.addCategory(Intent.CATEGORY_OPENABLE);
//                    intent.setType("application/doc");
//                    intent.putExtra(DocumentsContract.EXTRA_INITIAL_URI, 3);
//
//                    startActivity(intent);


                }
            });

            TextView text = new TextView(Task.this);
            text.setText("Name.docx");

            LinearLayout liner = new LinearLayout(Task.this);
            liner.setOrientation(LinearLayout.VERTICAL);
            liner.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            liner.addView(img);
            liner.addView(text);
            liner.setPadding(0,0,15,0);

            spec.addView(liner);
        }

    }
}