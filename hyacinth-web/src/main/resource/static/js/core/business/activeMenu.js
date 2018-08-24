// TODO: sometimes good, sometimes bad...
$(document).ready(function () {
    var lis = $(".navbar-left>li");
    for (var i = 0; lis.length - i != 0; i++) {
        if (lis[i].children[0].pathname == window.location.pathname) {
            lis[i].className = "active";
        }
    }
});