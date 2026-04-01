<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Checkout</title>
    <link rel="stylesheet" href="css/checkout.css">
</head>
<body>

<div class="container">
    <h2>Checkout</h2>

    <form action="checkout" method="post">
        <p>Confirm your order</p>
        <button type="submit">Place Order</button>
    </form>

    <a href="cart.jsp">Back to Cart</a>
</div>

</body>
</html>