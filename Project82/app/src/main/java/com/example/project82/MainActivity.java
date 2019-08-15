package com.example.project82;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import java.util.*;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static String[][] arr={{"Birthday Party","01-10-2019","M G Hall, Mumbai","Mr Salman Khan","Hiran ZINDA Hai"},
            {"Wedding","10-01-2019","Sachin Hall, Bandra","Mr Tendlya","Aila..!!!"},
            {"Reception","14-04-2018","Virat Hall, Anushka","Mr Bh#$%^d","Insta Likes.... *Facepalm*"},
            {"Aniverasy","21-06-2019","MS Dawni, Delhi","Mr Ziva","Idhar dekh le B...ke"},
            {"Other","15-05-2019","Nowhere, Assam","Mr SRK","KKK... Kiran"},
            {"Get_together","50-05-2018","Noname, NoShame","Mr India","Jhakas..."}
    };
    public static ArrayList<Integer> t=new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Intent intent=new Intent(MainActivity.this,NewEventFormActivity.class);
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Random r=new Random();

        int temp=r.nextInt(6);
        t.add(temp);

        TextView tv=(TextView) findViewById(R.id.eventname1);
        tv.setText(arr[temp][0]);
        TextView dt=(TextView) findViewById(R.id.date1);
        dt.setText(arr[temp][1]);
        TextView ve=(TextView) findViewById(R.id.venue1);
        ve.setText(arr[temp][2]);

        temp=r.nextInt(6);
        while(t.contains(temp)){
            temp=r.nextInt(6);
        }
        t.add(temp);
        TextView tv1=(TextView) findViewById(R.id.eventname2);
        tv1.setText(arr[temp][0]);
        TextView dt1=(TextView) findViewById(R.id.date2);
        dt1.setText(arr[temp][1]);
        TextView ve1=(TextView) findViewById(R.id.venue2);
        ve1.setText(arr[temp][2]);

        temp=r.nextInt(6);
        while(t.contains(temp)){
            temp=r.nextInt(6);
        }
        t.add(temp);
        TextView tv2=(TextView) findViewById(R.id.eventname3);
        tv2.setText(arr[temp][0]);
        TextView dt2=(TextView) findViewById(R.id.date3);
        dt2.setText(arr[temp][1]);
        TextView ve2=(TextView) findViewById(R.id.venue3);
        ve2.setText(arr[temp][2]);

        temp=r.nextInt(6);
        while(t.contains(temp)){
            temp=r.nextInt(6);
        }
        t.add(temp);
        TextView tv3=(TextView) findViewById(R.id.eventname4);
        tv3.setText(arr[temp][0]);
        TextView dt3=(TextView) findViewById(R.id.date4);
        dt3.setText(arr[temp][1]);
        TextView ve3=(TextView) findViewById(R.id.venue4);
        ve3.setText(arr[temp][2]);

        temp=r.nextInt(6);
        while(t.contains(temp)){
            temp=r.nextInt(6);
        }
        t.add(temp);
        TextView tv4= findViewById(R.id.eventname5);
        tv4.setText(arr[temp][0]);
        TextView dt4= findViewById(R.id.date5);
        dt4.setText(arr[temp][1]);
        TextView ve4= findViewById(R.id.venue5);
        ve4.setText(arr[temp][2]);

    }

    public void butonclick(View v){
        Intent intent=new Intent(MainActivity.this,EventDetailsActivity.class);
        Bundle b=new Bundle();
        switch (v.getId()) {
            case R.id.table1:
                b.putStringArray("arrvals", arr[t.get(0)]);
                intent.putExtras(b);
                startActivity(intent);
                break;
            case R.id.table2:
                b.putStringArray("arrvals", arr[t.get(1)]);
                intent.putExtras(b);
                startActivity(intent);
                break;
            case R.id.table3:
                b.putStringArray("arrvals", arr[t.get(2)]);
                intent.putExtras(b);
                startActivity(intent);
                break;
            case R.id.table4:
                b.putStringArray("arrvals", arr[t.get(3)]);
                intent.putExtras(b);
                startActivity(intent);
                break;
            case R.id.table5:
                b.putStringArray("arrvals", arr[t.get(4)]);
                intent.putExtras(b);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent inte=new Intent(MainActivity.this,InvitationActivity.class);
            startActivity(inte);
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {
            Intent inte=new Intent(MainActivity.this,AttendentsActivity.class);
            startActivity(inte);
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
