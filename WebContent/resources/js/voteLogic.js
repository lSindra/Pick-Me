


function vote(Restaurant_id) {
    $.post({
        url: "/vote/vote",
        Restaurant_ID: Restaurant_id
    },
    function (data, status) {
        alert("Data: " + data + "\nStatus: " + status);
    });
}