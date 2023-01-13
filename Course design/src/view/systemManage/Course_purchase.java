/*
 * Created by JFormDesigner on Wed Dec 21 16:14:19 CST 2022
 */

package view.systemManage;

import util.DBUtil;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

/**
 * @author 1
 */
public class Course_purchase extends JFrame {
    private DBUtil dbUtil = new DBUtil();
    public int id;
    private double balance;
    public Course_purchase(int id,double balance) {
        this.id = id;
        this.balance = balance;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        textField1 = new JTextField(String.valueOf(id));
        textField1.setEnabled(false);
        label2 = new JLabel();
        label3 = new JLabel();
        textField3 = new JTextField();
        label4 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        comboBox1 = new JComboBox<>();
        label5 = new JLabel();

        //======== this ========
        setVisible(true);
        setMinimumSize(new Dimension(0, 0));
        setTitle("\u8bfe\u7a0b\u8d2d\u4e70");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u5b66\u5458\u7f16\u53f7");
        contentPane.add(label1);
        label1.setBounds(85, 50, 90, 40);
        contentPane.add(textField1);
        textField1.setBounds(195, 55, 115, 35);

        //---- label2 ----
        label2.setText("\u8bfe\u7a0b\u540d\u79f0");
        contentPane.add(label2);
        label2.setBounds(85, 105, 90, 40);

        //---- label3 ----
        label3.setText("\u8d2d\u8bfe\u6570\u91cf");
        contentPane.add(label3);
        label3.setBounds(85, 160, 90, 40);
        contentPane.add(textField3);
        textField3.setBounds(195, 165, 115, 35);

        //---- label4 ----
        label4.setText("\u7528\u6237\u4f59\u989d");
        contentPane.add(label4);
        label4.setBounds(85, 220, 90, 40);

        //---- button1 ----
        button1.setText("\u8d2d\u8bfe");
        contentPane.add(button1);
        button1.setBounds(85, 315, 110, 40);


        //购课
        button1.addActionListener(e -> {
            //课程购买按钮

            String s = String.valueOf(comboBox1.getSelectedItem());
//            System.out.println(s);
            int price = Integer.parseInt(s.split(" ")[1]);
            String courseName = s.split(" ")[0];
            int num = Integer.parseInt(textField3.getText());
            if (balance >= price*num){
                Connection conn = dbUtil.getConn();
                //减少余额
                String updatesql = "UPDATE account SET balance = ? WHERE id = ?";
                //增加课程
                String insertsql = "INSERT INTO course (uid, course, courseNum) VALUES (?,?,?)";
                int result1 = 0;
                int result2 = 0;

                // 处理SQL,执行SQL
                try {
                    // 得到PreparedStatement对象
                    PreparedStatement pstmt1 = conn.prepareStatement(updatesql);
                    pstmt1.setDouble(1,balance - num*price);
                    pstmt1.setInt(2,id);
                    // 执行SQL语句
                    result1 = pstmt1.executeUpdate();

                    PreparedStatement pstmt2 = conn.prepareStatement(insertsql);
                    pstmt2.setInt(1,id);
                    pstmt2.setString(2,courseName);
                    pstmt2.setInt(3,num);
                    // 执行SQL语句
                    result2 = pstmt2.executeUpdate();
                } catch (SQLException ee) {
                    // 处理SQLException异常
                    ee.printStackTrace();
                }

                if (result1 != 0 && result2 != 0){
                    JOptionPane.showMessageDialog(null, "\u8d2d\u8bfe\u6210\u529f");

                }else {
                    JOptionPane.showMessageDialog(null, "\u8d2d\u8bfe\u5931\u8d25");
                }
            }else {
                JOptionPane.showMessageDialog(null, "\u4f59\u989d\u4e0d\u8db3");
            }
        });


        button2.addActionListener(e -> {
            //课程退订按钮

            String s = String.valueOf(comboBox1.getSelectedItem());
//            System.out.println(s);
            int price = Integer.parseInt(s.split(" ")[1]);
            String courseName = s.split(" ")[0];

            Connection conn = dbUtil.getConn();
            int count = 0;
            try {
                Statement statement = conn.createStatement();
                String searchsql = "select * from course where course = '"+courseName+"'";
                ResultSet rs = statement.executeQuery(searchsql);
                if (rs.next()){
                    count = rs.getInt(4);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


            //增加余额
            String updatesql = "UPDATE account SET balance = ? WHERE id = ?";
            //删除课程
            String deletesql = "DELETE FROM course WHERE course = '"+courseName+"' and uid = "+id;

            int result1 = 0;
            int result2 = 0;

            // 处理SQL,执行SQL
            try {
                // 得到PreparedStatement对象
                PreparedStatement pstmt1 = conn.prepareStatement(updatesql);
                pstmt1.setDouble(1,balance + count*price);
                pstmt1.setInt(2,id);
                // 执行SQL语句
                result1 = pstmt1.executeUpdate();

                PreparedStatement pstmt2 = conn.prepareStatement(deletesql);
                // 执行SQL语句
                result2 = pstmt2.executeUpdate();
            } catch (SQLException ee) {
                // 处理SQLException异常
                ee.printStackTrace();
            }

            if (result1 != 0 && result2 != 0){
                JOptionPane.showMessageDialog(null, "\u9000\u8bfe\u6210\u529f");

            }else {
                JOptionPane.showMessageDialog(null, "\u9000\u8bfe\u5931\u8d25");
            }
        });
        //---- button2 ----
        button2.setText("\u9000\u8bfe");
        contentPane.add(button2);
        button2.setBounds(235, 320, 110, 35);

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "\u5409\u4ed6 200 \uffe5",
            "\u94a2\u7434 400 \uffe5",
            "\u5c0f\u63d0\u7434 400 \uffe5",
            "\u67b6\u5b50\u9f13 300 \uffe5",
            "\u957f\u7b1b 100 \uffe5"
        }));
        contentPane.add(comboBox1);
        comboBox1.setBounds(200, 115, 115, 35);

        //---- label5 ----
        label5.setText(String.valueOf(balance));
        label5.setForeground(new Color(0xff0033));
        contentPane.add(label5);
        label5.setBounds(200, 230, 110, 30);

        contentPane.setPreferredSize(new Dimension(620, 480));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }
//    public static void main(String[] args) {
//        new Course_purchase().setVisible(true);
//    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField3;
    private JLabel label4;
    private JButton button1;
    private JButton button2;
    private JComboBox<String> comboBox1;
    private JLabel label5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
