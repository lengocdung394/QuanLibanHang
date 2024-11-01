package entity;

public class OrderDetails {
    private Orders maHD;
    private Products maSP;
    private int soLuong;

    public OrderDetails() {
    }

    public OrderDetails(Products maSP, int soLuong) {
        this.maSP = maSP;
        this.soLuong = soLuong;
    }
    
    public OrderDetails(Orders maHD, Products maSP, int soLuong) {
        this.maHD = maHD;
        this.maSP = maSP;
        this.soLuong = soLuong;
    }

    public Orders getMaHD() {
        return maHD;
    }

    public void setMaHD(Orders maHD) {
        this.maHD = maHD;
    }

    public Products getMaSP() {
        return maSP;
    }

    public void setMaSP(Products maSP) {
        this.maSP = maSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    public double tinhTien(){
        return soLuong*maSP.getDonGiaBan() - soLuong*maSP.getDonGiaBan()*maSP.getGiamGia();
    }

    
}
