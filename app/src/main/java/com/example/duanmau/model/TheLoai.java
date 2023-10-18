package com.example.duanmau.model;

public class TheLoai {
    private int maLoai;
    private String tenloai;

    public TheLoai(int maLoai, String tenloai) {
        this.maLoai = maLoai;
        this.tenloai = tenloai;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

}
