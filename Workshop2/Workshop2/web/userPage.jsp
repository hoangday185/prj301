<%--
    Document   : userForm
    Created on : Sep 26, 2023, 11:21:16 AM
    Author     : hoanghamhoc
--%>


<%@page import="DAO.EmployeeDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
              rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
              crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <%
                //req là check update thông tin
                //session là chào mừng với username mới nếu có update userName
                if (request.getAttribute("msg") != null) {
                    String msg = (String) request.getAttribute("msg");
                    out.println("<h1 class='text-success text-center'>" + msg + "</h1>"
                    );
                } else if (session.getAttribute("msg") != null) {
                    String msg = (String) session.getAttribute("msg");
                    out.println("<h1  class='text-success text-center'>" + msg + "</h1>");
                }
            %>
            <div class="d-flex flex-wrap justify-content-center">
                <a href="logoutServlet" class="btn btn-primary">Log out</a>
                <a href="ProfileAndDependent.jsp" class="btn btn-primary mx-3">My profile & dependent</a>
                <a href="MyProject" class="btn btn-primary mx-3">view my projects </a>
                <a href="TimeWorkServlet" class="btn btn-primary mx-3">report </a>
            </div>
        </div>
    </body>
</html>
