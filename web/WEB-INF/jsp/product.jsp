<%-- 
    Document   : product
    Created on : Dec 29, 2017, 9:34:55 AM
    Author     : user
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="prod" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="hr" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Page</title>
    </head>
    <body>
        <style>
            .kategori{margin-left: 100px;}
        </style>

        <jsp:include page="header.jsp"/>
        
        <div class="container products">
            <prod:forEach var="p" items="${products}">
                <div class="col-md-3 col-3" style="margin-top: 5px;margin-bottom: 5px">
                    <img class="img-rounded img-thumbnail" src="<c:url value="/img_products/${p.image}"/>" alt="${p.image}"/>
                    <div style="width: auto; height: auto">
                        <h2>${p.namaProduct}</h2>
                        <p><span class="glyphicon glyphicon-certificate"></span> <a href="${pageContext.request.contextPath}/product/showByKategori/${p.idKategori.idKetegori}">${p.idKategori.kategori}</a></p>
                        <p style="width:auto;margin: 2px;">${p.deskripsi}</p>
                        <p><strong>Rp.</strong> <hr:formatNumber value="${p.harga}"></hr:formatNumber></p>
                        <a class="btn btn-lg btn-primary" href="${pageContext.request.contextPath}/cart/orderproduct/${p.idProduct}" type="submit">
                            <span class="glyphicon glyphicon-plus-sign"></span> Order</a>
                    </div>
                </div>

            </prod:forEach>
        </div>



        <!--a href="/workshopkel3/product/tambah"><button>Tambah</button></a> <br--> 
        <hr/>
        <div style="background-color: #ccc; margin-top: 10px">
            <jsp:include page="footer.jsp"/>       
        </div>
    </body>
</html>
