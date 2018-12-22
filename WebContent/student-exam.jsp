<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head lang = "vi">
	<title>Thi trắc nghiệm</title>
	<meta charset = "UTF-8" />
	<!-- Bootstrap -->
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<!-- Latest compiled JavaScript -->
	<script src="js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/mainframe.css">
	<link rel="stylesheet" type="text/css" href="css/form-style.css">

	<link rel="stylesheet" href="fontawesome/fontawesome-free-5.3.1-web/css/all.min.css">
		<script src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/mainframe.js"></script>
	<link rel="stylesheet" href="fullcalendar/fullcalendar.css" />
   <!--  <script src="fullcalendar/lib/jquery.min.js"></script> -->
  <script src="fullcalendar/lib/moment.min.js"></script>
  <script src="fullcalendar/fullcalendar.js"></script>
	<script src="jsf/calendarjs.js"></script>
	<script src="jsf/homepage.js"></script>
	<script src='fullcalendar/locale/vi.js'></script>
	<script src="js/bootstrap.min.js"></script>

	 <style type="text/css">
	 #calendar {
 width: 94%;
 display: block;
 margin-left: auto;
 margin-right: auto;
}
.fc-toolbar .fc-left {
    float: left;
    margin: auto;
    margin-left: 27%;
    }
.fc-toolbar .fc-right {
    float: left;
    margin-left: 30%;
}
.centered {
 text-align: center;
 }
 .modal-header {
    margin: auto;
    background-color: deepskyblue;
    width: 100%;
 }
 .modal-title{
 margin-left: 39%;
 }
 .modal-body {
 text-align: center;
 }
	 </style>
</head>
<body>		
	<div class="canvas">
	<div class="popup-remove"></div>
	<t:header>
	</t:header>
		<div class="body">
			<div class="sidebar">
				<div class="sidebar-header">
					<p>MENU</p>
				</div>
				<div class="sidebar-menu">
					<ul>
						<li class="sidebar-feature">
							<a href="homepagestd">
								<i class="fas fa-book-open"></i>
								<span>Xem các bài kiểm tra</span>
							</a>
						</li>
						<li class="sidebar-feature">
							<a href="hienketquathisv">
								<i class="fas fa-star-half-alt"></i>
								<span>Xem điểm kiểm tra</span>
							</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="container-main">
				<div id="accordion" class="exam-list">
				 <div class="col-sm-7" style="float:left;margin-left: 5%;margin-top: 5%;">
					<c:forEach items="${lophoc}"  var="item" >
					<div class="card">
						<div class="card-header" style="background-color: antiquewhite;">
							<a class="card-link" data-toggle="collapse" href="#${item.malop}" >
								<i class="fas fa-graduation-cap"></i><span style="padding-left: 10px;">${item.tenlop}</span>
							</a>
						</div>
						
						<div id="${item.malop}" class="collapse">
							<div class="list-group list-group-flush exams">
								<c:forEach  items="${dethi}"  var="itema">
								<c:if test="${item.malop==itema.malop }">
								<a  href="#" class="list-group-item list-group-item-action" id="lop"><i class="fas fa-book-open"></i><span style="padding-left: 10px;">${itema.tenbode} </span>	
								<input type="hidden" id="maLop" value="${itema.malop}" />
								<input type="hidden" id="tenLop" value="${itema.tenlop}" />
								<input type="hidden" id="mabode" value="${itema.mabode}" />
								<input type="hidden" id="tenbode" value="${itema.tenbode}" />				
								<input type="hidden" id="tgbd" value="${itema.thoigianbatdau}" />
								<input type="hidden" id="tgkt" value="${itema.thoigianketthuc}" />
								<input type="hidden" id="tglb" value="${itema.thoigianlambai}" />
								<input type="hidden" id="sllbtd" value="${itema.solanlambaitoida}" />
								<input type="hidden" id="sllb" value="${itema.solanlambai}" />
								</a>
								</c:if>
								</c:forEach>
							</div>
						</div>
						
					</div>
					</c:forEach>
							
					</div>
					<div class="col-sm-4" style="float: right;margin-right: 0%; margin-top: 5%;">
					<div style="border: 1px solid #e3e3e3;border-radius: 10px;">
						<div  id="calendar"></div>
					</div>
			
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Bài kiểm tra</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <form action="XuLyBaiThi" method="POST">
      <div class="modal-body">
	      <h5 class="lop">Lớp : </h5>
		  <hr>
		  <h5 class="tenbaithi">Tên bài thi : </h5>
		  <hr>
		  <h5 class="thoigianbatdau">Thời gian bắt đầu : </h5>
		  <hr>
		  <h5 class="thoigianketthuc">Thời gian kêt thúc : </h5>
		  <hr>
		  <h5 class="thoigianlambai">Thời gian làm bài : </h5>
		  <hr>
		  <h5 class="solanlambaiconlai">Số lần làm bài còn lại : </h5>
		  <input type="hidden" id="mabd" name="mabd">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal" >Hủy</button>
        <input type="submit" class="btn btn-primary" id="thi" value="Thi">
      </div>
      </form>
    </div>
  </div>
</div>
</html>

