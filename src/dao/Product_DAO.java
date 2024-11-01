package dao;

import connectBD.ConnectDB;
import entity.Categories;
import entity.Products;
import entity.Suppliers;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class Product_DAO {

    public Products getTableAddToOrderDetail(String id) {
        try {
            ConnectDB.getInstance().connect();
            Connection con = ConnectDB.getCon();
            String sql = "SELECT maSanPham, tenSanPham, donGiaBan, giamGia FROM SanPham WHERE maSanPham = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String productId = rs.getString("maSanPham");
                String productName = rs.getString("tenSanPham");
                double unitPrice = rs.getDouble("donGiaBan");
                double discount = rs.getDouble("giamGia");

                // Tạo đối tượng Products
                Products product = new Products(productId, productName, unitPrice, discount);
                return product;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void updateProductQuantity(String productId, int quantity) {
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getCon();
            String sql = "UPDATE SanPham SET soLuongTon = ? WHERE maSanPham = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, quantity);
            pstmt.setString(2, productId);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public int getQuantityByID(String productId) {
        int quantity = 0;
        try {
            // Đảm bảo kết nối đã được thiết lập trước khi thực hiện truy vấn
            ConnectDB.getInstance().connect();
            Connection con = ConnectDB.getCon();
            String sql = "SELECT soLuongTon FROM SanPham WHERE maSanPham = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, productId);
            ResultSet rs = pstmt.executeQuery();

            // Kiểm tra xem có kết quả trả về không
            if (rs.next()) {
                quantity = rs.getInt("soLuongTon"); // Lấy giá trị số lượng từ kết quả truy vấn
            }

            // Đóng tất cả các tài nguyên
            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return quantity; // Trả về số lượng sản phẩm
    }

    public ArrayList<Products> getTableProduct() {
        ArrayList<Products> dsProduct = new ArrayList<>();

        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getCon();
            String spl = "SELECT * FROM SanPham";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(spl);
            //(String maSP, String tenSP, Suppliers maNCC, Categories maLoai, 
            //int soLuongTon, double donGia, String donViTinh, double giamGia, LocalDate ngaySX, LocalDate hanSuDung) 
            // (maSanPham, tenSanPham, maNCC , maLoai , soLuongTon, donGia, donViTinh, giamGia, ngaySanXuat, hanSuDung)
            while (rs.next()) {

                // ma san pham
                String productID = rs.getString("maSanPham");
                // ten san pham
                String productName = rs.getString("tenSanPham");
                // ma nha cung cap
                String supplierID = rs.getString("maNCC");

                Suppliers sp = new Suppliers(supplierID);
                // ma loai
                String categoryID = rs.getString("maLoai");
                Categories cate = new Categories(categoryID);
                // so luong 
                int unitlnStock = rs.getInt("soLuongTon");
                double price = rs.getDouble("donGiaMua");
                double unitPrice = rs.getDouble("donGiaBan");
                // don vi tinh     
                String quantityPerUnit = rs.getString("donViTinh");

                // giam gia
                double discount = Double.parseDouble(rs.getString("giamGia"));
                //ngay san xuat

                Date manufactureDate = rs.getDate(10);
                // han su dung
                Date expiryDate = rs.getDate(11);
                LocalDate localManufactureDate = null;
                if (manufactureDate != null) {
                    localManufactureDate = manufactureDate.toLocalDate();
                }

                LocalDate localExpiryDate = null;
                if (expiryDate != null) {
                    localExpiryDate = expiryDate.toLocalDate();
                }

                //(String maSP, String tenSP, Suppliers maNCC, Categories maLoai, 
                //int soLuongTon, double donGia, String donViTinh, double giamGia, LocalDate ngaySX, LocalDate hanSuDung)
                dsProduct.add(new Products(productID, productName, sp, cate, unitlnStock, price, unitPrice, quantityPerUnit, discount, localExpiryDate, localManufactureDate));
            }
        } catch (SQLException ex) {

            ex.printStackTrace();

        }
        return dsProduct;
    }

    public Product_DAO() {
    }

    public boolean find(Products p) {
        ConnectDB.getInstance();
        Connection con = (Connection) ConnectDB.getCon();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean found = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM SanPham WHERE productID = ?");
            stmt.setString(1, p.getMaSP());
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

    public void Product_DAO() {

    }

    // xoa 
    public boolean remove(String id) {
        ConnectDB.getInstance();
        Connection con = (Connection) ConnectDB.getCon();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("DELETE FROM SanPham WHERE maSanPham=?");
            stmt.setString(1, id);
            n = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return n > 0;
    }

    public boolean update(Products nv) {
        ConnectDB.getInstance();
        Connection con = (Connection) ConnectDB.getCon();
        PreparedStatement stmt = null;
        int n = 0;

        try {
            stmt = con.prepareStatement(
                    "UPDATE SanPham SET tenSanPham=?, maNCC=?, maLoai=?, soLuongTon=?, donGiaMua=?, donGiaBan=?, donViTinh=?, giamGia=?, ngaySanXuat=?, hanSuDung=? WHERE maSanPham=?");

            stmt.setString(1, nv.getTenSP());
            stmt.setString(2, nv.getMaNCC().getMaNCC());
            stmt.setString(3, nv.getMaLoai().getCategoryID());
            stmt.setInt(4, nv.getSoLuongTon());
            stmt.setDouble(5, nv.getDonGiaMua());
            stmt.setDouble(6, nv.getDonGiaBan());
            stmt.setString(7, nv.getDonViTinh());
            stmt.setDouble(8, nv.getGiamGia());

            LocalDate currentDate = nv.getNgaySX();

            if (currentDate != null) {
                java.sql.Date sqlDate = java.sql.Date.valueOf(currentDate);
                stmt.setDate(9, sqlDate);
            } else {
                stmt.setDate(9, null);
            }

            LocalDate currentDate1 = nv.getHanSuDung();

            if (currentDate1 != null) {
                java.sql.Date sqlDate1 = java.sql.Date.valueOf(currentDate1);
                stmt.setDate(10, sqlDate1);

            } else {
                stmt.setDate(10, null);
            }

            // Thêm tham số cho điều kiện WHERE
            stmt.setString(11, nv.getMaSP());

            n = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return n > 0;
    }

    public boolean create(Products nv) {
        Connection con = null;
        PreparedStatement stmt = null;
        int n = 0;
        try {
            con = ConnectDB.getCon();
            stmt = con.prepareStatement("INSERT INTO SanPham (tenSanPham, maNCC, maLoai, soLuongTon, donGiaMua, donGiaBan, donViTinh, giamGia, ngaySanXuat, hanSuDung) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, nv.getTenSP());
            stmt.setString(2, nv.getMaNCC().getMaNCC());
            stmt.setString(3, nv.getMaLoai().getCategoryID());
            stmt.setInt(4, nv.getSoLuongTon());
            stmt.setDouble(5, nv.getDonGiaMua());
            stmt.setDouble(6, nv.getDonGiaBan());
            stmt.setString(7, nv.getDonViTinh());
            stmt.setDouble(8, nv.getGiamGia());
            stmt.setDate(9, java.sql.Date.valueOf(nv.getNgaySX()));
            stmt.setDate(10, java.sql.Date.valueOf(nv.getHanSuDung()));
            n = stmt.executeUpdate();

        } catch (SQLException e) {
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
