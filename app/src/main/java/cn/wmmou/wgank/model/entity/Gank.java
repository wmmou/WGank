package cn.wmmou.wgank.model.entity;

import java.util.Date;

/**
 * Created by wmmou on 2017/9/4.
 * e-mail:666@wmmou.cn
 * desc:
 * version:
 */

public class Gank extends Base {
    /**
     * _id : 59a65dd2421aa901c85e5fe9
     * createdAt : 2017-08-30T14:40:18.444Z
     * desc : Android版ARKit
     * publishedAt : 2017-09-01T12:55:52.582Z
     * source : web
     * type : Android
     * url : https://github.com/google-ar/arcore-android-sdk
     * used : true
     * who : JackHang
     */
    private Date createdAt;
    private String desc;
    private Date publishedAt;
    private String source;

    private String type;
    private String url;
    private boolean used;
    private String who;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }
}
