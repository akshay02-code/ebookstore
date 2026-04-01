package com.ebook.servlet;


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import com.ebook.dao.DBConnection;

public class BookListServlet extends HttpServlet {
 protected void doGet(HttpServletRequest req, HttpServletResponse res)
 throws ServletException, IOException {

  try {
   Connection con = DBConnection.getConnection();
   Statement st = con.createStatement();
   ResultSet rs = st.executeQuery("SELECT * FROM books");

   List<Map<String,String>> list = new ArrayList<>();

   while(rs.next()){
    Map<String,String> m = new HashMap<>();
    m.put("id", rs.getString("id"));
    m.put("title", rs.getString("title"));
    m.put("author", rs.getString("author"));
    m.put("price", rs.getString("price"));
    m.put("image", rs.getString("image"));
    list.add(m);
   }

   req.setAttribute("books", list);
   RequestDispatcher rd = req.getRequestDispatcher("books.jsp");
   rd.forward(req, res);

  } catch(Exception e){ e.printStackTrace(); }
 }
}
