package cn.wmmou.wgank.view;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;

import cn.wmmou.wgank.R;
import cn.wmmou.wgank.utils.StatusBarUtil;

/**
 * Created by wmmou on 2017/9/4.
 * e-mail:666@wmmou.cn
 * desc:
 * version:
 */
public class LoadMoreRecyclerView extends RecyclerView {
    private LoadMoreListener listener;
    private FloatingActionButton floatingActionButton;
    private boolean isScrollingToDown=true;

    public LoadMoreRecyclerView(Context context) {
        super(context);
    }
    public LoadMoreRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    public LoadMoreRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    public void setListener(LoadMoreListener listener) {
        this.listener = listener;
    }
    public void setFloatingActionButton(FloatingActionButton floatingActionButton) {
        this.floatingActionButton = floatingActionButton;
    }
    @Override
    public void onScrolled(int dx, int dy){
        isScrollingToDown=dy>0;
        if (floatingActionButton!=null){
            if (isScrollingToDown){
                if (floatingActionButton.isShown())
                    floatingActionButton.hide();
                if (listener!=null)
                    listener.statusColor(true);
            }else {
                if (!floatingActionButton.isShown())
                    floatingActionButton.show();
                if (listener!=null)
                    listener.statusColor(false);
            }
        }
    }
    @Override
    public void onScrollStateChanged(int screenState){
        LinearLayoutManager layoutManager= (LinearLayoutManager) getLayoutManager();
        if (screenState==RecyclerView.SCROLL_STATE_IDLE){
            int lastItem=layoutManager.findLastCompletelyVisibleItemPosition();
            int allItem=layoutManager.getItemCount();
            if (lastItem==(allItem-1)&&isScrollingToDown){
                if (listener!=null)
                    listener.loadMore();
            }
        }
    }
    public interface LoadMoreListener{
        void loadMore();
        void statusColor(boolean iswhite);
    }

}
