package component;


import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import swing.Button;
import swing.ButtonOutLine;

public class PanelCover extends javax.swing.JPanel {

    private final DecimalFormat df = new DecimalFormat("##0.###", DecimalFormatSymbols.getInstance(Locale.US));
    private ActionListener event;
    private MigLayout layout;
    private JLabel title;
    private JLabel description;
    private JLabel description1;
    private Button btt;
    private ButtonOutLine bttout;
    private boolean islogin;

    public PanelCover() {
        initComponents();
        setOpaque(false);
        layout = new MigLayout("wrap, fill", "[center]", "push[]25[]10[]25[]push");
        setLayout(layout);
        init();
    }

    private void init() {
        // khia bao + add tua de

        title = new JLabel("Welcome Back!");
        title.setFont(new Font("sanserif", 1, 30));
        title.setForeground(new Color(255, 255, 245));
        add(title);

        // mo ta mot 
        description = new JLabel("To keep connected with us please");
        description.setForeground(new Color(255, 255, 245));
        add(description);

        description1 = new JLabel("Login with your personal info");
        description1.setForeground(new Color(255, 255, 245));
        add(description1);

        bttout = new ButtonOutLine();
        bttout.setBackground(new Color(255, 255, 245));
        bttout.setForeground(new Color(255, 255, 255));

        bttout.setText("SIGN IN");
        bttout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                event.actionPerformed(e);
            }

        }
        );
        add(bttout, "w 60%, h 30");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        GradientPaint gra = new GradientPaint(0, 0, new Color(35, 166, 97), 0, getHeight(), new Color(22, 116, 66));
        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(grphcs);
    }

    public void addEvent(ActionListener event) {
        this.event = event;
    }

    public void registerLeft(double v) {
        v = Double.valueOf(df.format(v));
        login(false);
        layout.setComponentConstraints(title, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(description, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(description1, "pad 0 -" + v + "% 0 0");
    }

    public void registerRight(double v) {
        v = Double.valueOf(df.format(v));
        login(false);
        layout.setComponentConstraints(title, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(description, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(description1, "pad 0 -" + v + "% 0 0");
    }

    public void loginRight(double v) {
        v = Double.valueOf(df.format(v));
        login(true);
        layout.setComponentConstraints(title, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(description, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(description1, "pad 0 " + v + "% 0 " + v + "%");
    }

    public void loginLeft(double v) {
        v = Double.valueOf(df.format(v));
        login(true);
        layout.setComponentConstraints(title, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(description, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(description1, "pad 0 " + v + "% 0 " + v + "%");
    }

    private void login(boolean login) {
        if(this.islogin!= login){
            if(login){
                title.setText("Hello friend");
                description.setText("Welcome Back!");
               // description1.setText("Ngoc dunggg");
            }else{
                title.setText("Welcome Back!");
                description.setText("To keep connected with us please");
                description1.setText("Login with your personal info");
            }
            
        }
        this.islogin=login;

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
