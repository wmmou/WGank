package cn.wmmou.wgank.gank24k.fragment;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.wmmou.wgank.R;
import cn.wmmou.wgank.model.entity.Gank;
import cn.wmmou.wgank.web.WebActivity;

/**
 * Created by wmmou on 2017/9/8.
 * e-mail:666@wmmou.cn
 * desc:
 * version:
 */

public class GankAdaper extends RecyclerView.Adapter<GankAdaper.GankViewHolder> {
    private Context context;
    private List<Gank> datas;
    public GankAdaper(Context context, List<Gank> datas) {
        this.context = context;
        this.datas = datas;
    }
    @Override
    public GankViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gank,parent,false);
        return new GankViewHolder(view);
    }
    @Override
    public void onBindViewHolder(GankViewHolder holder, int position){
        Gank gank=datas.get(position);
        holder.itemView.setTag(gank);
        String gankStr = gank.getDesc() + " @" + gank.getWho();
        SpannableString spannableString = new SpannableString(gankStr);
        spannableString.setSpan(new RelativeSizeSpan(0.8f),gank.getDesc().length()+1,gankStr.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new ForegroundColorSpan(Color.GRAY),gank.getDesc().length()+1,gankStr.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        holder.tvDescWithWho.setText(spannableString);
    }
    @Override
    public int getItemCount(){
        return datas.size();
    }
    class GankViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_desc_with_who_gank)
        TextView tvDescWithWho;
        public GankViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
        @OnClick(R.id.tv_desc_with_who_gank)
        void  onClick(){
            WebActivity.loadWebViewActivity(context, (Gank) itemView.getTag());
        }
    }
}
