package entity;

import java.time.LocalDate;

public class Products {
    private String maSP;
    private String tenSP;
    private Suppliers maNCC;
    private Categories maLoai;
    private int soLuongTon;
    private double donGiaMua;
    private double donGiaBan;
    private String donViTinh;
    private double giamGia;
    private LocalDate ngaySX;
    private LocalDate hanSuDung;

    public Products(String maSP) {
        this.maSP = maSP;
    }

    public Products() {
    }

    public Products(String maSP, String tenSP, double donGiaBan, double giamGia) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGiaBan = donGiaBan;
        this.giamGia = giamGia;
    }

    public Products(String maSP, String tenSP, double donGiaBan, String donViTinh) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGiaBan = donGiaBan;
        this.donViTinh = donViTinh;
    }
    
    public Products(String maSP, String tenSP, Suppliers maNCC, Categories maLoai, int soLuongTon, double donGiaMua, double donGiaBan, String donViTinh, double giamGia, LocalDate ngaySX, LocalDate hanSuDung) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.maNCC = maNCC;
        this.maLoai = maLoai;
        this.soLuongTon = soLuongTon;
        this.donGiaMua = donGiaMua;
        this.donGiaBan = donGiaBan;
        this.donViTinh = donViTinh;
        this.giamGia = giamGia;
        this.ngaySX = ngaySX;
        this.hanSuDung = hanSuDung;
    }

    public double getDonGiaMua() {
        return donGiaMua;
    }

    public void setDonGiaMua(double donGiaMua) {
        this.donGiaMua = donGiaMua;
    }

    public double getDonGiaBan() {
        return donGiaBan;
    }

    public void setDonGiaBan(double donGiaBan) {
        this.donGiaBan = donGiaBan;
    }

    

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public Suppliers getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(Suppliers maNCC) {
        this.maNCC = maNCC;
    }

    public Categories getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(Categories maLoai) {
        this.maLoai = maLoai;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

  
    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public double getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(double giamGia) {
        this.giamGia = giamGia;
    }

    public LocalDate getNgaySX() {
        return ngaySX;
    }

    public void setNgaySX(LocalDate ngaySX) {
        this.ngaySX = ngaySX;
    }

    public LocalDate getHanSuDung() {
        return hanSuDung;
    }

    public void setHanSuDung(LocalDate hanSuDung) {
        this.hanSuDung = hanSuDung;
    }
    
}
