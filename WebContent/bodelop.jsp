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
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/mainframe.css">
<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet"
	href="fontawesome/fontawesome-free-5.3.1-web/css/all.min.css">
	<script src="js/exammanage.js" charset="UTF-8"></script>
<link rel="stylesheet" href="css/studentmanage.css">
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/studentmanage.js" type="text/javascript"></script>
<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/mainframe.js"></script>
<script src="js/moment.min.js" type="text/javascript"></script>
<script src="js/bootstrap-datetimepicker.min.js"></script>

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
						<li class="sidebar-feature"><a href="QuanLyBoDe"> <i
								class="fas fa-file-signature"></i> <span>Ra đề</span>
						</a></li>
						<li class="sidebar-feature"><a href="ganbode_lop"> <i
								class="fas fa-file-signature"></i> <span>Gắn bộ đề</span>
						</a></li>
					</ul>
				</div>
			</div>
			<div class="container-main">
				<div id="report_result">
					<c:import url="Success.jsp" />
					<c:import url="Errors.jsp" />
				</div>
				<div class="card">
					<div class="card-body">
						<div id="table" class="table-editable">
							<div class="row">
								<div class="col-50" style="margin-left: 30px;">
									<label>Chọn Lớp</label><br> <select class="form-control"
										name="chonlop" id="chonlop" style="width: 90%" required>
										<c:forEach items="${chonlop}" var="item">
											<option value="${item.malop}">${item.tenlop}</option>
										</c:forEach>
									</select>
								</div>
								<div class="col-50" style="padding: 0px 10px;">
									<label>Chọn bộ đề</label><br> <select
										class="form-control" name="chonbd" id="chonbd"
										style="width: 90%">
										<c:forEach items="${chonbd}" var="item">
											<option value="${item.maBode}">${item.tenBoDe}</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-item" style="padding: 0px 10px;">
								<label class="item-title">Số lần làm bài: </label> <select
									class="form-control" name="solanlambai" id="solanlambai">
										<option value="1">1</option>
										<option value="2">2</option>	
										<option value="3">3</option>	
										<option value="4">4</option>	
										<option value="5">5</option>															
								</select>
							</div>
								<div class="form-item" style="padding: 0px 10px;">
									<label class="item-title">Ngày mở đề: </label>
									<div class="input-group date from-control" id="ngaymode">
										<input type="text" class="form-control" name="ngaymode" id="tgbd"
											required /> <span class="input-group-addon" style="padding: 0px 5px;"> <span
											class="fa fa-calendar" style="font-size: 31px;"></span>
										</span>
									</div>
								</div>
								<div class="form-item">
									<label class="item-title">Ngày đóng đề: </label>
									<div class="input-group date from-control" id="ngaydongde">
										<input type="text" class="form-control" name="ngaydongde" id="tgkt"
											required /> <span class="input-group-addon" style="padding: 0px 5px;" > <span
											class="fa fa-calendar" style="font-size: 31px;"></span>
										</span>
									</div>
								</div>
							
								
							</div>
							<div class="row">
							<div class="col-sm-8" >
							<div class="form-item" style="padding: 10px;">
								<label class="item-title" style="float: left;padding: 6px 10px;">Thời gian làm bài: </label> <select
									class="form-control" name="giolambai" id="giolambai" style="width: 15%;float: left;">
									<c:forEach begin="0" end="10" varStatus="loop">
										<option value="${loop.index }">${loop.index}</option>
										<br />
									</c:forEach>
								</select> <label style="padding: 0px 10px;">Tiếng </label> <select class="form-control"
									name="phutlambai" id="phutlambai" style="display: inline;width: 14%;">
									<c:forEach begin="0" end="59" varStatus="loop">
										<option value="${loop.index }">${loop.index}</option>
										<br />
									</c:forEach>
								</select> <label>Phút </label>
							</div>
							
							</div>
							<div class="col-sm-2" >
							<span class="table-add float-right mb-3 mr-2" style="padding: 5px;">
								<button class="btn btn-primary" class="btn" id="addbdclass">
									<i class="fa fa-plus fa-2x" aria-hidden="true"></i>
								</button>
							</span>
							</div>
							</div>

							

							<table id="bode_table"
								class="table table-bordered table-responsive-md table-striped text-center">
								<thead>
									<tr>
										<th class="text-center">STT</th>
										<th class="text-center">Mã Bộ ĐỀ</th>
										<th class="text-center">Tên Bộ ĐỀ</th>
										<th class="text-center">Thời Gian Bắt Đầu</th>
										<th class="text-center">Thời Gian Kết Thúc</th>
										<th class="text-center">Thời Gian Làm Bài</th>
										<th class="text-center">Số Lần Nộp Tối Đa</th>
										<th class="text-center">Xóa Bộ Đề</th>
									</tr>
								</thead>
								<tbody>
									<%
										int i = 1;
									%>
									<c:forEach items="${listbd}" var="item">
										<tr>
											<td><%=(i++)%></td>
											<td>${item.maBode}</td>
											<td>${item.tenBoDe}</td>
											<td>${item.thoiGianBatDau}</td>
											<td>${item.thoiGianKetThuc}</td>
											<td>${item.thoiGianLamBai}</td>
											<td>${item.soLanNopToiDa}</td>
											<td><span class="table-remove"><button
														type="button"
														class="btn btn-danger btn-rounded btn-sm my-0">
														<i class="fas fa-trash-alt"></i>
													</button></span></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<!-- end idtable -->


					</div>
				</div>
				<!-- Editable table -->
			</div>
			<!-- end container -->
		</div>
	</div>
</body>
</html>