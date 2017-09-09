package cn.wmmou.wgank.gank24k;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import butterknife.BindView;
import cn.wmmou.wgank.IBaseView;
import cn.wmmou.wgank.R;
import cn.wmmou.wgank.ToolBarActivity;

/**
 * Created by wmmou on 2017/9/8.
 * e-mail:666@wmmou.cn
 * desc:
 * version:
 */

public class GankActivity extends ToolBarActivity<GankPresenter> implements IBaseView {

    @BindView(R.id.tab_gank)
    TabLayout tabLayout;
    @BindView(R.id.viewpager_gank)
    ViewPager viewPager;

    @Override
    public void initView() {
        GankPagerApdaper pagerApdaper=new GankPagerApdaper(getSupportFragmentManager());
        viewPager.setAdapter(pagerApdaper);
        viewPager.setOffscreenPageLimit(5);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected int getLayoutResId(){
        return R.layout.activity_gank;
    }

    @Override
    protected void initPresenter(){
            presenter=new GankPresenter(this,this);
        presenter.init();
    }
}
