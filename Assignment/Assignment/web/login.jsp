<%--
    Document   : login
    Created on : Oct 30, 2023, 1:14:38 PM
    Author     : hoanghamhoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
              rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
              crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/1f4603e61c.js"
        crossorigin="anonymous"></script>
    </head>
    <body>
        <header class="mb-3">
            <div class="container d-flex justify-content-start">
                <div>
                    <h1><a href="index.jsp" class="text-decoration-none text-reset">Florist</a></h1>
                </div>
            </div>
        </header>
        <section>
            <div class="container" style="height: 525px">
                <form action="mainServlet" method="post">
                    <div class="mb-3">
                        <label for="Username" class="form-label">Username</label>
                        <%
                            if (request.getAttribute("email") != null) {
                                String email = (String) request.getAttribute("email");
                                out.println("<input type=\"text\" id=\"email\" "
                                        + "name=\"email\" class=\"form-control\""
                                        + "value=" + email
                                        + ">");
                            } else {
                                out.println("<input type=\"text\" id=\"email\" "
                                        + "name=\"email\" class=\"form-control\" required>");
                            }
                        %>
                    </div>
                    <div class="mb-3">
                        <label for="pwd" class="form-label">Password</label>
                        <%
                            if (request.getAttribute("pwd") != null) {
                                String pwd = (String) request.getAttribute("pwd");
                                out.println("<input type=\"password\" id=\"pwd\" "
                                        + "name=\"pwd\" class=\"form-control\""
                                        + "value=" + pwd
                                        + ">");
                            } else {
                                out.println("<input type=\"password\" id=\"pwd\" "
                                        + "name=\"pwd\" class=\"form-control\" required>");
                            }
                        %>
                        <!--<input type="password" id="pwd" name="pwd" class="form-control">-->
                    </div>
                    <%
                        if (request.getAttribute("msgLogin") != null) {
                            String msgLogin = (String) request.getAttribute("msgLogin");
                    %>
                    <p class="text-danger">${msgLogin}</p>
                    <%
                        }
                    %>
                    <input type="submit" name="action" value="login" class="btn btn-primary"/>
                </form>
            </div>
        </section>
        <%@include file="Footer.jsp" %>
    </body>
</html>
