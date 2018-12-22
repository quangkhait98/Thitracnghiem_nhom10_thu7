$(document).ready(function() {
  var myevents = [];	
  $.ajax({
	  cache: true,
	  url: "calendar",
	  dataType: "json",
	  type: "GET",
	  success: function(response) {	  
		  for(var i = 0 ; i < response.length;i++)
		  {
		  	myevents.push({
		  		  id:response[i].id,
                  start: response[i].start,
                  end: response[i].end,
                  allDay: false,
                  title: response[i].title,
                  tgian:response[i].tglambai,
                  solanlbconlai:response[i].solanlambaiconlai,
              });
		  }  
		$('#calendar').fullCalendar({
		header: {
			left: 'title',
			center: '',
			right: 'today,prev,next',
			  },
			  defaultView: 'month',
			  height: 700,
			  contentHeight: 450,
			  editable: true,
			  minTime: 0,
			  maxTime: 24,
			  timeFormat: 'H:mm',
			  eventLimit: true, 
			  events: myevents,
			  eventMouseover: function (data, event, view) {

		            tooltip = '<div class="tooltiptopicevent" style="width:auto;height:auto;background:#63B8FF;position:absolute;z-index:10001;padding:10px 10px 10px 10px ;  line-height: 200%;">' 
		            	+ 'Thông tin' + ': ' + data.title + '</br>'
		            + 'thời gian bắt đầu' + ': ' + $.fullCalendar.formatDate(data.start, 'YYYY/MM/DD HH:mm')+'</br>'
		            + 'thời gian kết thúc' + ': ' + $.fullCalendar.formatDate(data.end, 'YYYY/MM/DD HH:mm') + '</div>';


		            $("body").append(tooltip);
		            $(this).mouseover(function (e) {
		                $(this).css('z-index', 10000);
		                $('.tooltiptopicevent').fadeIn('500');
		                $('.tooltiptopicevent').fadeTo('10', 1.9);
		            }).mousemove(function (e) {
		                $('.tooltiptopicevent').css('top', e.pageY + 10);
		                $('.tooltiptopicevent').css('left', e.pageX - 250);
		            });


		        },
		        eventMouseout: function (data, event, view) {
		            $(this).css('z-index', 8);

		            $('.tooltiptopicevent').remove();

		        },
			  eventClick: function(calEvent, jsEvent, view) {
				  var n = Date.now();
				  var string = calEvent.title;
				  var leng = string.length;
				  var temp= string.search(":");
				  var tenlop="";
				  var tenbode="";
				  tenlop = tenlop + string.slice(0,temp-1);
				  tenbode=tenbode+ string.slice(temp+2,leng);
				  if(n>=calEvent.end||n<=calEvent.start)
				{
					  alert("Bài thi "+tenbode+" của lớp "+tenlop+" không trong thời gian làm bài");
				}
				  else
				{
					  var lop ="";
						lop = lop + 'Lớp : ' + tenlop;
						$('.lop').empty();
						$('.lop').text(lop);
						
						var tenbaithi ="";
						tenbaithi = tenbaithi + 'Tên bài thi : ' + tenbode;
						$('.tenbaithi').empty();
						$('.tenbaithi').text(tenbaithi);
						
						var thoigianbatdau ="";
						thoigianbatdau = thoigianbatdau + 'Thời gian bắt đầu : ' + $.fullCalendar.formatDate(calEvent.start, 'YYYY/MM/DD HH:mm');
						$('.thoigianbatdau').empty();
						$('.thoigianbatdau').text(thoigianbatdau);
						
						var thoigianketthuc ="";
						thoigianketthuc = thoigianketthuc + 'Thời gian kết thúc : ' + $.fullCalendar.formatDate(calEvent.end, 'YYYY/MM/DD HH:mm');
						$('.thoigianketthuc').empty();
						$('.thoigianketthuc').text(thoigianketthuc);
						
						var thoigianlambai ="";
						thoigianlambai = thoigianlambai + 'Thời gian làm bài : ' + calEvent.tgian;
						$('.thoigianlambai').empty();
						$('.thoigianlambai').text(thoigianlambai);
						
						var solanlambaiconlai="";
						solanlambaiconlai=solanlambaiconlai+ 'Số làn làm bài còn lại :'+ calEvent.solanlbconlai;
						$('.solanlambaiconlai').empty();
						$('.solanlambaiconlai').text(solanlambaiconlai);
						if(calEvent.solanlbconlai == 0)
							$('#thi').addClass("hidden");
						
						$('#mabd').val(calEvent.id);
						$('#exampleModal').modal('show');  
				}
				 
				  },
				  
		});
		
		
	  }
	});
});

