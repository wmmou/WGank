package cn.wmmou.wgank;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
/**
 * Created by wmmou on 2017/9/5.
 * e-mail:666@wmmou.cn
 * desc:
 * version:
 */
public abstract class BaseActivity<T extends BasePresenter> extends RxAppCompatActivity{
    protected String TAG=this.getClass().getSimpleName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.i(TAG,"onCreate");
        setContentView(getLayoutResId());
        ButterKnife.bind(this);
        initPresenter();
    }
    protected abstract int getLayoutResId();
    protected abstract void  initPresenter();
    @Override
    protected void onStart() {
        Log.i(TAG,"onStart");
        super.onStart();
    }
    @Override
    protected void onResume() {
        Log.i(TAG,"onResume");
        super.onResume();
    }
    @Override
    protected void onPause() {
        Log.i(TAG,"onPause");
        super.onPause();
    }
    @Override
    protected void onStop() {
        Log.i(TAG,"onStop");
        super.onStop();
    }
    @Override
    protected void onDestroy() {
        Log.i(TAG,"onDestroy");
        ButterKnife.bind(this).unbind();
        super.onDestroy();
    }
}
