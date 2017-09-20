package cn.wmmou.wgank.gankoneday;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.wmmou.wgank.R;
import cn.wmmou.wgank.model.entity.Gank;
import cn.wmmou.wgank.utils.StringStyleUtil;
import cn.wmmou.wgank.web.WebActivity;

/**
 * Created by wmmou on 2017/9/19.
 * e-mail:666@wmmou.cn
 * desc:
 * version:
 */
public class OneDayAdaper extends RecyclerView.Adapter<OneDayAdaper.OneViewHolder> {
    private Context context;
    private List<Gank> lists;
    public OneDayAdaper(Context context, List<Gank> lists) {
        this.context = context;
        this.lists = lists;
    }
    @Override
    public OneViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_oneday,parent,false);
        return new OneViewHolder(view);
    }
    @Override
    public void onBindViewHolder(OneViewHolder holder, int position){
        Gank gank=lists.get(position);
        holder.itemView.setTag(gank);
        if (position == 0){
            showCategory(true, holder.tvCategory);
        } else {
            if (lists.get(position).getType().equals(lists.get(position - 1).getType())){
                showCategory(false, holder.tvCategory);
            } else {
                showCategory(true, holder.tvCategory);
            }
        }
        holder.tvCategory.setText(gank.getType());
        holder.tvGankDesc.setText(StringStyleUtil.getGankStyleStr(gank));
    }
    private void showCategory(boolean show, TextView tvCategory){
        if(show){
            tvCategory.setVisibility(View.VISIBLE);
        }else{
            tvCategory.setVisibility(View.GONE);
        }
    }
    @Override
    public int getItemCount(){
        return lists.size();
    }
    class OneViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_category)
        TextView tvCategory;
        @BindView(R.id.tv_gank_desc)
        TextView tvGankDesc;
        @BindView(R.id.ll_gank)
        LinearLayout llGank;
        @OnClick(R.id.ll_gank)
        void gankClick(){
            WebActivity.loadWebViewActivity(context,(Gank)itemView.getTag());
        }
        public OneViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }


}
