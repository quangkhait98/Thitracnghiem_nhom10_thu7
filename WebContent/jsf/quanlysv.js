$(document).ready(function(){
$('#addsv').click(function() {
	$.ajax({
		url:"themsinhvien", 
		type:"POST",
		async: false,
		data: {
			masv:$('#masv').val(),
			tensv:$('#tensv').val(),
			matkhau:$('#password').val(),
		},
		success: function(content, status) {
			if(content != null)
				{
					$("#modalreport_result").html(content);
					/*$('#myModal').modal('dispose');*/
				}
			$('#std_table > tbody').empty();
			$.ajax({
				url:"quanlysinhvien",
				data:{
				},
				async:false,
				type:"POST",
				success: function(content, status) {
					$('#std_table > tbody').html(content);
				}
			});
		}
	}); 
}); 
}); 

$(document).on('click', '.table-remove', function() {
	var studentid = $(this).closest('tr').children('td:nth-child(2)').text();
	var isDelete = window.confirm("Bạn thực sự muốn xóa sinh viên ?");
	if(isDelete) {
		$('#std_table > tbody').empty();
		$.ajax({
			url:"deletetkstd", 
			type:"POST",
			async: false,
			data: {
				ID: studentid
			},
			success: function(content, status) {
				$("#report_result").html(content);
				$.ajax({
					url:"quanlysinhvien",
					data:{
					},
					async:false,
					type:"POST",
					success: function(content, status) {
						$('#std_table > tbody').html(content);
					}
				});
			}
		});
	}
});