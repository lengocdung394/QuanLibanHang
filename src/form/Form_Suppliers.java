package form;

import connectBD.ConnectDB;
import dao.Supplier_DAO;
import entity.Suppliers;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import org.apache.poi.sl.usermodel.Sheet;

public class Form_Suppliers extends javax.swing.JPanel {

    private Supplier_DAO sp_dao;
    private ArrayList<Suppliers> listSP;

    public Form_Suppliers() {
        try {
            ConnectDB.getInstance().connect();
            sp_dao = new Supplier_DAO();
        } catch (Exception e) {
            e.printStackTrace();
        }

        initComponents();
        clearTable();
        updateTable();

    }

    private void clearTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }

    public void updateTable() {
        this.listSP = sp_dao.getSuppliers();
        for (Suppliers pr : listSP) {
            ((DefaultTableModel) table.getModel()).addRow(new Object[]{pr.getMaNCC(), pr.getTenNCC(), pr.getDiaChi(), pr.getQuocGia(), pr.getThanhPho(), pr.getEmail(), pr.getSoDT()});
        }
    }

    public boolean valid() {
        String address = txtAddress.getText();
        String city = txtCity.getText();
        String country = txtCountry.getText();
        String email = txtEmail.getText();
        String phone = txtPhone.getText();
        String supplierID = txtSupplierID.getText();
        String supplierName = txtSupplierName.getText();
        // Add validation for supplier name
        if (supplierName == null || supplierName.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên nhà cung cấp");
            txtSupplierName.requestFocus();
            return false;
        }
        // Add validation for email
        if (email == null || !email.endsWith("@gmail.com")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập email hợp lệ");
            txtEmail.requestFocus();
            return false;
        }
        // Add validation for country
        if (country == null || country.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập quốc gia");
            txtCountry.requestFocus();
            return false;
        }
        // Check if city is empty
        if (city == null || city.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập thành phố");
            txtCity.requestFocus();
            return false;
        }

        // Add validation for phone number
        if (phone == null || !phone.matches("^\\d{10}$")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại hợp lệ");
            txtPhone.requestFocus();
            return false;
        }
        // Check if address is empty
        if (address == null || address.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập địa chỉ");
            txtAddress.requestFocus();
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLeftIcon = new javax.swing.JLabel();
        lblRightIcon = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        pSupplierInfo = new swing.PannelBorder();
        lblSupplierID = new javax.swing.JLabel();
        txtCountry = new javax.swing.JTextField();
        lblCountry = new javax.swing.JLabel();
        txtSupplierID = new javax.swing.JTextField();
        lblSupplierName = new javax.swing.JLabel();
        lblCity = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblSupplierInfo = new javax.swing.JLabel();
        txtSupplierName = new javax.swing.JTextField();
        pFunction = new swing.PannelBorder();
        btnRemove = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnRepair = new javax.swing.JButton();
        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        lblTitleFunction = new javax.swing.JLabel();
        btnExport = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1000, 571));

        lblLeftIcon.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblLeftIcon.setForeground(new java.awt.Color(102, 102, 255));
        lblLeftIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ncc_icon.png"))); // NOI18N

        lblRightIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delivery_icon.png"))); // NOI18N

        scrollPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scrollPaneMouseClicked(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhà cung cấp", "Tên nhà cung cấp", "Địa chỉ", "Quốc gia", "Thành phố", "Email", "Số điện thoại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        scrollPane.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(3).setResizable(false);
            table.getColumnModel().getColumn(4).setResizable(false);
            table.getColumnModel().getColumn(5).setResizable(false);
            table.getColumnModel().getColumn(6).setResizable(false);
        }

        lblSupplierID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSupplierID.setForeground(new java.awt.Color(255, 255, 255));
        lblSupplierID.setText("Mã số:");

        lblCountry.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCountry.setForeground(new java.awt.Color(255, 255, 255));
        lblCountry.setText("Quốc gia:");

        txtSupplierID.setEnabled(false);

        lblSupplierName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSupplierName.setForeground(new java.awt.Color(255, 255, 255));
        lblSupplierName.setText("Tên :");

        lblCity.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCity.setForeground(new java.awt.Color(255, 255, 255));
        lblCity.setText("Thành phố:");

        lblAddress.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAddress.setForeground(new java.awt.Color(255, 255, 255));
        lblAddress.setText("Địa chỉ:");

        lblPhone.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPhone.setForeground(new java.awt.Color(255, 255, 255));
        lblPhone.setText("Số điện thoại:");

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("Email:");

        lblSupplierInfo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSupplierInfo.setForeground(new java.awt.Color(255, 255, 255));
        lblSupplierInfo.setText("Thông tin nhà cung cấp:");

        javax.swing.GroupLayout pSupplierInfoLayout = new javax.swing.GroupLayout(pSupplierInfo);
        pSupplierInfo.setLayout(pSupplierInfoLayout);
        pSupplierInfoLayout.setHorizontalGroup(
            pSupplierInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSupplierInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pSupplierInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSupplierInfo)
                    .addGroup(pSupplierInfoLayout.createSequentialGroup()
                        .addGroup(pSupplierInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSupplierID, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAddress))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAddress))
                    .addGroup(pSupplierInfoLayout.createSequentialGroup()
                        .addGroup(pSupplierInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmail)
                            .addComponent(lblSupplierName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pSupplierInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pSupplierInfoLayout.createSequentialGroup()
                                .addGroup(pSupplierInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSupplierID, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(pSupplierInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pSupplierInfoLayout.createSequentialGroup()
                                        .addComponent(lblCountry)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pSupplierInfoLayout.createSequentialGroup()
                                        .addComponent(lblCity)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pSupplierInfoLayout.createSequentialGroup()
                                        .addComponent(lblPhone)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(158, 158, 158))
        );
        pSupplierInfoLayout.setVerticalGroup(
            pSupplierInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pSupplierInfoLayout.createSequentialGroup()
                .addComponent(lblSupplierInfo)
                .addGap(20, 20, 20)
                .addGroup(pSupplierInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCountry)
                    .addComponent(lblSupplierID)
                    .addComponent(txtSupplierID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(pSupplierInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCity)
                    .addComponent(lblSupplierName)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(pSupplierInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhone)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail))
                .addGap(18, 18, 18)
                .addGroup(pSupplierInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddress))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        txtCity.getAccessibleContext().setAccessibleDescription("");

        btnRemove.setBackground(Color.RED);
        btnRemove.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btnRemove.setText("Xóa");
        btnRemove.setMinimumSize(new java.awt.Dimension(90, 31));
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        btnSearch.setText("Tìm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnRepair.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRepair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/repair.png"))); // NOI18N
        btnRepair.setText("Chỉnh sửa");
        btnRepair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepairActionPerformed(evt);
            }
        });

        lblSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSearch.setForeground(new java.awt.Color(255, 255, 255));
        lblSearch.setText("Nhập mã:");

        lblTitleFunction.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitleFunction.setForeground(new java.awt.Color(255, 255, 255));
        lblTitleFunction.setText("Nghiệp vụ:");

        btnExport.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/folder.png"))); // NOI18N
        btnExport.setText("Xuất file");
        btnExport.setMaximumSize(new java.awt.Dimension(90, 31));
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        btnRefresh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/reset.png"))); // NOI18N
        btnRefresh.setText("Làm mới");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pFunctionLayout = new javax.swing.GroupLayout(pFunction);
        pFunction.setLayout(pFunctionLayout);
        pFunctionLayout.setHorizontalGroup(
            pFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFunctionLayout.createSequentialGroup()
                .addGroup(pFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pFunctionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRepair, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5))
                    .addGroup(pFunctionLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lblTitleFunction)))
                .addGroup(pFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(pFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pFunctionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        pFunctionLayout.setVerticalGroup(
            pFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFunctionLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lblTitleFunction)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRepair, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitle.setForeground(Color.decode("#1d976c"));
        lblTitle.setText("Bảng Nhà Cung Cấp");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblLeftIcon)
                        .addGap(275, 275, 275)
                        .addComponent(lblTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblRightIcon)
                        .addGap(84, 84, 84))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(pSupplierInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pFunction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(38, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLeftIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTitle)))
                    .addComponent(lblRightIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pSupplierInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pFunction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed

        if (table.getSelectedColumn() == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn dòng để xóa");
        } else {
            if (JOptionPane.showConfirmDialog(this, "Bạn muốn xóa dòng này không?", "Cảnh báo",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                int row = table.getSelectedRow();
                String ma = table.getValueAt(row, 0).toString();

                ((DefaultTableModel) table.getModel()).removeRow(row);

                JOptionPane.showMessageDialog(this, "Xóa thành công");

            }

        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed

        // TODO add your handling code here:
        String fileName = "FileExcel//BangNhaCungCap.xlsx";

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet;
            sheet = workbook.createSheet("Sheet1");

            // Tạo một hàng và viết dữ liệu vào đó
            Row rowHeader = sheet.createRow(0);
            Cell cellMaNCC = rowHeader.createCell(0);
            cellMaNCC.setCellValue("Mã Nhà Cung Cấp");
            Cell cellTenNCC = rowHeader.createCell(1);
            cellTenNCC.setCellValue("Tên Nhà Cung Cấp");
            Cell cellDiaChi = rowHeader.createCell(2);
            cellDiaChi.setCellValue("Địa chỉ");
            Cell cellQuocGia = rowHeader.createCell(3);
            cellQuocGia.setCellValue("Quốc gia");
            Cell cellTP = rowHeader.createCell(4);
            cellTP.setCellValue("Thành phố");
            Cell cellEmail = rowHeader.createCell(5);
            cellEmail.setCellValue("Email");
            Cell cellSDT = rowHeader.createCell(6);
            cellSDT.setCellValue("Số điện thoại");
            int i = 0;
            for (Suppliers p : listSP) {
                Row row = sheet.createRow(++i);
                Cell cell0 = row.createCell(0);
                cell0.setCellValue(p.getMaNCC());
                Cell cell1 = row.createCell(1);
                cell1.setCellValue(p.getTenNCC());
                Cell cell2 = row.createCell(2);
                cell2.setCellValue(p.getDiaChi());
                Cell cell3 = row.createCell(3);
                cell3.setCellValue(p.getQuocGia());
                Cell cell4 = row.createCell(4);
                cell4.setCellValue(p.getThanhPho());
                Cell cell5 = row.createCell(5);
                cell5.setCellValue(p.getEmail());
                Cell cell6 = row.createCell(6);
                cell6.setCellValue(p.getSoDT());

            }

            // Lưu workbook vào file
            try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
                workbook.write(fileOut);
            }
            workbook.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(this, "Xuất file thành công");
        File file = new File(fileName);
        if (file.exists()) {
            try {
                Desktop.getDesktop().open(file);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnExportActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        txtAddress.setText("");
        txtCity.setText("");
        txtCountry.setText("");
        txtEmail.setText("");
        txtPhone.setText("");
        txtSupplierID.setText("");
        txtSupplierName.setText("");
        txtSupplierID.setText("");
        txtSupplierID.setEnabled(false);
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void scrollPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scrollPaneMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_scrollPaneMouseClicked

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:

        int row = table.getSelectedRow();
        if (row >= 0) {
            txtSupplierID.setEnabled(false);
            txtAddress.setText(table.getValueAt(row, 2).toString());
            txtCity.setText(table.getValueAt(row, 4).toString());
            txtCountry.setText(table.getValueAt(row, 3).toString());
            txtEmail.setText(table.getValueAt(row, 5).toString());
            txtPhone.setText(table.getValueAt(row, 6).toString());
            txtSupplierID.setText(table.getValueAt(row, 0).toString());
            txtSupplierName.setText(table.getValueAt(row, 1).toString());

        }
    }//GEN-LAST:event_tableMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        if (valid()) {
            String address = txtAddress.getText();
            String city = txtCity.getText();
            String country = txtCountry.getText();
            String email = txtEmail.getText();
            String phone = txtPhone.getText();
            String supplierID = txtSupplierID.getText();
            String supplierName = txtSupplierName.getText();
            Suppliers pr = new Suppliers(supplierID, supplierName, address, country, city, email, phone);

            try {
                // tu sinh ma, tu chinh cho nay nha
                sp_dao.create(pr);
                clearTable();
                updateTable();

            } catch (Exception e) {
                e.printStackTrace();
            }
            JOptionPane.showMessageDialog(this, "Thêm nhà cung cấp thành công");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRepairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepairActionPerformed
        // TODO add your handling code here:

        int row = table.getSelectedRow();
        if (row > -1) {
            String address = txtAddress.getText();
            String city = txtCity.getText();
            String country = txtCountry.getText();
            String email = txtEmail.getText();
            String phone = txtPhone.getText();
            String supplierID = txtSupplierID.getText();
            String supplierName = txtSupplierName.getText();
            Suppliers pr = new Suppliers(supplierID, supplierName, address, country, city, email, phone);

            // tu sinh ma, tu chinh cho nay nha
            sp_dao.upDate(pr);
            ((DefaultTableModel) table.getModel()).setValueAt(supplierID, row, 0);
            ((DefaultTableModel) table.getModel()).setValueAt(supplierName, row, 1);
            ((DefaultTableModel) table.getModel()).setValueAt(address, row, 2);
            ((DefaultTableModel) table.getModel()).setValueAt(country, row, 3);
            ((DefaultTableModel) table.getModel()).setValueAt(city, row, 4);
            ((DefaultTableModel) table.getModel()).setValueAt(email, row, 5);
            ((DefaultTableModel) table.getModel()).setValueAt(phone, row, 6);
            JOptionPane.showMessageDialog(this, "Cập nhật thông tin thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa");
        }

    }//GEN-LAST:event_btnRepairActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:

        table.clearSelection();
        String supID = txtSearch.getText().trim();
        if (supID.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã nhà cung cấp để tìm kiếm");
            txtSearch.requestFocus();
        } else {
            boolean found = false;
            for (int i = 0; i < table.getRowCount(); i++) {
                String supIDTable = table.getValueAt(i, 0).toString();
                if (supIDTable.equalsIgnoreCase(supID)) {
                    table.addRowSelectionInterval(i, i);
                    found = true;
                }
            }
            if (!found) {
                JOptionPane.showMessageDialog(this, "Không tồn tại nhà cung cấp có mã " + supID);
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnRepair;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblLeftIcon;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblRightIcon;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblSupplierID;
    private javax.swing.JLabel lblSupplierInfo;
    private javax.swing.JLabel lblSupplierName;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitleFunction;
    private swing.PannelBorder pFunction;
    private swing.PannelBorder pSupplierInfo;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtCountry;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSupplierID;
    private javax.swing.JTextField txtSupplierName;
    // End of variables declaration//GEN-END:variables

}
