package cn.wmmou.wgank.main;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.tencent.smtt.sdk.TbsVideo;

import java.io.Serializable;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.wmmou.wgank.GankConfig;
import cn.wmmou.wgank.R;
import cn.wmmou.wgank.gank24k.GankActivity;
import cn.wmmou.wgank.gankoneday.GankOneDayActivity;
import cn.wmmou.wgank.model.entity.Gank;
import cn.wmmou.wgank.utils.ShareElement;
import cn.wmmou.wgank.web.WebActivity;

/**
 * Created by wmmou on 2017/9/5.
 * e-mail:666@wmmou.cn
 * desc:
 * version:
 */
public class MainAdaper extends RecyclerView.Adapter<MainAdaper.MianViewHolder>{
    List<Gank> lists;
    Context context;
    public MainAdaper(List<Gank> lists, Context context){
        this.lists = lists;
        this.context = context;
    }
    @Override
    public MianViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weal,parent,false);
        return new MianViewHolder(view);
    }
    @Override
    public void onBindViewHolder(MianViewHolder holder, int position){
        Gank gank=lists.get(position);
        int red= (int) (Math.random()*255);
        int green= (int) (Math.random()*255);
        int blue= (int) (Math.random()*255);
        holder.imgWeal.setBackgroundColor(Color.argb(200,red,green,blue));
        if (gank!=null){
            holder.cardView.setTag(gank);
            holder.tvTime.setText(gank.getDesc());
            Log.i("adaper",gank.getUrl()+gank.getDesc()+gank.getPublishedAt());
            Glide.with(context)
                    .load(gank.getUrl())
                    .crossFade()
                    .centerCrop()
                    .into(holder.imgWeal);
        }
    }
    @Override
    public int getItemCount(){
        return lists.size();
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
    class MianViewHolder extends RecyclerView.ViewHolder{
        View cardView;
        public MianViewHolder(View itemView){
            super(itemView);
            cardView=itemView;
            ButterKnife.bind(this,itemView);
            imgWeal.setsSize(300,150);//设置宽高
        }
        @BindView(R.id.time_tv)
        TextView tvTime;
        @BindView(R.id.title_tv)
        TextView tvTitle;
        @BindView(R.id.weal_img)
        RatioImageView imgWeal;
        @OnClick(R.id.root_car)
        void onClick(){
//            WebActivity.loadWebViewActivity(context, (Gank) cardView.getTag());
//            Bundle data = new Bundle();
//            data.putBoolean("standardFullScreen", false);// true表示标准全屏，false表示X5全屏；不设置默认false，
//            data.putBoolean("supportLiteWnd", true);// false：关闭小窗；true：开启小窗；不设置默认true，
//            data.putInt("DefaultVideoScreen", 1);// 1：以页面内开始播放，2：以全屏开始播放；不设置默认：1
//            TbsVideo.openVideo(context,"http://rbv01.ku6.com/FbWgxVgcAki2ntV94N5t3g.mp4",data);
//            TbsVideo.openVideo(context,"http://rbv01.ku6.com/FbWgxVgcAki2ntV94N5t3g.mp4",data);
//            Intent intent=new Intent(context, GankOneDayActivity.class);
//            context.startActivity(intent);
            ShareElement.shareDrawable=imgWeal.getDrawable();
            Intent intent = new Intent(context, GankOneDayActivity.class);
            intent.putExtra(GankConfig.MEIZI, (Serializable) cardView.getTag());
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat
                    .makeSceneTransitionAnimation((Activity) context, imgWeal, GankConfig.TRANSLATE_GIRL_VIEW);
            ActivityCompat.startActivity((Activity) context, intent, optionsCompat.toBundle());
    }
    }
}
