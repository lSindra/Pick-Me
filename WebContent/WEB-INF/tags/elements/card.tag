<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag description="Card Section" pageEncoding="UTF-8"%>
<%@ attribute name="restaurant" required="true" type="com.sap.pickme.models.Restaurant" %>



<div class="col-md-4" id="card">
    <div class="column">
        <!-- Post-->
        <div class="post-module" role="button">
            <!-- Thumbnail-->
            <div class="thumbnail">
                <a tabindex="0" class="date" role="button" data-toggle="popover" data-trigger="body"
                   data-content="<a data-toggle='modal' data-target='.bd-example-modal-sm' role='button' onclick='listVoters(${restaurant.id})' class='btn btn-secondary'>Voters</a> <br>
                                 <a href='#' data-toggle='modal' data-target='#restaurantEditModal' onclick='getRestaurant(${restaurant.id})' class='btn btn-secondary btn-lg'>Edit</a> <br>
                                 <a href='/restaurant/delete?id=${restaurant.id}' class='btn btn-danger'>Delete</a>">
                    <div class="day"><i class="fa fa-bars" aria-hidden="true"></i></div>
                </a>
                <img src="${restaurant.image}" class="img-responsive" alt="">
            </div>
            <!-- Post Content-->
            <div class="post-content" id="post-content-${restaurant.id}">
                <input type="hidden" name="restaurantId" id="restaurantId" value="${restaurant.id}"/>
                <div class="category">Pizza</div>
                <h1 class="title">${restaurant.name}</h1>
                <h2 class="sub_title">R$: ${restaurant.price} <c:if test="${restaurant.aleloAccepted}"><img src="/resources/img/aleloIcon.png" class="img-responsive " height="25px" alt=""></c:if></h2>
                <p class="description">${restaurant.description} <br> ${restaurant.location}</p>
                <div class="post-meta">
                    <span class="comments" id="voteCount-${restaurant.id}"></span>
                </div>
            </div>
        </div>
    </div>
</div>
