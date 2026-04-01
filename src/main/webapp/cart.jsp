<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cart</title>
    <link rel="stylesheet" href="css/cart.css">
</head>
<body>

<h2>Your Cart</h2>

<%
List<String> cart = (List<String>)session.getAttribute("cart");

if(cart != null && !cart.isEmpty()){
%>

<ul>
<%
for(String id : cart){
%>
    <li>Book ID: <%=id%></li>
<%
}
%>
</ul>

<a href="checkout.jsp">Proceed to Checkout</a>

<%
} else {
%>
<p>Cart is empty</p>
<%
}
%>

<br>
<a href="books">Back to Books</a>

</body>
</html>