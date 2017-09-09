package cn.wmmou.wgank.web;

import cn.wmmou.wgank.IBaseView;

/**
 * Created by wmmou on 2017/9/9.
 * e-mail:666@wmmou.cn
 * desc:
 * version:
 */

public interface IWebView extends IBaseView {

    void  setWebTitle(String title);
    void  openError();
}
