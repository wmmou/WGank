package cn.wmmou.wgank.web;

import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.LinearLayout;

import com.tencent.smtt.sdk.WebView;

import butterknife.BindView;
import butterknife.OnClick;
import cn.wmmou.wgank.GankConfig;
import cn.wmmou.wgank.R;
import cn.wmmou.wgank.ToolBarActivity;
import cn.wmmou.wgank.model.entity.Gank;

/**
 * Created by wmmou on 2017/9/9.
 * e-mail:666@wmmou.cn
 * desc:
 * version:
 */

public class WebActivity extends ToolBarActivity<WebPresenter> implements IWebView{

    private Gank gank;

    @BindView(R.id.web_view)
    WebView webView;
    @OnClick(R.id.toolbar)
    void small(){
        Log.i("test","--------------------------------toolbar--");
        presenter.enableLiteWndFunc(webView);
    }

    @Override
    protected int getLayoutResId() {
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        return R.layout.activity_web;
    }

    @Override
    protected void initPresenter() {
        presenter=new WebPresenter(this,this);
        presenter.init();
    }

    public static void loadWebViewActivity(Context from, Gank gank) {
        Intent intent = new Intent(from, WebActivity.class);
        intent.putExtra(GankConfig.GANK, gank);
        from.startActivity(intent);
    }
    @Override
    public void initView() {

        gank = (Gank) getIntent().getSerializableExtra(GankConfig.GANK);
        setTitle(gank.getDesc());
//        presenter.setWebViewSettings(webView, gank.getCreatedAt());
        presenter.setWebViewSettings(webView, gank.getUrl());
//        contentView = (LinearLayout) findViewById(R.id.web_content);
    }


    @Override
    public void setWebTitle(String title) {
        setTitle(title);//设置标题
    }

    @Override
    public void openError() {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (event.getAction()==KeyEvent.ACTION_DOWN){

            switch (keyCode){
                case KeyEvent.KEYCODE_BACK:
                    if (webView.canGoBack()){
                        webView.goBack();
                    }else {
                        finish();
                    }
                    return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
