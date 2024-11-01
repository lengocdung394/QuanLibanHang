package dao;

import connectBD.ConnectDB;

import entity.Suppliers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

public class Supplier_DAO {

    public void Supplier_DAO() {

    }

    public ArrayList<Suppliers> getSuppliers() {
        ArrayList<Suppliers> dsSupplier = new ArrayList<>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getCon();
            String spl = "SELECT * FROM NhaCungCap";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(spl);
            //Suppliers(String maNCC, String tenNCC, String diaChi, String quocGia, String thanhPho, String email, String soDT) {
            while (rs.next()) {
                // ma san pham
                String maNCC = rs.getString(1);
                // ten san pham
                String tenNCC = rs.getString(2);
                // ma nha cung cap
                String diaChi = rs.getString(3);
                // ma loai
                String quocGia = rs.getString(4);
                // ma loai
                String thanhPho = rs.getString(5);
                String email = rs.getString(6);
                String soDT = rs.getString(7);
                dsSupplier.add(new Suppliers(maNCC, tenNCC, diaChi, quocGia, thanhPho, email, soDT));

            }
        } catch (SQLException ex) {
            System.out.print("loi ket noi");
            ex.printStackTrace();

        }
        return dsSupplier;
    }

    public boolean find(Suppliers p) {
        ConnectDB.getInstance();
        Connection con = (Connection) ConnectDB.getCon();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean found = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM NhaCungCap WHERE tenNCC = ?");
            stmt.setString(2, p.getTenNCC());
            rs = stmt.executeQuery();
            found = rs.next(); // Kiểm tra xem có bản ghi kết quả hay không
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return found;
    }

    // xoa 
    public boolean remove(Suppliers nv) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getCon();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("delete from" + " NhaCungCap WHERE maNCC=?");
            stmt.setString(1, nv.getMaNCC());
            n = stmt.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
        return n > 0;
    }

    // sua
    public boolean upDate(Suppliers nv) {
        ConnectDB.getInstance();
        Connection con = (Connection) ConnectDB.getCon();
        PreparedStatement stmt = null;
        //   (maNCC, tenNCC, diaChi, quocGia, thanhPho, email, soDT)
        int n = 0;
        try {
            stmt = con.prepareCall(
                    "update NhaCungCap set tenNCC=?," + "diaChi=?, quocGia=?, thanhPho=?, email=?, soDT=?" + " where maNCC=?");
           // stmt.setString(1, nv.getMaNCC());
            stmt.setString(1, nv.getTenNCC());
            stmt.setString(2, nv.getDiaChi());
            stmt.setString(3, nv.getQuocGia());
            stmt.setString(4, nv.getThanhPho());
            stmt.setString(5, nv.getEmail());
            stmt.setString(6, nv.getSoDT());
            stmt.setString(7, nv.getMaNCC());
            n = stmt.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception

            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
        return n > 0;
    }

    public boolean create(Suppliers nv) {

        ConnectDB.getInstance();
        Connection con = (Connection) ConnectDB.getCon();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("insert into NhaCungCap values(?, ?, ?, ?, ?, ?)");
            stmt.setString(1, nv.getTenNCC());
            stmt.setString(2, nv.getDiaChi());
            stmt.setString(3, nv.getQuocGia());
            stmt.setString(4, nv.getThanhPho());
            stmt.setString(5, nv.getEmail());
            stmt.setString(6, nv.getSoDT());

            n = stmt.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();

        } finally {
            try {
                stmt.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
        return n > 0;
    }

    public String getNameBySupplierID(String id) {
    String supName = null;
    try {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getCon();
        String sql = "SELECT tenNCC FROM NhaCungCap WHERE maNCC = ?";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, id);
        ResultSet rs = statement.executeQuery();
       
        if (rs.next()) {
            supName = rs.getString("tenNCC");
        }
        
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return supName;
}
}
