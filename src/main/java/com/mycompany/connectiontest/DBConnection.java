/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.connectiontest;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author emil
 */
public class DBConnection {
    
    Connection connection = null;
    
    private static String url = "jdbc:mysql://localhost:3306/database";
    private static String user = "root";
    private static String password = "root";
    public static String query = "SELECT * FROM database.person";
    
    public Connection getConnection(){
        return this.connection;
    }
    
    public DBConnection() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        this.connection = null;
        connection = DriverManager.getConnection(url, user, password);
    }
    
    
    
//    public static void main(String[] args) {
//        Connection con = null;
//        Statement st = null;
//        ResultSet rs = null;
//
//        
//        
//
//        
//
//        try {
//
//            con = DriverManager.getConnection(url, user, password);
//
//            st = con.createStatement();
//            rs = st.executeQuery(query);
//
//            if (rs.next()) {                
//                System.out.println(rs.getString(1));
//            }
//
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//            System.err.println(ex);
//        } finally { 
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//                if (st != null) {
//                    st.close();
//                }
//                if (con != null) {
//                    con.close();
//                }
//            } catch (SQLException ex) {
//                System.err.println(ex.getMessage());
//                System.err.println(ex);
//            }
//        }
//    }
}