<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="elem" tagdir="/WEB-INF/tags/elements" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>


<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">

<!-- CSS -->
<link href="../../../resources/css/cards.css" rel="stylesheet">

<!DOCTYPE html>
<html lang="en">


<body id="page-top">

<!-- Navigation -->
<elem:header>
        <jsp:attribute name="navButtons">
            <li class="nav-item">
                <a class="nav-link" href="#about">Restaurants</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#download">Most Voted</a>
            </li>
            <li class="nav-item">
                <a class="text-center" href="/logout">Logout</a>
            </li>
        </jsp:attribute>
</elem:header>

<!-- Intro Header -->
<header class="masthead">
    <div class="intro-body">
        <div class="container">
            <div class="row">
                <div class="col-md-3">

                </div>


                <div class="col-md-8 offset-md-1">
                    <h1 class="brand-heading">Pick Me</h1>
                    <p class="intro-text">An answer for your questions.
                        <br>Restaurant picker.</p>
                    <a href="#about" class="btn btn-circle page-scroll">
                        <i class="fa fa-angle-double-down animated"></i>
                    </a>
                </div>
            </div>
        </div>
    </div>
</header>


<!-- About Section -->
<section id="about" class="container content-section text-center">

    <div class="row">
        <a class="nav-link" href="#" data-toggle="modal" data-target="#restaurantAddModal">New Restaurant</a>
        <a class="nav-link" role="button" onClick="window.location.reload()">Sort</a>
    </div>
    <div class="row">
        <c:forEach var="restaurant" items="${restaurants}">

            <div class="col-md-4">
                <div class="column">
                    <!-- Post-->
                    <div class="post-module">
                        <!-- Thumbnail-->
                        <div class="thumbnail">
                            <a tabindex="0" class="date" role="button" data-toggle="popover" data-trigger="body"
                               data-content="<a href='#' data-toggle='modal' data-target='#restaurantEditModal' onclick='getRestaurant(${restaurant.id})' class='btn btn-secondary btn-lg'>Edit</a> <br>
                                                 <a href='/restaurant/delete?id=${restaurant.id}' class='btn btn-danger'>Delete</a>">
                                <div class="day"><i class="fa fa-bars" aria-hidden="true"></i></div>
                            </a>
                            <img src="${restaurant.image}" class="img-responsive" alt="">
                        </div>
                        <!-- Post Content-->
                        <div class="post-content" id="post-content-${restaurant.id}">
                            <div class="category">Pizza</div>
                            <h1 class="title">${restaurant.name}</h1>
                            <h2 class="sub_title">R$: ${restaurant.price} <c:if test="${restaurant.aleloAccepted}"><img src="http://creditoedebito.com.br/wp-content/uploads/2011/12/alelo.jpg" class="img-responsive " height="25px" alt=""></c:if></h2>
                            <p class="description">${restaurant.description} <br> ${restaurant.location}</p>
                            <div class="post-meta">
                                <span class="comments" id="voteCount-${restaurant.id}"></span>
                                <a class="btn btn-default btn-sm" role="button" onclick="vote(${restaurant.id})">Vote</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </c:forEach>

    </div>
</section>

<!-- Download Section -->
<section id="download" class="content-section text-center">
    <div class="download-section">
        <div class="container">
            <div class="col-lg-8 offset-md-2">
                <h2>Most Voted</h2>
                <p>This is the most voted restaurant.</p>
                <a href="#" class="btn btn-default btn-lg">Place Holder</a>
            </div>
        </div>
    </div>
</section>

<!-- Map Section -->
<div id="map"></div>

<!-- Footer -->
<footer>
    <div class="container text-center">
        <p>Pick Me!</p>
    </div>
</footer>

<!-- Restaurant Add -->
<div class="modal fade" id="restaurantAddModal" tabindex="-1" role="dialog" aria-labelledby="restaurantAddModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <elem:addRestaurant/>
    </div>
</div>

<!-- Restaurant Edit -->
<div class="modal fade" id="restaurantEditModal" tabindex="-1" role="dialog" aria-labelledby="restaurantEditModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <elem:editRestaurant/>
    </div>
</div>


<!-- Bootstrap core JavaScript -->
<script src="../../../resources/vendor/jquery/jquery.min.js"></script>
<script src="../../../resources/vendor/tether/tether.min.js"></script>
<script src="../../../resources/vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Plugin JavaScript -->
<script src="../../../resources/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Google Maps API -->
<%--<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCqAZ-i7xPeqanrDkGPNvaTAi9Lnvv2C2g&sensor=false"></script>--%>

<!-- Custom scripts for this template -->
<script src="../../../resources/js/grayscale.js"></script>
<script src="../../../resources/js/voteLogic.js"></script>
<script src="../../../resources/js/restaurantListSort.js"></script>


</body>

</html>
