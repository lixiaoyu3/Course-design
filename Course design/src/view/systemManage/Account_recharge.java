/*
 * Created by JFormDesigner on Wed Dec 21 17:04:46 CST 2022
 */

package view.systemManage;

import entity.Account;
import util.DBUtil;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

/**
 * @author 1
 */
public class Account_recharge extends JFrame {
    private int id;
    private double balance;
    private String name;
    private DBUtil dbUtil = new DBUtil();
    public Account_recharge(String name) {
        this.name = name;
        initComponents();
    }

    private void initComponents() {
        dbUtil.getConn();
        System.out.println(name);
        String sql = "select * from account where name = ?";

        ResultSet rs = dbUtil.executeQuery(sql,new String[]{name});
        try {
            if (rs.next()){
                id = rs.getInt(1);
                balance = rs.getDouble(7);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        textField1 = new JTextField(String.valueOf(id));
        textField1.setEnabled(false);
        label2 = new JLabel();
        label3 = new JLabel();
        textField3 = new JTextField();
        label4 = new JLabel();
        label5 = new JLabel();
        textField2 = new JTextField(name);
        textField2.setEnabled(false);
        button1 = new JButton();

        //======== this ========
        setVisible(true);
        setTitle("\u8d26\u6237\u5145\u503c");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u5b66\u5458\u7f16\u53f7");
        contentPane.add(label1);
        label1.setBounds(70, 75, 90, 40);
        contentPane.add(textField1);
        textField1.setBounds(180, 80, 115, 35);

        //---- label2 ----
        label2.setText("\u59d3\u540d");
        contentPane.add(label2);
        label2.setBounds(75, 140, 90, 40);

        //---- label3 ----
        label3.setText("\u5145\u503c\u91d1\u989d");
        contentPane.add(label3);
        label3.setBounds(70, 195, 90, 40);
        contentPane.add(textField3);
        textField3.setBounds(180, 200, 115, 35);

        //---- label4 ----
        label4.setText("\u7528\u6237\u4f59\u989d");
        contentPane.add(label4);
        label4.setBounds(70, 245, 90, 40);

        //---- label5 ----
        label5.setText(String.valueOf(balance));
        label5.setForeground(new Color(0xff0033));
        contentPane.add(label5);
        label5.setBounds(185, 255, 110, 30);
        contentPane.add(textField2);
        textField2.setBounds(180, 145, 110, 35);

        //---- button1 ----
        button1.setText("\u5145\u503c");
        contentPane.add(button1);
        button1.setBounds(150, 310, 108, 30);

        button1.addActionListener(e -> {
            //充值
            double num = Double.parseDouble(textField3.getText());
            Connection conn = dbUtil.getConn();
            PreparedStatement pstmt = null;
            String updatesql = "UPDATE account SET balance = ? WHERE id = ?";
            int result = 0;

            // 处理SQL,执行SQL
            try {
                // 得到PreparedStatement对象
                pstmt = conn.prepareStatement(updatesql);
                pstmt.setDouble(1,num+balance);
                pstmt.setInt(2,id);
                // 执行SQL语句
                result = pstmt.executeUpdate();
            } catch (SQLException ee) {
                // 处理SQLException异常
                ee.printStackTrace();
            }

            if (result != 0){
                JOptionPane.showMessageDialog(null, "\u5145\u503c\u6210\u529f");

            }else {
                JOptionPane.showMessageDialog(null, "\u5145\u503c\u5931\u8d25");
            }
        });

        contentPane.setPreferredSize(new Dimension(445, 430));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }
    Container contentPane = getContentPane();


    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField3;
    private JLabel label4;
    private JLabel label5;
    private JTextField textField2;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
