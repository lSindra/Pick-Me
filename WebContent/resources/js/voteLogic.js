


function vote(restaurant_id) {
    $.post({
        url: "/vote/vote",
        data: {restaurant_id: restaurant_id},
        success : function() {
            sortRestaurantList();
        }
    });
}