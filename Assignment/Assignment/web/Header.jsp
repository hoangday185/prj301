<%--
    Document   : Header
    Created on : Oct 28, 2023, 12:37:44 AM
    Author     : hoanghamhoc
--%>

<header class="bg-white my-3">
    <div class="container d-flex justify-content-evenly">
        <div>
            <h1><a href="index.jsp" class="text-decoration-none text-reset">Florist</a></h1>
        </div>
        <div>
            <form action="mainServlet" method="get" class="d-flex position-relative">
                <input type="text" name="flowerName" class="form-control me-3" placeholder="search">
                <button
                    class="rounded-circle
                    bg-white
                    border-0
                    justify-content-center
                    align-items-center"
                    name="action" value="find">
                    <i class="fa-solid fa-magnifying-glass"></i>
                </button>
            </form>
        </div>
        <div class="d-flex justify-content-evenly">
            <%
                if (session.getAttribute("shipper") != null) {
            %>
            <div class="mx-3">
                <a href="index.jsp" class="btn btn-primary ">Home</a>
            </div>
            <div class="mx-3">
                <a href="#" class="btn btn-primary ">Order</a>
            </div>
            <div class="mx-3">
                <a href="#" class="btn btn-primary ">My profile</a>
            </div>
            <div class="mx-3">
                <form method="get" action="mainServlet">
                    <button class="btn btn-primary" name="action" value="logout">Logout</button>
                </form>
            </div>
            <%
            } else if (session.getAttribute("admin") != null) {
            %>
            <div class="mx-3">
                <a href="index.jsp" class="btn btn-primary ">Home</a>
            </div>
            <div class="mx-3">
                <a href="#" class="btn btn-primary">My profile</a>
            </div>
            <div class="mx-3">
                <form method="get" action="mainServlet">
                    <button class="btn btn-primary" name="action" value="listFlower">Flower</button>
                </form>
            </div>
            <div class="mx-3">
                <form method="post" action="mainServlet">
                    <button class="btn btn-primary" name="action" value="AdminOrderSuccessfull">OrderSuccessfull</button>
                </form>
            </div>
            <div class="mx-3">
                <form method="post" action="mainServlet">
                    <button class="btn btn-primary" name="action" value="AdminOrder">Order</button>
                </form>
            </div>
            <div class="mx-3">
                <form method="post" action="mainServlet">
                    <button class="btn btn-primary" name="action" value="customer">Customer</button>
                </form>
            </div>
            <div class="mx-3">
                <a href="#" class=" btn btn-primary">Shipper</a>
            </div>
            <div class="mx-3">
                <form method="post" action="mainServlet">
                    <button class="btn btn-primary" name="action" value="logout">Logout</button>
                </form>
            </div>
            <%
            } else if (session.getAttribute("customer") != null) {
            %>
            <div class="mx-3">
                <a href="index.jsp" class="btn btn-primary ">Home</a>
            </div>
            <div class="mx-3">
                <a href="#" class="btn btn-primary">My profile</a>
            </div>
            <div class="mx-3">
                <a href="#" class="btn btn-primary ">Cart</a>
            </div>
            <div class="mx-3">
                <a href="#" class="btn btn-primary ">Order</a>
            </div>
            <div class="mx-3">
                <form method="post" action="mainServlet">
                    <button class="btn btn-primary" name="action" value="logout">Logout</button>
                </form>
            </div>
            <%
            } else {
            %>
            <div class="mx-3">
                <a href="register.jsp" class="btn btn-primary ">Register</a>
            </div>
            <div class="mx-3">
                <a href="login.jsp" class=" btn btn-primary">Login</a>
            </div>
            <div class="mx-3">
                <a href="index.jsp" class="btn btn-primary ">Home</a>
            </div>
            <%
                }
            %>

        </div>
    </div>
</header>
