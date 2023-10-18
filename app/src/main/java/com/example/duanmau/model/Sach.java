package com.example.duanmau.model;

public class Sach {
    private int maSach;
    private String tenSach;
    private int giaThue;
    private int maLoai;
    private String tenLoai;
    private int SoLanMuon;


    public Sach(int maSach, String tenSach, int giaThue, int maLoai ,String tenLoai) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.giaThue = giaThue;
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
    }
    public Sach(int MaSach, String TenSach, int soLanMuon) {
        maSach = MaSach;
        tenSach = TenSach;
        SoLanMuon = soLanMuon;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public int getGiaThue() {
        return giaThue;
    }

    public void setGiaThue(int giaThue) {
        this.giaThue = giaThue;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }
    public int getSoLanMuon() {
        return SoLanMuon;
    }

}
