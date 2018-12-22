function removeElement(elementId) {
	// Removes an element from the document
	var element = document.getElementById(elementId);
	element.parentNode.removeChild(element);
};

function addQuestions() {
	if (checkDuplicatedText("type-of-questions")) {
		var type = $("#type-of-questions option:selected").text();
		var vlue = $("#questions-num option:selected").text();
		var id = 0;
		var arr = {};
		$('[id].list-group-item').each(function() {
			arr[this.id.trim()] = 1;
		});
		$('[id].list-group-item').each(function() {
			if (arr["list-question-" + id]) {
				id++;
			}
		});
		var li = document.createElement("li");
		var input1 = document.createElement("input")
		$(input1).attr({
			"type" : "text",
			"value" : type,
			"readonly" : true,
			"name" : "dokho-" + id,
		})
		$(input1).addClass("difficulty");
		$(li)
				.addClass(
						"list-group-item d-flex justify-content-between align-items-center");
		$(li).attr("id", "list-question-" + id);
		var div = document.createElement("div");
		var num = document.createElement("span");
		$(num).addClass("badge badge-primary badge-pill");
		var input2 = document.createElement("input")
		$(input2).attr({
			"type" : "text",
			"value" : vlue,
			"readonly" : true,
			"name" : "soluong-" + id,
		})
		$(input2).addClass("amount");
		$(num).append(input2);
		var btn = document.createElement("span");
		$(btn).addClass("btn badge badge-primary badge-pill delete-btn");
		$(btn).attr("onclick", "removeElement(this.parentNode.parentNode.id)");
		var icon = document.createElement("i");
		$(icon).addClass("fas fa-times");
		$(btn).append(icon);
		$(div).append(num, " ", btn);
		$(li).append(input1, div);
		$("#list-questions").append(li);
	}
};

function addClasses() {
	if (checkDuplicatedText("class")) {
		var type = $("#class option:selected").text();
		var id = 0;
		var arr = {};
		$('[id].list-group-item').each(function() {
			arr[this.id.trim()] = 1;
		});
		$('[id].list-group-item').each(function() {
			if (arr["list-question-" + id]) {
				id++;
			}
		});
		var li = document.createElement("li");
		li.innerHTML = type;
		$(li)
				.addClass(
						"list-group-item d-flex justify-content-between align-items-center");
		$(li).attr("id", "list-class-" + id);
		var div = document.createElement("div");
		var editbtn = document.createElement("span");
		$(editbtn).addClass("btn badge badge-primary badge-pill");
		var deletebtn = document.createElement("span");
		$(deletebtn).addClass("btn badge badge-primary badge-pill");
		$(deletebtn).attr("onclick",
				"removeElement(this.parentNode.parentNode.id)");
		var icon1 = document.createElement("i");
		$(icon1).addClass("fas fa-times");
		var icon2 = document.createElement("i");
		$(icon2).addClass("far fa-edit");
		$(editbtn).append(icon2);
		$(deletebtn).append(icon1);
		$(div).append(editbtn, " ", deletebtn);
		$(li).append(div);
		$("#list-classes").append(li);
	}
};
function checkDuplicatedText(id) {
	var found = false
	$('li.list-group-item > input').each(function() {
		if ($(this).val().trim() == $("#" + id + " option:selected").text()) {
			found = true;
			return false;
		}
	});
	if (!found)
		return true;
};

$(document).ready(function() {
	$('#addQuestionBtn').click(function() {
		addQuestions();
	});
	$("select[name=cauhoi]").change(function() {
		var str, val1, val2, val3, val4;
		$("select option:selected").each(function() {
			str = $(this).val();
			val1 = str.split(':')[0];
			val2 = str.split(':')[1];
			val3 = str.split(':')[2];
			val4 = str.split(':')[3];
		});
		$("#myAnswerSet").html(
			'<label class="choice"> A. '+ val1
			+ '</label></br><label class="choice"> B. '
			+ val2
			+ '</label></br><label class="choice"> C. '
			+ val3
			+ '</label></br><label class="choice"> D. '
			+ val4
			+ '</label>');
			}).change();
});
$(document).ready(
		function() {
			$("#formquanlybode").attr({
				action : 'QuanLyBoDe',
				method : 'POST'
			});
			$("#form_online_test").attr({
				action : 'XuLyDeThi',
				method : 'POST'
			});
			$('#jkl').click(function(){
				$.ajax({
					url: "exammanager",
					type: 'POST'
				})
			});
			$('.edit').click(function(){
				var id = $(this).parent().parent().attr('id');
				var thutu = id.substring(8,9);
				$('#sss').click(function() {
					var cauhoi = $('select[name=cauhoi] option:selected').val().split(':')[4];					
					$.ajax({
						url: "XuLyDeThi",
						type: 'GET',
						data : {
							cauhoi: cauhoi,
							thutu: thutu,
						},
						success: function(data){
							$('#questions-table').html(data);
						}
					});
				});
			});
			
			$('#form_online_test').submit(function(event) {
				var form = this;
				event.preventDefault();
				setTimeout(function() {
					form.submit();
				}, 2000);
			});
			$('#ngaymode, #ngaydongde').datetimepicker({
				format : 'DD/MM/YYYY hh:mm:00 A',
				icons : {
					time : 'far fa-clock'
				},
				minDate : new Date($.now()),
				maxDate : '12/31/2022',
				useCurrent : false,
			});
			$('#ngaymode').datetimepicker().on(
					"dp.change",
					function() {
						var now = new Date(Date.now());
						$('#ngaydongde').data("DateTimePicker").minDate(
								$('#ngaymode').data("DateTimePicker").date());

						$('#ngaydongde').data("DateTimePicker").clear();
					});
		});
