package com.example.demo_mybatis.entity;

import java.util.Date;
import java.sql.Timestamp;

public class Manga {
    int mId;
    String mName;
    String mDesc;
    Date mTime;
    String mDir;
    User uploader;

    @Override
    public String toString() {
        return "Manga{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mDesc='" + mDesc + '\'' +
                ", mTime=" + mTime +
                ", mDir='" + mDir + '\'' +
                ", uploader=" + uploader +
                '}';
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDesc() {
        return mDesc;
    }

    public void setmDesc(String mDesc) {
        this.mDesc = mDesc;
    }

    public Date getmTime() {
        return mTime;
    }

    public void setmTime(Date mTime) {
        this.mTime = mTime;
    }

    public String getmDir() {
        return mDir;
    }

    public void setmDir(String mDir) {
        this.mDir = mDir;
    }

    public User getUploader() {
        return uploader;
    }

    public void setUploader(User uploader) {
        this.uploader = uploader;
    }
}
