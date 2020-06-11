package com.example.nadu.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.net.URL;
import java.net.URLConnection;
import java.util.Timer;
import java.util.TimerTask;

public class splash_screen extends AppCompatActivity {
boolean status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {


            public void run() {
               // boolean value=isConnectedToServer("http://192.168.43.13/eba/android/androstart.php",5000);
                //if(value==false)
                //{
                  //  Toast.makeText(getApplicationContext(), "Server not found", Toast.LENGTH_SHORT).show();
                //}
                startActivity(new Intent(splash_screen.this,StartupScreen.class));
            }

        }, 7000);
    }
    /*public boolean isConnectedToServer(String url, int timeout) {
        try{
            URL myUrl = new URL(url);
            URLConnection connection = myUrl.openConnection();
            connection.setConnectTimeout(timeout);
            connection.connect();
            return true;
        } catch (Exception e) {
            // Handle your exceptions
            return false;
        }
    }*/
}
