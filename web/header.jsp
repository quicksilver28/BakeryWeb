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
                            <a class="nav-link" href="<%=request.getContextPath()%>">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="product_display">Products</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="mailto:nannans.bakery@gmail.com">Contact Us</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="ViewCart"><i class="fas fa-shopping-cart social"></i></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="admin_login.jsp"><i class="fas fa-tools"></i></a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>   
    </div>
</div>