package com.project.ichwan.bayurid.home;

import android.os.Parcel;
import android.os.Parcelable;

public class ArtikelItem implements Parcelable {
    String title, content;

    public ArtikelItem(String title, String content) {
        this.title = title;
        this.content = content;
    }

    protected ArtikelItem(Parcel in) {
        title = in.readString();
        content = in.readString();
    }

    public static final Creator<ArtikelItem> CREATOR = new Creator<ArtikelItem>() {
        @Override
        public ArtikelItem createFromParcel(Parcel in) {
            return new ArtikelItem(in);
        }

        @Override
        public ArtikelItem[] newArray(int size) {
            return new ArtikelItem[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(content);
    }
}
