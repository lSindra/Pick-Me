<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<t:genericpage>
    <jsp:attribute name="header"></jsp:attribute>

    <jsp:attribute name="leftsidenav">
        <a href="/add" class="btn btn-success pull-right">Add</a>
    </jsp:attribute>

    <jsp:attribute name="mainbody">
        <h1>Restaurants  <a href="/add" class="btn btn-success pull-right">Add</a></h1>
        <hr>
        <div class="row">
            <div class="card-deck">
                <c:forEach var="restaurant" items="${restaurants}">
                    <div class="card col-sm-4">
                        <div class="card-header>">
                            <img class="card-img-top img-fluid" src="${restaurant.image}" alt="Card image cap" style="min-height: 300px">
                        </div>
                        <div class="card-block">
                            <h4 class="card-title">${restaurant.name}
                                <a href="/edit?id=${restaurant.id}" class="btn btn-secondary btn-sm">Edit</a>
                                <a href="/delete?id=${restaurant.id}" class="btn btn-danger btn-sm">Delete</a>
                            </h4>
                            <hr>
                            <p class="card-text">Price: ${restaurant.price}</p>
                            <hr>
                            <p class="card-text">Accepts Alelo: <span class="badge badge-success">${restaurant.aleloAccepted}</span></p>
                            <hr>
                            <p class="card-text">${restaurant.location}</p>
                            <hr>
                            <p>
                                <a class="btn btn-primary" data-toggle="collapse" href="#collapse${restaurant.id}" aria-expanded="false" aria-controls="collapseExample">
                                    Description
                                </a>
                            </p>
                            <div class="collapse" id="collapse${restaurant.id}">
                                <div class="card card-block" style="background-color: #f9f9f9">
                                    <p class="card-text">    ${restaurant.description}</p>
                                </div>
                            </div>
                        </div>
                        <div class="card-footer">
                            <small class="text-muted">Votes: 0</small>
                            <a href="/vote?id=${restaurant.id}" class="btn btn-success">Vote</a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </jsp:attribute>

    <jsp:attribute name="rightsidenav">
        <a href="/add" class="btn btn-success pull-right">Add</a>
    </jsp:attribute>

</t:genericpage>




</html>