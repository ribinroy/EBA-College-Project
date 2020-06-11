package com.example.nadu.myapplication;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class lineman_menu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    String emp_id;
    TextView empno_display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lineman_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        //to set the value of textview with employee number in drawer
        emp_id=BackgroundTask.employeenumber;
        emp_id="emp no:"+emp_id;
        View headerView=navigationView.getHeaderView(0);
        TextView empno_display=(TextView)headerView.findViewById(R.id.empno_display);
        empno_display.setText(emp_id);

        //this code..

        navigationView.setNavigationItemSelectedListener(this);
        displaySelectedScreen(R.id.nav_lineman_works);
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
           // super.onBackPressed();
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
        getMenuInflater().inflate(R.menu.lineman_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {


            //Toast.makeText(getApplicationContext(), "hi you clicked on settings successfully", Toast.LENGTH_SHORT).show();
               return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void displaySelectedScreen(int itemId)
    {
        Fragment fragment=null;
        switch(itemId)
        {
            case R.id.nav_lineman_works:
                fragment=new works();break;
            case R.id.nav_lineman_history:
                fragment=new workhistory();break;
            case R.id.nav_lineman_password_settings:
                fragment=new lineman_change_pass();break;
            case R.id.nav_lineman_logout:
                finish();
                Intent i=new Intent(lineman_menu.this,Main2Activity.class);
                startActivity(i);

        }
        if(fragment!=null)
        {
            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_lineman_menu,fragment);
            ft.commit();
        }
        DrawerLayout drawer=(DrawerLayout)findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }
    public boolean onNavigationItemSelected(MenuItem item) {
        displaySelectedScreen(item.getItemId());
        return true;
    }
}
