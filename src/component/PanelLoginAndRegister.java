package component;

import connectBD.ConnectDB;
import dao.Employee_DAO;
import entity.Employees;
import swing.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import main.Main;
import net.miginfocom.swing.MigLayout;
import swing.MyPasswordField;
import swing.MyTextField;

public class PanelLoginAndRegister extends javax.swing.JLayeredPane {

    private ArrayList<Employees> nhanViens;
    private Employee_DAO nhanVien_DAO;
    private MyTextField txtName;

    public PanelLoginAndRegister() {

        try {
            ConnectDB.getInstance().connect();
            nhanVien_DAO = new Employee_DAO();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        initComponents();
        initFRegister();
        initLogin();

        nhanViens = nhanVien_DAO.getEmployee();
        login.setVisible(false);
        register.setVisible(true);
    }

    public void initFRegister() {
        // nam giua trang
        register.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]10[]push"));
        // register.setLayout(new MigLayout("wrap","push[center]push",""));

        JLabel label = new JLabel("Create Account");
        label.setFont(new Font("Arial", 1, 30));

        label.setForeground(new Color(22, 116, 66));

        register.add(label);

        txtName = new MyTextField();
        txtName.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/user.png")));
        txtName.setHint("Name");
        register.add(txtName, "w 60%");

        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/mail.png")));
        txtEmail.setHint("Email");
        register.add(txtEmail, "w 60%");

        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/pass.png")));
        txtPass.setHint("Password");
        register.add(txtPass, "w 60%");

        Button btt = new Button();
        btt.setBackground(new Color(22, 116, 66));
        btt.setForeground(new Color(250, 250, 250));
        btt.setText("SIGN IN");

        register.add(btt, "w 50%, h 40");

    }

    public JPanel login() {
        return login;
    }

    public MyTextField getTxtName() {
        return txtName;
    }

    public void initLogin() {

        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10push"));

        JLabel label = new JLabel("SIGN IN");
        label.setFont(new Font("Arial", 1, 30));

        label.setForeground(new Color(22, 116, 66));

        login.add(label);

        txtName = new MyTextField();
        txtName.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/user.png")));
        txtName.setHint("Name");
        login.add(txtName, "w 60%");

        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/pass.png")));
        txtPass.setHint("Password");
        login.add(txtPass, "w 60%");

        Button btt = new Button();
        btt.setBackground(new Color(22, 116, 66));
        btt.setForeground(new Color(250, 250, 250));
        btt.setText("SIGN IN");

        login.add(btt, "w 50%, h 40");

        btt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag = false;
                // Kiểm tra dữ liệu đăng nhập
                for (Employees nv : nhanViens) {
                    char[] passwordChars = txtPass.getPassword();
                    String password = new String(passwordChars);
                    if (nv.getMaNV().equalsIgnoreCase(txtName.getText()) && nv.getSoDT().equalsIgnoreCase(password)) {
                        showMainPage();
                        flag = true;
                    }
                }
                if (!flag) {
                    showLoginError();

                }

            }
        });

    }

    private void showMainPage() {
        String name = getTxtName().getText(); // Lấy giá trị của txtName
        Main main = new Main(name);
      
        main.setVisible(true);
        // Đóng cửa sổ hiện tại (đăng nhập)
        SwingUtilities.getWindowAncestor(this).dispose();
    }

    private void showLoginError() {
        JOptionPane.showMessageDialog(this, "Tên đăng nhập hoặc mật khẩu không đúng", "Lỗi đăng nhập", JOptionPane.ERROR_MESSAGE);
    }

    public void initFRegister1() {
        // ...
        txtName = new MyTextField(); // Loại bỏ khai báo kiểu dữ liệu MyTextField
        // ...
    }

    public void initLogin1() {
        // ...
        txtName = new MyTextField(); // Loại bỏ khai báo kiểu dữ liệu MyTextField
        // ...
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        register = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );

        add(login, "card2");

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(register, "card3");
    }// </editor-fold>//GEN-END:initComponents
    public void showRegister(boolean show) {

        if (show) {
            register.setVisible(true);
            login.setVisible(false);
        } else {
            register.setVisible(false);
            login.setVisible(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}
