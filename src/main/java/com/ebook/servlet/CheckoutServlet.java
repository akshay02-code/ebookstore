package com.ebook.servlet;


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import com.ebook.dao.DBConnection;

public class CheckoutServlet extends HttpServlet {
 protected void doPost(HttpServletRequest req, HttpServletResponse res)
 throws IOException {

  try {
   HttpSession session = req.getSession();
   String user = (String) session.getAttribute("user");

   Connection con = DBConnection.getConnection();
   PreparedStatement ps = con.prepareStatement(
    "INSERT INTO orders(username,total) VALUES(?,?)");

   ps.setString(1, user);
   ps.setDouble(2, 1000); // simple demo

   ps.executeUpdate();
   res.sendRedirect("order_list.jsp");

  } catch(Exception e){ e.printStackTrace(); }
 }
}
