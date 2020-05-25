package app.com.example.android.firebase;

import android.os.Bundle;
import android.os.Handler;
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

public class hamburger extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

private static int navItemIndex = 0;
    private static String TAG_FRAGMENT1 = "FRAGMENT1";
    private static String TAG_FRAGMENT2 = "FRAGMENT2";
    private static String TAG_FRAGMENT3 = "FRAGMENT3";
    private static String TAG_FRAGMENT4 = "FRAGMENT4";
    private static String TAG_FRAGMENT5 = "FRAGMENT5";
    private static String TAG_FRAGMENT6 = "FRAGMENT6";
    private static String TAG_FRAGMENT7 = "FRAGMENT7";
    private static String CURRENT_TAG = TAG_FRAGMENT1;
    private String[] activityTitles;

    DrawerLayout drawer;
    private Handler mHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hamburger);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        activityTitles = getResources().getStringArray(R.array.itemsHamburger);
//        toolbarText.setText(activityTitles[0]);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public boolean onNavigationItemSelected(MenuItem menuItem) {
        // Check to see which item was being clicked and perform appropriate action 
        switch (menuItem.getItemId()) {          //Replacing the main content with ContentFragment Which is our Inbox View; 
            case R.id.nav_home:
                navItemIndex = 0;
                CURRENT_TAG = TAG_FRAGMENT1;
                break;
            case R.id.nav_events:
                navItemIndex = 1;
                CURRENT_TAG = TAG_FRAGMENT2;
                break;
            case R.id.nav_team:
                navItemIndex = 2;
                CURRENT_TAG = TAG_FRAGMENT3;
                break;
            case R.id.nav_workshop:
                navItemIndex = 3;
                CURRENT_TAG = TAG_FRAGMENT4;
                break;
            case R.id.nav_sponsors:
                navItemIndex = 4;
                CURRENT_TAG = TAG_FRAGMENT5;
                break;
            case R.id.nav_aboutUs:
                navItemIndex = 5;
                CURRENT_TAG = TAG_FRAGMENT6;
                break;
            case R.id.nav_developers:
                navItemIndex = 6;
                CURRENT_TAG = TAG_FRAGMENT7;
                break;
            default:
                navItemIndex = 0;
        }
        loadHomeFragment();
        return true;
    }
    private void loadHomeFragment(){
        if(getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null)
        {
            drawer.closeDrawers();
        }
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                Fragment fragment = getHomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frg, fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };
        // If mPendingRunnable is not null, then add to the message queue 
        if (mPendingRunnable != null) {
            mHandler.post(mPendingRunnable);
        }
        drawer.closeDrawers();
        invalidateOptionsMenu();}

    private Fragment getHomeFragment() {
        switch (navItemIndex) {
            case 0:
                return new Fragment_home();
            case 1:
                return new Fragment_event();
            case 2:
                return new Fragment_team();
            case 3:
                return new Fragment_workshop();
            case 4:
                return new Fragment_sponsors();
            case 5:
                return new Fragment_developer();
            case 6:
                return new Fragment_aboutUs();
            default:
                return new Fragment_home();
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
        getMenuInflater().inflate(R.menu.hamburger, menu);
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
}