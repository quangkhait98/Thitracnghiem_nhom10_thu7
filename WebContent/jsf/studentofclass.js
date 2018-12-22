$(document).ready(function() {
	$('#chonlop').change(function() {
		var chonlop =  $(this).val();
		$.ajax({
			url: "Loadstudent",
			type: "GET",
			data: {
				classID: chonlop,
			},
			async:false,
			success: function(content,status) {
				var select = $('#chonsv');
		        select.find('option').remove();
				$('select#chonsv').html(content);
				$('#testing_table > tbody').empty();
				$.ajax({
				url: "studentofclass",
				type: "POST",
				data: {
					classID: chonlop,
				},
				async:false,
				success: function(content,status) {
					$('#testing_table > tbody').html(content);
				}
			});
			}
		}); 
	}); 
});

$(document).on('click', '.table-remove', function() {
	var studentID = $(this).closest('tr').children('td:nth-child(2)').text();
	var isDelete = window.confirm("Bạn thực sự muốn xóa sinh viên này ?");
	if(isDelete) {
		$('#testing_table > tbody').empty();
		$.ajax({
			url:"deletestudentofclass", 
			type:"POST",
			async: false,
			data: {
				ID: studentID,
				classid : $('#chonlop').val(),
			},
			success: function(content, status) {
				$("#report_result").html(content);
				$.ajax({
					url: "studentofclass",
					type: "POST",
					data: {
						classID: $('#chonlop').val(),
					},
					async:false,
					success: function(content,status) {
						$('#testing_table > tbody').html(content);
						$.ajax({
							url: "Loadstudent",
							type: "GET",
							data: {
								classID: $('#chonlop').val(),
							},
							async:false,
							success: function(content,status) {
								var select = $('#chonsv');
						        select.find('option').remove();
								$('select#chonsv').html(content);
							}
						});	
					}
				});
			}
		});
	}
});

$(document).ready(function() {
	$('#addst').on('click', function() {
		var isDelete = window.confirm("Bạn thực sự muốn thêm sinh viên này ?");
		if(isDelete){
			$.ajax({
				url: "addstudentclass",
				type: 'POST',
				async:false,
				data: {
					classID: $('#chonlop').val(),
					stdID: $('#chonsv').val(),
				},
				success: function(content,status) {
					$("#report_result").html(content);
					$.ajax({
						url: "studentofclass",
						type: "POST",
						data: {
							classID: $('#chonlop').val(),
						},
						async:false,
						success: function(content,status) {
							$('#testing_table > tbody').html(content);
							$.ajax({
								url: "Loadstudent",
								type: "GET",
								data: {
									classID: $('#chonlop').val(),
								},
								async:false,
								success: function(content,status) {
									var select = $('#chonsv');
							        select.find('option').remove();
									$('select#chonsv').html(content);
								}
							});	
						}
					});
				}
			});
		}
		});
});