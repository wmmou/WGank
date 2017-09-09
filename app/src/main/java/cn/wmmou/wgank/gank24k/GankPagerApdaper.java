package cn.wmmou.wgank.gank24k;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import cn.wmmou.wgank.gank24k.fragment.GankFragment;

/**
 * Created by wmmou on 2017/9/8.
 * e-mail:666@wmmou.cn
 * desc:
 * version:
 */

public class GankPagerApdaper extends FragmentStatePagerAdapter {
    String[] title={"Android","iOS","App","前端","瞎推荐","拓展资源"};

    public GankPagerApdaper(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new GankFragment().newInstance(title[position]);
    }
    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
