package cn.wmmou.wgank.main;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.MainThread;
import android.util.Log;

import java.util.List;

import cn.wmmou.wgank.BasePresenter;
import cn.wmmou.wgank.gank24k.GankActivity;
import cn.wmmou.wgank.model.GankData;
import cn.wmmou.wgank.model.RestData;
import cn.wmmou.wgank.model.WealData;
import cn.wmmou.wgank.model.entity.Gank;
import cn.wmmou.wgank.net.GankClient;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wmmou on 2017/9/5.
 * e-mail:666@wmmou.cn
 * desc:
 * version:
 */
public class MainPresenter extends BasePresenter<IMainView> {
    public MainPresenter(Context context, IMainView iView) {
        super(context, iView);
    }
    public void fetchGankData(int page)
    {
        Log.i(TAG,"fetchGankData()");
        Observable.zip(GankClient.getGankRetrofitInstance().getMeiziData(page),
                GankClient.getGankRetrofitInstance().getFunnyData(page), new BiFunction<WealData, RestData, WealData>(){
                    @Override
                    public WealData apply(WealData wealData,RestData restData) throws Exception{
                        return createGankData(wealData,restData);
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<WealData>(){
                    @Override
                    public void accept(WealData wealData){
                            //让页面更新数据
                        if (wealData.results.size()==0){
                            iView.showNoData();
                        }else {
                            iView.hideProgress();
                            iView.shouGankData(wealData.results);
                        }
                    }
                }, new Consumer<Throwable>(){
                    @Override
                    public void accept(Throwable throwable){
                        Log.i(TAG,"fetchGankData()--gg");
                        iView.showError();
                    }
                });
    }
    /**
     * 标题合并,福利图时间加休息视频描述
     * @param wealdata
     * @param restData
     * @return
     */
    private WealData createGankData(WealData wealdata, RestData restData)
    {
        int size=Math.min(wealdata.results.size(),restData.results.size());
        for (int i=0;i<size;i++){
            wealdata.results.get(i).setDesc(wealdata.results.get(i).getDesc()+","+restData.results.get(i).getDesc());
//            wealdata.results.get(i).setUrl(restData.results.get(i).getUrl());
        }
        return wealdata;
    }

    @Override
    public void release() {
    }


    public void  toGankActiivty(){
        Intent intent=new Intent(context, GankActivity.class);
        context.startActivity(intent);
    }
}
