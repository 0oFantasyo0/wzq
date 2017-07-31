package com.wuziqi.love.fantasy.faith;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.wuziqi.love.fantasy.faith.R;
import com.wuziqi.love.fantasy.faith.Utils;

public class ThemeActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);
        Utils.changeTheme(this);

        Button bt_pink =(Button)findViewById(R.id.bt_pink);
        bt_pink.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(Utils.isChange==1){
                }else {
                    Utils.isChange=1;
                    ThemeActivity.this.recreate();
                }
                Snackbar.make(view,"（日志）isChange="+Utils.isChange,Snackbar.LENGTH_SHORT).show();
            }});
        Button bt_red =(Button)findViewById(R.id.bt_red);
        bt_red.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(Utils.isChange==2){
                }else {
                    Utils.isChange=2;
                    ThemeActivity.this.recreate();
                }
                Snackbar.make(view,"（日志）isChange="+Utils.isChange,Snackbar.LENGTH_SHORT).show();
            }});
        Button bt_purple =(Button)findViewById(R.id.bt_purple);
        bt_purple.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(Utils.isChange==3){
                }else {
                    Utils.isChange=3;
                    ThemeActivity.this.recreate();
                }
                Snackbar.make(view,"（日志）isChange="+Utils.isChange,Snackbar.LENGTH_SHORT).show();
            }});
        Button bt_blue =(Button)findViewById(R.id.bt_blue);
        bt_blue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(Utils.isChange==4){
                }else {
                    Utils.isChange=4;
                    ThemeActivity.this.recreate();
                }
                Snackbar.make(view,"（日志）isChange="+Utils.isChange,Snackbar.LENGTH_SHORT).show();
            }});
        Button bt_orange =(Button)findViewById(R.id.bt_orange);
        bt_orange.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(Utils.isChange==5){
                }else {
                    Utils.isChange=5;
                    ThemeActivity.this.recreate();
                }
                Snackbar.make(view,"（日志）isChange="+Utils.isChange,Snackbar.LENGTH_SHORT).show();
            }});
        Button bt_green =(Button)findViewById(R.id.bt_green);
        bt_green.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(Utils.isChange==6){
                }else {
                    Utils.isChange=6;
                    ThemeActivity.this.recreate();
                }
                Snackbar.make(view,"（日志）isChange="+Utils.isChange,Snackbar.LENGTH_SHORT).show();
            }});
        Toolbar toolbar= (Toolbar)findViewById(R.id.tb_th);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar !=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent mIntent = new Intent(this, MainActivity.class);
        mIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(mIntent);
        finish();
    }
    //返回按钮
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    //返回按钮
}
