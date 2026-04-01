package com.ebook.servlet;



import java.io.PrintWriter;

public class NavUtil {

    public static void printNavbar(PrintWriter out, String username) {

        out.println("<div style='background:#333;padding:10px;'>");

        out.println("<span style='color:white;font-size:20px;'>eBook Store</span>");

        out.println("<span style='float:right;'>");

        if (username != null) {
            out.println("<a href='books' style='color:white;margin:10px;'>Books</a>");
            out.println("<a href='cart.jsp' style='color:white;margin:10px;'>Cart</a>");
            out.println("<a href='logout' style='color:white;margin:10px;'>Logout</a>");
        } else {
            out.println("<a href='login.html' style='color:white;margin:10px;'>Login</a>");
            out.println("<a href='register.html' style='color:white;margin:10px;'>Register</a>");
        }

        out.println("</span>");
        out.println("</div>");
    }
}
