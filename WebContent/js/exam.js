$(document).ready(function() {
	$('#nopbaibtn').click(function() {
		var dapAn = [], i = 0;
		$('label.questionLabel').each(function() {
			var name = $(this).attr('for');
			dapAn[i] = $('input[name=' + name + ']:checked').val();
			if (typeof dapAn[i] === "undefined") {
				dapAn[i] = 0;
			}
			if(getCookie(name)){
				document.cookie = name + "=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
			}
			document.cookie = "duration=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
			i++;
		})
		$.ajax({
			url : "SubmitBaiThi",
			type : "POST",
			async : false,
			data : {
				dapAn : dapAn,
				soluong : i
			},
			success : function(data) {
				$('#myContainer').html(data);
			}
		})
	});
	
	$(document).on("click", "#export", function () {
		$.ajax({
			url : "exportpdf",
			type : "GET",
			async : false,
			data : {
				
			},
			success : function(data) {
			}
		})		
	});
	
});


$(document).ready(function() {

	var currentTab = 0;
	showTab(currentTab);
	function showTab(n) {
		var x = document.getElementsByClassName("hidden");
		x[n].style.display = "block";
		if (n == 0) {
			document.getElementById("prev").style.display = "none";
		} else {
			document.getElementById("prev").style.display = "inline";
		}
		if (n == (x.length - 1)) {
			document.getElementById("next").style.display = "none";
		} else {
			document.getElementById("next").style.display = "inline";
		}
	}
	function nextPrev(n) {
		var x = document.getElementsByClassName("hidden");
		x[currentTab].style.display = "none";
		currentTab = currentTab + n;
		showTab(currentTab);
	}
	$('li.question-num').each(function(){
		$(this).click(function(){
			var x = document.getElementsByClassName("hidden");
			x[currentTab].style.display = "none";
				var n = $(this).attr('id').substring(15, 17);
				currentTab = n;
				showTab(n);
			});
	});
	$('#prev').click(function() {
		nextPrev(-1);
	})
	$('#next').click(function() {
		nextPrev(1);
	})
});
