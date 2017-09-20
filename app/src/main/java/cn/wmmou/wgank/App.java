package cn.wmmou.wgank;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsListener;

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
        initTbs();
    }
    public static Context getContext() {
        return context;
    }

    private void initTbs(){
        //搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback(){
            @Override
            public void onViewInitFinished(boolean arg0){
            }
            @Override
            public void onCoreInitFinished(){
            }
        };
        QbSdk.initX5Environment(getApplicationContext(), cb);
    }
}
