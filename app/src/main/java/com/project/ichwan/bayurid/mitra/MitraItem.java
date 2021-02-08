package com.project.ichwan.bayurid.mitra;

import android.os.Parcel;
import android.os.Parcelable;

public class MitraItem implements Parcelable {
    String namamitra;
    String alamatmitra;
    String nohp;
    String itemproduk;
    String stok;

    public MitraItem(String namamitra, String alamatmitra, String nohp, String itemproduk, String stok) {
        this.namamitra = namamitra;
        this.alamatmitra = alamatmitra;
        this.nohp = nohp;
        this.itemproduk = itemproduk;
        this.stok = stok;
    }

    public MitraItem() {

    }

    protected MitraItem(Parcel in) {
        namamitra = in.readString();
        alamatmitra = in.readString();
        nohp = in.readString();
        itemproduk = in.readString();
        stok = in.readString();
    }

    public static final Creator<MitraItem> CREATOR = new Creator<MitraItem>() {
        @Override
        public MitraItem createFromParcel(Parcel in) {
            return new MitraItem(in);
        }

        @Override
        public MitraItem[] newArray(int size) {
            return new MitraItem[size];
        }
    };

    public String getNamamitra() {
        return namamitra;
    }

    public void setNamamitra(String namamitra) {
        this.namamitra = namamitra;
    }

    public String getAlamatmitra() {
        return alamatmitra;
    }

    public void setAlamatmitra(String alamatmitra) {
        this.alamatmitra = alamatmitra;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public String getItemproduk() {
        return itemproduk;
    }

    public void setItemproduk(String itemproduk) {
        this.itemproduk = itemproduk;
    }

    public String getStok() {
        return stok;
    }

    public void setStok(String stok) {
        this.stok = stok;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(namamitra);
        parcel.writeString(alamatmitra);
        parcel.writeString(nohp);
        parcel.writeString(itemproduk);
        parcel.writeString(stok);
    }
}
