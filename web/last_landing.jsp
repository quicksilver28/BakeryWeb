<%-- 
    Document   : last_landing
    Created on : 11 Apr, 2021, 3:41:47 PM
    Author     : Sana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NanNan's Bakery</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body style="background-image: url('resources/images/bakedbg.jpg');">
        <% String msg = request.getParameter("msg");
            if(msg == null){
                response.sendRedirect(request.getContextPath());
            }
            if (msg.equals("SUCCESS")) {%>
        <h1>ORDER PLACED!</h1><br>
        <h4>Redirecting to Home....</h4>
        <script>
            setTimeout(function () {
                window.location.href = '<%=request.getContextPath()%>';
            }, 5000);
        </script>
        <% } else {%>
        <h1>ORDER FAILED!</h1><br>
        <h4>Redirecting to Products....</h4>
        <script>
         setTimeout(function(){
            window.location.href = '<%=request.getContextPath()%>/prodcut_display';
         }, 5000);
      </script>
        <% }%>
    </body>
</html>
