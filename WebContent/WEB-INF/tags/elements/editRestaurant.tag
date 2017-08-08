<%@ tag description="Edit Restaurant Form" pageEncoding="UTF-8"%>

<!-- CSS -->
<link href="../../../resources/css/restaurantForm.css" rel="stylesheet">

<div class="container" id="restaurant-form">
    <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h1 class="panel-title">Restaurant</h1>
                </div>
                <div class="panel-body">
                    <form class="form" role="form" id="form" method="post" action="/restaurant/edit" accept-charset="UTF-8">
                        <input type="hidden" name="id"/>
                    <%-- Name --%>
                        <div class="form-group">
                            <input type="text" name="name" id="name" class="form-control input-sm" placeholder="Name" required pattern="^[a-zA-Z\s]{2,}$"
                                   oninput="nameCheck()">
                        </div>
                        <%-- Price --%>
                        <div class="form-group">
                            <input type="number" name="price" id="price" class="form-control input-sm" placeholder="Restaurant price" step="0.01" required
                                   oninput="priceCheck()">
                        </div>
                        <%-- ALELO --%>
                        <div class="form-check">
                            <label class="form-check-label">
                                <input type="checkbox" name="alelo" class="form-check-input">
                                Accepts ALELO
                            </label>
                        </div>
                        <%-- Location --%>
                        <div class="form-group">
                            <input type="text" name="location" id="location" class="form-control input-sm" placeholder="Location" required pattern="^[a-zA-Z\s]{2,}$">
                        </div>
                        <%-- Description --%>
                        <div class="form-group">
                            <label for="restaurantDescription">Resutaurant description</label>
                            <textarea class="form-control" name="description" id="restaurantDescription" rows="3"></textarea>
                        </div>
                        <%-- Image --%>
                        <div class="form-group">
                            <input type="url" name="image" id="image" class="form-control input-sm" placeholder="Image" required>
                        </div>
                        <%-- Submit --%>
                        <input type="submit" id="submit-button" value="Submit" class="btn btn-info btn-block" disabled>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="../../../resources/js/restaurantForm.js"></script>