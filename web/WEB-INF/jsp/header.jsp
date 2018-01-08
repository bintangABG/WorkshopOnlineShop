
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
    <head>
        <title>My LAZADUT Online Shop</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>

        <style>
            .badge .badge-success {
                color: #337ab7;
                background-color: #fff;
            }
        </style>

        <nav class="navbar navbar-inverse" >
            <a class="navbar-brand" href="#">
                <img src="https://cdn.shopify.com/s/files/1/2351/5779/t/19/assets/sticky_logo.png?7745581531723433983" width="30" height="30" alt="">
            </a>
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>                        
                    </button>
                    <a class="navbar-brand" href="${pageContext.request.contextPath}">LAZADUT</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">

                    <ul class="nav navbar-nav">
                        <c:if test="${empty sessionScope.user}">
                           <li><a href="${pageContext.request.contextPath}/product/allproduct">Produk</a></li>
                            <li><a href="${pageContext.request.contextPath}/product/kategoriproduct/3">Fashion</a></li>
                            <li><a href="${pageContext.request.contextPath}/product/kategoriproduct/2">Elektronik</a></li>
                            <li><a href="${pageContext.request.contextPath}/product/kategoriproduct/1">Perlengkapan Bayi</a></li>
                            </c:if>

                        <c:if test="${sessionScope.user.level==2}">
                            <li><a href="${pageContext.request.contextPath}/product/allproduct">Produk</a></li>
                            <li><a href="${pageContext.request.contextPath}/product/kategoriproduct/3">Fashion</a></li>
                            <li><a href="${pageContext.request.contextPath}/product/kategoriproduct/2">Elektronik</a></li>
                            <li><a href="${pageContext.request.contextPath}/product/kategoriproduct/1">Perlengkapan Bayi</a></li>
                            </c:if>

                        <c:if test="${sessionScope.user.level==1}">
                            <li><a href="${pageContext.request.contextPath}/admin/master/datamasterproduct">Master Product</a></li>
                            <li><a href="${pageContext.request.contextPath}/admin/master/datamasteruser">Master User</a></li>
                            <li><a href="${pageContext.request.contextPath}/admin/master/datapenjualan">Master Order</a></li>
                            </c:if>
                    </ul>

                    
                        <form class="navbar-form navbar-left" action="${pageContext.request.contextPath}/admin/master/searchs" method="POST" style="margin-left:100px">
                            <div class="input-group" class="container">
                                <input type="text" name="keyword" required="true" class="form-control col-md-10 col-lg-pull-1" style="width:-300px" placeholder="Cari produk" name="search" >
                                
                                <div class="input-group-btn">
                                    <button class="btn btn-default" type="submit" style="margin-left:-11px">
                                        <i class="glyphicon glyphicon-search"></i>
                                    </button>
                                </div>
                            </div>
                        </form>
                        <c:forEach var="pr" items="${sessionScope.cart.cartlist.values()}">
                            <c:set var="s" value="${s+ pr.idProduct.harga * pr.qtyBeli}"></c:set>
                            <c:set var="qw" value="${qw + pr.qtyBeli}"></c:set>
                        </c:forEach>
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a href="${pageContext.request.contextPath}/welcome">
                                    <span class="glyphicon glyphicon-shopping-cart"><span class="badge badge-success">${qw}</span></span></a>
                            </li>
                            <c:if test="${empty sessionScope.user}">
                                <li><a href="${pageContext.request.contextPath}/registrasi"><span class="glyphicon glyphicon-user"></span> Daftar</a></li>
                                <li><a href="${pageContext.request.contextPath}/login"><span class="glyphicon glyphicon-log-in"></span> Masuk</a></li>&nbsp;

                            </ul>
                        </c:if>

                        <c:if test="${not empty sessionScope.user}">

                            <li><a href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                            </c:if>
                </div>
            </div>
        </nav>

    </body>
</html>

