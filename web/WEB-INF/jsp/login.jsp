<%-- 
    Document   : Login
    Created on : 17-Dec-2017, 10:52:00
    Author     : user
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <link href="<c:url value='/resources/css/bootstrap.css'/>" rel="stylesheet">
        <link href="<c:url value='/resources/css/login.css'/>" rel="stylesheet">
        <script src="<c:url value='/resources/js/bootstraps.js'/>"  ></script>
        <title>Login </title>
        <jsp:include page="header.jsp"/>
        <title>Login</title>
    </head>
    <body>
        <div class="container" style="padding: 5px;">
            <div class="card" style="width: 20rem;" align="center">
                <div class="card-body">
                    
                <div align="center">  
                    <legend>
                        <h1>Login Form</h1>
                    </legend>    
                </div>
             <p class="card-text">       
        <div class="container col-sm-4" style="padding: 40px;" >
            <form:form  action="login/check" modelAttribute="loginBean"  method="POST" >
                <div class="login-container">    
                <tr><td><form:label path="username">Username</form:label></td><br>
                <td><form:input path="username" cssClass="form-control f"/></td></tr>
            <tr><td><form:label path="password">Password</form:label></td>
            <td><form:password path="password" cssClass="form-control f" /></td></tr><br>
        <tr><td></td><td><form:button name="submitButton" value="Submit">Submit</form:button></td></tr>            
            </form:form>
        </div>
            </p>
        </div>
        </div>
    </div>
</div> 
        <div style="background-color: #ddd">
            <jsp:include page="footerlogin.jsp"/>
        </div>
        
        <style>
            .f{width: 300px;}
        </style>
</body>

</html>
