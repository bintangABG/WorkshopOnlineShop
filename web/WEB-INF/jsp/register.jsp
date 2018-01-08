<%-- 
    Document   : registration
    Created on : Dec 13, 2017, 10:16:10 AM
    Author     : imam
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <link href="<c:url value='/resources/css/bootstrap.css'/>" rel="stylesheet">
        <link href="<c:url value='/resources/css/login.css'/>" rel="stylesheet">
        <script src="<c:url value='/resources/js/bootstraps.js'/>"  ></script>
        <title>Form Registrasi </title>
        <jsp:include page="header.jsp"/>
    </head>
    <body>

        <div align="center">  
            <legend>
                <h1>Registration Form</h1>
            </legend>    
        </div>
        <div class="container col-sm-4" style="padding: 40px;" >
            <form:form action="registrasi/save" modelAttribute="registerBean" method="POST" >
                <div class="form-group">
                    <!--div class="form-group"-->
                 <tr><td><form:label path="nama">Nama</form:label></td>
                     <td><form:input path="nama" cssClass="form-control" placeholder="ex : Khaleem" required="required"/></td></tr><br>
                            <tr>
                                <td><form:label path="jenis_kelamin">Jenis Kelamin</form:label></td><br>
                            <td><form:radiobutton path = "jenis_kelamin" value = "l" label = "Male" />
                                    <form:radiobutton path = "jenis_kelamin" value = "p" label = "Female" /></td></tr><br><br>
                            <tr>
                                <td><form:label path="email">Email</form:label></td>
                                <td><form:input path="email" cssClass="form-control" placeholder="ex : Khaleem@gmail.com" required="required"/></td></tr><br>
                            <tr>
                                <!--<td><form:label path="level">Level</form:label></td>-->
                                <td><form:input type="hidden" path="level" cssClass="form-control"/></td></tr>
                            <tr>
                                <td><form:label path="telp">No Telp</form:label></td>
                                <td><form:input path="telp" cssClass="form-control" placeholder="ex : 081234567890" required="required"/></td></tr><br>
                            <tr>
                                <td><form:label path="alamat">Alamat</form:label></td>
                                <td><form:input path="alamat" cssClass="form-control" required="required"/></td></tr><br>
                            <tr>
                                <td><form:label path="tgl_lahir">Tanggal Lahir</form:label></td>
                                <td><form:input path="tgl_lahir" cssClass="form-control" placeholder="ex : 13/12/1996" required="required"/></td></tr><br>
                            <tr>
                                <td><form:label path="username">Username</form:label></td>
                                <td><form:input path="username" cssClass="form-control" placeholder="ex : Khaleem123" required="required" /></td></tr><br>
                            <tr>
                                <td><form:label path="password">Password</form:label></td>
                                <td><form:password path="password" cssClass="form-control" required="required" /></td></tr><br>
                <form:button name="submitButton" value="Submit" class="btn btn-info btn-block login" cssClass="form-control">Submit</form:button>
            </form:form>
                <div>
            <jsp:include page="footerlogin.jsp"/>
        </div>
                </div>
                
            </div>
        </div> 
        </div> 
        
        
    </body>
</html>
