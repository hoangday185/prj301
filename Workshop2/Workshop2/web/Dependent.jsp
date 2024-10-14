<%--
    Document   : Dependent
    Created on : Oct 23, 2023, 1:51:59 PM
    Author     : hoanghamhoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dependent</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
              rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
              crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <a href="userPage.jsp" class="btn btn-primary">Home</a>
            <%
                if (request.getAttribute("noti") != null) {
                    out.println(request.getAttribute("noti"));
                } else if (request.getAttribute("htmlViewDependent") != null) {
                    out.println(request.getAttribute("htmlViewDependent"));
                }
            %>
        </div>
    </body>
</html>
