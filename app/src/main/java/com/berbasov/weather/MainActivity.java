package com.berbasov.weather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    private String TAG = "Жизненный цикл";
    public final static String TEXT = "TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate()");
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        EditText editText = (EditText) findViewById(R.id.form);
        String message = editText.getText().toString();
        intent.putExtra(TEXT, message);
        startActivity(intent);
    }
    public void sendMessage1(View view) {
        EditText edit_txt = (EditText) findViewById(R.id.form);
        edit_txt.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    EditText editText = (EditText) findViewById(R.id.form);
                    String message = editText.getText().toString();
                    intent.putExtra(TEXT, message);
                    startActivity(intent);
                    handled = true;
                }
                return handled;
            }
        });
    }

}

