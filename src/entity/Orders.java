package entity;

import java.time.LocalDate;

public class Orders {
    private String maHD;
    private Employees maNV;
    private LocalDate ngayLap;
    private double thanhTien;
    private double thueVAT;

    public Orders(String maHD) {
        this.maHD = maHD;
    }

    public Orders() {
    }
    
    public Orders(String maHD, Employees maNV, LocalDate ngayLap, double thanhTien, double thueVAT) {
        this.maHD = maHD;
        this.maNV = maNV;

        this.ngayLap = ngayLap;
        this.thanhTien = thanhTien;
        this.thueVAT = thueVAT;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public Employees getMaNV() {
        return maNV;
    }

    public void setMaNV(Employees maNV) {
        this.maNV = maNV;
    }


    public LocalDate getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(LocalDate ngayLap) {
        this.ngayLap = ngayLap;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public double getThueVAT() {
        return thueVAT;
    }

    public void setThueVAT(double thueVAT) {
        this.thueVAT = thueVAT;
    }
    
}
