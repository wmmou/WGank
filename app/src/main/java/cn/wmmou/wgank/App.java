package cn.wmmou.wgank;

import android.app.Application;
import android.content.Context;

/**
 * Created by wmmou on 2017/9/4.
 * e-mail:666@wmmou.cn
 * desc:
 * version:
 */

public class App extends Application {

    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
    public static Context getContext() {
        return context;
    }







}
