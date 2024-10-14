<%--
    Document   : Customer
    Created on : Nov 6, 2023, 3:46:34 AM
    Author     : hoanghamhoc
--%>

<%@page import="dto.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
              rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
              crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/1f4603e61c.js"
        crossorigin="anonymous"></script>
    </head>
    <body>
        <%@include file="Header.jsp"%>
        <div class="container" style="height: 500px">
            <%if (request.getAttribute("listCus") != null) { %>
            <h1 class="text-center text-success">Thông tin khách hàng</h1>
            <table class="table">
                <thead>
                    <tr class="table-primary">
                        <th class="text-center">CustomerId</th>
                        <th class="text-center">Customer name</th>
                        <th class="text-center">Status</th>
                        <th class="text-center">Button</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        ArrayList<Customer> listCus = (ArrayList<Customer>) request.getAttribute("listCus");
                        for (Customer cus : listCus) {
                    %>
                    <tr class="text-center">
                        <td><%=cus.getCusId()%></td>
                        <td><%=cus.getCusName()%></td>
                        <td><%=cus.getAccount().getStatusAvailable()%></td>
                        <td>
                            <form action="mainServlet" method="post">
                                <input type="hidden" name ="status" value="<%=cus.getAccount().getStatusAvailable().getCodeAvailabel()%>" />
                                <input type="hidden" name ="accountId" value="<%=cus.getAccount().getAccountID()%>" />
                                <button
                                    class="btn btn-primary"
                                    value="updateUserAccount"
                                    name="action">
                                    <%=cus.getAccount().getStatusAvailable().getCodeAvailabel() == 1 ? "Unban" : "Ban"%>
                                </button>
                            </form>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
            <%}%>
        </div>
        <%@include file="Footer.jsp"%>
    </body>
</html>
