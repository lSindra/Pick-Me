<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<t:genericpage>
    <jsp:attribute name="header"></jsp:attribute>

    <jsp:attribute name="leftsidenav">
        <a href="/add" class="btn btn-success pull-right">Add</a>
    </jsp:attribute>

    <jsp:attribute name="mainbody">
        <h1>Restaurants</h1>
        <hr>
        <div class="row">
            <div class="card-deck">
                <c:forEach var="restaurant" items="${restaurants}">
                    <div class="card col-sm-4">
                        <div id="card-${restaurant.id}">
                            <div class="card-header>">
                                <img class="card-img-top img-fluid" src="${restaurant.image}" alt="Card image cap" style="min-height: 300px">
                            </div>
                            <div class="card-block">
                                <h4 class="card-title">${restaurant.name}
                                    <a href="#" onclick="editCard(${restaurant.id})" class="btn btn-secondary btn-sm">Edit</a>
                                    <a href="/delete?id=${restaurant.id}" class="btn btn-danger btn-sm">Delete</a>
                                </h4>
                                <hr>
                                <p class="card-text">Price: ${restaurant.price}</p>
                                <hr>
                                <p class="card-text">Accepts Alelo: <span class="badge badge-success">${restaurant.aleloAccepted}</span></p>
                                <hr>
                                <p class="card-text">Location: ${restaurant.location}</p>
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
                            <div class="card-footer ">
                                <small class="text-muted">Votes: 0</small>
                                <a class="btn btn-success">Vote</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>

                <div class="card col-sm-4">
                    <div class="card-block" id="addCard">
                            <a onclick="addCard()" class="btn btn-success btn-circle">+</a>
                    </div>
                </div>


            </div>
        </div>

        <div class="hide">
            <div class="card col-sm-4" id="hiddenaddcard" hidden>
                <form action="/add" method="post">
                    <div class="card-header>">
                        <div class="form-group">
                            <input type="text" class="form-control" name="image" placeholder="Enter restaurant image URL"/>
                        </div>
                    </div>
                    <div class="card-block">
                        <div class="form-group" id="addRestaurant">
                            <div class="form-group">
                                <input type="text" class="form-control" name="name" placeholder="Enter restaurant name"/>
                            </div>
                            <hr>
                            <div class="form-group">
                                <input type="number" class="form-control" name="price" placeholder="Enter average price">
                            </div>
                            <hr>
                            <div class="form-check">
                                <label class="form-check-label">
                                    <input type="checkbox" class="form-check-input">
                                    Accepts ALELO
                                </label>
                            </div>
                            <hr>
                            <div class="form-group">
                                <input type="text" class="form-control" name="location" placeholder="Enter location">
                            </div>
                            <hr>
                            <div class="form-group">
                                <textarea class="form-control" name="description" rows="2" placeholder="Enter description (optional)"></textarea>
                            </div>
                        </div>
                    </div>
                <div class="card-footer">
                    <button type="submit" class="btn btn-primary" onclick='$("#addRestaurant").submit();'>Submit</button>
                    <a href="/" class="btn btn-danger btn-sm">Cancel</a>
                </div>
                </form>
            </div>

            <div class="card col-sm-4" id="hiddeneditcard" hidden>
                <form action="/edit" method="post">
                    <div class="card-header>">
                        <input type="number" class="hidden-sm-up" value="${restaurant.id}"/>
                        <img class="card-img-top img-fluid" src="${restaurant.image}" alt="Card image cap" style="min-height: 300px">
                        <div class="form-group">
                            <input type="text" class="form-control" name="image" placeholder="Enter restaurant image URL" value="${resutaurant.image}"/>
                        </div>
                    </div>
                    <div class="card-block">
                        <div class="form-group" id="editRestaurant">
                            <div class="form-group">
                                <input type="text" class="form-control" name="name" placeholder="Enter restaurant name" value="${restaurant.name}"/>
                            </div>
                            <hr>
                            <div class="form-group">
                                <input type="number" class="form-control" name="price" placeholder="Enter average price" value="${restaurant.price}">
                            </div>
                            <hr>
                            <div class="form-check">
                                <label class="form-check-label">
                                    <input type="checkbox" class="form-check-input" value="${restaurant.aleloAccepted}">
                                    Accepts ALELO
                                </label>
                            </div>
                            <hr>
                            <div class="form-group">
                                <input type="text" class="form-control" name="location" placeholder="Enter location" value="${restaurant.location}">
                            </div>
                            <hr>
                            <div class="form-group">
                                <textarea class="form-control" name="description" rows="2" placeholder="Enter description (optional)" value="${restaurant.description}"></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="card-footer">
                        <button type="submit" class="btn btn-primary" onclick='$("#editRestaurant").submit();'>Submit</button>
                        <a href="/" class="btn btn-danger">Cancel</a>
                    </div>
                </form>
            </div>
        </div>

        <script>
            function addCard() {
                $("#addCard").replaceWith($("#hiddenaddcard").html());
            };
            function editCard(restaurantId) {
                $('#card-'+restaurantId).replaceWith($("#hiddeneditcard").html());
                $.get( "/get", { id: restaurantId } )
                    .done(function( data ) {
                        alert( "Data Loaded: " + data );
                });
            };
        </script>
    </jsp:attribute>

    <jsp:attribute name="rightsidenav">
        <a href="/add" class="btn btn-success">Add</a>
    </jsp:attribute>

</t:genericpage>




</html>