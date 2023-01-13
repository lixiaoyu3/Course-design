/*
 * Created by JFormDesigner on Fri Dec 16 15:45:30 CST 2022
 */

package view;

import javafx.scene.control.ToggleGroup;
import util.DBUtil;
import util.sqliteUtil;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import javax.swing.*;
import javax.swing.event.*;

/**
 * @author 1
 */
public class LoginFrame extends JFrame {


    private DBUtil dbUtil = new DBUtil();
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JButton loginButton;
    private JButton restButton;
    private JLabel username;
    private JLabel password;
    private JLabel title;
    private JRadioButton userButton;
    private JLabel userType;
    private JRadioButton adminBUtton;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton exitButton;

    private ButtonGroup buttonGroup;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public LoginFrame() {
        initComponents();
    }


    public void background(){
        ((JPanel)this.getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon("/image/background.jpg"); //添加图片
        JLabel background = new  JLabel(img);
        this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
    }


    protected void restButton(ActionEvent ae) {
        this.textField1.setText("");
        this.passwordField1.setText("");
    }

    private void rest(ActionEvent e) {
        this.textField1.setText("");
        this.passwordField1.setText("");
        // TODO add your code here
    }

    private void radioButton1AncestorAdded(AncestorEvent e) {
        // TODO add your code here
    }

    public void exit(ActionEvent e) {
        System.exit(0);
    }

    private void actionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    //登录按钮
    public void loginButtonMouseClicked(MouseEvent e) {

        dbUtil.getConn();
        String name = textField1.getText();
        String pwd = String.valueOf(passwordField1.getPassword());
        String role = "";

        for (Enumeration buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = (AbstractButton) buttons.nextElement();
            if (button.isSelected()) {
                role = button.getText();
                break;
            }
        }

//        System.out.println(a);
        String sql = "select * from user where name = ? and pwd = ? and role = ?";
        System.out.println(name+" "+" "+pwd+" "+role);
        ResultSet resultSet = dbUtil.executeQuery(sql,new String[]{name,pwd,role});

        System.out.println(role.equals("\u7ba1\u7406\u5458"));
        try {
            if (resultSet.next()){
                if ("\u7ba1\u7406\u5458".equals(role)){
                    new AdminFrame(name).setVisible(true);
                }else{
                    new IndexFrame(name).setVisible(true);
                }
            }else {
              JOptionPane.showMessageDialog(null,"\u8d26\u53f7\u6216\u5bc6\u7801\u8f93\u5165\u9519\u8bef\uff01\uff01\uff01");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void login(ActionEvent e) {
        // TODO add your code here
    }


    private void initComponents() {
//        background();
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        loginButton = new JButton();
        restButton = new JButton();
        username = new JLabel();
        password = new JLabel();
        title = new JLabel();
        userButton = new JRadioButton("用户");
        userType = new JLabel();
        adminBUtton = new JRadioButton("管理员");
        textField1 = new JTextField();
        passwordField1 = new JPasswordField();
        exitButton = new JButton();
//
//        loginButton.setOpaque(false);
//        restButton.setOpaque(false);
//        username.setOpaque(false);
//        password.setOpaque(false);
//        title.setOpaque(false);
//        userButton.setOpaque(false);
//        userType.setOpaque(false);
//        adminBUtton.setOpaque(false);
//        textField1.setOpaque(false);
//        passwordField1.setOpaque(false);
//        exitButton.setOpaque(false);


        //======== this ========
        ((JPanel)this.getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon(getClass().getResource("/image/back.jpg")); //添加图片
        JLabel background = new  JLabel(img);
        this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());


        setMinimumSize(new Dimension(120, 360));
        setTitle("\u767b\u5f55\u754c\u9762");
        setIconImage(new ImageIcon(getClass().getResource("/image/\u767b\u5f55 (1).png")).getImage());
        Container contentPane = getContentPane();
        contentPane.setLayout(null);





        //---- loginButton ----
        loginButton.setText("\u767b\u5f55");
        loginButton.setFont(new Font("\u4eff\u5b8b", Font.PLAIN, 14));
        loginButton.setIcon(new ImageIcon(getClass().getResource("/image/\u767b\u5f55.png")));
        loginButton.setFocusPainted(false);
        loginButton.addActionListener(e -> login(e));
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loginButtonMouseClicked(e);
            }
        });
        contentPane.add(loginButton);
        loginButton.setBounds(125, 200, 85, 35);

        //---- restButton ----
        restButton.setText("\u91cd\u7f6e");
        restButton.setFont(new Font("\u4eff\u5b8b", Font.PLAIN, 14));
        restButton.setIcon(new ImageIcon(getClass().getResource("/image/\u91cd\u7f6e.png")));
        restButton.setFocusPainted(false);
        restButton.addActionListener(e -> {
            rest(e);
        });
        contentPane.add(restButton);
        restButton.setBounds(305, 200, 85, 35);

        //---- username ----
        username.setText("\u7528\u6237\u540d\uff1a");
        username.setFont(new Font("\u4eff\u5b8b", Font.PLAIN, 15));
        username.setIcon(new ImageIcon(getClass().getResource("/image/\u7528\u6237-\u5706.png")));
        contentPane.add(username);
        username.setBounds(25, 70, 80, 43);

        //---- password ----
        password.setText("\u5bc6\u7801\uff1a");
        password.setFont(new Font("\u4eff\u5b8b", Font.PLAIN, 15));
        password.setIcon(new ImageIcon(getClass().getResource("/image/\u5bc6\u7801.png")));
        contentPane.add(password);
        password.setBounds(25, 130, 78, 45);

        //---- title ----
        title.setText("      \u97f3\u4e50\u5b66\u5458\u7ba1\u7406\u7cfb\u7edf");
        title.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.PLAIN, 24));
        contentPane.add(title);
        title.setBounds(90, 10, 345, 55);

        //---- userButton ----
        userButton.setText("\u7528\u6237");
        userButton.setFont(new Font("\u4eff\u5b8b", Font.PLAIN, 14));
        userButton.setFocusPainted(false);
        userButton.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent e) {
                radioButton1AncestorAdded(e);
            }
            @Override
            public void ancestorMoved(AncestorEvent e) {}
            @Override
            public void ancestorRemoved(AncestorEvent e) {}
        });
        contentPane.add(userButton);
        userButton.setBounds(260, 260, 85, userButton.getPreferredSize().height);

        //---- userType ----
        userType.setText("\u7528\u6237\u7c7b\u578b\uff1a");
        userType.setFont(new Font("\u4eff\u5b8b", Font.PLAIN, 14));
        userType.setIcon(new ImageIcon(getClass().getResource("/image/\u591a\u7528\u6237 (2).png")));
        contentPane.add(userType);
        userType.setBounds(new Rectangle(new Point(65, 260), userType.getPreferredSize()));

        //---- adminBUtton ----
        adminBUtton.setText("\u7ba1\u7406\u5458");
        adminBUtton.setFont(new Font("\u4eff\u5b8b", Font.PLAIN, 14));
        adminBUtton.setFocusPainted(false);
        adminBUtton.setSelected(true);
        contentPane.add(adminBUtton);
        adminBUtton.setBounds(175, 260, 90, 21);
        contentPane.add(textField1);
        textField1.setBounds(125, 75, 265, 40);
        contentPane.add(passwordField1);
        passwordField1.setBounds(125, 135, 265, 40);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());

        //---- exitButton ----
        exitButton.setText("\u53d6\u6d88");
        exitButton.setFont(new Font("\u4eff\u5b8b", Font.PLAIN, 14));
        exitButton.setIcon(new ImageIcon(getClass().getResource("/image/\u53d6\u6d88.png")));
        exitButton.setFocusPainted(false);
        exitButton.addActionListener(e -> exit(e));


        //---- buttonGroup ----
        buttonGroup = new ButtonGroup();
        buttonGroup.add(userButton);
        buttonGroup.add(adminBUtton);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    public static void main(String[] args) {
        new LoginFrame().setVisible(true);
    }


}

