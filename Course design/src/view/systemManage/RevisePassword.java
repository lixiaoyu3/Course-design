/*
 * Created by JFormDesigner on Tue Dec 20 21:06:50 CST 2022
 */

package view.systemManage;

import util.DBUtil;
import view.IndexFrame;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author 1
 */
public class RevisePassword extends JFrame {
    private String name;
    private DBUtil dbUtil = new DBUtil();
    public RevisePassword(String name) {
        this.name = name;
        initComponents();
    }

    private void login(ActionEvent e) {
        // TODO add your code here
    }

    private void loginButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    protected void button2(ActionEvent ae) {
        this.textField1.setText("");
        this.textField2.setText("");
        this.textField2.setText("");
    }

    private void rest(ActionEvent e) {
        this.textField1.setText("");
        this.textField2.setText("");
        this.textField2.setText("");
        // TODO add your code here
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label6 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        label5 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        label7 = new JLabel();

        //======== this ========
        setVisible(true);
        setTitle("        \u4fee\u6539\u5bc6\u7801");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u5f53\u524d\u7528\u6237\uff1a");
        label1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        contentPane.add(label1);
        label1.setBounds(75, 30, 75, 45);

        //---- label2 ----
        label2.setText(name);
        label2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        label2.setForeground(Color.red);
        contentPane.add(label2);
        label2.setBounds(160, 30, 170, 45);

        //---- label3 ----
        label3.setText("\u65e7\u5bc6\u7801\uff1a");
        label3.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        contentPane.add(label3);
        label3.setBounds(85, 85, 75, 45);

        //---- label4 ----
        label4.setText("\u65b0\u5bc6\u7801\uff1a");
        label4.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        contentPane.add(label4);
        label4.setBounds(85, 140, 75, 45);

        //---- label6 ----
        label6.setText("\u786e\u8ba4\u5bc6\u7801\uff1a");
        label6.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        contentPane.add(label6);
        label6.setBounds(85, 195, 70, 45);
        contentPane.add(textField1);
        textField1.setBounds(160, 95, 150, 35);
        contentPane.add(textField2);
        textField2.setBounds(160, 150, 150, 35);
        contentPane.add(textField3);
        textField3.setBounds(160, 200, 150, 35);
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(215, 435), label5.getPreferredSize()));

        //---- button1 ----
        button1.setText("\u786e\u8ba4");

        button1.addActionListener(e -> {
            dbUtil.getConn();
            String pwd = textField1.getText();
            String pwd1 = textField2.getText();
            String pwd2 = textField3.getText();

            System.out.println(pwd+" "+pwd1+" "+pwd2);

            if (pwd1 == pwd2 || pwd1.equals(pwd2)){
                String updatesql = "UPDATE user SET pwd = ? WHERE name = ?";
                int result = dbUtil.executeUpdate(updatesql,new String[]{pwd2,name});
                if (result != 0){
                    JOptionPane.showMessageDialog(null, "\u5bc6\u7801\u4fee\u6539\u6210\u529f");
                    System.out.println("1111");
                }


//                String sql = "select * from user where name = ? and pwd = ?";
//
//                ResultSet resultSet = dbUtil.executeQuery(sql,new String[]{name,pwd});
//
//                if (resultSet != null){
//                    String updatesql = "UPDATE account SET pwd = ? WHERE name = ?";
//                    int result = dbUtil.executeUpdate(updatesql,new String[]{pwd,name});
//                    if (result != 0){
//                        JOptionPane.showMessageDialog(null, "\u5bc6\u7801\u4fee\u6539\u6210\u529f");
//                    }
//                }else {
//                    JOptionPane.showMessageDialog(null, "\u539f\u5bc6\u7801\u9519\u8bef");
//                }
            }else {
                JOptionPane.showMessageDialog(null, "\u4e24\u6b21\u5bc6\u7801\u4e0d\u4e00\u81f4");
            }
        });


        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(120, 300), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u91cd\u7f6e");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(235, 300), button2.getPreferredSize()));
        button2.setFocusPainted(false);
        button2.addActionListener(e -> {
            rest(e);
        });
        contentPane.add(button2);



        contentPane.add(label7);
        label7.setBounds(455, 110, 20, 225);

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
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }
    //    public static void main(String[] args) {
//        new RevisePassword().setVisible(true);
//    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label6;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel label5;
    private JButton button1;
    private JButton button2;
    private JLabel label7;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
