
function myFunction() {
	var x = document.getElementById("mySidebar");
	if (x.className === "sidebar") {
		x.className += " responsive";
	} else {
		x.className = "sidebar";
	}
	var y = document.getElementById("myContainer");
	if (y.className === "container-main") {
		y.className += " responsive";
	} else {
		y.className = "container-main";
	}
};

$(document).ready(function() {
	$("#menubtn").click(function() {
		myFunction();
	});
	$('.sidebar-feature').click(function() {
		$('.sidebar-feature').removeClass("sidebar-selected");
		$(this).addClass("sidebar-selected");
	});

	$('#toggle-img').click(function(event) {
		event.stopPropagation();
		$(".info").slideToggle("fast");
	});
	$(".user-name").click(function(event) {
		event.stopPropagation();
		$(".info").slideToggle("fast");
	});
	$(".info").on("click", function(event) {
		event.hide();
	});
});


