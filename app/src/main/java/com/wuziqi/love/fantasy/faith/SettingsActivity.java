package com.wuziqi.love.fantasy.faith;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Utils.changeTheme(this);

        Button bt_zt=(Button)findViewById(R.id.bt_zt);
        bt_zt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SettingsActivity.this, ThemeActivity.class);
                startActivity(intent);
            }});
        Button bt_gy=(Button)findViewById(R.id.bt_gy);
        bt_gy.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SettingsActivity.this, DeveloperActivity.class);
                startActivity(intent);
            }});
        //返回按钮
        Toolbar toolbar= (Toolbar)findViewById(R.id.tb_sz);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar !=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        //返回按钮
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
