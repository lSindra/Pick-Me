<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="elem" tagdir="/WEB-INF/tags/elements" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">

<!-- CSS -->
<link href="../../resources/css/cards.css" rel="stylesheet">

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
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Login</b> <span class="caret"></span></a>
                <ul id="login-dp" class="dropdown-menu">
                    <elem:loginForm></elem:loginForm>
                </ul>
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
            <c:forEach var="restaurant" items="${restaurants}">

                <div class="col-md-4">
                    <div class="column">
                        <!-- Post-->
                        <div class="post-module">
                            <!-- Thumbnail-->
                            <div class="thumbnail">
                                <a tabindex="0" class="date" role="button" data-toggle="popover" data-trigger="body"
                                   data-content="<a href='/restaurant/edit?id=${restaurant.id}' class='btn btn-secondary btn-lg'>Edit</a> <br>
                                                 <a href='/restaurant/delete?id=${restaurant.id}' class='btn btn-danger'>Delete</a>">
                                    <div class="day"><i class="fa fa-bars" aria-hidden="true"></i></div>
                                </a>
                                <img src="${restaurant.image}" class="img-responsive" alt="">
                            </div>
                            <!-- Post Content-->
                            <div class="post-content">
                                <div class="category">Pizza</div>
                                <h1 class="title">${restaurant.name}</h1>
                                <h2 class="sub_title">R$: ${restaurant.price} <c:if test="${restaurant.aleloAccepted}"><img src="http://creditoedebito.com.br/wp-content/uploads/2011/12/alelo.jpg" class="img-responsive " height="25px" alt=""></c:if></h2>
                                <p class="description">${restaurant.description} <br> ${restaurant.location}</p>
                                <div class="post-meta">
                                    <span class="comments"><i class="fa fa-comments"></i><a href="#"> 0 Votes</a></span>
                                    <a class="btn btn-success btn-sm">Vote</a>
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
                    <a href="http://startbootstrap.com/template-overviews/grayscale/" class="btn btn-default btn-lg">Visit Download Page</a>
                </div>
            </div>
        </div>
    </section>

    <!-- Contact Section -->
    <section id="contact" class="container content-section text-center">
        <div class="row">
            <div class="col-lg-8 offset-md-2">
                <h2>Contact Start Bootstrap</h2>
                <p>Feel free to leave us a comment on the <a href="http://startbootstrap.com/template-overviews/grayscale/">Grayscale template overview page</a> on Start Bootstrap to give some feedback about this theme!</p>
                <ul class="list-inline banner-social-buttons">
                    <li class="list-inline-item">
                        <a href="https://twitter.com/SBootstrap" class="btn btn-default btn-lg"><i class="fa fa-twitter fa-fw"></i> <span class="network-name">Twitter</span></a>
                    </li>
                    <li class="list-inline-item">
                        <a href="https://github.com/BlackrockDigital/startbootstrap" class="btn btn-default btn-lg"><i class="fa fa-github fa-fw"></i> <span class="network-name">Github</span></a>
                    </li>
                    <li class="list-inline-item">
                        <a href="https://plus.google.com/+Startbootstrap/posts" class="btn btn-default btn-lg"><i class="fa fa-google-plus fa-fw"></i> <span class="network-name">Google+</span></a>
                    </li>
                </ul>
            </div>
        </div>
    </section>

    <!-- Map Section -->
    <div id="map"></div>

    <!-- Footer -->
    <footer>
        <div class="container text-center">
            <p>Copyright &copy; Your Website 2017</p>
        </div>
    </footer>

    <!-- Register Modal -->
    <div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="registerModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <elem:registerForm></elem:registerForm>
        </div>
    </div>

    <!-- Bootstrap core JavaScript -->
    <script src="../../resources/vendor/jquery/jquery.min.js"></script>
    <script src="../../resources/vendor/tether/tether.min.js"></script>
    <script src="../../resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="../../resources/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Google Maps API -->
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCqAZ-i7xPeqanrDkGPNvaTAi9Lnvv2C2g&sensor=false"></script>

    <!-- Custom scripts for this template -->
    <script src="../../resources/js/grayscale.min.js"></script>

    <script>
        $(window).on('load', function() {
            $('.post-module').hover(function() {
                $(this).find('.description').stop().animate({
                    height: "toggle",
                    opacity: "toggle"
                }, 300);
            });
        });
    </script>

    <script>
        $('[data-toggle="popover"]').popover({
            container: 'body',
            animation: true,
            html: true
        })
    </script>

</body>

</html>
