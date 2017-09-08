package cn.wmmou.wgank.main;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.wmmou.wgank.R;
import cn.wmmou.wgank.model.entity.Gank;
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
//            holder.tvTitle.setText(gank.getDesc());
            Log.i("adaper",gank.getUrl()+gank.getDesc()+gank.getPublishedAt());
//            Glide.with(context)
//                    .load(gank.getUrl())
//                    .crossFade()
//                    .into(holder.imgWeal);
        }
    }
    @Override
    public int getItemCount(){
        return lists.size();
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

    }
}
