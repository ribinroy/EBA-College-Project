package com.example.nadu.myapplication;

import android.app.Activity;
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

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    String un,pw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.editText3);
        password= (EditText) findViewById(R.id.editText);
        }



           public void userlogin(View view) {

               un = username.getText().toString();
               pw = password.getText().toString();
               String method="login";
               if (username.getText().length() == 0) {

                   Toast.makeText(getApplicationContext(),"Enter username", Toast.LENGTH_SHORT).show();
               }
               if (password.getText().length() == 0) {

                   Toast.makeText(getApplicationContext(),"Enter password", Toast.LENGTH_SHORT).show();

               }

               if(!un.isEmpty() && !pw.isEmpty()) {

                   BackgroundTask backgroundTask = new BackgroundTask(MainActivity.this);
                   backgroundTask.execute(method,un,pw);
                   finish();
               }
               /////startActivity(new Intent(this,menu_page.class));
                   //Intent ic = new Intent(MainActivity.this, menu_page.class);
                   //startActivity(ic);

            }
      //  });
       // Consumersignup=(ImageButton)findViewById(R.id.Consumersignup);
        //Consumersignup.setOnClickListener(new View.OnClickListener() {

            public void userreg(View view) {
                startActivity(new Intent(this,consumer_signup.class));
               // Intent i=new Intent(MainActivity.this,consumer_signup.class);
                //startActivity(i);

            }
    //    });

    public void onBackPressed() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this,StartupScreen.class));
            }
        },1);
    }


}
