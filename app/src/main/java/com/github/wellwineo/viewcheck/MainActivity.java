package com.github.wellwineo.viewcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView list;
    Button btn;
    String[] devices = {"Планшеты", "Телефоны", "Компьютеры", "Ноутбуки"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.listView);
        btn = findViewById(R.id.btn);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_multiple_choice,
                devices
        );
        list.setAdapter(adapter);

        btn.setOnClickListener(view -> {
            SparseBooleanArray checked = list.getCheckedItemPositions();
            String str = "";
            for (int i = 0; i < list.getAdapter().getCount(); i++) {
                if (checked.get(i))
                    str += " " + devices[i];
            }
            Toast.makeText(this, str, Toast.LENGTH_LONG).show();
        });

    }
}