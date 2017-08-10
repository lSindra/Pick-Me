

function sortRestaurantList() {
    $.ajax({
        url : "/restaurant/list",
        success : function(response) {
            for (var i in response) {
                if (response.hasOwnProperty(i)) {
                    getRestaurantVotes(response[i]);
                }
            }
        }
    });
}


// document.getElementById("myspan").textContent="newtext";


function getRestaurantVotes(restaurant) {
    $.ajax({
        url : "/restaurant/restaurant-count",
        type: "POST",
        data: restaurant,
        success : function(response) {
            alert("Votes "+response);
        }
    });
}