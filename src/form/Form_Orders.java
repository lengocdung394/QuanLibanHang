package form;


import dao.OrderDetail_DAO;
import dao.Order_DAO;
import entity.OrderDetails;
import entity.Orders;
import java.awt.Color;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class Form_Orders extends javax.swing.JPanel {

    private ArrayList<OrderDetails> orderDetailList;
    private OrderDetail_DAO orderdetail_dao;
    private ArrayList<Orders> orderList;
    private Order_DAO order_dao;

    public Form_Orders() {
        initComponents();
        try {
            orderdetail_dao = new OrderDetail_DAO();
            order_dao = new Order_DAO();
            orderList = new ArrayList<>();
            orderDetailList = new ArrayList<>();

        } catch (Exception e) {
            e.printStackTrace();
        }

        updateOrderTable();

       

    }

    public void updateOrderTable() {
        orderList = order_dao.getOrdersByEmployeeId("22684211");
        for (Orders order : orderList) {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            ((DefaultTableModel) tableOrders.getModel()).addRow(new Object[]{
                order.getMaHD(), df.format(order.getNgayLap()), order.getThueVAT(), order.getThanhTien()
            });
        }
    }
    public void updateOrderDetailTable(String id){
        orderDetailList = orderdetail_dao.getOrderDetailById(id);
        for (OrderDetails orderDetails : orderDetailList) {
            ((DefaultTableModel) tableOrdersDetails.getModel()).addRow(new Object[] {
                orderDetails.getMaSP().getTenSP(), orderDetails.getMaSP().getDonViTinh(), orderDetails.getSoLuong(), orderDetails.getMaSP().getDonGiaBan(), orderDetails.tinhTien()
            });
        }
    }
    public void clearOrderDetailTable(){
        DefaultTableModel model = (DefaultTableModel) tableOrdersDetails.getModel();
        model.setRowCount(0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        pannelBorder1 = new swing.PannelBorder();
        lblSearch1 = new javax.swing.JLabel();
        lblOrderId = new javax.swing.JLabel();
        lblDateFrom = new javax.swing.JLabel();
        lblDateTo = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        scrollOrders = new javax.swing.JScrollPane();
        tableOrders = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        scrollOrdersDetails = new javax.swing.JScrollPane();
        tableOrdersDetails = new javax.swing.JTable();
        lblOrderID = new javax.swing.JLabel();
        txtOrderId = new javax.swing.JTextField();
        lblDate = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        lblSumTotal = new javax.swing.JLabel();
        txtSumTotal = new javax.swing.JTextField();

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setText("Mã HD");

        jLabel8.setText("Ngày lập");

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel9.setText("Tổng tiền");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên SP", "Đơn vị tính", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setShowGrid(false);
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(30, 30, 30)
                                .addComponent(jTextField4))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3))
        );

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        pannelBorder1.setForeground(new java.awt.Color(255, 255, 255));

        lblSearch1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSearch1.setForeground(new java.awt.Color(255, 255, 255));
        lblSearch1.setText("TÌM KIẾM");

        lblOrderId.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblOrderId.setForeground(new java.awt.Color(255, 255, 255));
        lblOrderId.setText("Mã hóa đơn:");

        lblDateFrom.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDateFrom.setForeground(new java.awt.Color(255, 255, 255));
        lblDateFrom.setText("Từ ngày:");

        lblDateTo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDateTo.setForeground(new java.awt.Color(255, 255, 255));
        lblDateTo.setText("Đến ngày:");

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
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

        btnRefresh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/reset.png"))); // NOI18N
        btnRefresh.setText("Làm mới");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pannelBorder1Layout = new javax.swing.GroupLayout(pannelBorder1);
        pannelBorder1.setLayout(pannelBorder1Layout);
        pannelBorder1Layout.setHorizontalGroup(
            pannelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelBorder1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pannelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOrderId)
                    .addComponent(lblDateTo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pannelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(pannelBorder1Layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(lblSearch1)
                .addGap(0, 128, Short.MAX_VALUE))
            .addGroup(pannelBorder1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefresh)
                .addGap(45, 45, 45))
        );
        pannelBorder1Layout.setVerticalGroup(
            pannelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pannelBorder1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pannelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pannelBorder1Layout.createSequentialGroup()
                        .addComponent(lblSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(pannelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblOrderId)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblDateFrom))
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pannelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDateTo)
                    .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(pannelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa Đơn", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24), Color.decode("#1d976c"))); // NOI18N

        scrollOrders.setBackground(new java.awt.Color(255, 255, 255));
        scrollOrders.setBorder(null);
        scrollOrders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scrollOrdersMouseClicked(evt);
            }
        });

        tableOrders.setBackground(new java.awt.Color(242, 242, 242));
        tableOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Ngày lập", "Thuế VAT", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableOrders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableOrdersMouseClicked(evt);
            }
        });
        scrollOrders.setViewportView(tableOrders);
        if (tableOrders.getColumnModel().getColumnCount() > 0) {
            tableOrders.getColumnModel().getColumn(0).setResizable(false);
            tableOrders.getColumnModel().getColumn(1).setResizable(false);
            tableOrders.getColumnModel().getColumn(2).setResizable(false);
            tableOrders.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 595, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollOrders, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(17, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pannelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pannelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi Tiết Hóa Đơn", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24), Color.decode("#1d976c"))); // NOI18N

        scrollOrdersDetails.setBackground(new java.awt.Color(255, 255, 255));

        tableOrdersDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên sản phẩm", "Đơn vị tính", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        scrollOrdersDetails.setViewportView(tableOrdersDetails);
        if (tableOrdersDetails.getColumnModel().getColumnCount() > 0) {
            tableOrdersDetails.getColumnModel().getColumn(0).setMinWidth(300);
        }

        lblOrderID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblOrderID.setForeground(Color.decode("#1d976c"));
        lblOrderID.setText("Mã hóa đơn:");

        txtOrderId.setToolTipText("");
        txtOrderId.setEnabled(false);
        txtOrderId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOrderIdActionPerformed(evt);
            }
        });

        lblDate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDate.setForeground(Color.decode("#1d976c"));
        lblDate.setText("Ngày lập: ");

        txtDate.setEnabled(false);
        txtDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateActionPerformed(evt);
            }
        });

        lblSumTotal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSumTotal.setForeground(Color.decode("#1d976c"));
        lblSumTotal.setText("Tổng tiền:");

        txtSumTotal.setEnabled(false);
        txtSumTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSumTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblOrderID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtOrderId, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(lblDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(lblSumTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSumTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollOrdersDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 922, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(21, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblSumTotal)
                        .addComponent(txtSumTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDate))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtOrderId, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblOrderID)))
                .addContainerGap(172, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(scrollOrdersDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 959, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void txtOrderIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrderIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOrderIdActionPerformed

    private void txtSumTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSumTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSumTotalActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String maHD = txtSearch.getText();

        // TODO add your handling code here:
        tableOrders.clearSelection();
        tableOrdersDetails.clearSelection();
        if (!maHD.isEmpty()) {
            jDateChooser3.setEnabled(false);
            jDateChooser4.setEnabled(false);
            boolean found = false;
            for (int i = 0; i < tableOrders.getRowCount(); i++) {
                String productIDTable = tableOrders.getValueAt(i, 0).toString();
                if (productIDTable.equalsIgnoreCase(maHD)) {
                    tableOrders.addRowSelectionInterval(i, i);
                    found = true;
                }
            }
            if (!found) {
                JOptionPane.showMessageDialog(this, "Hoa don khong ton tai");
            }
        } else if (jDateChooser3.getDate() == null || jDateChooser4.getDate() == null) {
            JOptionPane.showMessageDialog(this, "vui long nhap day du du lieu");

        } else {
            boolean found1 = false;

            for (int i = 0; i < tableOrders.getRowCount(); i++) {
                String dateString = tableOrders.getValueAt(i, 1).toString();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                java.util.Date selectedManufactureDate = jDateChooser3.getDate();
                java.util.Date selectedExpiryDate = jDateChooser4.getDate();

                LocalDate selectDate1 = selectedManufactureDate != null ? selectedManufactureDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;
                LocalDate selectDate2 = selectedExpiryDate != null ? selectedExpiryDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;
                //___________________________________________________________//

                DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String selectDate1str = selectDate1 != null ? selectDate1.format(formatter2) : null;
                String selectDate2str = selectDate2 != null ? selectDate2.format(formatter2) : null;
                LocalDate date1 = LocalDate.parse(selectDate1str, formatter2);
                LocalDate date2 = LocalDate.parse(selectDate2str, formatter2);
                //___________________________________________________________//
                LocalDate localDate = LocalDate.parse(dateString, formatter);
                if ((localDate.isAfter(date1) && localDate.isBefore(date2)) || (localDate.equals(date1) || localDate.equals(date2))) {
                    tableOrders.addRowSelectionInterval(i, i);
                    found1 = true;
                }
            }

            if (!found1) {

                JOptionPane.showMessageDialog(this, "khong tin thay");
            }
        }


    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        tableOrders.clearSelection();
        tableOrdersDetails.clearSelection();
        // o nhap
        txtSearch.setText("");
        // o hien thi ma hoa don 
        txtOrderId.setText("");
        txtSumTotal.setText("");
        txtDate.setText("");
        jDateChooser3.setEnabled(true);
        jDateChooser4.setEnabled(true);
        tableOrders.clearSelection();

    }//GEN-LAST:event_btnRefreshActionPerformed

    private void tableOrdersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableOrdersMouseClicked
        int row = tableOrders.getSelectedRow();
        if(row > -1){
            clearOrderDetailTable();
            String maHoaDon = tableOrders.getValueAt(row, 0).toString();
            String ngayLap = tableOrders.getValueAt(row, 1).toString();
            String tongTien = tableOrders.getValueAt(row, 3)+ " VND";
           txtOrderId.setText(maHoaDon);
            txtDate.setText(ngayLap);
            txtSumTotal.setText(tongTien);
            updateOrderDetailTable(maHoaDon);
        }
    }//GEN-LAST:event_tableOrdersMouseClicked

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void scrollOrdersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scrollOrdersMouseClicked
    
    }//GEN-LAST:event_scrollOrdersMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDateFrom;
    private javax.swing.JLabel lblDateTo;
    private javax.swing.JLabel lblOrderID;
    private javax.swing.JLabel lblOrderId;
    private javax.swing.JLabel lblSearch1;
    private javax.swing.JLabel lblSumTotal;
    private swing.PannelBorder pannelBorder1;
    private javax.swing.JScrollPane scrollOrders;
    private javax.swing.JScrollPane scrollOrdersDetails;
    private javax.swing.JTable tableOrders;
    private javax.swing.JTable tableOrdersDetails;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtOrderId;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSumTotal;
    // End of variables declaration//GEN-END:variables
}
