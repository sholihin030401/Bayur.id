package com.project.ichwan.bayurid.produk;

public class ProdukItem {
    String namaproduk;
    String desproduk;
    String hargaproduk;
    String stokproduk;
    String fotoproduk;

    public ProdukItem(String namaproduk, String desproduk, String hargaproduk, String stokproduk, String fotoproduk) {
        this.namaproduk = namaproduk;
        this.desproduk = desproduk;
        this.hargaproduk = hargaproduk;
        this.stokproduk = stokproduk;
        this.fotoproduk = fotoproduk;
    }

    public String getNamaproduk() {
        return namaproduk;
    }

    public void setNamaproduk(String namaproduk) {
        this.namaproduk = namaproduk;
    }

    public String getDesproduk() {
        return desproduk;
    }

    public void setDesproduk(String desproduk) {
        this.desproduk = desproduk;
    }

    public String getHargaproduk() {
        return hargaproduk;
    }

    public void setHargaproduk(String hargaproduk) {
        this.hargaproduk = hargaproduk;
    }

    public String getStokproduk() {
        return stokproduk;
    }

    public void setStokproduk(String stokproduk) {
        this.stokproduk = stokproduk;
    }

    public String getFotoproduk() {
        return fotoproduk;
    }

    public void setFotoproduk(String fotoproduk) {
        this.fotoproduk = fotoproduk;
    }
}
