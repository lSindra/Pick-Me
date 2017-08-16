var restaurantList;

function initOrRefreshCards() {
    var card_row = $("#card-row");
    $.ajax({
        url: "/restaurant/list",
        success: function (result) {
            card_row.html("");
            card_row.append(result);
            sortRestaurantList();
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


function getRestaurantList() {
    $.ajax({
        url: "/restaurant/list-sorted-restaurants",
        success: function (result) {
            restaurantList = result;
        }
    });
}

function sortRestaurantList() {
    getRestaurantList();
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



// var qs = $('input#id_search_list').quicksearch('ul#list_example li');
//
// $.ajax({
//     'url': 'example.json',
//     'type': 'GET',
//     'dataType': 'json',
//     'success': function (data) {
//         for (let i in data['list_items']) {
//             $('ul#list_example').append('<li>' + data['list_items'][i] + '</li>');
//         }
//         qs.cache();
//     }
// });