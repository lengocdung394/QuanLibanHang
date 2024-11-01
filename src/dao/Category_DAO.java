
package dao;

import connectBD.ConnectDB;
import entity.Categories;
import entity.Suppliers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Category_DAO {
    
    public boolean find(Categories p) {
        ConnectDB.getInstance();
        Connection con = (Connection) ConnectDB.getCon();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean found = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM LoaiSanPham WHERE maLoai = ?");
            stmt.setString(1, p.getCategoryID());
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

   public String getNameByCategoryID(String id) {
    String categoryName = null;
    try {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getCon();
        String sql = "SELECT tenLoai FROM LoaiSanPham WHERE maLoai = ?";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, id);
        ResultSet rs = statement.executeQuery();
       
        if (rs.next()) {
            categoryName = rs.getString("tenLoai");
        }
        
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return categoryName;
}

    public ArrayList<Categories> getCategories() {
        ArrayList<Categories> dsCategory = new ArrayList<>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getCon();
            String spl = "SELECT * FROM LoaiSanPham";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(spl);
           
            while (rs.next()) {
               
                String maLoai = rs.getString(1);
              
                String tenLoai= rs.getString(2);
           
                String moTa = rs.getString(3);
              
               
                dsCategory.add(new Categories(maLoai, tenLoai, moTa));

            }
        } catch (SQLException ex) {
            System.out.print("loi ket noi");
            ex.printStackTrace();

        }
        return dsCategory;
    }
    public boolean create(Suppliers nv) {

        ConnectDB.getInstance();
        Connection con = (Connection) ConnectDB.getCon();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("insert into" + "NhaCungCap values(?, ?, ?, ?, ?, ?,?)");
            stmt.setString(1, nv.getMaNCC());
            stmt.setString(2, nv.getTenNCC());
            stmt.setString(3, nv.getDiaChi());
            stmt.setString(4, nv.getQuocGia());
            stmt.setString(5, nv.getThanhPho());
            stmt.setString(6, nv.getEmail());
            stmt.setString(7, nv.getSoDT());
            
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

   
}
