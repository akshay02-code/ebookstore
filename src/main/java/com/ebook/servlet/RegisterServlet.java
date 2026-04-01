package com.ebook.servlet;


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import com.ebook.dao.DBConnection;


public class RegisterServlet extends HttpServlet {
 protected void doPost(HttpServletRequest req, HttpServletResponse res)
 throws IOException {

  try {
   Connection con = DBConnection.getConnection();
   PreparedStatement ps = con.prepareStatement(
    "INSERT INTO users(username,password) VALUES(?,?)");

   ps.setString(1, req.getParameter("username"));
   ps.setString(2, req.getParameter("password"));
   ps.executeUpdate();

   res.sendRedirect("login.html");
  } catch(Exception e){ e.printStackTrace(); }
 }
}
