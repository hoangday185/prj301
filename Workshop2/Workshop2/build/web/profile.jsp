<%--
    Document   : profile
    Created on : Oct 2, 2023, 9:40:23 AM
    Author     : hoanghamhoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My profile</title>
    </head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
    <body>
        <div class="container">
            <a href="userPage.jsp" class="btn btn-primary">Home</a>
            <%  if (request.getAttribute("viewProfile") != null) {
                    String viewProfile = (String) request.getAttribute("viewProfile");
                    out.println(viewProfile);
                } else if (request.getAttribute("updateProfile") != null) {
                    String updateProfile = (String) request.getAttribute("updateProfile");
                    out.println(updateProfile);
                } else if (request.getAttribute("htmlError") != null) {
                    out.println(request.getAttribute("htmlError"));
                }
            %>
        </div>
    </body>
</html>
