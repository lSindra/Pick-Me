var restaurantList;

function initOrRefreshCards() {
    var card_row = $("#card-row");
    var searchText = $("#id_search_list").val();
    $.ajax({
        url: "/restaurant/list",
        data: {searchText: searchText},
        success: function (result) {
            card_row.html("");
            card_row.append(result);
            sortRestaurantList();
        }
    });
}

function search() {
    var searchText = $("#id_search_list").val();
    $.ajax({
        url: "/restaurant/search",
        data: {searchText: searchText},
        success: function (result) {
            restaurantList = result;
        }
    });
}


function getAndDisplayRestaurantVotes(restaurant) {
    $.ajax({
        url : "/restaurant/restaurant-count",
        type: "POST",
        data: restaurant,
        success : function(votes) {
            document.getElementById("voteCount-"+restaurant.id).innerHTML = votes;
            document.getElementById("post-content-"+restaurant.id).style.backgroundColor = "#fcfcfc";
        }
    });
}


function sortRestaurantList() {
    search();
    for (var i in restaurantList) {
        getAndDisplayRestaurantVotes(restaurantList[i])
    }
    highlightVotedRestaurant();
}

function highlightVotedRestaurant() {
    $.ajax({
        url: "/vote/voted-restaurant",
        success: function (response) {
            document.getElementById("post-content-"+response.id).style.backgroundColor = "#4dbcff";
        }
    });
}


initOrRefreshCards();
highlightVotedRestaurant();