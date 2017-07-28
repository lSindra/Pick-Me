<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/general.css">
</head>

<body>

<nav class="container-fluid text-center">
    <p>Pick Me!</p>
</nav>

<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-2 sidenav">
            <p><a href="#">Link</a></p>
            <p><a href="#">Link</a></p>
            <p><a href="#">Link</a></p>
        </div>
        <div class="col-sm-8 text-left">

            <h1>Restaurants</h1>
            <a href="/add" class="btn btn-success pull-right">Add</a>
            <hr>

            <div class="card-deck" style="background-color: rgba(244,244,244,0.5)">
                <c:forEach var="restaurant" items="${restaurants}">
                    <div class="card">
                        <img class="card-img-top img-fluid" src="${restaurant.image}" alt="Card image cap">
                        <div class="card-block" style="background-color: rgba(236,236,236,0.5)">
                            <h4 class="card-title">${restaurant.name}</h4>
                            <p class="card-text">Price: ${restaurant.price}</p>
                            <p class="card-text">Accepts Alelo: ${restaurant.aleloAccepted}</p>
                            <p class="card-text">${restaurant.description}</p>
                        </div>
                        <div class="card-footer">
                            <small class="text-muted">Votes: 0</small>
                            <a href="/vote?id=${restaurant.id}" class="btn btn-success">Vote</a>
                            <a href="/edit?id=${restaurant.id}" class="btn btn-secondary pull-right">Edit</a>
                            <a href="/delete?id=${restaurant.id}" class="btn btn-danger pull-right">Delete</a>
                        </div>
                    </div>
                </c:forEach>
            </div>

        </div>
        <div class="col-sm-2 sidenav">
            <div class="well">
                <p>ADS</p>
            </div>
            <div class="well">
                <p>ADS</p>
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/resources/jquery-3.2.1.slim.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/tether.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/bootstrap.min.js"></script>
</body>
</html>