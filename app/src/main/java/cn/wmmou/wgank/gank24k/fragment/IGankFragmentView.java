package cn.wmmou.wgank.gank24k.fragment;

import java.util.List;

import cn.wmmou.wgank.BaseActivity;
import cn.wmmou.wgank.BasePresenter;
import cn.wmmou.wgank.IBaseView;
import cn.wmmou.wgank.model.entity.Gank;

/**
 * Created by wmmou on 2017/9/8.
 * e-mail:666@wmmou.cn
 * desc:
 * version:
 */

public interface IGankFragmentView  extends IBaseView{
    void shouGankData(List<Gank> list);
    void showProgress();
    void hideProgress();
    void showError();
    void showNoData();
}
