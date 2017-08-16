

function search() {
    var searchText = $("#id_search_list").val();
    $.ajax({
        url: "/restaurant/search",
        type: "POST",
        data: {searchText: searchText},
        success: function (result) {
        }
    });
}

