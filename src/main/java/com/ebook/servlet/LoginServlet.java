package com.ebook.servlet;


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import com.ebook.dao.DBConnection;

public class LoginServlet extends HttpServlet {
 protected void doPost(HttpServletRequest req, HttpServletResponse res)
 throws ServletException, IOException {

  String u = req.getParameter("username");
  String p = req.getParameter("password");

  try {
   Connection con = DBConnection.getConnection();
   PreparedStatement ps = con.prepareStatement(
     "SELECT * FROM users WHERE username=? AND password=?");
   ps.setString(1,u);
   ps.setString(2,p);

   ResultSet rs = ps.executeQuery();

   if(rs.next()){
    HttpSession session = req.getSession();
    session.setAttribute("user", u);
    res.sendRedirect("books");
   } else {
    res.sendRedirect("login.html");
   }
  } catch(Exception e){ e.printStackTrace(); }
 }
}