package com.berbasov.weather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        characteristic();
    }
    private void characteristic (){
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.TEXT);
        conditionsCharacteristic(message, intent);
    }
    private void conditionsCharacteristic(String message, Intent intent) {
        TextView textView = findViewById(R.id.city);
        if(message.length()>0) {
            textView.setText(message);
        }
        else textView.setText("Ошибка");
        conditionsWind(intent);
        conditionsDamp(intent);
        conditionsPressure(intent);
    }
    private void conditionsWind(Intent intent){
        int wind=intent.getIntExtra("WIND",0);
        if(wind>0) {
            TextView wind1 = findViewById(R.id.wind1);
            wind1.setText(" 5 м/с ");
        }
        else {
            TextView wind1 = findViewById(R.id.wind1);
            TextView windTitle = findViewById(R.id.windTitle);
            wind1.setText("");
            windTitle.setText("");
        }
    }
    private void conditionsDamp(Intent intent){
        int damp=intent.getIntExtra("DAMP",0);
        if(damp>0) {
            TextView damp1 = findViewById(R.id.damp1);
            damp1.setText(" 80% ");
        }
        else{
            TextView damp1 = findViewById(R.id.damp1);
            TextView dampTitle = findViewById(R.id.dampTitle);
            damp1.setText("");
            dampTitle.setText("");
        }
    }
    private void conditionsPressure(Intent intent) {
        int pressure=intent.getIntExtra("PRESSURE",0);
        if(pressure>0) {
            TextView pressure1 = findViewById(R.id.pressure1);
            pressure1.setText(" 745 ");
        }
        else {
            TextView pressure1 = findViewById(R.id.pressure1);
            TextView pressureTitle = findViewById(R.id.pressureTitle);
            pressure1.setText("");
            pressureTitle.setText("");
        }
    }
}
