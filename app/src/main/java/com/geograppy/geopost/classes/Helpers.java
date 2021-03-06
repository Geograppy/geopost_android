package com.geograppy.geopost.classes;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.TypedValue;

import com.geograppy.geopost.R;

import java.util.ArrayList;

public class Helpers {
    public static int getBufferDistance(Activity a){
        return a.getResources().getInteger(R.integer.buffer_for_conversations);
    }

    public static boolean hasKnownUsername(Activity activity){

        String username = getUsernameFromPreferences(activity);
        return !username.isEmpty() && !username.equals("-1") && !username.equals("");
    }

    public static void setUsernameInPreferences(String username, Activity activity){
        SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(String.valueOf(R.string.sharePrefUsername), username);
        editor.commit();
    }

    public static String getUsernameFromPreferences(Activity activity){
        SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
        return sharedPref.getString(String.valueOf(R.string.sharePrefUsername), "");
    }

    public static int getUseridFromPreferences(Activity activity){
        SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
        return sharedPref.getInt(String.valueOf(R.string.sharePrefUserId), -1);
    }

    public static void setUseridInPreferences(int userid, Activity activity){
        SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(String.valueOf(R.string.sharePrefUserId), userid);
        editor.commit();
    }

    public static void setBadgeCount(Context context, LayerDrawable icon, int count) {

        BadgeDrawable badge;

        // Reuse drawable if possible
        Drawable reuse = icon.findDrawableByLayerId(R.id.ic_badge);
        if (reuse != null && reuse instanceof BadgeDrawable) {
            badge = (BadgeDrawable) reuse;
        } else {
            badge = new BadgeDrawable(context);
        }

        badge.setCount(count);
        icon.mutate();
        icon.setDrawableByLayerId(R.id.ic_badge, badge);
    }

}
