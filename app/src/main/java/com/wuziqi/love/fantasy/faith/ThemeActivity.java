package com.wuziqi.love.fantasy.faith;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ThemeActivity extends Activity implements OnClickListener{

    Button button =null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);
        Utils.onActivityCreateSetTheme(this);

        findViewById(R.id.bt_pink).setOnClickListener(this);
        findViewById(R.id.bt_red).setOnClickListener(this);
        findViewById(R.id.bt_purple).setOnClickListener(this);
        findViewById(R.id.bt_blue).setOnClickListener(this);
        findViewById(R.id.bt_orange).setOnClickListener(this);
        findViewById(R.id.bt_green).setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.bt_red:
                Utils.changeToTheme(this, 1);
                break;
            case R.id.bt_purple:
                Utils.changeToTheme(this, 2);
                break;
            case R.id.bt_blue:
                Utils.changeToTheme(this, 3);
                break;
            case R.id.bt_orange:
                Utils.changeToTheme(this, 4);
                break;
            case R.id.bt_green:
                Utils.changeToTheme(this, 5);
                break;
        }
    }
}
