
function getAndDisplayRestaurantVotes(restaurant) {
    $.ajax({
        url : "/restaurant/restaurant-count",
        type: "POST",
        data: restaurant,
        success : function(votes) {
            document.getElementById("voteCount-"+restaurant.id).innerHTML = votes;
            document.getElementById("post-content-"+restaurant.id).style.backgroundColor = "#fcfcfc";
            highlightVotedRestaurant();
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

function highlightVotedRestaurant() {
    $.post({
        url: "/vote/voted-restaurant",
        success: function (response) {
            document.getElementById("post-content-"+response.id).style.backgroundColor = "#4dbcff";
        }
    });
}


window.onload = sortRestaurantList(); highlightVotedRestaurant();

