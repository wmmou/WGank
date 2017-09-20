package cn.wmmou.wgank.gankoneday;

import java.util.List;

import cn.wmmou.wgank.IBaseView;
import cn.wmmou.wgank.model.entity.Gank;

/**
 * Created by wmmou on 2017/9/18.
 * e-mail:666@wmmou.cn
 * desc:
 * version:
 */

public interface IGankOneDayView  extends IBaseView{
    void shouOneDayData(List<Gank> lists);

}
