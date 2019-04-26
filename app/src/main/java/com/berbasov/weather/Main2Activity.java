package com.berbasov.weather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.TEXT);
        TextView textView = findViewById(R.id.city);
        if(message.length()>0) {
            textView.setText(message);
        }
        else textView.setText("Ошибка");;
    }
}
