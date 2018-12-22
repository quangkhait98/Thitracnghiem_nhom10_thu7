function setCookie(cname,cvalue,exdays) {
  var d = new Date();
  d.setTime(d.getTime() + (exdays*1000));
  var expires = "expires=" + d.toGMTString();
  document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}

function getCookie(cname) {
  var name = cname + "=";
  var decodedCookie = decodeURIComponent(document.cookie);
  var ca = decodedCookie.split(';');
  for(var i = 0; i < ca.length; i++) {
    var c = ca[i];
    while (c.charAt(0) == ' ') {
      c = c.substring(1);
    }
    if (c.indexOf(name) == 0) {
      return c.substring(name.length, c.length);
    }
  }
  return "";
}

function startTimer(duration, display) {
	var hours, minutes, seconds;
   
     if(!getCookie("duration")){
    var now = (new Date).getTime();
    setCookie("ftime", now , 9999999999999999);
    setCookie("duration", duration , 9999999999999999999999999);
    var timer = getCookie("duration") - 1;   
    }
    else {
    	var currentTime = (new Date).getTime();
     	var usedTime = (currentTime - getCookie("ftime")) / 1000;
   	var timer = getCookie("duration") - usedTime - 1;
    }
	setInterval(function() {
   
		hours = parseInt(timer / (60 * 60), 10)
		minutes = parseInt(timer % (60 * 60) / 60, 10)
		seconds = parseInt(timer % 60, 10);
		hours = hours < 10 ? "0" + hours : hours;
		minutes = minutes < 10 ? "0" + minutes : minutes;
		seconds = seconds < 10 ? "0" + seconds : seconds;

		display.textContent = hours + ":" + minutes + ":" + seconds;
		if (--timer < 0) {
			clearInterval(this);
			document.getElementById("clock").innerHTML = "Hết thời gian";
			$('#nopbaibtn').click();
		}
	}, 1000);
};
$(document).ready(function() {
	var time = document.getElementById("clock").innerHTML,
	h = time.split(':')[0],
	m = time.split(':')[1],
	duration = h*60*60 + m*60,
	display = document.querySelector('#clock');
	startTimer(duration, display);
	$('label.questionLabel').each(function() {
		var name = $(this).attr('for');	
		$('input[name=' + name + ']').change(function() {
			if (this.checked) {
				$('#index-' + name).children().css("color", "red");
				var value = $(this).val();
				setCookie(name,value,9999999999999999999999999999999999999);
			}
		});	
		if(getCookie(name)){
			vlue = getCookie(name);
			$('input[name=' + name + '][value=' + vlue + ']').attr("checked",true);
			$('#index-' + name).children().css("color", "red");
		}
	});	
	
});