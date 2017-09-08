package cn.wmmou.wgank.model;

import java.util.List;

import cn.wmmou.wgank.model.entity.Gank;

/**
 * Created by wmmou on 2017/9/5.
 * e-mail:666@wmmou.cn
 * desc:
 * version:
 */

public class RestData extends BaseData {
    public List<Gank> results;
    @Override
    public String toString() {
        return "FunnyData{" +
                "results=" + results +
                '}';
    }
}
