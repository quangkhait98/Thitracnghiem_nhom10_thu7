$(document).ready(
		function() {
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
			
			
			$('#chonlop').change(function() {
				var chonlop =  $(this).val();
				$.ajax({
					url: "loadbode",
					type: "GET",
					data: {
						classID: chonlop,
					},
					async:false,
					success: function(content,status) {
						var select = $('#chonbd');
				        select.find('option').remove();
						$('select#chonbd').html(content);
						$('#bode_table > tbody').empty();
						$.ajax({
						url: "loadbode",
						type: "POST",
						data: {
							classID: chonlop,
						},
						async:false,
						success: function(content,status) {
							$('#bode_table > tbody').html(content);
						}
					});
					}
				}); 
			}); 
});

$(document).ready(function() {
	$('#addbdclass').on('click', function() {
		var isDelete = window.confirm("Bạn thực sự muốn thêm bộ đề này vào lớp này ?");
		if(isDelete){
			$.ajax({
				url: "addbodevaolop",
				type: 'POST',
				async:false,
				data: {
					classID: $('#chonlop').val(),
					bodeID: $('#chonbd').val(),
					solannop:$('#solanlambai').val(),
					tgbd:$('#tgbd').val(),
					tgkt:$('#tgkt').val(),
					giolambai:$('#giolambai').val(),
					phutlambai:$('#phutlambai').val(),
				},
				success: function(content,status) {
					$("#report_result").html(content);
					$.ajax({
						url: "loadbode",
						type: "POST",
						data: {
							classID: $('#chonlop').val(),
						},
						async:false,
						success: function(content,status) {
							$('#bode_table > tbody').html(content);
							$.ajax({
								url: "loadbode",
								type: "GET",
								data: {
									classID: $('#chonlop').val(),
								},
								async:false,
								success: function(content,status) {
									var select = $('#chonbd');
							        select.find('option').remove();
									$('select#chonbd').html(content);
								}
							});	
						}
					});
				}
			});
		}
		});
});

$(document).on('click', '.table-remove', function() {
	var bodeID = $(this).closest('tr').children('td:nth-child(2)').text();
	var isDelete = window.confirm("Bạn thực sự muốn xóa bộ đề này khỏi lớp này ?");
	if(isDelete) {
		$('#bode_table > tbody').empty();
		$.ajax({
			url:"deletebodelop", 
			type:"POST",
			async: false,
			data: {
				bodeid: bodeID,
				classid : $('#chonlop').val(),
			},
			success: function(content, status) {
				$("#report_result").html(content);
				$.ajax({
					url: "loadbode",
					type: "POST",
					data: {
						classID: $('#chonlop').val(),
					},
					async:false,
					success: function(content,status) {
						$('#bode_table > tbody').html(content);
						$.ajax({
							url: "loadbode",
							type: "GET",
							data: {
								classID: $('#chonlop').val(),
							},
							async:false,
							success: function(content,status) {
								var select = $('#chonbd');
						        select.find('option').remove();
								$('select#chonbd').html(content);
							}
						});	
					}
				});
			}
		});
	}
});
