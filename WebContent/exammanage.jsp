<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head lang="vi">
<title>Thi trắc nghiệm</title>
<meta charset="UTF-8" />
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Latest compiled JavaScript -->
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/mainframe.css">
<link rel="stylesheet" type="text/css" href="css/exam-manage.css">
<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet"
	href="fontawesome/fontawesome-free-5.3.1-web/css/all.min.css">
<script src="js/jquery.min.js"></script>
<script src="js/exammanage.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/mainframe.js"></script>
<script src="js/moment.min.js" type="text/javascript"></script>
<script src="js/bootstrap-datetimepicker.min.js"></script>
</head>
<body>
<%
String err="";
if(request.getAttribute("err")!=null)
{
    err=(String) request.getAttribute("err"); 
}
%>
	<div class="canvas">
		<t:header>
		</t:header>
		<div class="body">
			<a href="javascript:void(0);" class="icon" id="menubtn"> <i
				class="fa fa-bars"></i>
			</a>
			<div class="sidebar" id="mySidebar">
				<div class="sidebar-header">
					<p>MENU</p>
				</div>
				<div class="sidebar-menu">
					<ul>
						<li class="sidebar-feature"><a href="QuanLyBoDe"> <i
								class="fas fa-file-signature"></i> <span>Ra đề</span>
						</a></li>
						<li class="sidebar-feature"><a href="ganbode_lop"> <i
								class="fas fa-file-signature"></i> <span>Gắn bộ đề</span>
						</a></li>
					</ul>
				</div>
			</div>
			<div class="container-main" id="myContainer">
				<div class="manager-form">
				<p style="color:red"><%=err  %></p>
					<form id="formquanlybode">
						<div class="form-group">
						<div class="form-item">
								<label class="item-title">Tên bộ đề:  </label> 
									<input type="text" class="form-control" name="tenbode" required/>
							</div>
							<div class="form-item">
								<label class="item-title">Ngày mở đề: </label>
								<div class="input-group date from-control" id="ngaymode">
									<input type="text" class="form-control" name="ngaymode" required/> <span
										class="input-group-addon"> <span class="fa fa-calendar"></span>
									</span>
								</div>
							</div>
							<div class="form-item">
								<label class="item-title">Ngày đóng đề: </label>
								<div class="input-group date from-control" id="ngaydongde">
									<input type="text" class="form-control" name="ngaydongde" required/> <span
										class="input-group-addon"> <span class="fa fa-calendar"></span>
									</span>
								</div>
							</div>
							<div class="form-item">
								<label class="item-title">Thời gian làm bài: </label> <select
									class="form-control" name="giolambai">
									<c:forEach begin="0" end="10" varStatus="loop">
										<option value="${loop.index }">${loop.index}</option>
										<br />
									</c:forEach>
								</select> <label>Tiếng </label> <select class="form-control"
									name="phutlambai">
									<c:forEach begin="0" end="59" varStatus="loop">
										<option value="${loop.index }">${loop.index}</option>
										<br />
									</c:forEach>
								</select> <label>Phút </label>
							</div>
							<div class="form-item">
								<label class="item-title">Chọn lớp giao đề: </label> <select
									class="form-control" id="class" name="lopgiaode">
									<c:forEach items="${lop}" var="item">
										<option value="${item.malop}">${item.tenlop}</option>
									</c:forEach>
								</select>
								<!--<button type="button" onclick="addClasses()" class="btn btn-primary">Thêm lớp</button>-->
							</div>
							<!--<div class="form-item">
								<ul class="list-group" id="list-classes">

								</ul>
							</div>  -->
							<div class="form-item">
								<label class="item-title">Chọn môn: </label> <select
									class="form-control" id="subject" name="mon">
									<c:forEach items="${mon}" var="item">
										<option value="${item.mamon}">${item.tenmon}</option>
									</c:forEach>
								</select>
							</div>
							
							<div class="form-item">
								<label class="item-title">Tổng số câu hỏi: </label> <select
									class="form-control" id="type-of-questions"
									style="margin-right: 6px;" name="dokho">
									<option>Dễ</option>
									<option>Trung Bình</option>
									<option>Khó</option>
								</select> <label style="margin-right: 10px;">Số lượng: </label> <select
									class="form-control" name="soluong" id="questions-num">
									<c:forEach begin="1" end="20" varStatus="loop">
										<option value="${loop.index }">${loop.index}</option>
										<br />
									</c:forEach>
								</select>
								<button type="button" class="btn btn-primary"
									id="addQuestionBtn">Thêm</button>
							</div>
							<div class="form-item">
								<ul class="list-group" id="list-questions">

								</ul>
							</div>							
							<div class="form-item">
								<label class="item-title">Số lần làm bài: </label> <select
									class="form-control" name="solanlambai">
									<c:forEach begin="1" end="5" varStatus="loop">
										<option value="${loop.index }">${loop.index}</option>
										<br />
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="review-btn">
							<button type="submit" class="btn btn-primary" id="previewButton">Xem
								trước</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>