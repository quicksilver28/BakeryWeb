<%@page import="bakeryjava.bean.Product"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.concurrent.ConcurrentHashMap"%>
<%@page import="javafx.util.Pair"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>View Cart</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="https://use.fontawesome.com/releases/v5.15.3/js/all.js"></script>
        <link rel="stylesheet" type="text/css" href="style.css">
        <style>
            #type_color_1{
                color: green;
            }
            #type_color_2{
                color: red;
            }
            #type_color_3{
                color: brown;
            }
            .fa-cart-plus{
                font-size: 1.5em;
                color: #693F26;
            }
            .fa-cart-plus:hover{
                color: #e2b870;
            }
        </style>
        <script>
            function checkout() {
                location = '/bakeryweb/checkout.jsp';
            }
            function removeFromCart(pid) {
                location = '/bakeryweb/RemoveFromCart?pid=' + pid;
            }
            function updateQuantity(operation, qty, pid) {
                var span = document.getElementById("qty");
                if (operation === 'plus')
                    qty += 1;
                else {
                    if (qty == "1") {
                        removeFromCart(pid);
                        return false;
                    } else {
                        qty -= 1;
                    }
                }
                location = '/bakeryweb/UpdateCart?pid=' + pid + '&qty=' + qty;
                span.textContent = qty;
            }
        </script>
    </head>
    <body style="background-image: url('resources/images/bakedbg.jpg');">
        <%@include file="header.jsp"%>
        <div class="container-fluid padding" style="margin-top: 30px;">
            <div class="row justify-content-center">
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
                <div class="col-lg-8" style="background-color:#fff; opacity:0.8;">
                    <div class="col"><i class="far fa-stop-circle" id="type_color_<%=String.valueOf(product.getType())%>"></i></div>
                    <div class="col"><%=product.getPname()%></div>
                    <div class="col"><button class="btn" style="background-color:#fff;" onclick="updateQuantity('plus', <%=quantity%>, <%=product.getPid()%>)"><i class="fas fa-plus"></i></button>&emsp;<span id="qty"><%=quantity%></span>&emsp;<button class="btn" style="background-color:#fff;" onclick="updateQuantity('minus', <%=quantity%>, <%=product.getPid()%>)"><i class="fas fa-minus"></i></button></div>
                    <div class="col"><i class="fas fa-rupee-sign"></i> <span class="pp"><%=product.getPrice() * quantity%></span></div>
                    <div class="col"><button class="btn" style="background-color:#fff;" onclick="removeFromCart(<%=product.getPid()%>)"><i class="fas fa-times"></i></button></div>
                    <hr>
                    <!--<div class="card">
                        <img class="card-img-top" style="widht:100%; height:15vw; object-fit: cover;" src="ProductImages/<%=product.getImg()%>" alt="aigoo">
                        <div class="card-body">
                            <h4 class="card-title"><%=product.getPname()%>&emsp;<i class="far fa-stop-circle" id="type_color_<%=String.valueOf(product.getType())%>"></i></h4>
                            <p class="card-text pp"><i class="fas fa-rupee-sign"></i> <%=product.getPrice()%></p>
                            <p class="card-text"><%=quantity%></p>
                        </div>
                    </div>-->
                </div>
                <%}%>
                <div class="col-lg-8" style="background-color:#fff; opacity:0.8;"><i class="fas fa-rupee-sign"></i>  <span class="pp"><%=total%></span></div>
                <div class="col-lg-8"><button type="submit" class="btn btn-primary mx-auto d-block" onClick="checkout()">Checkout</button></div>
                <%    } else {
                            //out.println("cart entries khali hain");
                            response.sendRedirect(request.getContextPath() + "/product_display");
                        }
                    } else {
                        //out.println("cart khali hai");
                        response.sendRedirect(request.getContextPath() + "/product_display");
                    }%>
            </div>
        </div>
        <%@include file="footer.jsp"%>
    </body>
</html>