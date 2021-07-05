<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Add Product</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="style.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="https://use.fontawesome.com/releases/v5.15.3/js/all.js"></script>
    </head>
    <body>
        <%
            response.addHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.setDateHeader("Expires", 0);
        %>
        <% if (session.getAttribute("admin") == null) {
                response.sendRedirect(request.getContextPath() + "/admin_login.jsp");
            }%>
        <%@ include file="header_admin.jsp"%>
        <div class="container-fluid">
            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <form class="form-container" name="add_product_form" action="ProductInsert" method="post" enctype="multipart/form-data" autocomplete="off">
                        <div class="form-group">
                            <label for="productname">Product Name</label>
                            <input type="text" class="form-control" id="productname" name="product_name">
                        </div>
                        <div class="form-group">
                            <label for="productdescrp">Description</label>
                            <textarea class="form-control" id="productdescrp" name="product_descrp" rows="3"></textarea>
                        </div>
                        <fieldset>
                            <legend>Choose category:</legend>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="product_category" id="categoryradio1" value="1" checked>
                                <label class="form-check-label" for="categoryradio1">
                                    Sweet
                                </label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="product_category" id="categoryradio2" value="2">
                                <label class="form-check-label" for="categoryradio2">
                                    Savoury
                                </label>
                            </div>
                        </fieldset>
                        <br>
                        <fieldset>
                            <legend>Choose type:</legend>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="product_type" id="typeradio1" value="1" checked>
                                <label class="form-check-label" for="typeradio1">
                                    Veg
                                </label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="product_type" id="typeradio2" value="2">
                                <label class="form-check-label" for="typeradio2">
                                    Non Veg
                                </label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="product_type" id="typeradio3" value="3" checked>
                                <label class="form-check-label" for="typeradio3">
                                    Egg
                                </label>
                            </div>
                        </fieldset>
                        <div class="form-group">
                            <label for="productprice">Price</label>
                            <input type="number" class="form-control" id="productprice" name="product_price" placeholder="0.0">
                        </div>
                        <div class="form-group">
                            <label for="productimg">Choose Image:</label>
                            <input type="file" class="form-control-file" id="productimg" name="product_image">
                        </div>
                        <button type="submit" class="btn btn-primary mx-auto d-block" name="btn_add_product" value="add_product">Add Product</button>
                    </form>
                </div>
            </div>
        </div>
        <%@include file="footer.jsp"%>
    </body>
</html>
