package dao;

import connectBD.ConnectDB;
import entity.OrderDetails;
import entity.Orders;
import entity.Products;
import entity.Suppliers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class OrderDetail_DAO {

    public void createOrderDetail(String maHD, String maSP, int soLuong) {
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getCon();

            // Chuẩn bị câu lệnh SQL
            String sql = "INSERT INTO ChiTietHoaDon (maHD, maSanPham, soLuong) VALUES (?, ?, ?)";

            // Tạo PreparedStatement
            PreparedStatement pstmt = con.prepareStatement(sql);

            // Thiết lập các tham số cho câu lệnh SQL
            pstmt.setString(1, maHD);
            pstmt.setString(2, maSP);
            pstmt.setInt(3, soLuong);

            // Thực thi câu lệnh SQL
            pstmt.executeUpdate();

            // Đóng kết nối
            pstmt.close();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    public ArrayList<OrderDetails> getOrderDetailById(String id) {
        ArrayList<OrderDetails> dsOrderDetails = new ArrayList<>();

        try {
            Connection con = ConnectDB.getCon();
            String sql = "SELECT * FROM ChiTietHoaDon C\n"
                    + "JOIN HoaDon H \n"
                    + "ON C.maHD = H.maHD\n"
                    + "JOIN SanPham S \n"
                    + "ON S.maSanPham = C.maSanPham\n"
                    + "WHERE C.maHD = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                // Mã đơn hàng
                String maHD = rs.getString("maHD");
                // Mã sản phẩm
                String maSP = rs.getString("maSanPham");
                String tenSP = rs.getString("tenSanPham");
                String donViTinh = rs.getString("donViTinh");
                double donGiaBan = Double.parseDouble(rs.getString("donGiaBan"));
                Products p = new Products(maSP, tenSP, donGiaBan, donViTinh);
                // Số lượng
                int soLuong = rs.getInt("soLuong");
                // Tạo đối tượng OrderDetails và thêm vào danh sách
                dsOrderDetails.add(new OrderDetails(new Orders(maHD), p, soLuong));
            }
        } catch (SQLException ex) {
            // Xử lý ngoại lệ
            ex.printStackTrace();
        }
        return dsOrderDetails;
    }

    public boolean find(OrderDetails p) {
        ConnectDB.getInstance();
        Connection con = (Connection) ConnectDB.getCon();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean found = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM ChiTietHoaDon WHERE maHD = ?");
            stmt.setString(1, p.getMaHD().getMaHD());
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
    public boolean remove(OrderDetails order) {
        ConnectDB.getInstance();
        Connection con = (Connection) ConnectDB.getCon();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("delete from" + " ChiTietHoaDon  WHERE maHD=?");
            stmt.setString(1, order.getMaHD().getMaHD());
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
                    "update NhaCungCap set maNCC=?, tenNCC=?," + "diaChi=?, quocGia=?, thanhPho=?, email=?, soDT=?" + "where maNCC=?");
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
