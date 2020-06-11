package com.example.nadu.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import static android.R.attr.fragment;

public class menu_page extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
        TextView nav_user;
        String cons_no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        //to set the value of textview with employee number in drawer
        cons_no=BackgroundTask.number;
        cons_no="consumer no:"+cons_no;
        View headerView=navigationView.getHeaderView(0);
        TextView nav_user=(TextView)headerView.findViewById(R.id.nav_user);
        nav_user.setText(cons_no);

        //this code..

        navigationView.setNavigationItemSelectedListener(this);
        displaySelectedScreen(R.id.nav_notification);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            //super.onBackPressed();

                Timer timer = new Timer();
                timer.schedule(new TimerTask() {

                    public void run() {

                    }
                }, 555, 666);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_myprofile) {
            startActivity(new Intent(menu_page.this,consumer_profile.class));
            // return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")


    private void displaySelectedScreen(int itemId)
    {
        Fragment fragment=null;
        switch(itemId)
        {
            case R.id.nav_notification:
                fragment=new news();break;
            case R.id.nav_regcomplaints:
                fragment=new complaint();break;
            case R.id.nav_bill_details:
                fragment=new bill_payment();break;
            case R.id.nav_bill_history:
                fragment=new bill_history();break;
            case R.id.nav_statuscomplaints:
                fragment=new status_complaint();break;
            case R.id.nav_apply_connection:
                fragment=new new_connection();break;
            case R.id.nav_help:
                fragment=new consumer_help();break;
            case R.id.nav_calendar:
                fragment=new calender_view();break;
            case R.id.nav_pass_change_consumer:
                fragment=new consumer_pass_change();break;
            case R.id.nav_apply_connection_details:
                fragment=new application_status();break;
            case R.id.nav_logout:
                finish();
                Intent i=new Intent(menu_page.this,MainActivity.class);
                startActivity(i);

        }
        if(fragment!=null)
        {
            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_menu_page_frame,fragment);
            ft.commit();
        }
        DrawerLayout drawer=(DrawerLayout)findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        displaySelectedScreen(item.getItemId());
        return true;
    }
}
