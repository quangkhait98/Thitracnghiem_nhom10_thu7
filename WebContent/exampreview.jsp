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
<link rel="stylesheet" type="text/css" href="css/mainframe.css">
<link rel="stylesheet" type="text/css" href="css/form-style.css">

<link rel="stylesheet"
	href="fontawesome/fontawesome-free-5.3.1-web/css/all.min.css">
<script src="js/popper.min.js"></script>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/timer.js"></script>
<script type="text/javascript" src="js/mainframe.js"></script>
<script src="js/exammanage.js" charset="UTF-8"></script>

</head>
<body>
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
				<form id="form_online_test" class="online-test">
					<ol class="questions" id="questions-table">
						<c:import url="questionlist.jsp" />
					</ol>
					<div class="submit">
						<button type="submit" class="btn btn-primary" id="def">Save</button>
						<a href="exammanager"><button type="button" class="btn" id="jkl">Cancel</button></a>
					</div>
				</form>
			</div>
			<div id="questionModal" class="modal fade" role="dialog">
				<div class="modal-dialog">

					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title">Danh sách câu hỏi</h4>
							<button type="button" class="close" data-dismiss="modal">&times;</button>
						</div>
						<div class="modal-body">
							<select class="form-control" name="cauhoi">
								<c:forEach items="${cauhoi}" var="item">
									<option
										value="${item.dapan1}:${item.dapan2}:${item.dapan3}:${item.dapan4}:${item.macauhoi}">${item.noidung}</option>
								</c:forEach>
							</select>
							<div class="answerSet" id="myAnswerSet"></div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" id="sss">Save</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>