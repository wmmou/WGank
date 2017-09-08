package cn.wmmou.wgank;

import android.content.Context;
import android.util.Log;

/**
 * Created by wmmou on 2017/9/4.
 * e-mail:666@wmmou.cn
 * desc:
 * version:
 */

public abstract class BasePresenter<T extends IBaseView> {
    protected Context context;
    protected T iView;
    protected String TAG=this.getClass().getSimpleName();

    public BasePresenter(Context context, T iView) {
        Log.i(TAG,"supper--BasePresenter()");
        this.context = context;
        this.iView = iView;
    }

    public void init(){
        Log.i(TAG,"supper--init()");
        iView.initView();
    }

    public abstract void release();




}
