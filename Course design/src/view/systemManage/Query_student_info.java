/*
 * Created by JFormDesigner on Wed Dec 21 15:24:17 CST 2022
 */

package view.systemManage;

import entity.Account;
import util.DBUtil;
import util.ExportExcel1;
import view.AdminFrame;
import view.IndexFrame;

import java.awt.*;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author 1
 */
public class Query_student_info extends JFrame {
    public DBUtil dbUtil = new DBUtil();
    public Query_student_info() {
        initComponents();
    }

    public ArrayList<Account> getAllAccount(){
        ArrayList<Account> accounts = new ArrayList<>();
        Connection connection = dbUtil.getConn();
        String sql = "select * from account";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet rs = p.executeQuery();

            while (rs.next()){
                Account account = new Account();
                account.setId(rs.getInt(1));
                account.setName(rs.getString(2));
                account.setSex(rs.getString(3));
                account.setAge(rs.getInt(4));
                account.setDate(rs.getString(5));
                account.setPhone(rs.getString(6));
                account.setBalance(rs.getDouble(7));
                accounts.add(account);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return accounts;
    }


    /**导出JTable到excel */
    public void exportTable(JTable table, File file) throws IOException {
        TableModel model = table.getModel();
        BufferedWriter bWriter = new BufferedWriter(new FileWriter(file));
        for(int i=0; i < model.getColumnCount(); i++) {
            bWriter.write(model.getColumnName(i));
            bWriter.write("\t");
        }
        bWriter.newLine();
        for(int i=0; i< model.getRowCount(); i++) {
            for(int j=0; j < model.getColumnCount(); j++) {
                bWriter.write(model.getValueAt(i,j).toString());
                bWriter.write("\t");
            }
            bWriter.newLine();
        }
        bWriter.close();
        System.out.println("write out to: " + file);
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();
        textArea1 = new JTextArea();
        textField1 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setVisible(true);
        setMinimumSize(new Dimension(0, 0));
        setTitle("\u67e5\u8be2\u5b66\u751f\u4fe1\u606f");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            ArrayList<Account> accounts  = getAllAccount();

            Object[][] o = new Object[accounts.size()][6];

            for (int i = 0; i < accounts.size(); i++) {
                o[i][0] = accounts.get(i).getId();
                o[i][1] = accounts.get(i).getName();
                o[i][2] = accounts.get(i).getSex();
                o[i][3] = accounts.get(i).getAge();
                o[i][4] = accounts.get(i).getDate();
                o[i][5] = accounts.get(i).getPhone();
            }

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                o,
                new String[] {
                    "\u5b66\u5458\u7f16\u53f7", "\u59d3\u540d", "\u6027\u522b", "\u5e74\u9f84", "\u51fa\u751f\u65e5\u671f", "\u7535\u8bdd\u53f7\u7801"
                }
            ));
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(40, 115, 755, 395);

        //---- label1 ----
        label1.setText("\u8bf7\u8f93\u5165\u5b66\u5458\u7f16\u53f7\uff1a");
        contentPane.add(label1);
        label1.setBounds(65, 35, 110, 40);
        contentPane.add(textArea1);
        textArea1.setBounds(new Rectangle(new Point(190, 45), textArea1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(180, 40, 135, 35);

        //---- button1 ----
        button1.setText("\u67e5\u8be2");

        button1.addActionListener(e -> {
            //查询指定的学员，通过id
            Connection connection = dbUtil.getConn();
            String sql = "select * from account where id = ?";
            try {
                PreparedStatement p = connection.prepareStatement(sql);
                int id = Integer.parseInt(textField1.getText());
                System.out.println("id:"+id);
                p.setInt(1,id);
                ResultSet rs = p.executeQuery();

                if (rs.next()){
                    Object ob[][] = new Object[1][6];
                    ob[0][0] = rs.getInt(1);
                    ob[0][1] = rs.getString(2);
                    ob[0][2] = rs.getString(3);
                    ob[0][3] = rs.getInt(4);
                    ob[0][4] = rs.getString(5);
                    ob[0][5] = rs.getString(6);

                    table1.setModel(new DefaultTableModel(
                            ob,
                            new String[] {
                                    "\u5b66\u5458\u7f16\u53f7", "\u59d3\u540d", "\u6027\u522b", "\u5e74\u9f84", "\u51fa\u751f\u65e5\u671f", "\u7535\u8bdd\u53f7\u7801"
                            }
                    ));
                    scrollPane1.setViewportView(table1);
                }

            } catch (SQLException ee) {
                throw new RuntimeException(ee);
            }
        });


        contentPane.add(button1);
        button1.setBounds(350, 40, 110, 35);

        //---- button2 ----
        button2.setText("\u5bfc\u51fa\u5b66\u5458\u4fe1\u606f");

        //导出学员信息

        button2.addActionListener(e -> {

            FileDialog fd = new FileDialog(this, "保存流水记录", FileDialog.SAVE);
            fd.setLocation(400, 250);
            fd.setVisible(true);
            String stringfile = fd.getDirectory()+fd.getFile()+".xls";
            try {
                exportTable(table1, new File(stringfile));
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        });

        contentPane.add(button2);
        button2.setBounds(490, 40, 100, 35);

        contentPane.setPreferredSize(new Dimension(825, 635));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    private JTextArea textArea1;
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
