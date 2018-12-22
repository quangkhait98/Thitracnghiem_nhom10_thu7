$(document).ready(function(){
	$(document).on('click', '#lop', function(){
		var n = Date.now();
		var end =Date.parse( $(this).find("input[type=hidden][id$='tgkt']").val());
		var start =Date.parse($(this).find("input[type=hidden][id$='tgbd']").val());
		if(n>=end||n<=start)
		{
			alert("Bài thi "+ $(this).find("input[type=hidden][id$='tenbode']").val()+" của lớp "+$(this).find("input[type=hidden][id$='tenLop']").val()+" không trong thời gian làm bài");
		}
		else
		{
			var lop ="";
			lop = lop + 'Lớp : ' + $(this).find("input[type=hidden][id$='tenLop']").val();
			$('.lop').empty();
			$('.lop').text(lop);
			
			var tenbaithi ="";
			tenbaithi = tenbaithi + 'Tên bài thi : ' + $(this).find("input[type=hidden][id$='tenbode']").val();
			$('.tenbaithi').empty();
			$('.tenbaithi').text(tenbaithi);
			
			var thoigianbatdau ="";
			thoigianbatdau = thoigianbatdau + 'Thời gian bắt đầu : ' + $(this).find("input[type=hidden][id$='tgbd']").val();
			$('.thoigianbatdau').empty();
			$('.thoigianbatdau').text(thoigianbatdau);
			
			var thoigianketthuc ="";
			thoigianketthuc = thoigianketthuc + 'Thời gian kết thúc : ' + $(this).find("input[type=hidden][id$='tgkt']").val();
			$('.thoigianketthuc').empty();
			$('.thoigianketthuc').text(thoigianketthuc);
			
			var thoigianlambai ="";
			thoigianlambai = thoigianlambai + 'Thời gian làm bài : ' + $(this).find("input[type=hidden][id$='tglb']").val();
			$('.thoigianlambai').empty();
			$('.thoigianlambai').text(thoigianlambai);
			
			var solanlambaiconlai ="";
			var num1 = $(this).find("input[type=hidden][id$='sllbtd']").val(), num2 = $(this).find("input[type=hidden][id$='sllb']").val();
			solanlambaiconlai = solanlambaiconlai + 'Số lần làm bài còn lại : ' + (num1-num2);
			$('.solanlambaiconlai').empty();
			$('.solanlambaiconlai').text(solanlambaiconlai);
			$('#mabd').val($(this).find("input[type=hidden][id$='mabode']").val());
			if(num1 - num2 == 0)
				$('#thi').addClass("hidden");
			$('#exampleModal').modal('show');
		}
		});
	
});

