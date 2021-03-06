package com.example.sonam.sw_bhutan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
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
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    /* for bottom navigation and its page */
    private BottomNavigationView mBottomNav;
    private FrameLayout mMainFrame;

    private EventFragment eventFragment;
    private RegistrationFragment registrationFragment;
    private HomeFragment homeFragment;
    private SponsorFragment sponsorFragment;
    private MentorFragment mentorFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        /* for bottom navigation and its pages */
        mBottomNav = (BottomNavigationView) findViewById(R.id.bottom_nav);
        mMainFrame = (FrameLayout) findViewById(R.id.mainframe);

        eventFragment = new EventFragment();
        registrationFragment = new RegistrationFragment();
        homeFragment = new HomeFragment();
        sponsorFragment = new SponsorFragment();
        mentorFragment = new MentorFragment();


        mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.bottom_events:
                        setFragment(eventFragment);
                        return true;
                    case R.id.bottom_reg:
                        setFragment(registrationFragment);
                        return true;
                    case R.id.bottom_home:
                        setFragment(homeFragment);
                        return true;
                    case R.id.bottom_sponsor:
                        setFragment(sponsorFragment);
                        return true;
                    case R.id.bottom_mentors:
                        setFragment(mentorFragment);
                        return true;

                        default:
                            return  false;
                }

            }

            private void setFragment(Fragment fragment) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.mainframe, fragment);
                fragmentTransaction.commit();
            }
        });
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


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id){
            case R.id.organisers:
                Intent intent=new Intent(MainActivity.this, organisers.class);
                startActivity(intent);
                break;

            case R.id.prize:
                break;
            case R.id.contactus:
                break;

            case R.id.nav_share:
                break;
            case R.id.nav_rate:
                break;
        }
        /*
        if (id == R.id.organisers) {
            Intent intent = new Intent(MainActivity.this, organisers.class);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.prize) {

        } else if (id == R.id.contactus) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_rate) {

        } */

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
