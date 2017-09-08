package cn.wmmou.wgank.main;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by wmmou on 2017/9/5.
 * e-mail:666@wmmou.cn
 * desc:
 * version:
 */

public class RatioImageView extends ImageView {
    private int width;
    private int height;
    public RatioImageView(Context context) {
        super(context);
    }

    public RatioImageView(Context context,  AttributeSet attrs) {
        super(context, attrs);
    }

    public RatioImageView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public void setsSize(int width,int height){
        this.width=width;
        this.height=height;
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (width>0&&height>0){
            float ratio=(float)width/(float)height;
            int w= MeasureSpec.getSize(widthMeasureSpec);
            int h=MeasureSpec.getSize(heightMeasureSpec);
            if (w>0){
                h= (int)((float)w/ratio);
            }
            setMeasuredDimension(w,h);
        }else {
            super.onMeasure(widthMeasureSpec,heightMeasureSpec);
        }
    }
}
