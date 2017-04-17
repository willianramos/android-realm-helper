package com.example.wramos.arealmproject;

import android.app.Application;

/**
 * Created by wramos on 13/04/17.
 */

public class App extends Application {
    private static App instance;
    public static App get() { return instance; }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}