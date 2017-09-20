package cn.wmmou.wgank.gankoneday;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import cn.wmmou.wgank.BaseActivity;
import cn.wmmou.wgank.BasePresenter;
import cn.wmmou.wgank.model.OneDayData;
import cn.wmmou.wgank.model.entity.Gank;
import cn.wmmou.wgank.net.GankClient;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wmmou on 2017/9/18.
 * e-mail:666@wmmou.cn
 * desc:
 * version:
 */

public class GankOneDayPresenter extends BasePresenter<IGankOneDayView>{

    public GankOneDayPresenter(Context context, IGankOneDayView iView){
        super(context, iView);
    }

    @Override
    public void release() {
    }


    public  void fetchGankData(int year,int month,int day){

        GankClient.getGankRetrofitInstance().getGankOneDayData(year,month,day)
                .map(new Function<OneDayData, List<Gank>>() {
                    @Override
                    public List<Gank> apply(OneDayData oneDayData) throws Exception {
                        return manageData(oneDayData.results);
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Gank>>(){
                    @Override
                    public void accept(List<Gank> list){
                        iView.shouOneDayData(list);
                    }
                }, new Consumer<Throwable>(){
                    @Override
                    public void accept(Throwable throwable){

                    }
                });
    }
    private List<Gank>  manageData(OneDayData.Result result){
        List<Gank> lists=new ArrayList<>();
        if (result.androidList!=null){lists.addAll(result.androidList);}
        if (result.iosList!=null){lists.addAll(result.iosList);}
        if (result.wealList!=null){lists.addAll(result.wealList);}
        if (result.expandList!=null){lists.addAll(result.expandList);}
        if (result.recommendList!=null){lists.addAll(result.recommendList);}
        if (result.frontList!=null){lists.addAll(result.frontList);}
        if (result.appList!=null){lists.addAll(result.appList);}
        if (result.restVideoList!=null){lists.addAll(0,result.restVideoList);}
        return lists;
    }
}
