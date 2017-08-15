var restaurantList;

function initOrRefreshCards() {
    $.ajax({
        url: "/restaurant/list",
        success: function (result) {
            $("#card-row").html("");
            $("#card-row").append(result);
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
    $.post({
        url: "/vote/voted-restaurant",
        success: function (response) {
            document.getElementById("post-content-"+response.id).style.backgroundColor = "#4dbcff";
        }
    });
}
initOrRefreshCards();
getRestaurantList();
sortRestaurantList();



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