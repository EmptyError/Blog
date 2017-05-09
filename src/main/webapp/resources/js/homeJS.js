/**
 * Created by Admin on 29.04.2017.
 */
$(".button").mouseenter(function () {
    $(this).css({'background-color':'#ca3eb0','border':'solid 1px white','font-size':'large'})
});
$(".button").mouseleave(function () {
    $(this).css({'background-color':'#f589df','border':'none','font-size':'medium','border':'solid 1px #ca3eb0'})
});
$(".b").mouseenter(function () {
    $(this).css({'background-color':'#ca3eb0','border':'solid 1px white','font-size':'large'})
});
$(".b").mouseleave(function () {
    $(this).css({'background-color':'#f589df','border':'none','font-size':'medium','border':'solid 1px #ca3eb0'})
});
$(".d").mouseenter(function () {
    $(this).css({'background-color':'#ca3eb0','border':'solid 1px white','font-size':'large'})
});
$(".d").mouseleave(function () {
    $(this).css({'background-color':'#f589df','border':'none','font-size':'medium','border':'solid 1px #ca3eb0'})
});

$("#addArticle").click(function () {
$(".addArticle").slideToggle(200)
});

function getObject() {
    return {subject: $("#subject").val(), text: $("#text").val()};
}



$(".addCommentButton").click(function () {
    $(".addComment").show()
});
$("#viewArticles").click(function () {
   $(".viewArticles").fadeToggle(200);
});

$("#readArticle").click(function () {
    $(".viewArticles").hide();
    $("#read").slideDown(300)

});
$(".comments").mouseenter(function () {
    $(this).css({'background-color':'#800a7e','color':'white'})
});

$(".comments").mouseleave(function () {
    $(this).css({'background-color':'','color':'#800a7e'})
});