package com.example.nadu.myapplication;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import android.widget.Toast;



public class consumer_signup extends AppCompatActivity {
    //ImageButton CreateAccount;
    EditText user_name, address, phone, consumer_number, username, password, re_password;
    String u_n, addr, phn, csn, un, ps, rps;
    boolean flag = true, phonevaldity = true;
    String method;
    double d;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    // private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumer_signup);
        user_name = (EditText) findViewById(R.id.user_name);
        address = (EditText) findViewById(R.id.address);
        phone = (EditText) findViewById(R.id.phone);
        consumer_number = (EditText) findViewById(R.id.consumer_number);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        re_password = (EditText) findViewById(R.id.re_password);
        //CreateAccount = (ImageButton) findViewById(R.id.CreateAccount);

    }
            public void userreg(View view) {

                 u_n = user_name.getText().toString();
                 addr = address.getText().toString();
                 phn = phone.getText().toString();
                 csn = consumer_number.getText().toString();
                 un = username.getText().toString();
                 ps = password.getText().toString();
                 rps = re_password.getText().toString();
                flag = true;
                phonevaldity = true;

                try {
                    d = Double.parseDouble(phn);
                } catch (NumberFormatException nfe) {
                    phonevaldity = false;
                }

                if (user_name.getText().length() == 0) {
                    user_name.setError("Enter name");
                    flag=false;
                }
                if (address.getText().length() == 0) {
                    address.setError("Enter address");
                    flag=false;
                }
                if (phone.getText().length() == 0 ) {

                    phone.setError("Enter phone number");
                    flag=false;
                }

                if (consumer_number.getText().length() == 0) {
                    consumer_number.setError("Enter consumer number");
                    flag=false;
                }
                if (username.getText().length() == 0) {
                    username.setError("Enter username");
                    flag=false;
                }
                if (password.getText().length() == 0) {
                    password.setError("Enter password");
                    flag=false;
                }
                if (re_password.getText().length() == 0) {

                    re_password.setError("Re-type pasword");
                    flag=false;
                }
                if( !phonevaldity||phone.getText().length() !=10)
                {
                    flag=false;
                    Toast.makeText(getApplicationContext(), "Invalid phone number", Toast.LENGTH_SHORT).show();
                }
                if (!ps.equals(rps)) {
                    flag=false;
                    Toast.makeText(getApplicationContext(), "password mismatch", Toast.LENGTH_SHORT).show();

                }

                if (flag && !u_n.isEmpty() && !addr.isEmpty() && !phn.isEmpty() && !csn.isEmpty() && !ps.isEmpty()&& !rps.isEmpty()) {
                     method = "register";
                    BackgroundTask backgroundTask = new BackgroundTask(consumer_signup.this);
                    backgroundTask.execute(method,u_n,addr,phn,un,csn,ps);
                    finish();
                }

            }
        }




