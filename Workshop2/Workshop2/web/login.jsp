<%--
    Document   : login
    Created on : Sep 26, 2023, 10:49:52 AM
    Author     : hoanghamhoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log in</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
              rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
              crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <form method="POST" action="Login">
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
                                    + "name=\"email\" class=\"form-control\">");
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
                                    + "name=\"pwd\" class=\"form-control\">");
                        }
                    %>
                    <!--<input type="password" id="pwd" name="pwd" class="form-control">-->
                </div>
                <%
                    if (request.getAttribute("msg") != null) {
                        String msg = (String) request.getAttribute("msg");
                %>
                <p class="text-danger">${msg}</p>
                <%
                    }
                %>
                <input type="submit" value="Submit" class="btn btn-primary"/>
            </form>

        </div>
    </body>
</html>
