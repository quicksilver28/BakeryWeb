<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>NanNan's Bakery</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <!-- Navigation --> 
        <nav class="navbar navbar-expand-md navbar-light bg-light sticky-top">
            <div class="container-fluid">
                <a class="navbar-brand" href="#"><img src="ProductImages/logo_overlay2.png"></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav">
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Products</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Contact Us</a>
                        </li>
                    </ul>
                </div>
            </div>
        
        </nav>   
        
        <!-- Image Slider -->
        <div id="slides" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="ProductImages/background.png">
                    <div class="carousel-caption">
                        <h1 class="display2">Bootstrap</h1>
                        <h3>Complete Website Layout</h3>
                        <button type="button" class="btn btn-outline-light btn-lg">View</button>
                    </div>
                </div>
            </div>
        </div>
        
        <!--<div class="container-fluid p-0">
            <section class="row no-gutters align-items-center">
                <div class="col-12 text-center d-flex">
                        <img class="img-fluid w-100 h-auto p-0 m-0" src="ProductImages/background.png">
                    <h4 class="w-50 position-absolute text-danger mt-4 mr-5 pr-5">This is also<br>available on your mobile.</h4>
                </div>
            </section>
        </div>-->
        <!--<div class="container-fluid w-100 h-auto m-0 p-0">
            <img src="https://placeholder.com/wp-content/uploads/2019/06/stock-images.webp" class="img-fluid w-100 h-auto p-0 m-0" alt="Patience">  
            
        </div> -->
        <!--<hr style="height:3px;background-color:#000;border: none;">-->
        
        <!--- Welcome Section -->
        <div class="container-fluid padding">
            <div class="row welcome text-center">
                <div class="col-12">
                    <h1 class="display-4">Built with ease.</h1>
                </div>
                <hr class="col-4">
                <div class="col-12">
                    <p class="lead">Welcome to my Bootstrap 4 website tutorial! Bootstrap is a free and open-source front-end library with HTLM and CSS based designs.</p>
                </div>
            </div>
        </div>

        <!--- Two Column Section -->
        <div class="container-fluid padding">
            <div class="row padding">
                <div class="col-lg-6">
                    <h2>If you build it...</h2>
                    <p>Helllllllll</p>
                    <p>oooooooooooooo</p>
                    <p>Thereeeeeeeeeeeeeeee</p>
                    <br>
                    <a href="#" class="btn btn-primary">Learn More</a>
                </div>
                <div class="col-lg-6">
                    <img src="ProductImages/desk.png" class="img-fluid">
                </div>
                
            </div>
        </div>

        <!--- Fixed background -->

        
        <!--- Meet the team -->
        <div class="container-fluid padding">
            <div class="row welcome text-center">
                <div class="col-12">
                    <h1 class="display-4">Meet the Team</h1>
                </div>
                <hr>
            </div>
        </div>

        <!--- Cards -->
        <div class="container-fluid padding">
            <div class="row padding">
                <div class="col-md-4">
                    <div class="card">
                        <img class="card-img-top" src="ProductImages/logo.png">
                        <div class="card-body">
                            <h4 class="card-title">Jane Doe</h4>
                            <p class="card-text">Heyyyyy :D</p>
                            <a href="#" class="btn btn-outline-secondary">See Profile</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card">
                        <img class="card-img-top" src="ProductImages/logo.png">
                        <div class="card-body">
                            <h4 class="card-title">Jane Doe</h4>
                            <p class="card-text">Heyyyyy :D</p>
                            <a href="#" class="btn btn-outline-secondary">See Profile</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card">
                        <img class="card-img-top" src="ProductImages/logo.png">
                        <div class="card-body">
                            <h4 class="card-title">Jane Doe</h4>
                            <p class="card-text">Heyyyyy :D</p>
                            <a href="#" class="btn btn-outline-secondary">See Profile</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!--- Connect 
        <div class="container-fluid padding">
            <div class="row text-center padding">
                <div class="col-12">
                    <h2>Connect</h2>
                </div>
                <div class="col-12 social padding">
                    <a href="#"><i class="fab fa-facebook"></i></a>
                    <a href="#"><i class="fab fa-instagram"></i></a>
                    <a href="#"><i class="fab fa-facebook"></i></a>
                </div>
            </div>
        </div>-->
        
        <!--- Footer -->
        <footer>
            <div class="container-fluid padding">
                <div class="row text-center">
                    <div class="col-md-12 social">
                        <a href="#"><i class="fab fa-instagram"></i></a>
                        <a href="#"><i class="fas fa-envelope"></i></a>
                    </div>
                    <div class="col-12">
                        <hr class="light">
                        <h5>&copy; quicksilver28</h5>
                    </div>
                </div>
            </div>
        </footer>
        
    </body>
</html>