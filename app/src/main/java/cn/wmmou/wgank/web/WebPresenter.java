package cn.wmmou.wgank.web;

import android.content.Context;
import android.os.Bundle;
import android.os.Trace;

import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import cn.wmmou.wgank.BasePresenter;

/**
 * Created by wmmou on 2017/9/9.
 * e-mail:666@wmmou.cn
 * desc:
 * version:
 */

public class WebPresenter  extends BasePresenter<IWebView>{

    public WebPresenter(Context context, IWebView iView){
        super(context, iView);
    }
    @Override
    public void release(){
    }
    public void  setWebViewSettings(WebView webView, String url)
    {
        WebSettings webSetting=webView.getSettings();

        webSetting.setAllowFileAccess(true);
        webSetting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSetting.setSupportZoom(true);
        webSetting.setBuiltInZoomControls(true);
        webSetting.setUseWideViewPort(true);
        webSetting.setSupportMultipleWindows(false);
        webSetting.setAppCacheEnabled(true);
        webSetting.setDomStorageEnabled(true);
        webSetting.setJavaScriptEnabled(true);
        webSetting.setGeolocationEnabled(true);
        webSetting.setPluginState(WebSettings.PluginState.ON_DEMAND);
        webView.setWebChromeClient(new ChromeClient());
        webView.setWebViewClient(new GankClick());
        webView.loadUrl(url);
    }
    public void enableLiteWndFunc(WebView webView) {
        if (webView.getX5WebViewExtension() != null) {
            Bundle data = new Bundle();
            data.putBoolean("standardFullScreen", false);// true表示标准全屏，会调起onShowCustomView()，false表示X5全屏；不设置默认false，
            data.putBoolean("supportLiteWnd", false);// false：关闭小窗；true：开启小窗；不设置默认true，
            data.putInt("DefaultVideoScreen", 2);// 1：以页面内开始播放，2：以全屏开始播放；不设置默认：1
            webView.getX5WebViewExtension().invokeMiscMethod("setVideoParams",data);
        }
    }
    private class ChromeClient extends WebChromeClient{
        @Override
        public void onProgressChanged(WebView webView, int i){
            super.onProgressChanged(webView, i);
        }

        @Override
        public void onReceivedTitle(WebView webView, String s){
            super.onReceivedTitle(webView, s);
        }
    }
    private class GankClick extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            if (url != null) view.loadUrl(url);
            return true;
        }
    }

}
