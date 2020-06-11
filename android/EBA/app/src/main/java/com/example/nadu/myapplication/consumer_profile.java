package com.example.nadu.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class consumer_profile extends AppCompatActivity {

    private WebView cons_profile ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cons_profile  = new WebView(this);

        cons_profile.getSettings().setJavaScriptEnabled(true); // enable javascript

        final Activity activity = this;

        cons_profile.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }
        });

        cons_profile .loadUrl("http://"+StartupScreen.ipval+"/eba/android/consumerdetails.php?consumerno="+BackgroundTask.number);
        setContentView(cons_profile);


      //  setContentView(R.layout.activity_consumer_profile);

    }
    public void onBackPressed() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(consumer_profile.this,menu_page.class));
            }
        },1);
    }

}
