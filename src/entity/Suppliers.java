package entity;

public class Suppliers {
    private String maNCC;
    private String tenNCC;
    private String diaChi;
    private String quocGia;
    private String thanhPho;
    private String email;
    private String soDT;

    public Suppliers() {
    }

    public Suppliers(String maNCC) {
        this.maNCC = maNCC;
    }

    public Suppliers(String maNCC, String tenNCC, String diaChi, String quocGia, String thanhPho, String email, String soDT) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.diaChi = diaChi;
        this.quocGia = quocGia;
        this.thanhPho = thanhPho;
        this.email = email;
        this.soDT = soDT;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    public String getThanhPho() {
        return thanhPho;
    }

    public void setThanhPho(String thanhPho) {
        this.thanhPho = thanhPho;
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
