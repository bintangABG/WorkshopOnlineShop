<%-- 
    Document   : detail_order
    Created on : Jan 8, 2018, 10:05:40 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail Order Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <div class="container">
                <table class="table table-responsive table-bordered">
                    <tr><th>NAMA PRODUK</th><th>JUMLAH UNIT</th><th>HARGA</th>     
                        <c:forEach var="od" items="${orderdetail}">
                    
                        <c:forEach var="dot" items="${od.itemsList}">
                            <tr>
                            <td> ${dot.idProduct.namaProduct}</td>
                            <td> ${dot.qtyBeli}</td>
                            <td> ${dot.idProduct.harga}</td>
                            
                        </c:forEach>
                            
                        <tr></tr>    
                        <th colspan="2">TOTAL HARGA</th><td> ${od.total}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
