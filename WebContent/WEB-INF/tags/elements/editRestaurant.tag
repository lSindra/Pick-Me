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
                    <form class="form" role="form" id="form" method="POST" action="/restaurant/edit" accept-charset="UTF-8">
                        <input type="hidden" name="id" id="idEdit"/>
                    <%-- Name --%>
                        <div class="form-group">
                            <input type="text" name="name" id="nameEdit" class="form-control input-sm" placeholder="Name" required pattern="^[a-zA-Z\s]{2,}$">
                        </div>
                        <%-- Price --%>
                        <div class="form-group">
                            <input type="number" name="price" id="priceEdit" class="form-control input-sm" placeholder="Restaurant price" step="0.01" required>
                        </div>
                        <%-- ALELO --%>
                        <div class="form-check">
                            <label class="form-check-label">
                                <input type="checkbox" name="aleloAccepted" id="aleloAcceptedEdit" class="form-check-input" onclick="setAleloBox()">
                                Accepts ALELO
                            </label>
                        </div>
                        <%-- Location --%>
                        <div class="form-group">
                            <input type="text" name="location" id="locationEdit" class="form-control input-sm" placeholder="Location" required pattern="^[a-zA-Z\s]{2,}$">
                        </div>
                        <%-- Description --%>
                        <div class="form-group">
                            <label for="descriptionEdit">Resutaurant description</label>
                            <textarea class="form-control" name="description" id="descriptionEdit" rows="3"></textarea>
                        </div>
                        <%-- Image --%>
                        <div class="form-group">
                            <input type="url" name="image" id="imageEdit" class="form-control input-sm" placeholder="Image" required>
                        </div>
                        <%-- Submit --%>
                        <input type="submit" id="submit-button" value="Submit" class="btn btn-info btn-block">

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="../../../resources/js/restaurantForm.js"></script>
