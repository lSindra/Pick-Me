

function getRestaurantVotes(restaurant) {
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
                getRestaurantVotes(response[i])
            }
        }
    });
}

