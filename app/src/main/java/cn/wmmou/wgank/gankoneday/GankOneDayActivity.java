package cn.wmmou.wgank.gankoneday;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import cn.wmmou.wgank.GankConfig;
import cn.wmmou.wgank.R;
import cn.wmmou.wgank.ToolBarActivity;
import cn.wmmou.wgank.model.entity.Gank;
import cn.wmmou.wgank.utils.ShareElement;

/**
 * Created by wmmou on 2017/9/18.
 * e-mail:666@wmmou.cn
 * desc:
 * version:
 */
public class GankOneDayActivity extends ToolBarActivity<GankOneDayPresenter> implements IGankOneDayView{

    private List<Gank> lists;
    private OneDayAdaper adaper;
    private Calendar calendar;


    @BindView(R.id.recyc_oneday)
    RecyclerView recyclerView;
    @BindView(R.id.img_oneday)
    ImageView img;
    @Override
    protected int getLayoutResId(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
        return R.layout.activity_gankoneday;
    }
    @Override
    protected void initPresenter(){
        presenter=new GankOneDayPresenter(this,this);
        presenter.init();
    }
    @Override
    public void initView(){
        initData();
        lists=new ArrayList<>();
        adaper=new OneDayAdaper(this,lists);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaper);
        img.setImageDrawable(ShareElement.shareDrawable);
        ViewCompat.setTransitionName(img, GankConfig.TRANSLATE_GIRL_VIEW);
    }
    private void  initData(){
        Gank gank = (Gank) getIntent().getSerializableExtra(GankConfig.MEIZI);
        calendar = Calendar.getInstance();
        calendar.setTime(gank.getPublishedAt());
        presenter.fetchGankData(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.DAY_OF_MONTH));
    }
    @Override
    public void shouOneDayData(List<Gank> lists){
        this.lists.addAll(lists);
        adaper.notifyDataSetChanged();
    }
    @Override
    protected void onDestroy(){
        ShareElement.shareDrawable=null;
        super.onDestroy();
    }
}
