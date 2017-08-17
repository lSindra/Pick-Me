<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="elem" tagdir="/WEB-INF/tags/elements" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<link href="../../../resources/css/voteHistory.css" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">



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


    <div class="container">
        <div class="row" style="height: 10%"></div>
        <h1>Vote History</h1>
        <div class="row">
            <div class="table-responsive col-md-12">
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>Restaurant</th><th>User</th><th>Date</th>
                    </tr>
                    </thead>
                    <tbody>

                        <c:forEach var="vote" items="${votes}">

                            <tr>
                                <td><p>${vote.restaurant.name}</p></td>
                                <td><p>${vote.user.name}</p></td>
                                <td><p>${vote.date}</p></td>
                                <td><p></p></td>
                            </tr>

                        </c:forEach>

                    </tbody>
                </table>
            </div>
            <div class="pull-right">
                <ul class="pagination">
                    <li><a href="#">«</a></li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">»</a></li>
                </ul>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript -->
    <script src="../../../resources/vendor/jquery/jquery.min.js"></script>
    <script src="../../../resources/vendor/tether/tether.min.js"></script>
    <script src="../../../resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="../../../resources/vendor/jquery-easing/jquery.easing.min.js"></script>
    <script src="../../../resources/js/grayscale.js"></script>


</body>

</html>
