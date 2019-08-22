package com.isansc.drawerpoc;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupToolBar();
        setupDrawer();

        // InitialPage:
        String home = getString(R.string.navbar_txt_menu_home);
        goToPage(PageFragment.newInstance(home), home);
    }

    private void setupToolBar(){

        mToolbar = findViewById(R.id.tlb_toolbar);
        setSupportActionBar(mToolbar);

        mToolbar.setTitle(R.string.toolbar_title);

    }

    private void setupDrawer(){
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.navbar_txt_description_open_drawer, R.string.navbar_txt_description_close_drawer);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        mNavigationView = (NavigationView) findViewById(R.id.navView);
        mNavigationView.getMenu().getItem(0).setChecked(true);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                String title = item.getTitle().toString();
                switch (item.getItemId()) {
                    case R.id.nav_home: {
                        goToPage(PageFragment.newInstance(title), title);
                        break;
                    }
                    case R.id.nav_video: {
                        goToPage(PageFragment.newInstance(title), title);
                        break;
                    }
                    case R.id.nav_cloud: {
                        goToPage(PageFragment.newInstance(title), title);
                        break;
                    }
                    case R.id.nav_history: {
                        goToPage(PageFragment.newInstance(title), title);
                        break;
                    }
                    case R.id.nav_translate: {
                        goToPage(PageFragment.newInstance(title), title);
                        break;
                    }
                    case R.id.nav_settings: {
                        goToPage(PageFragment.newInstance(title), title);
                        break;
                    }
                    default: {
                        goToPage(PageFragment.newInstance(title), title);
                        break;
                    }
                }
                mDrawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }

    /**
     * Method to handle the fragment's transitions
     * @param fragment nextFragment to go
     */
    private void goToPage(Fragment fragment, String title){
        setTitle(title);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frm_content, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
