package cn.wmmou.wgank.main;

import java.util.List;

import cn.wmmou.wgank.IBaseView;
import cn.wmmou.wgank.model.WealData;
import cn.wmmou.wgank.model.entity.Gank;

/**
 * Created by wmmou on 2017/9/5.
 * e-mail:666@wmmou.cn
 * desc:
 * version:
 */

public interface IMainView extends IBaseView{
    void shouGankData(List<Gank> list);
    void showProgress();
    void hideProgress();
    void showError();
    void showNoData();
}
