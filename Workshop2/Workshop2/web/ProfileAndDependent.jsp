<%--
    Document   : ProfileAndDependent
    Created on : Oct 22, 2023, 10:59:35 PM
    Author     : hoanghamhoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
              rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
              crossorigin="anonymous">
        <title>Profile and dependent</title>
    </head>
    <body>
        <div class="container">
            <a href="userPage.jsp" class="btn btn-primary">Home</a>
            <form action="ProfileUser" method="post" class="mx-3 mt-3">
                <button class="btn btn-primary" value="view" name="type">My profile</button>
            </form>
            <form action="DependentList" method="post" class="mx-3 mt-3">
                <button class="btn btn-primary">My dependent</button>
            </form>
        </div>
    </body>
</html>
