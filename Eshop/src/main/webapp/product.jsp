<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Product</title>
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
    <a class="navbar-brand" href="#">
        <img src="${contextPath}/images/logo/java1.jpg" alt="logo" style="width:70px;height: 50px">
    </a>
    <!-- Links -->
    <ul class="navbar-nav">
        <li class="nav-item">
            <a href="${contextPath}/eshop?command=start_page">
                <button type="submit" style="width: 80px"
                        class="btn btn-dark">Home
                </button>
            </a>
        </li>
    </ul>
    <div class="col-md-2 offset-md-9">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a href="${contextPath}/eshop?command=start_cart_page">
                    <button type="submit" style="width: 100px"
                            class="btn btn-dark">Cart <span
                            class="badge badge-pill badge-warning"><%=session.getAttribute("count")%></span>
                    </button>
                </a>
            </li>
        </ul>
    </div>
</nav>
<div class="container-fluid mb-4 offset-md-1">

    <c:if test="${not empty products}">
    <c:forEach items="${products}" var="product">
    <div class="row">
        <div class="card w-35 m-1 bg-dark text-white" type="product" style="width:650px">
                    <span class="border border-primary">
                        <div class="row no-gutters">
                             <div class="col-4">
                                <img class="img-fluid" style="width:650px;height:200px"
                                     src="${contextPath}/images/products/${product.getImageName()}"
                                     alt="Card image" style="width: 100%">
                             </div>
                                 <div class="col-8">
                                     <div class="card-body">
                                    <h4 class="card-title">${product.getName()}</h4>
                                    <p class="card-text">${product.getDescription()}</p>
                                      <h4 class="card-title">Price: ${product.getPrice()}$</h4>
                                    <a href="${contextPath}/eshop?command=add-product-to-cart&product_id=${product.getId()}">
                                         <button type="submit" style="width: 120px"
                                                 class="btn btn-primary">Add to cart</button>
                                    </a>
                                     </div>
                                  </div>
                        </div>
                    </span>
        </div>
    </div>
    </c:forEach>
    </c:if>

</body>
</html>
