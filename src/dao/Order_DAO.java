/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

//import com.sun.org.apache.bcel.internal.generic.AALOAD;
import connectBD.ConnectDB;
import entity.Employees;
import entity.Orders;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Order_DAO {
    public String getSumOfTotalByYear(int year, String maNV) {
        DecimalFormat df = new DecimalFormat("#,###.0 VND");
    double countOfOrder;
    String total = null;
    try {
        ConnectDB.getInstance().connect();
        Connection con = ConnectDB.getCon();
        String sql = "SELECT maNV, YEAR(ngayLapHD) AS YEAR, SUM(thanhTien) AS TongTien\n"
                + "FROM HoaDon\n"
                + "WHERE maNV = ? \n"
                + "GROUP BY maNV, YEAR(ngayLapHD)\n"
                + "HAVING YEAR(ngayLapHD) = ?\n"
                + "ORDER BY YEAR;";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, maNV);
        preparedStatement.setString(2, year + "");

        // Thực thi truy vấn và lấy kết quả
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            countOfOrder = Double.parseDouble(resultSet.getString("TongTien"));
            total = df.format(countOfOrder);
        }
    } catch (SQLException ex) {
        Logger.getLogger(Order_DAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return total;
}

    public String getCountOfOrderByYear(int year, String maNV) {
    String countOfOrder = null;
    try {
        ConnectDB.getInstance().connect();
        Connection con = ConnectDB.getCon();
        String sql = "SELECT maNV, YEAR(ngayLapHD) AS YEAR, COUNT(*) AS InvoiceCount\n"
                + "FROM HoaDon\n"
                + "WHERE maNV = ? \n"
                + "GROUP BY maNV, YEAR(ngayLapHD)\n"
                + "HAVING YEAR(ngayLapHD) = ?\n"
                + "ORDER BY YEAR;";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, maNV);
        preparedStatement.setString(2, year + "");

        // Thực thi truy vấn và lấy kết quả
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            countOfOrder = resultSet.getString("InvoiceCount");
        }
    } catch (SQLException ex) {
        Logger.getLogger(Order_DAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return countOfOrder + " hóa đơn";
}


    public String getTop1OrderID() {
        String id = null;

        try {

            ConnectDB.getInstance();
            Connection con = ConnectDB.getCon();
            String sql = "select top 1 maHD from HoaDon\n"
                    + "order by maHD desc";

            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String orderId = rs.getString("maHD");
                id = Integer.parseInt(orderId) + "";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Order_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public ArrayList<Orders> getAllOrder() {
        ArrayList<Orders> list = new ArrayList<>();
        try {

            ConnectDB.getInstance();
            Connection con = ConnectDB.getCon();
            String sql = "select * from HoaDon";

            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String orderId = rs.getString("maHD");
                Employees employeeID = new Employees(rs.getString("maNV"));
                LocalDate orderDate = rs.getDate("ngayLapHD").toLocalDate();
                double total = rs.getDouble("thanhTien");
                double vat = rs.getDouble("thueVAT");
                Orders o = new Orders(orderId, employeeID, orderDate, total, vat);

                list.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Order_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public ArrayList<Orders> getOrdersByEmployeeId(String ma) {
        ArrayList<Orders> list = new ArrayList<>();
        try {

            ConnectDB.getInstance().connect();
            Connection con = ConnectDB.getCon();
            String sql = "select * from HoaDon where maNV = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, ma);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String orderId = rs.getString("maHD");
                Employees employeeID = new Employees(rs.getString("maNV"));
                LocalDate orderDate = rs.getDate("ngayLapHD").toLocalDate();
                double total = rs.getDouble("thanhTien");
                double vat = rs.getDouble("thueVAT");
                Orders o = new Orders(orderId, employeeID, orderDate, total, vat);

                list.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Order_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public boolean createOrder(String employeeId, LocalDate orderDate, double total, double vat) {
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getCon();
            String sql = "INSERT INTO HoaDon (maNV, ngayLapHD, thanhTien, thueVAT) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, employeeId);
            preparedStatement.setDate(2, java.sql.Date.valueOf(orderDate));
            preparedStatement.setDouble(3, total);
            preparedStatement.setDouble(4, vat);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Order_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

}
