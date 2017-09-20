package cn.wmmou.wgank.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import cn.wmmou.wgank.model.entity.Gank;

/**
 * Created by wmmou on 2017/9/19.
 * e-mail:666@wmmou.cn
 * desc:
 * version:
 */

public class SPDataUtil {
    private static final String GANK = "gank";
    private static final String GIRLS = "girls";
    private static final String IS_FIRST_OPEN = "is_first_open";
    private static Gson gson = new Gson();

    public static boolean saveFirstPageGirls(Context context, List<Gank> girls) {//保存第一页数据
        SharedPreferences preferences = context.getSharedPreferences(GANK, Context.MODE_PRIVATE);
        return preferences.edit().putString(GIRLS, gson.toJson(girls)).commit();
    }

    public static List<Gank> getFirstPageGirls(Context context) {//获取第一页数据
        SharedPreferences preferences = context.getSharedPreferences(GANK, Context.MODE_PRIVATE);
        return gson.fromJson(preferences.getString(GIRLS, ""), new TypeToken<List<Gank>>() {
        }.getType());
    }
}
