package com.example.nadu.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class StartupScreen extends AppCompatActivity {
ImageButton Consumername,Lineman;
    EditText ipaddress;
    Button ok;
    public static String ipval;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup_screen);
        ipaddress = (EditText) findViewById(R.id.ipaddress);
        Consumername=(ImageButton)findViewById(R.id.Consumername);
        Consumername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent ic=new Intent(StartupScreen.this,MainActivity.class);
                startActivity(ic);
               // finish();
            }
        });
        Lineman=(ImageButton)findViewById(R.id.Lineman);
        Lineman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ic=new Intent(StartupScreen.this,Main2Activity.class);
                startActivity(ic);
            }
        });
    }
    public void okPress(View view)
    {
        ipval= ipaddress.getText().toString();
        Toast.makeText(getApplicationContext(),ipval, Toast.LENGTH_SHORT).show();
    }
    public void onBackPressed() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

            }
        }, 555, 666);
    }

}
