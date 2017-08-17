$(function(){
    $('.post-module').hover(function() {
        $(this).find('.description').stop().animate({
            height: "toggle",
            opacity: "toggle"
        }, 300);
    });

    $('.post-module').click(function() {
        var id = $(this).find('#restaurantId').val();
        vote(id);
    });

    $('[data-toggle="popover"]').popover({
        delay: 100,
        container: 'body',
        animation: true,
        html: true
    });
});