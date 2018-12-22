$(document).ready(function(){      
$('#searchBut').click(function() {
		pageOffset = 0;
		pageLength=8;
		isLimit=false;
		$('#question_table > tbody').empty();
		$.ajax({
			url:"questionmanage",
			data:{
				chonmon:$('#chonmon').val(),
				search:$('#search').val(),
				chonloai:$('#chonloai').val(),
				offset:0,
				length:pageLength
			},
			async:false,
			type:"POST",
			success: function(content, status) {	
				var pageIndex = pageOffset / pageLength + 1;
				$('#question_table_cap').text("Trang "+pageIndex);
				$('#question_table > tbody').html(content);	
			}
		});
	});
 });
$(document).ready(function(){  
	$('#backBut').click(function() {
		$('#question_table > tbody').empty();
		if(pageOffset >= pageLength) {
			pageOffset -= pageLength;
		}
		$.ajax({
			url:"questionmanage",
			data:{
				chonmon:$('#chonmon').val(),
				search:$('#search').val(),
				chonloai:$('#chonloai').val(),
				offset:pageOffset,
				length:pageLength
			},
			async:false,
			type:"POST",
			success: function(content, status) {
				var pageIndex = pageOffset / pageLength + 1;
				$('#question_table_cap').text("Trang "+pageIndex);
				$('#question_table > tbody').html(content);		
				if(content.trim() == '') {
					pageOffset = 0;
				} else {
					isLimit = false;
				}
			}
		});
	});
});	

$(document).ready(function(){  
	$('#forwardBut').click(function() {
		$('#question_table > tbody').empty();
		if(!isLimit) {
			pageOffset += pageLength;
		}
		$.ajax({
			url:"questionmanage",
			data:{
				chonmon:$('#chonmon').val(),
				search:$('#search').val(),
				chonloai:$('#chonloai').val(),
				offset:pageOffset,
				length:pageLength
			},
			async:false,
			type:"POST",
			success: function(content, status) {
				var pageIndex = pageOffset / pageLength + 1;
				$('#question_table_cap').text("Trang "+pageIndex);
				$('#question_table > tbody').html(content);
				if(content.trim() == '') {
					isLimit = true;
				} else {
					isLimit = false;
				}
			}
		});
	});
});	
$(document).on('click', '.table-remove', function() {
	var questionID = $(this).closest('tr').children('td:nth-child(2)').text();
	var isDelete = window.confirm("Bạn thực sự muốn xóa câu hỏi "+questionID+" ?");
	if(isDelete) {
		$('#question_table > tbody').empty();
		$.ajax({
			url:"deletequestion", 
			type:"POST",
			async: false,
			data: {
				ID: questionID
			},
			success: function(content, status) {
				$("#report_result").html(content);
				$.ajax({
					url:'questionmanage',
					data:{
						chonmon:$('#chonmon').val(),
						search:$('#search').val(),
						chonloai:$('#chonloai').val(),
						offset:pageOffset,
						length:pageLength
					},
					async:false,
					type:"POST",
					success: function(content, status) {
						$('#question_table > tbody').html(content);
						if(content.trim() == '') {
							isLimit = true;
						} else {
							isLimit = false;
						}
					}
				});
			}
		});
	}
});

$(document).ready(function(){
	$(document).on('click', '.table-edit', function(){
		 var columnHeadings = $("thead th").map(function() {
             return $(this).text();
          }).get();
		 columnHeadings.splice(0, 9);
		 columnHeadings.splice(0,0,"noidung","dapan1","dapan2","dapan3","dapan4","dapandung")	
	       var columnValues = $(this).parent().siblings().map(function() {
	                 return $(this).text();
	       }).get();
	       columnValues.shift();
	       var id= columnValues.shift();
	       var labels=["Nội dung","Đáp án 1","Đáp án 2","Đáp án 3","Đáp án 4","Đáp án đúng"];
	       var modalBody = $('<div id="modalContent"></div>');
	       var modalForm = $('<form role="form" name="modalForm" action="editquestion" method="post"></form>');
	      /*$.each(columnHeadings, function(i, columnHeader) {
	           var formGroup = $('<div class="form-group"></div>');
	           formGroup.append('<label for="'+columnHeader+'">'+columnHeader+'</label>');
	           formGroup.append('<input class="form-control" name="'+columnHeader+'" id="'+columnHeader+'" value="'+columnValues[i]+'" />'); 
	           modalForm.append(formGroup);
	      });*/
	       for(var i=0 ; i<6 ; i++)
	       {
	    	   var formGroup = $('<div class="form-group"></div>');
	           formGroup.append('<label for="'+labels[i]+'">'+labels[i]+'</label>');
	           formGroup.append('<input class="form-control" name="'+columnHeadings[i]+'" id="'+columnHeadings[i]+'" value="'+columnValues[i]+'" />'); 
	           modalForm.append(formGroup);
	       }
	       modalForm.append('<input type="hidden" name="idq" id="idq" value="'+id+'"/>')
	       modalBody.append(modalForm);
	       
	       $('.modal-body').html(modalBody);
	     });
});
$(document).ready(function(){
$('.modal-footer #register-btn').click(function() {
	$.ajax({
		url:"editquestion", 
		type:"POST",
		async: false,
		data: {
			idq:$('#idq').val(),
			noidung:$('#noidung').val(),
			dapan1:$('#dapan1').val(),
			dapan2:$('#dapan2').val(),
			dapan3:$('#dapan3').val(),
			dapan4:$('#dapan4').val(),
			dapandung:$('#dapandung').val()
		},
		success: function(content, status) {
			$("#report_result").html(content);
			$.ajax({
				url:'questionmanage',
				data:{
					chonmon:$('#chonmon').val(),
					search:$('#search').val(),
					chonloai:$('#chonloai').val(),
					offset:pageOffset,
					length:pageLength
				},
				async:false,
				type:"POST",
				success: function(content, status) {
					$('#question_table > tbody').html(content);
					if(content.trim() == '') {
						isLimit = true;
					} else {
						isLimit = false;
					}
				}
			});
		}
	}); 
	$(this).next().click(); 
	});
});