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
                    <div class="col-md-3"></div>

                    <div class="col-md-8 offset-md-1">
                        <h1 class="brand-heading">Pick Me</h1>
                        <p class="intro-text">An answer for your questions.
                            <br>Restaurant picker.</p>
                    </div>
                </div>
            </div>
        </div>
    </header>


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
