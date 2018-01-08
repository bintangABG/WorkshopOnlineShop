<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="prod" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="hr" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Bootstrap Example</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
            /* Remove the navbar's default margin-bottom and rounded borders */ 
            .navbar {
                margin-bottom: 100;
                border-radius: 0;
            }

            /* Add a gray background color and some padding to the footer */
            footer {
                background-color: #f2f2f2;
                padding: 25px;
            }

            .carousel-inner img {
                width: 100%; /* Set width to 100% */
                margin: auto;
                min-height:200px;
            }

            /* Hide the carousel text when the screen is less than 600 pixels wide */
            @media (max-width: 600px) {
                .carousel-caption {
                    display: none; 
                }
            }
        </style>
    </head>

    <body>
        <jsp:include page="header.jsp"/>

        <div id="myCarousel" class="carousel slide" data-ride="carousel" style="margin-top: -50px ">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img src="https://about.canva.com/wp-content/uploads/sites/3/2017/02/birthday_banner.png" alt="Image">
                    <div class="carousel-caption">
                    </div>      
                </div>

                <div class="item">
                    <img src="https://ps.w.org/adrotate/assets/banner-772x250.jpg?rev=1691423" alt="Image">
                    <div class="carousel-caption">
                    </div>      
                </div>
            </div>

            <!-- Left and right controls -->
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>

        <div class="container text-center" align="center">     
            <h3>What We Sell</h3><br>
            <div class="row">
                <div class="col-sm-4">
                    <a href="${pageContext.request.contextPath}/product/kategoriproduct/3"><img src="http://www.insidefashion.com/assets/inside_fashion_new_logo.jpg" class="img-responsive" style="width:100%" alt="Image">
                        </div>
                        <div class="col-sm-4"> 
                            <a href="${pageContext.request.contextPath}/product/kategoriproduct/2"><img src="https://upload.wikimedia.org/wikipedia/commons/5/55/Elektronik_Zeitschrift_logo_1990.png" class="img-responsive" style="width:100%" alt="Image">
                                </div>
                                <div class="col-sm-4"> 
                                    <li><a href="${pageContext.request.contextPath}/product/kategoriproduct/1"><img src="http://www.bebeeshoppee.com/image/data/logo.png" class="img-responsive" style="width:100%" alt="Image"></a>
                                </div>
                        </div>
                </div>

                <div class="py-5 section bg-faded bg-light">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12" align="center">
                                <h1 class="mb-4">Latest Products</h1>
                                <hr/>
                                <br>
                            </div>
                        </div>
                        <div class="row">   
                            <prod:forEach var="p" items="${products}">
                                <div class="col-md-4 col-4" style="margin-top: 5px;margin-bottom: 5px">
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
                    </div>
                    <div style="margin-top: 30px;">
                        <jsp:include page="footer.jsp"/>
                    </div>
                    </body>
                    </html>
