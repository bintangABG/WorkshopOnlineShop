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
        <title>Data Master User</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <h1>Data Master User</h1>
        <hr/>
        <u:forEach var="dt" items="${users}">
            <u:set var="t" value="${t+1}"></u:set>
        </u:forEach>
        Total User : ${t}
        <hr/>
        <table border="1">
            <tr><td>No.</td><td>UserName</td><td>Tgl lahir</td><td>Level</td><td>Jenis Kelamin</td><td colspan="3">Opsi</td></tr>
            <u:forEach var="us" varStatus="i" items="${users}">
                <tr>
                    <td>${i.count}</td><td>${us.username}</td><td>${us.tglLahir}</td><td>${us.level}</td>
                    <td>${us.jenisKelamin}</td>
                    <td><a href="${pageContext.request.contextPath}/admin/master/historyuser/${us.idUser}"><button>History Order</button></a></td>
                </tr>    
            </u:forEach>
            
        </table>
    </body>
</html>
