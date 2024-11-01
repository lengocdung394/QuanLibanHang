package dao;

import connectBD.ConnectDB;

import entity.Employees;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class Employee_DAO {

    public ArrayList<Employees> getEmployee() {
        ArrayList<Employees> dsEmployee = new ArrayList<>();
//NhanVien (maNV ,hoNV, tenNV, ngaySinh, soCccd, diaChi, gioiTinh, email, soDT)
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getCon();
            String spl = "SELECT * FROM NhanVien";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(spl);

            while (rs.next()) {

                // ma san pham
                String maNV = rs.getString("maNV");
                // ten san pham
                String hoNV = rs.getString("hoNV");
                // ma nha cung cap
                String tenNV = rs.getString("tenNV");

                // so luong 
                String soCccd = rs.getString("soCccd");
                String diaChi = rs.getString("diaChi");
                boolean gioiTinh = rs.getBoolean("gioiTinh");
                // don vi tinh     
                String email = rs.getString("email");
                String soDT = rs.getNString("soDT");

                //ngay san xuat
                Date manufactureDate = rs.getDate("ngaySinh");
                // han su dung

                LocalDate ngaySinh = null;
                if (manufactureDate != null) {
                    ngaySinh = manufactureDate.toLocalDate();
                }
                Employees e = new Employees(maNV, hoNV, tenNV, ngaySinh, soCccd, diaChi, gioiTinh, email, soDT);
                dsEmployee.add(e);
            }
        } catch (SQLException ex) {

            ex.printStackTrace();

        }
        return dsEmployee;
    }

    public Employee_DAO() {
    }
}
