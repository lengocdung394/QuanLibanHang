package entity;

import java.time.LocalDate;


public class Employees {
    private String maNV;
    private String hoNV;
    private String tenNV;
    private LocalDate ngaySinh;
    private String cccd;
    private String diaChi;
    private boolean gioiTinh;
    private String email;
    private String soDT;

    public Employees() {
    }

    public Employees(String maNV) {
        this.maNV = maNV;
    }
    
    public Employees(String maNV, String hoNV, String tenNV, LocalDate ngaySinh, String cccd, String diaChi, boolean gioiTinh, String email, String soDT) {
        this.maNV = maNV;
        this.hoNV = hoNV;
        this.tenNV = tenNV;
        this.ngaySinh = ngaySinh;
        this.cccd = cccd;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.soDT = soDT;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoNV() {
        return hoNV;
    }

    public void setHoNV(String hoNV) {
        this.hoNV = hoNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }
}
