package cn.wmmou.wgank.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * Created by wmmou on 2017/9/4.
 * e-mail:666@wmmou.cn
 * desc:
 * version:
 */
public class GankClient {
    public static final String HOST = "http://gank.io/api/";
    private static Api gankRetrofit;
    private static Retrofit retrofit;
    private GankClient(){
    }
    static{
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(HOST)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
    public static Api getGankRetrofitInstance(){
        if (gankRetrofit==null){
            synchronized (GankClient.class){
                if (gankRetrofit==null){
                    gankRetrofit=retrofit.create(Api.class);
                }
            }
        }
        return gankRetrofit;
    }

}
