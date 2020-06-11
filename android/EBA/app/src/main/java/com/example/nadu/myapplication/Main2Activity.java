package com.example.nadu.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class Main2Activity extends AppCompatActivity {
    ImageButton LinemanLogin, LinemanSignup;
    EditText username, password;
    String lun,lpw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // LinemanLogin=(ImageButton)findViewById(R.id.LinemanLogin);
        username = (EditText) findViewById(R.id.editText3);
        password = (EditText) findViewById(R.id.editText);

    }

    public void linelogin(View view) {

        lun = username.getText().toString();
        lpw = password.getText().toString();
        String method = "linemanlog";
        if (username.getText().length() == 0) {

            Toast.makeText(getApplicationContext(), "Enter username", Toast.LENGTH_SHORT).show();
        }
        if (password.getText().length() == 0) {

            Toast.makeText(getApplicationContext(), "Enter password", Toast.LENGTH_SHORT).show();

        }

        if (!lun.isEmpty() && !lpw.isEmpty()) {

            BackgroundTask backgroundTask = new BackgroundTask(Main2Activity.this);
            backgroundTask.execute(method,lun,lpw);
            finish();
        }
    }

    public void onBackPressed() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(Main2Activity.this,StartupScreen.class));
            }
        },1);
    }
}
