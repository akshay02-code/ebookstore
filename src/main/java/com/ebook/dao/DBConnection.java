package com.ebook.dao;




import java.sql.*;

public class DBConnection {

    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ebookstore",
                    "root",
                    "Aksh03*kash"
                );
            

        } catch(Exception e) {
            e.printStackTrace();
        }

        return con;
    }



public static void main(String[] args) {
    Connection con = getConnection();

    if (con != null) {
        System.out.println("Database Connected Successfully!");
    } else {
        System.out.println("Connection Failed!");
    }
}
}