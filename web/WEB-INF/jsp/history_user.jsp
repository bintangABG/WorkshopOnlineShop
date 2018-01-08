<%-- 
    Document   : history_user
    Created on : Jan 8, 2018, 9:30:49 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History User Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <div class="container">
                <table class="table table-responsive table-bordered">
                    <tr><th>NAMA</th><th>TANGGAL ORDER</th><th>TOTAL</th></tr>
                        <c:forEach var="hu" items="${orders}">
                    <tr>
                        <td>${hu.idUser.nama}</td>
                        <td>${hu.createddate}</td>
                        <td>${hu.total}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
