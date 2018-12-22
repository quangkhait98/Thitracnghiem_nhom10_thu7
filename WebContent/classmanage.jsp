<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="vi">
<title>Thi trắc nghiệm</title>
<meta charset="UTF-8" />
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Latest compiled JavaScript -->
<link rel="stylesheet" type="text/css" href="css/mainframe.css">
<link rel="stylesheet"
	href="fontawesome/fontawesome-free-5.3.1-web/css/all.min.css">
<link rel="stylesheet" href="css/classmanage.css">
<script src="js/jquery.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<script src="js/mainframe.js"></script>
<!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js">
	
</script>
<script src="jsf/classmanage.js"></script>
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
						<li class="sidebar-feature"><a href="quanlysinhvien"> <i
								class="fas fa-user-graduate"></i> <span>Quản lý thí sinh</span>
						</a></li>
						<li class="sidebar-feature"><a href="classmanage"> <i
								class="fas fa-users"></i> <span>Quản lý lớp học</span>
						</a></li>
						<li class="sidebar-feature"><a href="studentofclass"> <i
								class="fas fa-users"></i> <span>Thêm sinh viên vào lớp</span>
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
							<span class="table-add float-right mb-3 mr-2"> <a href="#"
								class="text-success">

									<button type="button" class="btn btn-primary"
										data-toggle="modal" data-target="#myModal">
										<i class="fa fa-plus fa-2x" aria-hidden="true"></i>
									</button>

							</a>
							</span>
							<table id="class_table"
								class="table table-bordered table-responsive-md table-striped text-center">
								<thead>
									<tr>
										<th class="text-center">STT</th>
										<th class="text-center">Mã lớp</th>
										<th class="text-center">Tên lớp</th>
										<th class="text-center">Số lượng sinh viên</th>
										<th class="text-center">Chức năng</th>
									</tr>
								</thead>
								<tbody>
									<%
										int i = 1;
									%>
									<c:forEach var="item" items="${getclass}">
										<tr>
											<td><%=(i++)%></td>
											<td class="pt-1-half" contenteditable="false">${item.malop}</td>
											<td class="pt-2-half" contenteditable="false">${item.tenlop}</td>
											<td class="pt-2-half" contenteditable="false">${item.soluong}</td>
											<td><span class="table-remove"><button
														type="button"
														class="btn btn-danger btn-rounded btn-sm my-0"><i class="fas fa-trash-alt"></i></button></span>

											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<!-- end idtable -->
					</div>
				</div>
			</div>
			<!-- Editable table -->
		</div>
		<!-- end container -->
	</div>
	<div class="modal" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Thêm lớp học</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div id="modalreport_result">
					<c:import url="Success.jsp" />
					<c:import url="Errors.jsp" />
				</div>
				<form role="form" name="modalForm">
					<!-- Modal body -->
					<div class="modal-body">

						<div class="form-group">
							<label for="">Mã Lớp</label> <input type="text"
								class="form-control" name="malop" id="malop" /> <label for="">Tên
								lớp</label> <input type="text" class="form-control" name="tenlop"
								id="tenlop" />
						</div>
					</div>
					<!-- Modal footer -->
					<div class="modal-footer">
						<button id="close" type="button" class="btn btn-danger"
							data-dismiss="modal">Close</button>
						<button type="button" id="addclass" class="btn btn-danger">save</button>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>

</html>