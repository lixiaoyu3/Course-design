/*
 * Created by JFormDesigner on Wed Dec 21 14:40:23 CST 2022
 */

package view.systemManage;

import org.sqlite.core.DB;
import util.DBUtil;
import view.AdminFrame;
import view.IndexFrame;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import javax.swing.*;

/**
 * @author 1
 */
public class Add_student_info extends JFrame {
    public DBUtil dbUtil = new DBUtil();
    public Add_student_info() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
//        label1 = new JLabel();
//        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        label4 = new JLabel();
        textField4 = new JTextField();
        label5 = new JLabel();
        textField5 = new JTextField();
        comboBox1 = new JComboBox<>();
        label6 = new JLabel();
        textField6 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        label8 = new JLabel();

        //======== this ========
        setVisible(true);
        setTitle("  \u6dfb\u52a0\u5b66\u751f\u4fe1\u606f");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
//        label1.setText("\u5b66\u5458\u7f16\u53f7:");
//        label1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
//        contentPane.add(label1);
//        label1.setBounds(40, 45, 90, 30);
//        contentPane.add(textField1);
//        textField1.setBounds(125, 45, 100, textField1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u59d3\u540d\uff1a");
        label2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        contentPane.add(label2);
        label2.setBounds(40, 80, 90, 30);
        contentPane.add(textField2);
        textField2.setBounds(125, 85, 100, 30);

        //---- label3 ----
        label3.setText("\u6027\u522b\uff1a");
        label3.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        contentPane.add(label3);
        label3.setBounds(40, 120, 55, 30);

        //---- label4 ----
        label4.setText("\u5e74\u9f84\uff1a");
        label4.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        contentPane.add(label4);
        label4.setBounds(40, 175, 60, 30);
        contentPane.add(textField4);
        textField4.setBounds(125, 170, 100, 30);

        //---- label5 ----
        label5.setText("\u51fa\u751f\u65e5\u671f\uff1a");
        label5.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        contentPane.add(label5);
        label5.setBounds(30, 220, 85, 35);
        contentPane.add(textField5);
        textField5.setBounds(125, 220, 100, 30);

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "\u7537",
            "\u5973"
        }));
        contentPane.add(comboBox1);
        comboBox1.setBounds(new Rectangle(new Point(130, 125), comboBox1.getPreferredSize()));

        //---- label6 ----
        label6.setText("\u7535\u8bdd\u53f7\u7801\uff1a");
        label6.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        contentPane.add(label6);
        label6.setBounds(25, 260, 85, 35);
        contentPane.add(textField6);
        textField6.setBounds(125, 265, 100, 30);

        //---- button1 ----
        button1.setText("\u6dfb\u52a0");


        button1.addActionListener(e -> {
            //添加学员
            String name = textField2.getText();
            int age = Integer.parseInt(textField4.getText());
            String date = textField5.getText();
            String phone = textField6.getText();
            String sex = String.valueOf(comboBox1.getSelectedItem());

            String sql = "INSERT INTO account (name,sex,age,date,phone,balance) VALUES (?,?,?,?,?,?)";
            Connection conn = dbUtil.getConn();

            // 处理SQL,执行SQL
            try {
                // 得到PreparedStatement对象
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,name);
                pstmt.setString(2,sex);
                pstmt.setInt(3,age);
                pstmt.setString(4,date);
                pstmt.setString(5,phone);
                pstmt.setDouble(6,0);
                // 执行SQL语句
                int result = pstmt.executeUpdate();

                if (result != 0){
                    JOptionPane.showMessageDialog(null, "\u6dfb\u52a0\u6210\u529f");
                }
            } catch (SQLException ee) {
                // 处理SQLException异常
                ee.printStackTrace();
            }
        });


        contentPane.add(button1);
        button1.setBounds(35, 335, button1.getPreferredSize().width, 35);

        //---- button2 ----
        button2.setText("\u53d6\u6d88");
        contentPane.add(button2);
        button2.setBounds(155, 335, 78, 35);
        contentPane.add(label8);
        label8.setBounds(5, 5, 80, 25);

        contentPane.setPreferredSize(new Dimension(345, 445));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JLabel label4;
    private JTextField textField4;
    private JLabel label5;
    private JTextField textField5;
    private JComboBox<String> comboBox1;
    private JLabel label6;
    private JTextField textField6;
    private JButton button1;
    private JButton button2;
    private JLabel label8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
