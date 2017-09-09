package cn.wmmou.wgank.gank24k.fragment;

import android.animation.TypeEvaluator;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.wmmou.wgank.R;
import cn.wmmou.wgank.model.entity.Gank;
import cn.wmmou.wgank.view.LoadMoreRecyclerView;

/**
 * Created by wmmou on 2017/9/8.
 * e-mail:666@wmmou.cn
 * desc:
 * version:
 */

public class GankFragment extends BaseFragment<GankFragmentPresenter> implements IGankFragmentView,SwipeRefreshLayout.OnRefreshListener,LoadMoreRecyclerView.LoadMoreListener {

    private static final String TYPE="type";
    private String type;
    private GankAdaper adaper;
    private List<Gank> datas;
    private int page=1;
    private boolean isRefresh=true;
    private boolean canLoading=true;

    @BindView(R.id.recycler_view)
    LoadMoreRecyclerView recyclerView;
    @BindView(R.id.swipeRefresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    public static GankFragment newInstance(String type){
        GankFragment fragment = new GankFragment();
        Bundle args = new Bundle();
        args.putString(TYPE, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initView(){
        type=getArguments().getString(TYPE);
        datas=new ArrayList<>();
        adaper=new GankAdaper(getContext(),datas);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adaper);
        recyclerView.setListener(this);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                presneter.loadData(type,page);
            }
        });
    }
    @Override
    public void shouGankData(List<Gank> list){
        page++;
        canLoading=true;
        if (isRefresh){
            isRefresh=false;
            datas.clear();
            datas.addAll(list);
            adaper.notifyDataSetChanged();
            page=1;
        }else {
            datas.addAll(list);
            adaper.notifyDataSetChanged();
        }
    }

    @Override
    public void showProgress(){
        if (!swipeRefreshLayout.isRefreshing())
            swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideProgress(){
        if (swipeRefreshLayout.isRefreshing())
            swipeRefreshLayout.setRefreshing(false);

    }

    @Override
    public void showError(){

    }

    @Override
    public void showNoData(){

    }

    @Override
    int getLayoutResId(){
        return R.layout.fragment_gank;
    }

    @Override
    void initPresenter(){
        presneter=new GankFragmentPresenter(getContext(),this);
        presneter.init();
    }


    @Override
    public void onRefresh(){

    }

    @Override
    public void loadMore(){

    }

    @Override
    public void statusColor(boolean iswhite){

    }

}
