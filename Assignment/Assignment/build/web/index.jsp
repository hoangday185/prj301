<%--
    Document   : index
    Created on : Oct 28, 2023, 12:37:20 AM
    Author     : hoanghamhoc
--%>

<%@page import="dto.Customer"%>
<%@page import="dto.Shipper"%>
<%@page import="dto.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
              rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
              crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/1f4603e61c.js"
        crossorigin="anonymous"></script>
        <title>Florist</title>
    </head>
    <body>
        <%@include file="Header.jsp"%>
        <div class="container" style="height: 500px">
            <%if (request.getAttribute("updateOrder") != null) {
                    out.println("<h1 class='text-center text-success'>" + request.getAttribute("updateOrder") + "</h1>");
                } else if (request.getAttribute("updateOrderFail") != null) {
                    out.println("<h1 class='text-center text-warning'>" + request.getAttribute("updateOrderFail") + "</h1>");
                } else if (request.getAttribute("updateCustomerFail") != null) {
                    out.println("<h1 class='text-center text-warning'>" + request.getAttribute("updateCustomerFail") + "</h1>");
                } else if (session.getAttribute("admin") != null) {
                    Admin admin = (Admin) session.getAttribute("admin");
                    out.println("<h1 class='text-center text-success'> Welcome " + admin.getName() + "</h1>");
                } else if (session.getAttribute("shipper") != null) {
                    Shipper shipper = (Shipper) session.getAttribute("shipper");
                    out.println("<h1 class='text-center text-success'> Welcome " + shipper.getName() + "</h1>");
                } else if (session.getAttribute("customer") != null) {
                    Customer customer = (Customer) session.getAttribute("customer");
                    out.println("<h1 class='text-center text-success'> Welcome " + customer.getCusName() + "</h1>");
                }
            %>
        </div>
        <%@include file="Footer.jsp"%>
    </body>
</html>
