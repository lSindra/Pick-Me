$(function(){
    $('.post-module').hover(function() {
        $(this).find('.description').stop().animate({
            height: "toggle",
            opacity: "toggle"
        }, 300);
    });

    $('.post-module').click(function() {
        debugger;
        var id = $(this).find('#restaurantId').val();
        vote(id);
    });

    $('[data-toggle="popover"]')
        .on('click',function(){
            event.stopPropagation();
        })
        .popover({
        delay: 20,
        container: 'body',
        animation: true,
        html: true
    });

});