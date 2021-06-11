<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Categories</title>
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
    <div class="col-md-3 offset-md-4">
        <ul class="navbar-nav">
        <li class="nav-item">
            <h2 class="text-white">Popular categories</h2>
        </li>
    </ul>
    </div>
    <div class="col-md-2 offset-md-3">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a href="${contextPath}/eshop?command=start_cart_page">
                    <button type="submit" style="width: 100px"
                            class="btn btn-dark">Cart <span class="badge badge-pill badge-warning"><%=session.getAttribute("count")%></span>
                    </button>
                </a>
            </li>
        </ul>
    </div>
</nav>
<div class="container-fluid mb-4">
    <c:if test="${not empty categories}">
        <div class="row">
            <c:forEach items="${categories}" var="category">
                <div class="card w-20 m-1" type="category" style="width:300px">
                    <div class="card-body">
                            <img class="img-fluid" style="width:300px;height:200px"
                                 src="${contextPath}/images/${category.getImageName()}"
                                 alt="Card image" style="width: 100%">
                            <a href="${contextPath}/eshop?command=start_product_page&type=${category.getName()}">
                            <button type="submit" style="width: 140px"
                                    class="btn btn-primary stretched-link">${category.getName()} </button>
                            </a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:if>
</div>
</div>
</body>
</html>

