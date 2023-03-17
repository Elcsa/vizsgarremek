package com.example.vizsgarremek;

import com.google.gson.Gson;
import javafx.geometry.Dimension2D;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.net.ConnectException;

public class loginForm extends JDialog{
    private JPanel panel1;
    private JTextField JEmail;
    private JPasswordField passwordFild;
    private JButton BtnOk;
    private JButton btncsancel;
    private JPanel loginPanel;

    public loginForm(JFrame parent){
        super(parent);
//        setTitle("login");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(450,475));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        BtnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email=JEmail.getText();
                String password=String.valueOf(passwordFild.getPassword());

               user= getAuthenticatedUser(email,password);
               if(user!=null){
                   dispose();
               }
               else {
                   JOptionPane.showMessageDialog(loginForm.this,
                           "rosz email cim vagy jelszo",
                           "pobald ujra",
                           JOptionPane.ERROR_MESSAGE);
               }
            }
        });
        btncsancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }
        public User user;
        private User getAuthenticatedUser(String email,String password){
            User user=null;
            final String DB_URL="http://localhost:8080";
            final String USERNAME="root";
            final String PASSWORD="";

            try {
              //  Connection conn=DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
                Gson gson = new Gson();

                user = new User(email,password);
                RequestHandler.post("url", gson.toJson(user));
                ///connectonn to database sucesssfully...

//                Statement stn=conn.createStatement();
//                String sql= "SELECT* FROM user WHERE email=? AND password=?";
//                PreparedStatement preparedStatement=conn.preparedStatement(sql);
//                preparedStatement.setSring(1,email);
//                preparedStatement.setString(2,password);
//
//                Result resultSet=preparedStatement.executeQuery();
//                if (resultSet.next()){
//                    user=new User();
//                    user.name=resultSet.getString("name");
//                    user.email=resultSet.getString("email");
//                    user.password=resultSet.getString("password");
//
//                }
//                stmt.close();
//                conn.close();

            }catch (Exception e){
                e.printStackTrace();
            }
            return user;
        }
    public static void main(String[] args) {
//        loginForm loginForm=new loginForm(null);
//
    }
}
