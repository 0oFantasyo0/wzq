package com.wuziqi.love.fantasy.faith;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView textView,textView1,textView2,textView4,textView5,textView6;
    private ProgressBar pb_timeprogress;
    private Timer timer;
    private Handler handler;
    private Boolean begined = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Utils.changeTheme(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.openDrawer(Gravity.LEFT);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        init();
        handler = new Handler()
        {
            public void handleMessage(Message msg)
            {
                super.handleMessage(msg);
                if(begined == true)
                {   Calendar loveday = new GregorianCalendar(2015,10,8);
                    Calendar now = Calendar.getInstance();

                    int day = now.get(Calendar.DAY_OF_MONTH) - loveday.get(Calendar.DAY_OF_MONTH);
                    int month = now.get(Calendar.MONTH) - loveday.get(Calendar.MONTH);
                    int year = now.get(Calendar.YEAR) - loveday.get(Calendar.YEAR);
                    if(day<0){
                        month -= 1;
                        now.add(Calendar.MONTH, -1);//得到上一个月，用来得到上个月的天数。
                        day = day + now.getActualMaximum(Calendar.DAY_OF_MONTH);
                    }
                    if(month<0){
                        month = (month+12)%12;
                        year--;
                    }


                    int tday=day+1;
                    int tmonth=month+2;
                    if(tmonth>12){tmonth=1;year=year+1;}

                    textView1 = (TextView) findViewById(R.id.tw_year);
                    textView1.setText(year+"年");

                    textView2 = (TextView) findViewById(R.id.tw_month);
                    textView2.setText(tmonth+"月");

                    textView5 = (TextView) findViewById(R.id.tw_dayl);
                    textView5.setText(tday+"日");


                    Date date = new Date();
                    Calendar calendar = new GregorianCalendar(2015, 10, 8);
                    //2015.10.8 8:00计时起
                    long x=date.getTime()-calendar.getTimeInMillis();
                    long y=x-8*3600*1000;
                    SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                    String submittime = format.format(y);
                    long days =x/(1000*3600*24);
                    long dayss=days+30;

                    textView = (TextView) findViewById(R.id.tw_day);
                    textView.setText(dayss+"");

                    textView6 = (TextView) findViewById(R.id.tw_hour);
                    textView6.setText(submittime);

                    textView4 = (TextView) findViewById(R.id.tw_sec);
                    long seconds=x/1000;
                    textView4.setText(seconds+"秒");


                }
            }
        };



        ProgressBar pb_time=(ProgressBar)findViewById(R.id.pb_time);
        pb_time.setIndeterminate(true);

        Date d = new Date();
        Calendar c = new GregorianCalendar(2015, 10, 8);
        //2015.10.8 8:00计时起
        long a=(d.getTime()-c.getTimeInMillis());
        long s =a/(1000*3600*24);
        long i=a/1000-s*86400;
        long hours=a/(1000*60*60)-s*24;
        long mins =a/(1000*60)-s*24*60-hours*60;
        long secs =a/1000-s*24*60*60-hours*60*60-mins*60;
        int t=(int)i;
        int tss=(int)secs*1440;
        pb_timeprogress=(ProgressBar)findViewById(R.id.pb_timeprogress);
        pb_timeprogress.incrementProgressBy(t);
        //pb_timeprogress.incrementSecondaryProgressBy(tss);


        TextView tw_info=(TextView)findViewById(R.id.tw_sec);
        tw_info.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                AlertDialog.Builder dialog =new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("说明").setMessage("计时器从2015.10.8 0:00计时起，每天0点整跳动一次"+
                        "\nX年X月X日   XX：XX：XX为计时的具体时间，精确到秒"+
                        "\n使用了新算法，新算法中只能精确到日，时分秒都不行的~"+
                        "\n最上面天数和最下面时钟是绝对没问题的，主要是中间的那个日期...调了两天了应该不会有毛病...吧..."+
                        "\nSorry我的能力还达不到那么高的水平233就先这样凑合吧"
                ).setCancelable(true)
                        .setPositiveButton("噗....", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog ,int which){}
                        });
                dialog.show();
            }
        });

    }

    void init(){
        timer = new Timer();
        timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                // TODO Auto-generated method stub
                Message message = new Message();
                message.what = (int) (Math.random() * 999 + 100);
                handler.sendMessage(message);
            }
        }, 1000, 1000);        //从1000ms即1s开始，1000ms为数字改变周期
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

    @Override//右上角菜单
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }else if (id== R.id.action_updatelog){
            Snackbar.make(getWindow().getDecorView(), "历史N天，精心打磨，只为蛊惑住你的心~\n希望纸琪能够喜欢~", Snackbar.LENGTH_LONG)
                    .setAction("详细",new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            AlertDialog.Builder dialog =new AlertDialog.Builder(MainActivity.this);
                            dialog.setTitle("日志").setMessage(R.string.update_log).setCancelable(true)
                                    .setPositiveButton("OK~", new DialogInterface.OnClickListener(){
                                        @Override
                                        public void onClick(DialogInterface dialog ,int which){}
                                    });
                            dialog.show();
                        }})
                    .show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_study) {
            // Handle the camera action
        } else if (id == R.id.nav_game) {
            Intent intent = new Intent(MainActivity.this, WuziqiActivity.class);
            overridePendingTransition(0, 0);
            startActivity(intent);
        } else if (id == R.id.nav_decide) {
            Intent intent = new Intent(MainActivity.this, DecideActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_developer) {
            Intent intent = new Intent(MainActivity.this, DeveloperActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_setting) {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}
