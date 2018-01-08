<%-- 
    Document   : masterdatauser
    Created on : 31-Dec-2017, 21:08:19
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="u" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Data Master Order</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="container">
        <h1>Data Master Order</h1>
        <hr/>
        <u:forEach var="dt" items="${penjualan}">
            <u:set var="t" value="${t+1}"></u:set>
        </u:forEach>
        Total Order : ${t}
        <hr/>
        
        <table border="1">
            <tr><td>No.</td><td>Nama Pembeli</td><td>Id Order</td><td>Total Biaya</td><td>Tanggal Pembelian</td><td colspan="3">Opsi</td></tr>
            <u:forEach var="us" varStatus="i" items="${penjualan}">
                <tr>
                    <td>${i.count}</td><td>${us.idUser.nama}</td><td>${us.idOrder}</td><td>${us.total}</td><td>${us.createddate}</td>
                    
                    <td><a href="${pageContext.request.contextPath}/admin/master/detailorder/${us.idOrder}"><button>Detail Order</button></a></td>
                </tr>    
            </u:forEach>
            
        </table>
            </div>
        <div style="margin-top: 10px; background-color: #ccc">
        <jsp:include page="footer.jsp"/>
        </div>
    </body>
</html>
