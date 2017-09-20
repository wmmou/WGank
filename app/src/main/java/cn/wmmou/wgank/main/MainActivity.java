package cn.wmmou.wgank.main;
import android.app.Activity;
import android.os.Build;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.wmmou.wgank.BaseActivity;
import cn.wmmou.wgank.R;
import cn.wmmou.wgank.ToolBarActivity;
import cn.wmmou.wgank.model.entity.Gank;
import cn.wmmou.wgank.utils.SPDataUtil;
import cn.wmmou.wgank.utils.StatusBarUtil;
import cn.wmmou.wgank.view.LoadMoreRecyclerView;
import dalvik.system.PathClassLoader;
public class MainActivity extends ToolBarActivity<MainPresenter> implements IMainView, SwipeRefreshLayout.OnRefreshListener, LoadMoreRecyclerView.LoadMoreListener {
    @BindView(R.id.fab_btn)
    FloatingActionButton fab;
    @BindView(R.id.recycler_view)
    LoadMoreRecyclerView recyclerView;
    @BindView(R.id.swipeRefresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    MainAdaper adaper;
    List<Gank> ganks;
    int page = 1;
    boolean isrefresh = true;
    boolean canLoading = true;
    private MainPresenter presenter;

    @OnClick(R.id.fab_btn)
    void  toGank(){
        presenter.toGankActiivty();
    }
    @Override
    protected int getLayoutResId(){
        return R.layout.activity_main;
    }
    @Override
    protected void initPresenter(){
        Log.i(TAG, "initPresenter()");
        presenter = new MainPresenter(this, this);
        presenter.init();
    }
    @Override
    public void initView(){

        StatusBarUtil.StatusBarLightMode(this);
        Log.i(TAG, "initview()");

        ganks = SPDataUtil.getFirstPageGirls(this);
        if (ganks==null)
            ganks = new ArrayList<>();
        adaper = new MainAdaper(ganks, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adaper);
        recyclerView.setFloatingActionButton(fab);
        recyclerView.setListener(this);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent, R.color.md_blue_400);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.post(new Runnable(){
            @Override
            public void run(){
                swipeRefreshLayout.setRefreshing(true);
                presenter.fetchGankData(page);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected boolean canBack() {
        return false;
    }
    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh(){
        isrefresh = true;
        page = 1;
        presenter.fetchGankData(page);
    }
    /**
     * 加载更多
     */
    @Override
    public void loadMore(){
        if (canLoading){
            presenter.fetchGankData(page);
            canLoading = false;
        }
    }
    @Override
    public void statusColor(boolean iswhite){
        if(iswhite){
            StatusBarUtil.StatusBarLightMode(this);
            StatusBarUtil.setStatusBarColor(this,R.color.md_white);
        }else {
            StatusBarUtil.setStatusBarColor(this,R.color.md_deep_orange_400);
            StatusBarUtil.StatusBarLightMode(this);
        }
    }
    @Override
    public void shouGankData(List<Gank> list){
        Log.i(TAG, "shouGankData()--list" + list.size());
        canLoading = true;
        page++;
        if (isrefresh){
            SPDataUtil.saveFirstPageGirls(this, list);
            isrefresh = false;
            ganks.clear();
            ganks.addAll(list);
            adaper.notifyDataSetChanged();
        }else{
            ganks.addAll(list);
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
//    Activity
}
