package com.vis.merna.spaintask;

import android.app.Application;

/**
 * Created by Merna on 09/07/2017.
 */

public class SpainApp extends Application {
    private static SpainApp appInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        appInstance = this;
    }

    public static SpainApp getInstance(){
        return appInstance;
    }
}

