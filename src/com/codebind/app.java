package com.codebind;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;

public class app {
    private JLabel labelUser;
    private JLabel labelPass;
    private JTextField textFieldUser;
    private JPasswordField passwordField;
    private JButton buttonLogin;
    private JPanel panelMain;
    private JButton buttonReg;

    public app() {
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/apptestdb", "root", "");
                    String sql = "Select * from logindatabse where username=? and password =?";
                    PreparedStatement pst =con.prepareStatement(sql);
                    pst.setString(1, textFieldUser.getText());
                    pst.setString(2, passwordField.getText());
                    ResultSet rs = pst.executeQuery();
                    if(rs.next()){
                        JOptionPane.showMessageDialog(null, "Correct");

                    }else{
                        JOptionPane.showMessageDialog(null, "Incorrect");
                    }
                    con.close();
                } catch (ClassNotFoundException | SQLException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Server Not Running!");
                }


            }
        });


        buttonReg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/apptestdb", "root", "");
                    

                }
                catch(ClassNotFoundException | SQLException classNotFoundException) {
                    classNotFoundException.printStackTrace();

                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame Frame = new JFrame("Login Test");
        Frame.setContentPane(new app().panelMain);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Frame.pack();
        Frame.setSize(500, 180);
        Frame.setVisible(true);
    }
}

