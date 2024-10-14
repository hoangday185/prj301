<%--
    Document   : AdminOrder
    Created on : Nov 5, 2023, 5:19:04 PM
    Author     : hoanghamhoc
--%>

<%@page import="dto.OrderDetail"%>
<%@page import="dto.FullInforOrder"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Full order</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
              rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
              crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/1f4603e61c.js"
        crossorigin="anonymous"></script>
    </head>
    <body>
        <%@include file="Header.jsp"%>
        <div class="container" style="height: 100vh">
            <table class="table text-center">
                <thead>
                    <tr>
                        <th>Thông tin order</th>
                    </tr>
                    <tr class="table-primary">
                        <th>OrderID</th>
                        <th>Customer name</th>
                        <th>Shipper Name</th>
                        <th>Date Order</th>
                        <th>Price ship</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                    <%  if (request.getAttribute("showListOrder") != null) {
                            ArrayList<FullInforOrder> listFullInforOrder = (ArrayList<FullInforOrder>) session.getAttribute("listFullOrder");
                            for (FullInforOrder item : listFullInforOrder) {
                    %>
                    <tr class="text-center">
                        <td><%=item.getOrder().getOrderID()%></td>
                        <td><%=item.getOrder().getCustomer().getCusName()%></td>
                        <td><%=item.getOrder().getShipper() == null ? "None" : item.getOrder().getShipper().getName()%></td>
                        <td><%=item.getOrder().getDateOrder()%></td>
                        <td><%=item.getOrder().getPriceShip()%></td>
                        <td><%=item.getOrder().getStatus()%></td>
                        <td>
                            <form action="mainServlet" method="post">
                                <input type="hidden" name ="orderId" value="<%=item.getOrder().getOrderID()%>" />
                                <button class="btn btn-primary" value="showDetailOrder" name="action">Detail</button>
                            </form>
                        </td>
                    </tr>

                    <%
                        }
                    } else if (request.getAttribute("readFullInforOrder") != null) {
                        FullInforOrder fullInforOrder = (FullInforOrder) request.getAttribute("readFullInforOrder");
                    %>
                    <tr>
                        <td><%=fullInforOrder.getOrder().getOrderID()%></td>
                        <td><%=fullInforOrder.getOrder().getCustomer().getCusName()%></td>
                        <td><%=fullInforOrder.getOrder().getShipper() == null ? "None" : fullInforOrder.getOrder().getShipper().getName()%></td>
                        <td><%=fullInforOrder.getOrder().getDateOrder()%></td>
                        <td><%=fullInforOrder.getOrder().getPriceShip()%></td>
                        <td><%=fullInforOrder.getOrder().getStatus()%></td>
                    <tr>
                    <tr class="table-warning">
                        <td>Flower name</td>
                        <td>Image</td>
                        <td>Price</td>
                        <td>Quantity</td>
                    </tr>
                    <%      double total = fullInforOrder.getOrder().getPriceShip();
                        for (OrderDetail item : fullInforOrder.getListOrderDetail()) {
                            total += item.getQuantity() * item.getFlower().getPrice();
                    %>
                    <tr>
                        <td><%=item.getFlower().getFlowerName()%></td>
                        <td><div style="width: 100px; height: 100px"><img style="width: 100%" src="<%=item.getFlower().getImageUrl()%>"></div></td>
                        <td><%=item.getFlower().getPrice()%></td>
                        <td><%=item.getQuantity()%></td>
                    </tr>
                    <%
                        }
                    %>
                <h2 class="text-center text-warning">Total : <%=total%></h2>
                <%
                    }
                %>
                </tbody>
            </table>

        </div>
        <%@include file="Footer.jsp"%>
    </body>
</html>
