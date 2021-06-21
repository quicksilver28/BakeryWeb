<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>      
<%@page import="bakeryjava.bean.Product"%>
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
        <script type='text/javascript'>
            function confirmDelete(pid)
            {
                var choice = confirm("Do you want to delete this record?");
                if (choice === true) {
                    //location.href = "/ProductDelete?pid="+pid;
                    window.open("ProductDelete?pid=" + pid);
                }
            }
            function justUpdate(pid) {
                location.href = "/bakeryweb/update_product.jsp?pid=" + pid;
            }
        </script>
    </head>
    <body style="background-image: url('resources/images/bakedbg.jpg');">
        <% if (session.getAttribute("admin") == null) {
                response.sendRedirect(request.getContextPath() + "/admin_login.jsp");
        }%>
        <%@include file="header_admin.jsp"%>
        <div class="container-fluid padding">
            <div class="row padding">
                <% ArrayList<Product> product_list = (ArrayList) request.getAttribute("products");
                    if (product_list != null) {
                        Iterator<Product> itr = product_list.iterator();
                        while (itr.hasNext()) {
                            Product product = itr.next();%>
                <div class="col-md-4">
                    <div class="card">
                        <img class="card-img-top" style="widht:100%; height:15vw; object-fit: cover;" src="ProductImages/<%=product.getImg()%>" alt="aigoo">
                        <div class="card-body">
                            <h4 class="card-title"><%=product.getPname()%></h4>
                            <p class="card-text"><%=product.getDescrp()%></p>
                            <p class="card-text pp"><i class="fas fa-rupee-sign"></i> <%=product.getPrice()%></p>
                            <button class="btn" style="background-color:#fff;" onclick="justUpdate(<%=String.valueOf(product.getPid())%>)"><i class="fas fa-edit"></i></button>
                            <button class="btn" style="background-color:#fff;" onclick="confirmDelete(<%=String.valueOf(product.getPid())%>)"><i class="fas fa-trash"></i></button>
                            <!--<a href=""><i class="fas fa-edit"></i></a>
                            <a href="" onclick="return confirmDelete()"><i class="fas fa-trash"></i></a>
                            <a href="#" class="btn btn-outline-secondary">Buy</a>
                            <a href="#" class="btn btn-outline-secondary">Buy</a>-->
                        </div>
                    </div>
                </div>
                <%
                        }
                    } else {
                        out.println("List khali hai :(");
                    }
                %>
            </div>
        </div>
        <%@include file="footer.jsp"%>
    </body>
</html>