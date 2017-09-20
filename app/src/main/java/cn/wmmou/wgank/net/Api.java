package cn.wmmou.wgank.net;

import cn.wmmou.wgank.GankConfig;
import cn.wmmou.wgank.model.GankData;
import cn.wmmou.wgank.model.OneDayData;
import cn.wmmou.wgank.model.RestData;
import cn.wmmou.wgank.model.WealData;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by wmmou on 2017/9/4.
 * e-mail:666@wmmou.cn
 * desc:
 * version:
 */

public interface Api {
    // http://gank.io/api/data/数据类型/请求个数/第几页
    @GET("data/福利/" + GankConfig.MEIZI_SIZE + "/{page}")
    Observable<WealData> getMeiziData(@Path("page") int page);

    @GET("data/休息视频/" + GankConfig.MEIZI_SIZE + "/{page}")
    Observable<RestData> getFunnyData(@Path("page") int page);
    //请求某天干货数据
//    @GET("day/{year}/{month}/{day}")
//    Observable<GankData> getDailyData(
//            @Path("year") int year,
//            @Path("month") int month,
//            @Path("day") int day);
//
    //请求不同类型干货（通用）
    @GET("data/{type}/"+GankConfig.GANK_SIZE+"/{page}")
    Observable<GankData> getGankData(@Path("type") String type, @Path("page") int page);
    //请求某天数据  http://gank.io/api/day/2017/09/15
    @GET("day/{year}/{month}/{day}")
    Observable<OneDayData> getGankOneDayData(@Path("year") int year, @Path("month") int month, @Path("day") int day);
}
