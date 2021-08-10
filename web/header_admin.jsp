<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="header">
    <div class="menu-bar">
        <nav class="navbar navbar-expand-md navbar-light sticky-top">
            <div class="container-fluid">
                <a class="navbar-brand" href="<%=request.getContextPath()%>"><img src="resources/images/logo_overlay2.png"></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="add_product.jsp">Add Product</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="product_display">View Products</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="order_display">View Orders</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="admin_logout"><i class="fas fa-sign-out-alt"></i></a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>   
    </div>
</div>