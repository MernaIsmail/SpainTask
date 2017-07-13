package com.vis.merna.spaintask.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.vis.merna.spaintask.SpainApp;

/**
 * Created by Merna on 09/07/2017.
 */

public class SharedPref {

    private static final String PREF_NAME = "SHAREDPREF";

    private static final Context context = SpainApp.getInstance();
    private static SharedPreferences prefs = context.getSharedPreferences(PREF_NAME,context.MODE_PRIVATE);

    public static void saveString(String key, String value){

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.commit();

    }
    public static String retrieveString(String key){
        return prefs.getString(key, null);
    }

}
