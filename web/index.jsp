<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>NanNan's Bakery</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="style.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="https://use.fontawesome.com/releases/v5.15.3/js/all.js"></script>
        <script>
            function productDisplay(){
                location.href = "/bakeryweb/ProductDisplay";
            }
        </script>
    </head>
    <body>
        <%@include file="header.jsp"%>
        <div id="slides" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="resources/images/bread2.jpg">
                    <div class="carousel-caption">
                        <h1 class="display2">NanNan's Bakery</h1>
                        <h3>Sugar, spice and everything nice!</h3>
                        <button type="button" class="btn btn-outline-light btn-lg" onclick='productDisplay()'>Shop</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="container-fluid padding">
            <div class="row welcome text-center">
                <div class="col-12">
                    <h1 class="display-4">Welcome</h1>
                </div>
                <hr class="col-4">
                <div class="col-12">
                    <p class="lead">We help curb your cravings with home-baked goods <3</p>
                </div>
            </div>
        </div>

        <div class="container-fluid padding">
            <div class="row padding text-center">
                <div class="col-lg-6">
                    <h2>Get In touch!</h2>
                    <br>
                    <p>To know more about us or for custom deliveries, feel free to drop us an email by contacting us!</p>
                    <br>
                    <a href="mailto:nannans.bakery@gmail.com" class="btn btn-primary">Contact Us</a>
                </div>
                <div class="col-lg-6">
                    <img src="resources/images/bread3.jpg" class="img-fluid">
                </div>

            </div>
        </div>

        <%@include file="footer.jsp" %>
    </body>
</html>