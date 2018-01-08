<%-- 
    Document   : teskeranjang
    Created on : 31-Dec-2017, 00:03:00
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="idr" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>
    </head>
    <body>

        <jsp:include page="header.jsp"/>

        <c:forEach var="pr" items="${sessionScope.cart.cartlist.values()}">
            <c:set var="s" value="${s+ pr.idProduct.harga * pr.qtyBeli}"></c:set>
            <c:set var="qw" value="${qw + pr.qtyBeli}"></c:set>
        </c:forEach>

        <div class="container">
            <table class="table table-striped table-responsive table-bordered">
                <tr>
                    <th><h2>No</h2></td>
                    <th><h2>Nama Product</h2></td>
                    <th><h2>Kategori</h2></td>
                    <th><h2>Harga</h2></td>
                    <th><h2>Qty Beli</h2></td>
                    <th><h2>Opsi</h2></td>

                        <c:forEach var="p" varStatus="i" items="${sessionScope.cart.cartlist.values()}">
                    <tr>
                        <td>${i.count}.</td>
                        <td>${p.idProduct.namaProduct}</td>
                        <td>${p.idProduct.idKategori.kategori}</td>
                        <td>Rp. <idr:formatNumber value="${p.idProduct.harga}"></idr:formatNumber></td>
                        <td>${p.qtyBeli}</td>
                        <td><a href="${pageContext.request.contextPath}/cart/delete/${p.idProduct.idProduct}">Hapus</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="container">
            <p style="margin-left: 10px;float: left">Jumlah Item dalam Keranjang : ${qw}</p>
            <h2 style="float: right">Total : Rp. <idr:formatNumber value="${s}"></idr:formatNumber></h2>
            </div>
        <center><a class="btn btn-lg btn-primary" href="${pageContext.request.contextPath}/product/allproduct">Belanja Lagi</a></center>
    <br/>
    <form:form action="${pageContext.request.contextPath}/order/save" modelAttribute="paymentbean" role="form" method="POST">
        <form:label path="credit">Pembayaran : </form:label>
        <form:radiobutton path="credit" title="Tunai" label="Tunai" value="0"></form:radiobutton>
        <form:radiobutton path="credit" title="Kredit" label="Kredit" value="1"></form:radiobutton>
        <br>
        <form:label path="jenis_paket">Jenis Pengiriman : </form:label>
        <form:select path="jenis_paket">
            <form:option label="--Pilih Paket--" value=""></form:option>
            <form:option label="Reguler" value="reguler"></form:option>
            <form:option label="SDS" value="sds"></form:option>
            <form:option label="Kilat" value="kilat"></form:option>
            <form:option label="ONS" value="ons"></form:option>
            <form:option label="HDS" value="hds"></form:option>
        </form:select>
        <br>
        <form:label path="kota_tujuan">Tujuan Pengiriman : </form:label>
        <form:select path="kota_tujuan">
            <form:option label="--Pilih Kota--" value=""></form:option>
            <form:option label="Jakarta" value="Jakarta"></form:option>
            <form:option label="Surabaya" value="Surabaya"></form:option>
            <form:option label="Bandung" value="Bandung"></form:option>
            <form:option label="Bogor" value="Bogor"></form:option>
            <form:option label="Depok" value="Depok"></form:option>
        </form:select>
        <br/>
        <form:label path="isAsuransi">Asuransi Pengiriman : </form:label>
        <form:radiobutton path="isAsuransi" title="ya" label="Ya" value="0"></form:radiobutton>
        <form:radiobutton path="isAsuransi" title="tidak" label="Tidak" value="1"></form:radiobutton>
        <br/>
        <form:label path="gaji_pokok">Gaji Pokok : </form:label>
        <form:input path="gaji_pokok" required="true"></form:input><br/>
        <form:label path="penghasilan_tambahan">Penghasilan Tambahan : </form:label>
        <form:input path="penghasilan_tambahan" required="true"></form:input><br/>
        <form:label path="tanggungan">Tanggungan : </form:label>
        <form:input path="tanggungan" required="true"></form:input><br/>
        <form:label path="uang_muka">Uang Muka : </form:label>
        <form:input path="uang_muka" required="true"></form:input><br/>

        <c:if var="kondisi" test="${empty sessionScope.user}">     
            <a href="${pageContext.request.contextPath}/login/check/"><button onclick="alert('maaf anda harus login untuk melanjutkan');red();">CheckOut</button></a>
            <!--script type="text/javascript">
                window.location.href = "${pageContext.request.contextPath}/login";
            </script-->
        </c:if>
        <c:if test="${not empty sessionScope.user}">
            <a href="${pageContext.request.contextPath}/order/save/"><button class="btn btn-lg btn-primary">CheckOut</button></a>    
        </c:if>


    </form:form>
   
    <style>
        td{padding:5px;}
    </style>

    <div style="background-color: #ccc;margin-top: 100px;">
        <jsp:include page="footer.jsp"/>
    </div>
</body>
</html>
