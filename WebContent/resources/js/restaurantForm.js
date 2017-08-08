    // JavaScript form validation

    function getFieldsFromRestaurantBeingEdited() {
        var id = $("#idEdit");
        var name = $("#nameEdit");
        var price = $("#priceEdit");
        var aleloAccepted = $("#aleloAcceptedEdit");
        var location = $("#locationEdit");
        var description = $("#descriptionEdit");
        var image = $("#imageEdit");
        var submitButton = $("#submit-button");
        return {
            "id": id,
            "name": name,
            "price": price,
            "aleloAccepted": aleloAccepted,
            "location": location,
            "description": description,
            "submitButton": submitButton,
            "image": image
        }
    }

    function getRestaurant(id) {
        $.ajax({
            url : '/restaurant/get',
            data: { id: id},
            dataType: 'json',
            success : function(response) {
                var oElements = getFieldsFromRestaurantBeingEdited();
                for (var key in response) {
                    if (oElements.hasOwnProperty(key)) {
                        oElements[key].val(response[key]);
                    }
                }
                if(oElements.aleloAccepted.val() === "true") {
                    oElements.aleloAccepted.prop("checked", true);
                } else oElements.aleloAccepted.prop("checked", false);
            }
        });
    }

    function setAleloBox() {
        var aleloAccepted = $("#aleloAcceptedEdit");
        if (aleloAccepted.prop("checked") === true) {
            aleloAccepted.val(true);
        } else aleloAccepted.val(false);
    }