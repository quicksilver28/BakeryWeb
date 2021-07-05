<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Admin Login</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="style.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="https://use.fontawesome.com/releases/v5.15.3/js/all.js"></script>
        <script type="text/javascript">
            function validate() {
                var username = document.signinform.username.value;
                if (username == "") {
                    alert("Enter the username");
                    document.signinform.username.focus();
                    return false;
                }
                if (username.length > 50) {
                    alert("Invalid username,too long (not what she said xD)");
                    document.signinform.username.focus();
                    return false;
                }
                var password = document.signinform.password.value;

                if (password == "") {
                    alert("Enter the password");
                    document.signinform.password.focus();
                    return false;
                } else if (username.length > 50) {
                    alert("Invalid password,too long");
                    document.signinform.password.focus();
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <% if (session.getAttribute("admin") != null) {
                response.sendRedirect(request.getContextPath() + "/add_products.jsp");
            }%>
        <%@include file="header.jsp"%>
        <div class="container-fluid">
            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <form class="form-container" name="signinform" action="AdminLogin" method="post" autocomplete="off">
                        <div class="form-group">
                            <label for="username">Username</label>
                            <input type="text" class="form-control" id="username" name="username" required>
                        </div>
                        <div class="form-group">
                            <label for="username">Password</label>
                            <input type="password" class="form-control" id="password" name="password">
                        </div>
                        <br>
                        <button type="submit" name="action" value="signin" class="btn btn-primary mx-auto d-block" onClick="return validate();">Open Sesame</button>
                    </form>
                </div>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>