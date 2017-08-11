function displayRestaurants() {
    
}

function getAndDisplayRestaurantVotes(restaurant) {
    $.ajax({
        url : "/restaurant/restaurant-count",
        type: "POST",
        data: restaurant,
        success : function(votes) {
            document.getElementById("voteCount-"+restaurant.id).innerHTML = votes;
        }
    });
}

function sortRestaurantList() {
    $.ajax({
        url: "/restaurant/list",
        success: function (response) {
            for (var i in response) {
                getAndDisplayRestaurantVotes(response[i])
            }
        }
    });
}

window.onload = sortRestaurantList();

