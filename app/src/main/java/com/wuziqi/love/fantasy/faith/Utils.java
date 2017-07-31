package com.wuziqi.love.fantasy.faith;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by Administrator on 2017/7/31.
 */

public class Utils
{
    private static int sTheme;

    public final static int THEME_PINK = 0;
    public final static int THEME_RED = 1;
    public final static int THEME_PURPLE = 2;
    public final static int THEME_BLUE = 3;
    public final static int THEME_ORANGE = 4;
    public final static int THEME_GREEN = 5;

    /**
     * Set the theme of the Activity, and restart it by creating a new Activity
     * of the same type.
     */
    public static void changeToTheme(Activity activity, int theme)
    {
        sTheme = theme;
        activity.finish();

        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    /** Set the theme of the activity, according to the configuration. */
    public static void onActivityCreateSetTheme(Activity activity)
    {
        switch (sTheme)
        {
            default:
            case 1:
                activity.setTheme(R.style.AppTheme_Red);
                break;
            case 2:
                activity.setTheme(R.style.AppTheme_Purple);
                break;
            case 3:
                activity.setTheme(R.style.AppTheme_Blue);
                break;
            case 4:
                activity.setTheme(R.style.AppTheme_Orange);
                break;
            case 5:
                activity.setTheme(R.style.AppTheme_Green);
                break;
        }
    }
}