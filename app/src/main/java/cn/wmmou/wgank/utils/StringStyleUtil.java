package cn.wmmou.wgank.utils;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;

import cn.wmmou.wgank.model.entity.Gank;

/**
 * Created by wmmou on 2017/9/19.
 * e-mail:666@wmmou.cn
 * desc:
 * version:
 */

public class StringStyleUtil {
    private StringStyleUtil() {
    }
    public static SpannableString getGankStyleStr(Gank gank) {
        String gankStr = gank.getDesc() + " @" + gank.getWho();
        SpannableString spannableString = new SpannableString(gankStr);
        spannableString.setSpan(new RelativeSizeSpan(0.8f), gank.getDesc().length() + 1, gankStr.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new ForegroundColorSpan(Color.GRAY), gank.getDesc().length() + 1, gankStr.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        return spannableString;
    }


//    SpannableString spannableString = new SpannableString(gankStr);
//        spannableString.setSpan(new RelativeSizeSpan(0.8f),gank.getDesc().length()+1,gankStr.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
//        spannableString.setSpan(new ForegroundColorSpan(Color.GRAY),gank.getDesc().length()+1,gankStr.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
//        holder.tvDescWithWho.setText(spannableString);
}
