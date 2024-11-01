/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package component;

import event.EventMenuSelected;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import model.Model_Menu;

/**
 *
 * @author DungGa2134
 */
public class Menu extends javax.swing.JPanel {
    private EventMenuSelected event;
    public void addEventMenuSelected(EventMenuSelected event){
        this.event = event;
        listMenu.addEventMenuSelected(event);
    }
    /**
     * Tạo form menu mới
     */
    public Menu() {
        initComponents();
        /*
        Đặt giao diện hình nền trong suốt
        */
        setOpaque(false);
        init();
    }
    
    /**
     * Thêm các Item vào Menu
     */
    private void init(){
        listMenu.addItem(new Model_Menu("home","Trang chủ",Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("inhoadon","In hóa đơn",Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("hoadon","Hóa đơn",Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("sanpham","Sản phẩm",Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("nhacungcap","Nhà cung cấp",Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu(""," ",Model_Menu.MenuType.EMPTY));
        
        listMenu.addItem(new Model_Menu(""," ",Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu(""," ",Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu(""," ",Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu(""," ",Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu(""," ",Model_Menu.MenuType.EMPTY));
        
        listMenu.addItem(new Model_Menu("","",Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("logout","Thoát",Model_Menu.MenuType.MENU));
        
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelMoving = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        listMenu = new swing.ListMenu<>();

        PanelMoving.setName("panelMoving"); // NOI18N
        PanelMoving.setOpaque(false);

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logo.png"))); // NOI18N
        lblTitle.setText("BreezeStore");

        listMenu.setOpaque(false);

        javax.swing.GroupLayout PanelMovingLayout = new javax.swing.GroupLayout(PanelMoving);
        PanelMoving.setLayout(PanelMovingLayout);
        PanelMovingLayout.setHorizontalGroup(
            PanelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMovingLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
            .addComponent(listMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelMovingLayout.setVerticalGroup(
            PanelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMovingLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(listMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintChildren(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g1;
        g1 = new GradientPaint(0, 0, Color.decode("#1d976c"), 0, getHeight(), Color.decode("#93f9b9"));
        g2.setPaint(g1);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        super.paintChildren(g);
    }

    private int x;
    private int y;

    public void initMoving(JFrame fram) {
        PanelMoving.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
            }

        });

        PanelMoving.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                fram.setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
            }

        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelMoving;
    private javax.swing.JLabel lblTitle;
    private swing.ListMenu<String> listMenu;
    // End of variables declaration//GEN-END:variables
}
