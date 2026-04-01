<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*,javax.servlet.http.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Books</title>
    <link rel="stylesheet" href="css/books.css">
</head>
<body>

<div class="navbar">
    <h2>eBook Store</h2>
    <a href="cart.jsp">Cart</a>
    <a href="logout">Logout</a>
</div>

<div class="container">

<%
List<Map<String,String>> books = (List<Map<String,String>>)request.getAttribute("books");

if(books != null){
    for(Map<String,String> b : books){
%>

    <div class="card">
        <img src="images/<%=b.get("image")%>" alt="Book">
        <h3><%=b.get("title")%></h3>
        <p>Author: <%=b.get("author")%></p>
        <p>Price: ₹<%=b.get("price")%></p>

        <a class="btn" href="cart?id=<%=b.get("id")%>">Add to Cart</a>
    </div>

<%
    }
} else {
%>
    <p>No books available</p>
<%
}
%>

</div>

</body>
</html>