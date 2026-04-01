package com.ebook.servlet;




import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class CartServlet extends HttpServlet {
 protected void doGet(HttpServletRequest req, HttpServletResponse res)
 throws IOException {

  HttpSession session = req.getSession();
  List<String> cart = (List<String>) session.getAttribute("cart");

  if(cart == null) cart = new ArrayList<>();

  cart.add(req.getParameter("id"));
  session.setAttribute("cart", cart);

  res.sendRedirect("cart.jsp");
 }
}