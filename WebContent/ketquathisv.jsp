<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head lang = "vi">
	<title>Thi trắc nghiệm</title>
	<meta charset = "UTF-8" />
	<!-- Bootstrap -->
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<!-- Latest compiled JavaScript -->	
	<link rel="stylesheet" type="text/css" href="css/mainframe.css">
	<link rel="stylesheet" href="fontawesome/fontawesome-free-5.3.1-web/css/all.min.css">
	<link rel="stylesheet" href="css/classmanage.css">
	<script src="js/jquery.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.bundle.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

	<script src="js/mainframe.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"> </script>
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
				 <div id="report_result">
				<c:import url="Success.jsp" />
				<c:import url="Errors.jsp" />
			</div> 
				<div class="card">
				  	<div class="card-body">
					    <div id="table" class="table-editable">
							<span class="table-add float-right mb-3 mr-2">
						    </span>
					        <table id="class_table" class="table table-bordered table-responsive-md table-striped text-center">
					         <thead>
						        <tr>
						          <th class="text-center">STT</th>
						          <th class="text-center">Tên lớp</th>
						          <th class="text-center">tên bộ đề</th>
						          <th class="text-center">Điểm</th>
						          <th class="text-center">Thời gian nộp</th>
						        </tr>
							</thead>
							<tbody>
							 <% int i=1; %>
								<c:forEach var="item" items="${kqthi}">
						        <tr>
						       	  <td><%= (i++) %></td>
						          <td class="pt-1-half" contenteditable="false">${item.tenlop}</td>
						          <td class="pt-2-half" contenteditable="false">${item.tenbode}</td>
						          <td class="pt-2-half" contenteditable="false">${item.diem}</td>
						          <td class="pt-2-half" contenteditable="false">${item.thoigiannopbai}</td>
						        </tr>
						        </c:forEach>
							</tbody>
					      </table>
					    </div>
					</div>
				</div>
				<!-- Editable table -->
			</div>
			<!-- end container -->
		</div>
	
  </div>
</body>

</html>