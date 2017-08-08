    // JavaScript form validation

    var id = document.getElementById("id");

    var name = document.getElementById("name");
    name.setCustomValidity(name.title);

    var price = document.getElementById("price");
    price.setCustomValidity(price.title);

    var alelo = document.getElementById("alelo");

    var location = document.getElementById("location");

    var description = document.getElementById("description");

    var submitButton = document.getElementById("submit-button");

    var localRestaurant;

    var supports__validity = function()
    {
        var i = document.createElement("");
        return "setCustomValidity" in i;
    };

    function getRestaurant(id) {

        alert(id);

    }

    if(supports__validity()) {

        function checkForm() {
            if (name.classList.contains("green-color") &&
                price.classList.contains("green-color")) {
                submitButton.disabled = false;
            } else {
                submitButton.disabled = true;

            }
        }

        function nameCheck() {
            if (!name.validity.patternMismatch && name.value !== "") {
                name.classList.remove("red-color");
                name.classList.add("green-color");
            } else {
                name.classList.remove("green-color");
                name.classList.add("red-color");
            }
            checkForm();
        }


        function priceCheck() {
            if (!price.validity.patternMismatch && price.value !== "") {
                price.classList.remove("red-color");
                price.classList.add("green-color");
            } else {
                price.classList.remove("green-color");
                price.classList.add("red-color");
            }
            checkForm();
        }
        
    }