package main;

import event.EventMenuSelected;
import form.Form_Chart;

import form.Form_Orders;
import form.Form_Payment;
import form.Form_Products;

import form.Form_Suppliers;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JOptionPane;



public class Main extends javax.swing.JFrame {

    private String loggedInUserName;

    private Main() {
        
    }

    public void setLoggedInUserName(String name) {
        loggedInUserName = name;
    }

    public String getLoggedInUserName() {
        return loggedInUserName;
    }

    public Main(String name) {
        initComponents();
        this.loggedInUserName = name;
        setLocationRelativeTo(null);
        //setBackground(new Color(0, 0, 0, 0));
        menu.initMoving(Main.this);
        menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                switch (index) {
                    case 0:
                        setForm(new Form_Chart());
                        break;
                    case 1:
                        setForm(new Form_Payment(getLoggedInUserName()));
                        break;
                    case 2:
                        setForm(new Form_Orders());
                        break;
                    case 3:
                        setForm(new Form_Products());
                        break;
                    case 4:
                        setForm(new Form_Suppliers());
                        break;
                    case 12:
                        int i = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn đăng xuất không ?", "Cảnh báo", JOptionPane.YES_NO_OPTION);
                        if (i == JOptionPane.YES_OPTION) {
                            System.exit(0);
                        }
                        break;

                }

            }

        });
        setForm(new Form_Chart());
    }

    private void setForm(Component component) {
        mainPanel.removeAll();
        mainPanel.add(component);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pannelBorder2 = new swing.PannelBorder();
        pannelBorder1 = new swing.PannelBorder();
        menu = new component.Menu();
        mainPanel = new javax.swing.JPanel();

        javax.swing.GroupLayout pannelBorder2Layout = new javax.swing.GroupLayout(pannelBorder2);
        pannelBorder2.setLayout(pannelBorder2Layout);
        pannelBorder2Layout.setHorizontalGroup(
            pannelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        pannelBorder2Layout.setVerticalGroup(
            pannelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pannelBorder1.setBackground(new java.awt.Color(242, 240, 240));
        pannelBorder1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        mainPanel.setOpaque(false);
        mainPanel.setPreferredSize(new java.awt.Dimension(1000, 571));
        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout pannelBorder1Layout = new javax.swing.GroupLayout(pannelBorder1);
        pannelBorder1.setLayout(pannelBorder1Layout);
        pannelBorder1Layout.setHorizontalGroup(
            pannelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelBorder1Layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 964, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pannelBorder1Layout.setVerticalGroup(
            pannelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelBorder1Layout.createSequentialGroup()
                .addGroup(pannelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pannelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pannelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanel;
    private component.Menu menu;
    private swing.PannelBorder pannelBorder1;
    private swing.PannelBorder pannelBorder2;
    // End of variables declaration//GEN-END:variables
}
