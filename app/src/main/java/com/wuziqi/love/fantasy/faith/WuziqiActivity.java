package com.wuziqi.love.fantasy.faith;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.defaultHeight;
import static android.R.attr.gravity;
import static android.R.attr.keycode;

//程序入口Activity
public class WuziqiActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

	private Chessboard gameView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_activity_wuziqi);
        gameView = (Chessboard) findViewById(R.id.snake);
        gameView.setTextView((TextView)findViewById(R.id.text));
        TextView tv_wuziqiback=(TextView)findViewById(R.id.tv_wzqback);
        tv_wuziqiback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_wuziqi);
                drawer.openDrawer(Gravity.LEFT);
            }
        });

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_wuziqi);
        navigationView.setNavigationItemSelectedListener(this);

        TextView bt_1=(TextView) findViewById(R.id.bt_1);
        bt_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performKeyDown(KeyEvent.KEYCODE_1);
                Snackbar.make(v,"OK,人人对战，开始玩吧233",Snackbar.LENGTH_LONG).show();
            }
        });
        TextView bt_2=(TextView) findViewById(R.id.bt_2);
        bt_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performKeyDown(KeyEvent.KEYCODE_2);
                Snackbar.make(v,"OK，人机对战，开始玩吧233",Snackbar.LENGTH_LONG).show();
            }
        });
        TextView bt_restart=(TextView) findViewById(R.id.bt_restart);
        bt_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performKeyDown(KeyEvent.KEYCODE_3);
                Snackbar.make(v,"OK，重置棋盘（仅在游戏运行过程中有效233）",Snackbar.LENGTH_LONG).show();
            }
        });

    }
    public void performKeyDown(final int keyCode) {
        new Thread() {
            public void run() {
                try {
                    Instrumentation inst = new Instrumentation();
                    inst.sendKeyDownUpSync(keyCode);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_wuziqi);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_study) {
            // Handle the camera action
        } else if (id == R.id.nav_home) {
            Intent intent = new Intent(WuziqiActivity.this, MainActivity.class);
            overridePendingTransition(0, 0);
            startActivity(intent);
        } else if (id == R.id.nav_decide) {
            Intent intent = new Intent(WuziqiActivity.this, DecideActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_developer) {
            Intent intent = new Intent(WuziqiActivity.this, DeveloperActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_setting) {
            Intent intent = new Intent(WuziqiActivity.this, SettingsActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_wuziqi);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}