<%--
    Document   : AdminOrder
    Created on : Nov 1, 2023, 4:39:20 PM
    Author     : hoanghamhoc
--%>

<%@page import="dto.OrderDetail"%>
<%@page import="dto.Shipper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.FullInforOrder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
              rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
              crossorigin="anonymous">
    </head>
    <body>
        <%@include file="Header.jsp"%>
        <div class="container" style="height: 100vh">
            <table class="table text-center">
                <thead>
                    <tr>
                        <th class="text-center text-primary">Information order</th>
                    </tr>
                    <tr class="table-primary">
                        <th>OrderID</th>
                        <th>Customer name</th>
                        <th>Status</th>
                        <th>Shipper Name</th>
                    </tr>
                </thead>
                <tbody>
                    <%  if (request.getAttribute("showListOrder") != null) {
                            ArrayList<FullInforOrder> listFullInforOrder = (ArrayList<FullInforOrder>) session.getAttribute("listFullInforOrder");
                            for (FullInforOrder item : listFullInforOrder) {
                    %>
                    <tr>
                        <td><%=item.getOrder().getOrderID()%></td>
                        <td><%=item.getOrder().getCustomer().getCusName()%></td>
                        <td><%=item.getOrder().getStatus()%></td>
                        <td><%=item.getOrder().getShipper() == null ? "None" : item.getOrder().getShipper().getName()%></td>
                        <td>
                            <form action="mainServlet" method="post">
                                <input type="hidden" name ="orderId" value="<%=item.getOrder().getOrderID()%>" />
                                <button class="btn btn-primary" value="setUpOrderFullInfor" name="action">Update</button>
                            </form>
                        </td>
                    </tr>

                    <%
                        }
                    } else if (request.getAttribute("setUpFullInforOrder") != null) {
                        FullInforOrder fullInforOrder = (FullInforOrder) request.getAttribute("setUpFullInforOrder");
                        ArrayList<Shipper> listShipper = (ArrayList<Shipper>) request.getAttribute("listShipper");
                        String htmlShipper = "";
                        for (Shipper shipper : listShipper) {
                            htmlShipper += "<option value=\"" + shipper.getShipperId() + "\">" + shipper.getName() + "</option>";
                        }

                    %>

                    <tr>
                        <td><%=fullInforOrder.getOrder().getOrderID()%></td>
                        <td><%=fullInforOrder.getOrder().getCustomer().getCusName()%></td>
                        <td><%=fullInforOrder.getOrder().getStatus()%></td>
                        <td>
                            <form class="d-flex justify-content-center" action="mainServlet" method="post">
                                <div class="mb-3 mx-3">
                                    <label for="shipper"></label>
                                    <select name="shipperId" id="shipper" class="form-select">
                                        <%=htmlShipper%>
                                    </select>
                                </div>
                                <input type="hidden" name ="orderId" value="<%=fullInforOrder.getOrder().getOrderID()%>" />
                                <button class="btn btn-primary btn-sm" name="action" value="updateOrderToShipping">Update</button>
                            </form>
                        </td>
                    </tr>
                    <tr class="table-warning">
                        <td>Flower name</td>
                        <td>Image</td>
                        <td>Price</td>
                        <td>Quantity</td>
                    </tr>
                    <%
                        for (OrderDetail item : fullInforOrder.getListOrderDetail()) {

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
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
        <%@include file="Footer.jsp"%>
    </body>
</html>
