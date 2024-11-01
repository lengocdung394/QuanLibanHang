package swing;

import java.awt.Color;
import java.awt.Font;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import model.Model_Menu;

/**
 *
 * @author DungGa2134
 */
public class Menu_Item extends javax.swing.JPanel {

    /**
     * @return the selected
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
        repaint();
    }

    public void setOver(boolean over) {
        this.over = over;
        repaint();
    }

    private boolean selected;
    private boolean over;

    public Menu_Item(Model_Menu data) {
        initComponents();
        setOpaque(false);
        if (data.getType() == Model_Menu.MenuType.MENU) {
            lbicon.setIcon(data.toIcon());
            jLabel1.setText(data.getName());
            ///
        } else if (data.getType() == Model_Menu.MenuType.TITLE) {
            lbicon.setText(data.getName());
            lbicon.setFont(new Font("Segoe UI", Font.BOLD, 15));
            jLabel1.setVisible(false);
        } else {
            jLabel1.setText("");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (selected || over) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
           if(selected)
                g2.setColor(new Color(255, 255, 255, 80));
           else 
                g2.setColor(new Color(255, 255, 255, 20));
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 5, 5);
        }

        super.paintComponent(g); // Generated from 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbicon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setOpaque(false);

        lbicon.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Menu Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbicon, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
            .addComponent(lbicon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbicon;
    // End of variables declaration//GEN-END:variables
}
