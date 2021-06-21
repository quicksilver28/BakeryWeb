<%-- 
    Document   : all_orders
    Created on : 28 Mar, 2021, 11:43:40 PM
    Author     : Sana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NanNan's Bakery</title>
    </head>
    <body style="background-image: url('resources/images/under_construction.jpg');">
        <% if (session.getAttribute("admin") == null) {
            response.sendRedirect(request.getContextPath() + "/admin_login.jsp");
        }%>
        <div class='container'>
            <h1>Under Construction!</h1>
            <a href="add_product.jsp">Admin Home</a>
        </div>
    </body>
</html>
