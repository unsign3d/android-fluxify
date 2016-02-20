package unsigned.fluxifytest;

import android.app.Application;

import net.danlew.android.joda.JodaTimeAndroid;

import stores.UselessStore;

/**
 * Created by Luca Bruzzone on 20/02/2016.
 */
public class MyApplication extends Application {

    private SingleDispatcher singleDispatcher;

    public void onCreate() {
        super.onCreate();
        // create a jodatime initialization
        JodaTimeAndroid.init(this);

        // create a single dispatcher and make sure it will be
        // linked in all the app
        singleDispatcher = SingleDispatcher.getInstance();
    }
}
