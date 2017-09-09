package cn.wmmou.wgank.gank24k.fragment;

import android.content.Context;

import com.bumptech.glide.load.model.ImageVideoWrapperEncoder;

import cn.wmmou.wgank.BasePresenter;
import cn.wmmou.wgank.gank24k.fragment.IGankFragmentView;
import cn.wmmou.wgank.model.GankData;
import cn.wmmou.wgank.net.GankClient;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wmmou on 2017/9/8.
 * e-mail:666@wmmou.cn
 * desc:
 * version:
 */

public class GankFragmentPresenter extends BasePresenter<IGankFragmentView> {
    public GankFragmentPresenter(Context context, IGankFragmentView iView) {
        super(context, iView);
    }
    /**
     * 加载数据
     */
    public void loadData(String type,int page){

        GankClient.getGankRetrofitInstance().getGankData(type,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GankData>() {
                    @Override
                    public void accept(GankData gankData)  {
                        if (gankData.results.size()>0){
                            iView.shouGankData(gankData.results);
                        }else {
                            iView.showNoData();
                        }

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable){
                        iView.showError();
                    }
                });

    }
    @Override
    public void release() {
    }
}
