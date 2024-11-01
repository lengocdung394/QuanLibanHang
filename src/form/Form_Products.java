package form;

import connectBD.ConnectDB;
import dao.Category_DAO;
import dao.Product_DAO;
import dao.Supplier_DAO;
import entity.Categories;
import entity.Products;
import entity.Suppliers;

import java.awt.Color;
import java.awt.Desktop;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Form_Products extends javax.swing.JPanel {

    private Product_DAO pr_dao;
    private Supplier_DAO sp_dao;
    private Category_DAO cate_dao;
    private ArrayList<Suppliers> listSP;
    private ArrayList<Categories> listCate;
    private ArrayList<Products> list;

    public Form_Products() {
        try {
            ConnectDB.getInstance().connect();
            sp_dao = new Supplier_DAO();
            pr_dao = new Product_DAO();
            cate_dao = new Category_DAO();

        } catch (Exception e) {
            // TODO: handle exception

            e.printStackTrace();
        }
        initComponents();

        updateComboboxSupplierID();
        updateComboboxCategoryID();
        clearTable();
        updateTable();

    }

    public boolean valid() {
        String tenSP = txtProductName.getText();
        String donVT = txtQuantityPerUnit.getText();
        String soLuong = txtUnitlnStock.getText();
        String giaBan = txtUnitPrice.getText();
        String giaMua = txtPrice.getText();
        String giamGia = txtDiscount.getText();

        if (tenSP == null || tenSP.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên sản phẩm");
            txtProductName.requestFocus();
            return false;
        }

        // Kiểm tra số lượng nhập vào có phải là số không
        try {
            int soLuongInt = Integer.parseInt(soLuong);
            if (soLuongInt <= 0) {
                JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0");
                txtUnitlnStock.requestFocus();
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là một số nguyên dương");
            txtUnitlnStock.requestFocus();
            return false;
        }

        // Kiểm tra giá bán và giá mua có phải là số không
        try {
            double giaBanDouble = Double.parseDouble(giaBan);
            double giaMuaDouble = Double.parseDouble(giaMua);
            if (giaBanDouble <= 0 || giaMuaDouble <= 0) {
                JOptionPane.showMessageDialog(this, "Giá bán và giá mua phải lớn hơn không");
                txtUnitPrice.requestFocus();
                return false;
            }
            if (giaBanDouble < giaMuaDouble) {
                JOptionPane.showMessageDialog(this, "Giá bán phải lớn hơn giá mua");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Giá bán và giá mua phải là số dương");
            txtUnitPrice.requestFocus();
            return false;
        }

        // Kiểm tra giảm giá có phải là số không
        try {
            double giamGiaDouble = Double.parseDouble(giamGia);
            if (giamGiaDouble < 0) {
                JOptionPane.showMessageDialog(this, "Giảm giá phải lớn hơn bằng 0");
                txtDiscount.requestFocus();
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Giảm giá phải là một số");
            txtDiscount.requestFocus();
            return false;
        }
        if (donVT == null || donVT.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đơn vị tính");
            txtQuantityPerUnit.requestFocus();
            return false;
        }
        // Kiểm tra ngày sản xuất và hạn sử dụng không được để trống
        if (manufactureDate.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày sản xuất");
            manufactureDate.requestFocus();
            return false;
        }

        if (expiryDate.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hạn sử dụng");
            expiryDate.requestFocus();
            return false;
        }

        return true;
    }

    public void updateComboboxSupplierID() {
        this.listSP = sp_dao.getSuppliers();
        for (Suppliers sp : listSP) {
            cbxSupplierID.addItem(sp.getMaNCC() + ": " + sp.getTenNCC());
        }
    }

    private void updateComboboxCategoryID() {
        this.listCate = cate_dao.getCategories();
        for (Categories c : listCate) {
            cboCategoryID.addItem(c.getCategoryID() + ": " + c.getCategoryName());
        }
    }

    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }

    public void updateTable() {
        this.list = pr_dao.getTableProduct();
        for (Products pr : list) {

            String manufactureDate = null;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            if (pr.getNgaySX() != null) {
                LocalDate ngays = pr.getNgaySX();
                manufactureDate = ngays.format(formatter);
            }

            String expiryDate = null;
            if (pr.getHanSuDung() != null) {
                LocalDate ngayss = pr.getHanSuDung();
                expiryDate = ngayss.format(formatter);
            }

            ((DefaultTableModel) table.getModel()).addRow(new Object[]{pr.getMaSP(), pr.getTenSP(), pr.getMaNCC().getMaNCC(), pr.getMaLoai().getCategoryID(), pr.getSoLuongTon(), pr.getDonGiaMua(), pr.getDonGiaBan(), pr.getDonViTinh(), pr.getGiamGia(), expiryDate, manufactureDate});
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelHeader1 = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        lblTitle = new javax.swing.JLabel();
        lblLogo1 = new javax.swing.JLabel();
        lblLogo2 = new javax.swing.JLabel();
        lblLogo3 = new javax.swing.JLabel();
        pannelBorder1 = new swing.PannelBorder();
        lblInsert = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblMajor = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        btnExportFile = new javax.swing.JButton();
        pannelBorder2 = new swing.PannelBorder();
        lblProductID = new javax.swing.JLabel();
        lblUnitPrice = new javax.swing.JLabel();
        txtUnitPrice = new javax.swing.JTextField();
        lblProductName = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        lblQuantityPerUnit = new javax.swing.JLabel();
        txtQuantityPerUnit = new javax.swing.JTextField();
        lblCategoryID = new javax.swing.JLabel();
        jlbDiscount = new javax.swing.JLabel();
        txtDiscount = new javax.swing.JTextField();
        lblUnitlnStock = new javax.swing.JLabel();
        txtUnitlnStock = new javax.swing.JTextField();
        lblExpiryDate = new javax.swing.JLabel();
        lblManufactureDate = new javax.swing.JLabel();
        lblSupplierID = new javax.swing.JLabel();
        lblInformationProduct = new javax.swing.JLabel();
        cbxSupplierID = new javax.swing.JComboBox<>();
        manufactureDate = new com.toedter.calendar.JDateChooser();
        expiryDate = new com.toedter.calendar.JDateChooser();
        txtProductId = new javax.swing.JTextField();
        lblPrice = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        cboCategoryID = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));

        PanelHeader1.setBackground(new java.awt.Color(255, 255, 255));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Mã NCC", "Mã loại", "Số lượng", "Đơn giá mua", "Đơn giá bán", "Đơn vị tính", "Giảm giá", "Ngày sản xuất", "Hạn sử dụng"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        scrollPane.setViewportView(table);

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitle.setForeground(Color.decode("#1d976c"));
        lblTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/products (1).png"))); // NOI18N
        lblTitle.setText("Bảng sản phẩm");

        lblLogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cubes.png"))); // NOI18N

        lblLogo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cubes.png"))); // NOI18N

        lblLogo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/products (1).png"))); // NOI18N

        lblInsert.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblInsert.setForeground(new java.awt.Color(255, 255, 255));
        lblInsert.setText("Nhập mã:");

        txtSearch.setToolTipText("Nhạp mã cần tìm sp");
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        btnSearch.setText("Tìm kiếm");
        btnSearch.setPreferredSize(new java.awt.Dimension(90, 30));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btnAdd.setText("Thêm ");
        btnAdd.setPreferredSize(new java.awt.Dimension(90, 30));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/repair.png"))); // NOI18N
        btnUpdate.setText("Chỉnh sửa");
        btnUpdate.setPreferredSize(new java.awt.Dimension(90, 30));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(Color.RED);
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.setPreferredSize(new java.awt.Dimension(90, 30));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lblMajor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblMajor.setForeground(new java.awt.Color(255, 255, 255));
        lblMajor.setText("Nghiệp vụ: ");

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/reset.png"))); // NOI18N
        btnRefresh.setText("Làm mới");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnExportFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/folder.png"))); // NOI18N
        btnExportFile.setText("Xuất file");
        btnExportFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pannelBorder1Layout = new javax.swing.GroupLayout(pannelBorder1);
        pannelBorder1.setLayout(pannelBorder1Layout);
        pannelBorder1Layout.setHorizontalGroup(
            pannelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelBorder1Layout.createSequentialGroup()
                .addGroup(pannelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pannelBorder1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(pannelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pannelBorder1Layout.createSequentialGroup()
                                .addGroup(pannelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(pannelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pannelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnExportFile, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pannelBorder1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblInsert)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pannelBorder1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblMajor)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        pannelBorder1Layout.setVerticalGroup(
            pannelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMajor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pannelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pannelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(pannelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(pannelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExportFile, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        lblProductID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblProductID.setForeground(new java.awt.Color(255, 255, 255));
        lblProductID.setText("Mã sản phẩm:");

        lblUnitPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblUnitPrice.setForeground(new java.awt.Color(255, 255, 255));
        lblUnitPrice.setText("Đơn giá:");

        txtUnitPrice.setToolTipText("Nhập đơn giá");
        txtUnitPrice.setPreferredSize(new java.awt.Dimension(75, 25));
        txtUnitPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUnitPriceActionPerformed(evt);
            }
        });

        lblProductName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblProductName.setForeground(new java.awt.Color(255, 255, 255));
        lblProductName.setText("Tên sản phẩm:");

        txtProductName.setToolTipText("Nhập tên sản phẩm");
        txtProductName.setPreferredSize(new java.awt.Dimension(75, 25));

        lblQuantityPerUnit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblQuantityPerUnit.setForeground(new java.awt.Color(255, 255, 255));
        lblQuantityPerUnit.setText("Đơn vị tính:");

        txtQuantityPerUnit.setToolTipText("Nhập đơn vị tính");
        txtQuantityPerUnit.setPreferredSize(new java.awt.Dimension(75, 25));

        lblCategoryID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCategoryID.setForeground(new java.awt.Color(255, 255, 255));
        lblCategoryID.setText("Mã loại:");

        jlbDiscount.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jlbDiscount.setForeground(new java.awt.Color(255, 255, 255));
        jlbDiscount.setText("Giảm giá");

        txtDiscount.setToolTipText("Nhập nhà sản xuất");
        txtDiscount.setPreferredSize(new java.awt.Dimension(75, 25));

        lblUnitlnStock.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblUnitlnStock.setForeground(new java.awt.Color(255, 255, 255));
        lblUnitlnStock.setText("Số lượng:");

        txtUnitlnStock.setToolTipText("Nhập số lượng");
        txtUnitlnStock.setPreferredSize(new java.awt.Dimension(75, 25));

        lblExpiryDate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblExpiryDate.setForeground(new java.awt.Color(255, 255, 255));
        lblExpiryDate.setText("Hạn sử dụng: ");

        lblManufactureDate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblManufactureDate.setForeground(new java.awt.Color(255, 255, 255));
        lblManufactureDate.setText("Ngày sản xuất:");

        lblSupplierID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSupplierID.setForeground(new java.awt.Color(255, 255, 255));
        lblSupplierID.setText("Mã NCC:");

        lblInformationProduct.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblInformationProduct.setForeground(new java.awt.Color(255, 255, 255));
        lblInformationProduct.setText("Thông tin sản phẩm: ");

        cbxSupplierID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSupplierIDActionPerformed(evt);
            }
        });

        txtProductId.setEnabled(false);

        lblPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPrice.setForeground(new java.awt.Color(255, 255, 255));
        lblPrice.setText("Giá mua:");

        javax.swing.GroupLayout pannelBorder2Layout = new javax.swing.GroupLayout(pannelBorder2);
        pannelBorder2.setLayout(pannelBorder2Layout);
        pannelBorder2Layout.setHorizontalGroup(
            pannelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pannelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pannelBorder2Layout.createSequentialGroup()
                        .addGroup(pannelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pannelBorder2Layout.createSequentialGroup()
                                .addGroup(pannelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblProductID, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pannelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtProductId, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pannelBorder2Layout.createSequentialGroup()
                                .addComponent(lblCategoryID, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboCategoryID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pannelBorder2Layout.createSequentialGroup()
                                .addComponent(lblUnitlnStock, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pannelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPrice)
                                    .addComponent(txtUnitlnStock, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pannelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pannelBorder2Layout.createSequentialGroup()
                                .addComponent(lblManufactureDate, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(manufactureDate, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pannelBorder2Layout.createSequentialGroup()
                                .addComponent(lblExpiryDate)
                                .addGap(18, 18, 18)
                                .addComponent(expiryDate, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pannelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblQuantityPerUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pannelBorder2Layout.createSequentialGroup()
                                    .addGroup(pannelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jlbDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(32, 32, 32)
                                    .addGroup(pannelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtDiscount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtUnitPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(pannelBorder2Layout.createSequentialGroup()
                        .addComponent(lblSupplierID, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxSupplierID, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtQuantityPerUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pannelBorder2Layout.createSequentialGroup()
                        .addGroup(pannelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInformationProduct)
                            .addComponent(lblPrice))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pannelBorder2Layout.setVerticalGroup(
            pannelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelBorder2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblInformationProduct)
                .addGap(5, 5, 5)
                .addGroup(pannelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pannelBorder2Layout.createSequentialGroup()
                        .addGroup(pannelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUnitPrice)
                            .addComponent(txtUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblProductID)
                            .addComponent(txtProductId, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(pannelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblProductName)
                            .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbDiscount)
                            .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(pannelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pannelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblSupplierID)
                                .addComponent(txtQuantityPerUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblQuantityPerUnit))
                            .addGroup(pannelBorder2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(cbxSupplierID, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11)
                        .addGroup(pannelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCategoryID)
                            .addComponent(lblManufactureDate)
                            .addComponent(cboCategoryID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(manufactureDate, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(pannelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pannelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblUnitlnStock)
                        .addComponent(txtUnitlnStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblExpiryDate))
                    .addComponent(expiryDate, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pannelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrice)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout PanelHeader1Layout = new javax.swing.GroupLayout(PanelHeader1);
        PanelHeader1.setLayout(PanelHeader1Layout);
        PanelHeader1Layout.setHorizontalGroup(
            PanelHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelHeader1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblLogo1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(199, 199, 199)
                .addComponent(lblTitle)
                .addGap(0, 0, 0)
                .addComponent(lblLogo3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLogo2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelHeader1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(PanelHeader1Layout.createSequentialGroup()
                        .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 953, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(PanelHeader1Layout.createSequentialGroup()
                        .addComponent(pannelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pannelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );
        PanelHeader1Layout.setVerticalGroup(
            PanelHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHeader1Layout.createSequentialGroup()
                .addGroup(PanelHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogo1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelHeader1Layout.createSequentialGroup()
                        .addContainerGap(11, Short.MAX_VALUE)
                        .addGroup(PanelHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelHeader1Layout.createSequentialGroup()
                                .addGroup(PanelHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblLogo3)
                                    .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(13, 13, 13))
                            .addComponent(lblLogo2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pannelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pannelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(PanelHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtUnitPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUnitPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnitPriceActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        table.clearSelection();
        String productID = txtSearch.getText().trim();
        if (productID.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sản phảm để tìm");
            txtSearch.requestFocus();
        } else {
            boolean found = false;
            for (int i = 0; i < table.getRowCount(); i++) {
                String productIDTable = table.getValueAt(i, 0).toString();
                if (productIDTable.equalsIgnoreCase(productID)) {
                    table.addRowSelectionInterval(i, i);
                    found = true;
                }
            }
            if (!found) {
                JOptionPane.showMessageDialog(this, "San pham khong ton tai");
            }
        }

    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if (valid()) {
            String maSP = txtProductId.getText();
            String tenSP = txtProductName.getText();
            String cbxSupID = cbxSupplierID.getSelectedItem().toString();
            String[] parts1 = cbxSupID.split(":");
            String supplierID = parts1[0].trim();
            String cbxCateID = cboCategoryID.getSelectedItem().toString();
            String[] parts2 = cbxCateID.split(":");
            String categoryID = parts2[0].trim(); // Lấy phần tử đầu tiên sau khi chia chuỗi và loại bỏ các khoảng trắng ở đầu và cuối chuỗi

            int soLuongTon = Integer.parseInt(txtUnitlnStock.getText());
            double donGiaBan = Double.parseDouble(txtUnitPrice.getText());
            double donGiaMua = Double.parseDouble(txtPrice.getText());
            double giamGia = Double.parseDouble(txtDiscount.getText());
            String donViTinh = txtQuantityPerUnit.getText();

            java.util.Date selectedManufactureDate = manufactureDate.getDate();
            java.util.Date selectedExpiryDate = expiryDate.getDate();

            LocalDate localManufactureDate = selectedManufactureDate != null ? selectedManufactureDate.toInstant().atZone(ZoneId.systemDefault().systemDefault()).toLocalDate() : null;
            LocalDate localExpiryDate = selectedExpiryDate != null ? selectedExpiryDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;

            //_________________________________________________________________________//
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String manufactureDateStr = localManufactureDate != null ? localManufactureDate.format(formatter) : null;
            String expiryDateStr = localExpiryDate != null ? localExpiryDate.format(formatter) : null;
            //_________________________________________________________________________//
            Suppliers s = new Suppliers(supplierID);
            Categories c = new Categories(categoryID);
            Products p = new Products(maSP, tenSP, s, c, soLuongTon, donGiaMua, donGiaBan, donViTinh, giamGia, localManufactureDate, localExpiryDate);
            pr_dao.create(p);
            clearTable();
            updateTable();
            JOptionPane.showMessageDialog(this, "Thêm thành công");

        }
        //public Products(String maSP, String tenSP, Suppliers maNCC, Categories maLoai, int soLuongTon, double donGia, String donViTinh, double giamGia, LocalDate ngaySX, LocalDate hanSuDung) {

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int row = table.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa");
        } else {
            
            String maSP = txtProductId.getText();
            String tenSP = txtProductName.getText();
            String cbxSupID = cbxSupplierID.getSelectedItem().toString();
            String[] parts1 = cbxSupID.split(":");
            String supplierID = parts1[0].trim();
            String cbxCateID = cboCategoryID.getSelectedItem().toString();
            String[] parts2 = cbxCateID.split(":");
            String categoryID = parts2[0].trim();
            int soLuongTon = Integer.parseInt(txtUnitlnStock.getText());
            double donGiaBan = Double.parseDouble(txtUnitPrice.getText());
            double donGiaMua = Double.parseDouble(txtPrice.getText());
            double giamGia = Double.parseDouble(txtDiscount.getText());
            String donViTinh = txtQuantityPerUnit.getText();
            java.util.Date selectedManufactureDate = manufactureDate.getDate();
            java.util.Date selectedExpiryDate = expiryDate.getDate();
            LocalDate localManufactureDate = selectedManufactureDate != null ? selectedManufactureDate.toInstant().atZone(ZoneId.systemDefault().systemDefault()).toLocalDate() : null;
            LocalDate localExpiryDate = selectedExpiryDate != null ? selectedExpiryDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String manufactureDateStr = localManufactureDate != null ? localManufactureDate.format(formatter) : null;
            String expiryDateStr = localExpiryDate != null ? localExpiryDate.format(formatter) : null;

            // Tạo một đối tượng Products từ các thông tin đã lấy
            Suppliers s = new Suppliers(supplierID);
            Categories c = new Categories(categoryID);
            Products p = new Products(maSP, tenSP, s, c, soLuongTon, donGiaMua, donGiaBan, donViTinh, giamGia, localManufactureDate, localExpiryDate);

            // Gọi phương thức để cập nhật thông tin sản phẩm vào cơ sở dữ liệu
            // Đây là nơi bạn gọi phương thức cập nhật
            if (pr_dao.update(p)) {
                JOptionPane.showMessageDialog(this, "Cập nhật thành công");
                clearTable();
                updateTable();
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật không thành công");
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        if (table.getSelectedColumn() == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn dòng để xóa");
        } else {
            
            if (JOptionPane.showConfirmDialog(this, "Ban muon xoa dong nay u!!!", "Canh bao",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                int row = table.getSelectedRow();
                String ma = table.getValueAt(row, 0).toString();
                ((DefaultTableModel) table.getModel()).removeRow(row);
                JOptionPane.showMessageDialog(this, "xoa thanh cong");

                if (pr_dao.remove(ma)) {
                    JOptionPane.showMessageDialog(this, "xoa thanh cong");

                }

            }

        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        txtProductId.setText("");
        txtProductName.setText("");
        cbxSupplierID.setSelectedIndex(-1);
        cboCategoryID.setSelectedIndex(-1);
        txtUnitlnStock.setText("");
        txtUnitPrice.setText("");
        txtDiscount.setText("");
        txtPrice.setText("");
        txtSearch.setText("");
        txtQuantityPerUnit.setText("");
        manufactureDate.setDate(null);
        expiryDate.setDate(null);
        


    }//GEN-LAST:event_btnRefreshActionPerformed


    private void btnExportFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportFileActionPerformed
        String fileName = "FileExcel//BangSanPham.xlsx";

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Sheet1");

            // Tạo một hàng và viết dữ liệu vào đó
            Row rowHeader = sheet.createRow(0);
            Cell cellMaSP = rowHeader.createCell(0);
            cellMaSP.setCellValue("Mã sản phẩm");
            Cell cellTenSP = rowHeader.createCell(1);
            cellTenSP.setCellValue("Tên sản phẩm");
            Cell cellMaNCC = rowHeader.createCell(2);
            cellMaNCC.setCellValue("Mã nhà cung cấp");
            Cell cellMaLoai = rowHeader.createCell(3);
            cellMaLoai.setCellValue("Mã loại");
            Cell cellSoLuong = rowHeader.createCell(4);
            cellSoLuong.setCellValue("Số lượng");
            Cell cellDonGiaMua = rowHeader.createCell(5);
            cellDonGiaMua.setCellValue("Đơn giá mua");
            Cell cellDonGiaBan = rowHeader.createCell(6);
            cellDonGiaBan.setCellValue("Đơn giá bán");
            Cell cellDonViTinh = rowHeader.createCell(7);
            cellDonViTinh.setCellValue("Đơn vị tính");
            Cell cellGiamGia = rowHeader.createCell(8);
            cellGiamGia.setCellValue("Giảm giá");
            Cell cellNhaSX = rowHeader.createCell(9);
            cellNhaSX.setCellValue("Nhà sản xuất");
            Cell cellHanSD = rowHeader.createCell(10);
            cellHanSD.setCellValue("Hạn sử dụng");
            int i = 0;
            for (Products p : list) {
                Row row = sheet.createRow(++i);
                Cell cell0 = row.createCell(0);
                cell0.setCellValue(p.getMaSP());
                Cell cell1 = row.createCell(1);
                cell1.setCellValue(p.getTenSP());
                Cell cell2 = row.createCell(2);
                cell2.setCellValue(p.getMaNCC().getMaNCC());
                Cell cell3 = row.createCell(3);
                cell3.setCellValue(p.getMaLoai().getCategoryID());
                Cell cell4 = row.createCell(4);
                cell4.setCellValue(p.getSoLuongTon());
                Cell cell5 = row.createCell(5);
                cell5.setCellValue(p.getDonGiaMua());
                Cell cell6 = row.createCell(6);
                cell6.setCellValue(p.getDonGiaBan());
                Cell cell7 = row.createCell(7);
                cell7.setCellValue(p.getDonViTinh());
                Cell cell8 = row.createCell(8);
                cell8.setCellValue(p.getGiamGia());
                Cell cell9 = row.createCell(9);
                cell9.setCellValue(p.getNgaySX() == null ? "" : p.getNgaySX().toString());
                Cell cell10 = row.createCell(10);
                cell10.setCellValue(p.getHanSuDung() == null ? "" : p.getHanSuDung().toString());
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
    }//GEN-LAST:event_btnExportFileActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        int row = table.getSelectedRow();
        if (row >= 0) {
           
            txtProductId.setText(table.getValueAt(row, 0).toString());
            txtProductName.setText(table.getValueAt(row, 1).toString());
            String tenNCC = sp_dao.getNameBySupplierID(table.getValueAt(row, 2).toString());
            String tenLoai = cate_dao.getNameByCategoryID(table.getValueAt(row, 3).toString());
            cbxSupplierID.setSelectedItem(table.getValueAt(row, 2).toString() + ": " + tenNCC);
            cboCategoryID.setSelectedItem(table.getValueAt(row, 3).toString() + ": " + tenLoai);

            txtUnitlnStock.setText(table.getValueAt(row, 4).toString());
            txtPrice.setText(table.getValueAt(row, 5).toString());
            txtUnitPrice.setText(table.getValueAt(row, 6).toString());
            txtQuantityPerUnit.setText(table.getValueAt(row, 7).toString());
            txtDiscount.setText(table.getValueAt(row, 8).toString());

            String ngaySX = table.getValueAt(row, 9) != null ? table.getValueAt(row, 9).toString() : null;
            String hanSuDung = table.getValueAt(row, 10) != null ? table.getValueAt(row, 10).toString() : null;
            SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat outputDateFormat = new SimpleDateFormat("MMM dd, yyyy");

            try {
                java.util.Date dateSX = null;
                if (ngaySX != null && !ngaySX.isEmpty() && !ngaySX.equals("0.0")) {
                    dateSX = inputDateFormat.parse(ngaySX);
                }

                java.util.Date dateHSD = null;
                if (hanSuDung != null && !hanSuDung.isEmpty() && !hanSuDung.equals("0.0")) {
                    dateHSD = inputDateFormat.parse(hanSuDung);
                }

                if (dateSX != null) {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(dateSX);
                    String monthName = new SimpleDateFormat("MMM", new DateFormatSymbols(Locale.ENGLISH)).format(cal.getTime());
                    String formattedDateSX = monthName + " " + new SimpleDateFormat("dd, yyyy").format(dateSX);
                    manufactureDate.setDateFormatString(formattedDateSX);
                    manufactureDate.setDate(new java.sql.Date(dateSX.getTime()));
                } else {
                    manufactureDate.setDateFormatString("");
                    manufactureDate.setDate(null);
                }

                if (dateHSD != null) {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(dateHSD);
                    String monthName = new SimpleDateFormat("MMM", new DateFormatSymbols(Locale.ENGLISH)).format(cal.getTime());
                    String formattedDateHSD = monthName + " " + new SimpleDateFormat("dd, yyyy").format(dateHSD);
                    expiryDate.setDateFormatString(formattedDateHSD);
                    expiryDate.setDate(new java.sql.Date(dateHSD.getTime()));
                } else {
                    expiryDate.setDateFormatString("");
                    expiryDate.setDate(null);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_tableMouseClicked

    private void cbxSupplierIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSupplierIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxSupplierIDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelHeader1;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExportFile;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboCategoryID;
    private javax.swing.JComboBox<String> cbxSupplierID;
    private com.toedter.calendar.JDateChooser expiryDate;
    private javax.swing.JLabel jlbDiscount;
    private javax.swing.JLabel lblCategoryID;
    private javax.swing.JLabel lblExpiryDate;
    private javax.swing.JLabel lblInformationProduct;
    private javax.swing.JLabel lblInsert;
    private javax.swing.JLabel lblLogo1;
    private javax.swing.JLabel lblLogo2;
    private javax.swing.JLabel lblLogo3;
    private javax.swing.JLabel lblMajor;
    private javax.swing.JLabel lblManufactureDate;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblProductID;
    private javax.swing.JLabel lblProductName;
    private javax.swing.JLabel lblQuantityPerUnit;
    private javax.swing.JLabel lblSupplierID;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUnitPrice;
    private javax.swing.JLabel lblUnitlnStock;
    private com.toedter.calendar.JDateChooser manufactureDate;
    private swing.PannelBorder pannelBorder1;
    private swing.PannelBorder pannelBorder2;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtDiscount;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtProductId;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtQuantityPerUnit;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtUnitPrice;
    private javax.swing.JTextField txtUnitlnStock;
    // End of variables declaration//GEN-END:variables

}
