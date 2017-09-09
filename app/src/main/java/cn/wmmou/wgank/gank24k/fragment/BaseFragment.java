package cn.wmmou.wgank.gank24k.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle2.components.support.RxFragment;

import butterknife.ButterKnife;
import cn.wmmou.wgank.BasePresenter;

/**
 * Created by wmmou on 2017/9/8.
 * e-mail:666@wmmou.cn
 * desc:
 * version:
 */
public abstract class BaseFragment<T extends BasePresenter> extends RxFragment {
    protected T presneter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(getLayoutResId(),container,false);
        ButterKnife.bind(this,view);
        initPresenter();
        return view;
    }

    abstract int getLayoutResId();
    abstract void  initPresenter();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.bind(getActivity()).unbind();
    }
}
