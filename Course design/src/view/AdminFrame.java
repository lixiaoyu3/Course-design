package view;

import entity.Account;
import util.DBUtil;
import view.systemManage.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminFrame extends JFrame {
    private String name;
    private DBUtil dbUtil = new DBUtil();
    public AdminFrame(String name) {
        this.name = name;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        menu2 = new JMenu();
        menuItem3 = new JMenuItem();
        menuItem4 = new JMenuItem();
        menuItem11 = new JMenuItem();
        menuItem12 = new JMenuItem();
//        menu4 = new JMenu();
//        menuItem7 = new JMenuItem();
//        menu3 = new JMenu();
//        menuItem5 = new JMenuItem();
//        menu5 = new JMenu();
//        menuItem8 = new JMenuItem();

//        String picPath = AdminFrame.class.getResource("/image/back.jpg").getPath();// 将getFile改为getPath亦可
//
//        final Image image;
//        try {
//            image = ImageIO.read(new File(picPath));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        desktopPane1 = new JDesktopPane() {
//            public void paint(Graphics g) {
//                // 改为protected void paintComponent(Graphics g) { 亦可
//                g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
//            };
//        };

        menuBar1.setBackground(new Color(212,242,250));

        desktopPane1 = new JDesktopPane();



        //======== this ========

        Container contentPane = getContentPane();



        contentPane.setLayout(new BorderLayout());



        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("  \u7cfb\u7edf\u7ba1\u7406");
                menu1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 15));

                //---- menuItem1 ----
                menuItem1.setText(" \u4fee\u6539\u5bc6\u7801");
                menuItem1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));

                menuItem1.addActionListener(e -> {
                    //修改密码
                    new RevisePassword(name).setVisible(true);
                });

                menu1.add(menuItem1);

                //---- menuItem2 ----
                menuItem2.setText(" \u9000\u51fa\u7cfb\u7edf");
                menuItem2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));

                menuItem2.addActionListener(e -> {
                    System.exit(0);
                });

                menu1.add(menuItem2);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("\u5b66\u5458\u4fe1\u606f");
                menu2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 15));

                //---- menuItem3 ----
                menuItem3.setText("\u6dfb\u52a0\u5b66\u5458");
                menuItem3.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));

                //添加学员
                menuItem3.addActionListener(e -> {
                    new Add_student_info().setVisible(true);
                });
                menu2.add(menuItem3);


                //---- menuItem4 ----
                menuItem4.setText("\u67e5\u8be2\u5b66\u5458\u4fe1\u606f");
                menuItem4.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));

                //查询所有学员信息
                menuItem4.addActionListener(e -> {
                    new Query_student_info().setVisible(true);
                });
                menu2.add(menuItem4);

             /*   //---- menuItem11 ----
                menuItem11.setText("\u4fee\u6539\u5b66\u5458\u4fe1\u606f");
                menuItem11.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
                menu2.add(menuItem11);

                //---- menuItem12 ----
                menuItem12.setText("\u5220\u9664\u5b66\u5458\u4fe1\u606f");
                menuItem12.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
                menu2.add(menuItem12);*/
            }
            menuBar1.add(menu2);

//            //======== menu4 ========
//            {
//                menu4.setText(" \u8bfe\u7a0b\u8d2d\u4e70");
//                menu4.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 15));
//
//                //---- menuItem7 ----
//                menuItem7.setText("\u8bfe\u7a0b\u8d2d\u4e70");
//                menuItem7.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
//
//                menuItem7.addActionListener(e -> {
//                    //课程购买按钮
//
//                    dbUtil.getConn();
////                    System.out.println(name);
//                    String sql = "select * from account where name = ?";
//
//                    ResultSet rs = dbUtil.executeQuery(sql,new String[]{name});
//
//                    try {
//                        int id = 0;
//                        double balance = 0;
//                        if (rs.next()){
//                            id = rs.getInt(1);
//                            balance = rs.getDouble(7);
//                        }
//
//                        new Course_purchase(id,balance).setVisible(true);
//                    } catch (SQLException ex) {
//                        throw new RuntimeException(ex);
//                    }
//                });
//
//                menu4.add(menuItem7);
//            }
//            menuBar1.add(menu4);
//
//            //======== menu3 ========
//            {
//                menu3.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 15));
//                menu3.setText("\u8d26\u6237\u5145\u503c");
//
//                //---- menuItem5 ----
//                menuItem5.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
//                menuItem5.setText("\u8d26\u6237\u5145\u503c");
//
//
//                menuItem5.addActionListener(e -> {
//                    //充值按钮
//                    new Account_recharge(name).setVisible(true);
//                });
//
//                menu3.add(menuItem5);
//            }
//            menuBar1.add(menu3);
//
//            //======== menu5 ========
//            {
//                menu5.setText("\u4e2a\u4eba\u4fe1\u606f");
//                menu5.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 15));
//
//                //---- menuItem8 ----
//                menuItem8.setText("\u8d26\u6237\u4fe1\u606f");
//                menuItem8.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
//                menuItem8.addActionListener(e -> {
//                    //查看个人信息按钮
//                    dbUtil.getConn();
////                    System.out.println(name);
//                    String sql = "select * from account where name = ?";
//
//                    ResultSet rs = dbUtil.executeQuery(sql,new String[]{name});
//
//                    try {
//                        if(rs.next()) {
//                            Account account = new Account();
//                            account.setId(rs.getInt(1));
//                            account.setName(rs.getString(2));
//                            account.setSex(rs.getString(3));
//                            account.setAge(rs.getInt(4));
//                            account.setDate(rs.getString(5));
//                            account.setPhone(rs.getString(6));
//                            account.setBalance(rs.getDouble(7));
//                            System.out.println(account.toString());
//                            new Account_info(account);
//                        }
//                    } catch (SQLException ex) {
//                        throw new RuntimeException(ex);
//                    }
//                });
//                menu5.add(menuItem8);
//            }
//            menuBar1.add(menu5);
        }
        setJMenuBar(menuBar1);

        //======== desktopPane1 ========
        {
            desktopPane1.setForeground(new Color(0x6bafdd));
        }
//        desktopPane1.setBackground(Color.WHITE);
//        contentPane.add(desktopPane1, BorderLayout.CENTER);
//        JLabel backgroundLabel = new JLabel();
//        ImageIcon img = new ImageIcon(AdminFrame.class.getResource("/image/back.jpg"));
//        backgroundLabel.setIcon(img);
        contentPane.add(desktopPane1, BorderLayout.CENTER);
        setSize(900, 635);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

        //创建一个标签组件，用于放置背景图片
        final JLabel backgroundLabel = new JLabel();
        //需要自己导入一张背景图片到src目录下
        ImageIcon icon = new ImageIcon(this.getClass().getResource("/image/back1.jpg"));
        //压缩背景图片，使其适应窗口大小
        icon.setImage(icon.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
        backgroundLabel.setIcon(icon);
        backgroundLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
        desktopPane1.add(backgroundLabel, new Integer(Integer.MIN_VALUE));

    }






    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenu menu2;
    private JMenuItem menuItem3;
    private JMenuItem menuItem4;
    private JMenuItem menuItem11;
    private JMenuItem menuItem12;
//    private JMenu menu4;
//    private JMenuItem menuItem7;
//    private JMenu menu3;
//    private JMenuItem menuItem5;
//    private JMenu menu5;
//    private JMenuItem menuItem8;
    private JDesktopPane desktopPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

}
