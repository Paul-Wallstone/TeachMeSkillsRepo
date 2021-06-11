<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Cart</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <!-- Brand/logo -->
    <col-1>
        <a class="navbar-brand">
            <img src="${contextPath}/images/logo/java1.jpg" alt="logo" style="width:70px;height: 50px">
        </a>
    </col-1>
    <!-- Links -->
    <col-1>
        <ul class="navbar-nav">
            <li class="nav-item">
                <a href="${contextPath}/eshop?command=start_page">
                    <button type="submit" style="width: 80px"
                            class="btn btn-dark">Home
                    </button>
                </a>
            </li>
        </ul>
    </col-1>
    <div class="col-md-2 offset-md-6 text-white" style="height:50px; width:140px; text-align:center">
        <div style="position:absolute; top:50%; left:50%; margin-top:-12px; margin-left:25px">
            <ul class="navbar-nav" style="width: 100px">
                <li class="offset-md-1" style="width: 100px">
                    <p>Total price</p>
                </li>
            </ul>
        </div>
    </div>
    <div class="col-md-1  text-white">
        <ul class="navbar-nav">
            <li class="offset-md-1">
                <span class="badge badge-pill badge-warning"><%=session.getAttribute("total_price")%> $</span>
            </li>
        </ul>
    </div>
    <div class="col-md-1">
        <ul class="navbar-nav">
            <li class="nav-item">
                <form method="post">
                    <button type="submit" style="width: 100px"
                            class="btn btn-dark">Cart <span
                            class="badge badge-pill badge-warning"><%=session.getAttribute("count")%></span>
                    </button>
                </form>
            </li>
        </ul>
    </div>
</nav>
<div class="container-fluid mb-4 offset-md-1">

    <c:if test="${not empty carts}">
    <c:forEach items="${carts}" var="product">
    <div class="row">
        <div class="card w-35 m-1 bg-dark text-white" type="cart" style="width:650px">
                    <span class="border border-primary">
                        <div class="row no-gutters">
                             <div class="col-4">
                                <img class="img-fluid" style="width:650px;height:200px"
                                     src="${contextPath}/images/products/${product.getImageName()}"
                                     alt="Card image" style="width: 100%">
                             </div>
                                 <div class="col-8">                                    <div class="card-body">
                                    <h4 class="card-title">${product.getName()}</h4>
                                    <p class="card-text">${product.getDescription()}</p>
                                      <h4 class="card-title">Price: ${product.getPrice()}$</h4>
                                     <a href="${contextPath}/eshop?command=remove-product-from-cart&product_id=${product.getId()}">
                                       <button type="submit" style="width: 180px"
                                               class="btn btn-primary">Delete product</button>
                                     </a>
                                     </div>
                                  </div>
                        </div>
                    </span>
        </div>
    </div>
    </c:forEach>
    </c:if>
    <div class="row">
        <div class="card w-35 m-1 bg-warning" type="cart" style="width:650px">
            <div class="row no-gutters">
                <div class="col-8">
                    <h1>Total price: <%=session.getAttribute("total_price")%>$</h1>
                </div>
                <div class="col-4">
                <button type="submit" style="width: 180px"
                        class="btn btn-success btn-lg">Ordered
                </button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
