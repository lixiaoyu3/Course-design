/*
 * Created by JFormDesigner on Wed Dec 21 17:10:02 CST 2022
 */

package view.systemManage;

import entity.Account;

import java.awt.*;
import javax.swing.*;

/**
 * @author 1
 */
public class Account_info extends JFrame {
    private Account account;
    public Account_info(Account account) {
        this.account = account;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        System.out.println(account.getId());
        textField1 = new JTextField(String.valueOf(account.getId()));
        label2 = new JLabel();
        textField2 = new JTextField(account.getName());
        label3 = new JLabel();
        label4 = new JLabel();
        textField4 = new JTextField(String.valueOf(account.getAge()));
        label5 = new JLabel();
        textField5 = new JTextField(account.getDate());
        label6 = new JLabel();
        textField6 = new JTextField(account.getPhone());
        textField3 = new JTextField(account.getSex());
        label7 = new JLabel();
        textField7 = new JTextField(String.valueOf(account.getBalance()));

        //======== this ========
        setVisible(true);
        setTitle("\u8d26\u6237\u4fe1\u606f");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u5b66\u5458\u7f16\u53f7:");
        label1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        contentPane.add(label1);
        label1.setBounds(75, 35, 90, 30);
        contentPane.add(textField1);
        textField1.setBounds(160, 35, 100, 30);

        //---- label2 ----
        label2.setText("\u59d3\u540d\uff1a");
        label2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        contentPane.add(label2);
        label2.setBounds(75, 70, 90, 30);
        contentPane.add(textField2);
        textField2.setBounds(160, 75, 100, 30);

        //---- label3 ----
        label3.setText("\u6027\u522b\uff1a");
        label3.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        contentPane.add(label3);
        label3.setBounds(75, 115, 55, 30);

        //---- label4 ----
        label4.setText("\u5e74\u9f84\uff1a");
        label4.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        contentPane.add(label4);
        label4.setBounds(75, 165, 60, 30);
        contentPane.add(textField4);
        textField4.setBounds(160, 160, 100, 30);

        //---- label5 ----
        label5.setText("\u51fa\u751f\u65e5\u671f\uff1a");
        label5.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        contentPane.add(label5);
        label5.setBounds(65, 210, 85, 35);
        contentPane.add(textField5);
        textField5.setBounds(160, 210, 100, 30);

        //---- label6 ----
        label6.setText("\u7535\u8bdd\u53f7\u7801\uff1a");
        label6.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        contentPane.add(label6);
        label6.setBounds(60, 250, 85, 35);
        contentPane.add(textField6);
        textField6.setBounds(160, 255, 100, 30);
        contentPane.add(textField3);
        textField3.setBounds(160, 115, 100, 30);

        //---- label7 ----
        label7.setText("\u8d26\u6237\u4f59\u989d\uff1a");
        label7.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        contentPane.add(label7);
        label7.setBounds(60, 295, 85, 35);
        contentPane.add(textField7);
        textField7.setBounds(160, 300, 100, 30);

        textField1.setEnabled(false);
        textField2.setEnabled(false);
        textField3.setEnabled(false);
        textField4.setEnabled(false);
        textField5.setEnabled(false);
        textField6.setEnabled(false);
        textField7.setEnabled(false);

        contentPane.setPreferredSize(new Dimension(360, 415));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

//    public static void main(String[] args) {
//        new Account_info().setVisible(true);
//    }
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
    private JLabel label6;
    private JTextField textField6;
    private JTextField textField3;
    private JLabel label7;
    private JTextField textField7;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
