<%--
    Document   : AdminFlower
    Created on : Oct 31, 2023, 1:11:21 AM
    Author     : hoanghamhoc
--%>

<%@page import="dto.CategoryFlower"%>
<%@page import="dto.Flower"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flower</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
              rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
              crossorigin="anonymous">
    </head>
    <body>
        <%@include file="Header.jsp" %>
        <section style="height : 100vh">
            <div class="container">
                <%  if (request.getAttribute("setUpFlower") != null) {
                        Flower setUpFlower = (Flower) request.getAttribute("setUpFlower");
                %>
                <form action="mainServlet" method="post">
                    <div class="mb-3">
                        <label for="flowerName" class="form-label">Flower name</label>
                        <input
                            type="text"
                            name="flowerName"
                            id="flowerName"
                            value="<%=setUpFlower.getFlowerName()%>"
                            required=""
                            class="form-control" />
                    </div>
                    <div class="mb-3">
                        <label for="categoryName" class="form-label">Category name</label>
                        <%
                            ArrayList<CategoryFlower> listCategory = (ArrayList<CategoryFlower>) request.getAttribute("listCategory");

                        %>
                    </div>
                    <div class="mb-3"></div>
                </form>
                <%                } else if (session.getAttribute("listFlower") != null) {
                    ArrayList<Flower> listFlower = (ArrayList<Flower>) session.getAttribute("listFlower");
                %>
                <table class="table text-center">
                    <thead>
                        <tr>
                            <th>Flower name</th>
                            <th>Category name</th>
                            <th>Price</th>
                            <th>Amount</th>
                            <th>Image</th>
                            <th>Status</th>
                            <th>Button</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Flower item : listFlower) {

                        %>
                        <tr>
                            <td><%=item.getFlowerName()%></td>
                            <td><%=item.getCategory().getCategoryName()%></td>
                            <td><%=item.getPrice()%></td>
                            <td><%=item.getAmount()%></td>
                            <td><div style="width: 100px; height: 100px"><img style="width: 100%" src="<%=item.getImageUrl()%>"></div></td>
                            <td><%=item.getStatus()%></td>
                            <td>
                                <form action="mainServlet" method="post">
                                    <input type="hidden" value="<%=item.getFlowerrId()%>" name="flowerId">
                                    <button class="btn btn-primary" name="action" value="setUpFlower">Update</button>
                                </form>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
                <%
                    }%>
            </div>
        </section>
        <%@include file="Footer.jsp" %>
    </body>
</html>
