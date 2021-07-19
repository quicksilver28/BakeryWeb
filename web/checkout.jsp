<%@page import="javafx.util.Pair"%>
<%@page import="bakeryjava.bean.Product"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.concurrent.ConcurrentHashMap"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Checkout</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="https://use.fontawesome.com/releases/v5.15.3/js/all.js"></script>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <%@include file="header.jsp"%>
        <div class="container-fluid padding">
            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <form class="form-container" action="PlaceOrder" method="post" autocomplete="off">
                        <div class="form-group">
                            <label for="fname">First Name</label>
                            <input type="text" class="form-control" id="fname" name="fname" required>
                        </div>
                        <div class="form-group">
                            <label for="lname">Last Name</label>
                            <input type="text" class="form-control" id="lname" name="lname" required>
                        </div>
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="email" class="form-control" id="email" name="email" required>
                        </div>
                        <div class="form-group">
                            <label for="phone">Contact No</label>
                            <input type="text" class="form-control" id="phone" name="phone" pattern="[0-9]{10}" required>
                        </div>
                        <div class="form-group">
                            <label for="line1">Address Line 1</label>
                            <input type="text" class="form-control" id="line1" name="line1" required>
                        </div>
                        <div class="form-group">
                            <label for="line2">Address Line 2</label>
                            <input type="text" class="form-control" id="line2" name="line2" required>
                        </div>
                        <div class="form-group">
                            <label for="zipcode">Pin Code</label>
                            <input type="text" class="form-control" id="zipcode" name="zipcode" pattern="[0-9]{6}" required>
                        </div>
                        <br>
                        <button type="submit" name="action" value="signin" class="btn btn-primary mx-auto d-block">Place Order</button>
                    </form>
                </div>
                <div class="col-lg-4">
                    Order Summary
                    <% Map<Integer, Pair> cart = (ConcurrentHashMap<Integer, Pair>) session.getAttribute("cart");
                        float total = 0.0f;
                        if (cart != null) {
                            Set<Map.Entry<Integer, Pair>> entries = cart.entrySet();
                            if (entries != null) {
                                for (Map.Entry<Integer, Pair> entry : entries) {
                                    int pid = entry.getKey();
                                    Pair product_set = entry.getValue();
                                    int quantity = (Integer) product_set.getValue();
                                    Product product = (Product) product_set.getKey();
                                    total += product.getPrice() * quantity;
                    %>
                    <%=product.getPname()%><br>
                    <%=quantity%>*<%=product.getPrice()%><br>
                    <%}
                            } else {
                                //out.println("cart entries khali hain");
                                response.sendRedirect(request.getContextPath() + "/product_display");
                            }
                        } else {
                            //out.println("cart khali hai");
                            response.sendRedirect(request.getContextPath() + "/product_display");
                        }
                    %>
                    <hr>
                    <%=total%>
                </div>
            </div>
        </div>
        <%@include file="footer.jsp"%>
    </body>
</html>
