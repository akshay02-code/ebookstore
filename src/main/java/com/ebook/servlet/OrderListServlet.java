package com.ebook.servlet;



import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import com.ebook.dao.DBConnection;

public class OrderListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.html");
            return;
        }

        List<Map<String, String>> orders = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM orders WHERE username=?");
            ps.setString(1, user);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Map<String, String> order = new HashMap<>();
                order.put("id", rs.getString("id"));
                order.put("total", rs.getString("total"));
                orders.add(order);
            }

            request.setAttribute("orders", orders);

            RequestDispatcher rd = request.getRequestDispatcher("order_list.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
