<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>      
<%@page import="bakeryjava.bean.Order"%>
<%@page import="java.util.Iterator"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>All Products</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="https://use.fontawesome.com/releases/v5.15.3/js/all.js"></script>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body style="background-image: url('resources/images/bakedbg.jpg');">
        <%
            response.addHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.setDateHeader("Expires", 0);
        %>
        <% if (session.getAttribute("admin") == null) {
                response.sendRedirect(request.getContextPath() + "/admin_login.jsp");
            }%>
        <%@include file="header_admin.jsp"%>
        <div class="container-fluid padding" style="margin-top: 30px;">
            <div class="row justify-content-center">
                <div class="col-lg-8" style="background-color:#fff; opacity:0.8;">
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Created Date</th>
                                <th scope="col">Ship Date</th>
                                <th scope="col">Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% ArrayList<Order> order_list = (ArrayList) request.getAttribute("orders");
                                if (order_list != null) {
                                    Iterator<Order> itr = order_list.iterator();
                                    while (itr.hasNext()) {
                                        Order order = itr.next();
                            %>
                            <tr>
                                <th scope="row"><%=order.getOid()%></th>
                                <td><%=order.getCreatedate()%></td>
                                <td><%=order.getShipdate()%></td>
                                <td><%=order.getStatus()%></td>
                            </tr>
                            <%}
                            }%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <%@include file="footer.jsp"%>
    </body>
</html>
