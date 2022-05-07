$(".title").on("click", function() {
    console.log("CLICKED!");
    $(".extra-info").slideToggle(500);
});
$(".add-button").on("click", function() {
    console.log("CLICKED ADD BTN!");
    window.location="post.jsp";
});