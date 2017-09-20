package cn.wmmou.wgank.model;

import com.google.gson.annotations.SerializedName;

import java.lang.invoke.CallSite;
import java.security.PublicKey;
import java.util.List;

import cn.wmmou.wgank.model.BaseData;
import cn.wmmou.wgank.model.entity.Gank;

/**
 * Created by wmmou on 2017/9/18.
 * e-mail:666@wmmou.cn
 * desc:
 * version:
 */

public class OneDayData extends BaseData {
    public List<String> category;
    public Result results;
    public class  Result{
        @SerializedName("Android")
        public List<Gank> androidList;
        @SerializedName("iOS")
        public List<Gank> iosList;
        @SerializedName("福利")
        public List<Gank> wealList;
        @SerializedName("拓展资源")
        public List<Gank> expandList;
        @SerializedName("瞎推荐")
        public List<Gank> recommendList;
        @SerializedName("前端")
        public List<Gank> frontList;
        @SerializedName("App")
        public List<Gank> appList;
        @SerializedName("休息视频")
        public List<Gank> restVideoList;

    }
    @Override
    public String toString() {
        return "GankData{" +
                "category=" + category +
                ", results=" + results +
                '}';
    }
}
