<%@page import="model.monhoc"%>
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

	<link rel="stylesheet" href="fontawesome/fontawesome-free-5.3.1-web/css/all.min.css">
	
	<script src="js/jquery.min.js"></script>
	<script src="js/jquery321.js"></script>
	<link rel="stylesheet" type="text/css" href="css/questionmanage.css">
	<script src="js/mainframe.js"></script>
	<script src="jsf/viewquestion.js"></script>
	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"> </script>
</head>
<body>		
	<div class="canvas">
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
							<a href="questionmanage">
								<i class="fas fa-user-graduate"></i>
								<span>Quản lý câu hỏi</span>
							</a>
						</li>
						<li class="sidebar-feature">
							<a href="AddQuestion">
								<i class="fas fa-user-graduate"></i>
								<span>Thêm câu hỏi</span>
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
				<!-- Editable table -->
				<div class="row filter-search">
		  			<div class="col-sm-3">
						<label >Chọn môn</label><br>
								<select class="form-control" name="chonmon" id="chonmon" style="width: 90%" required>									
										<c:forEach items="${chonmon}" var="item">
											<option value="${item.mamon}">${item.tenmon}</option>
										</c:forEach>						
								</select>
					</div>
					<div class="col-sm-3">
						<label>Chọn loại </label><br>
								<select class="form-control" name="chonloai" id="chonloai" style="width: 90%" required>
									<option value="kho">Khó</option>
									<option value="trungbinh">Trung Bình</option>
									<option value="de">Dễ</option>
								</select>
					</div>
					<div class="col-sm-3">
						<label>Nhập câu hỏi: </label><br>
						<input type="text" name="search" id="search" style="height: 39px;width: 350px;"
						class="form-control">
					</div>
					<div class="col-sm-3">
						<button type="button" id="searchBut" class="btn btn-primary btn-md" style="width: 130px;margin-left: 38%;margin-top: 13%"><i class="fas fa-search"></i></button>
					</div>
		  		</div>
				<div class="card">
				  	<div class="card-body">
					    <div id="table" class="table-editable" style="overflow: inherit">
							<span class="table-add float-right mb-3 mr-2">
						    	<a href="#!" class="text-success">
						    		
						        </a>
						    </span>
							
					        <table  id="question_table" class="table table-bordered table-responsive-md table-striped text-center">
					        <%--  <caption  id="question_table_cap" >Trang 1</caption>  --%>
					       
					        <thead>
						        <tr>
						          <th class="text-center">STT</th>
						          <th class="text-center">Mã câu hỏi</th>
						          <th class="text-center">Nội dung</th>
						          <th class="text-center">Đáp án 1</th>
						          <th class="text-center">Đáp án 2</th>
						          <th class="text-center">Đáp án 3</th>
						          <th class="text-center">Đáp án 4</th>
						          <th class="text-center">Đáp án đúng</th>						       
						          <th class="text-center">Chức năng</th>
						        </tr>
						        </thead>
								<tbody>	
								<%
										int i = 1;
									%>
									<c:forEach items="${danhsach}" var="item">
										<tr>
											<td><%=(i++)%></td>
											<td>${item.macauhoi}</td>
											<td>${item.noidung}</td>
											<td>${item.dapan1}</td>
											<td>${item.dapan2}</td>
											<td>${item.dapan3}</td>
											<td>${item.dapan4}</td>
											<td>${item.dapandung}</td>
											<td>
				<span class="table-edit" ><button type="button" id="myBtn" data-toggle="modal" data-target="#myModal" class="btn btn-primary btn-rounded btn-sm my-0" id="table-edit"><i class="fas fa-edit"></i></button></span>
				<span class="table-remove"><button type="button" class="btn btn-danger btn-rounded btn-sm my-0"><i class="fas fa-trash-alt"></i></button></span>
			</td>
										</tr>
									</c:forEach>						
								</tbody>
					      </table>
					      <div class="col-sm-3" style="margin-left: 39%;">
				<button type="button" id="backBut" class="btn btn-primary btn-md" style="width: 33%;margin-right: 11px;float: left;">previous</button>		
				<div id="question_table_cap" style="float: left;margin-top: 5px;">Trang 1</div>
				<button type="button" id="forwardBut" class="btn btn-primary btn-md"style="width: 33%;margin-left: 12px;">next</button>
				 
				</div>
					    </div>
					    
				  	</div>
				</div>
				
				 <!-- Modal -->
           
			<!-- end container -->
		</div>
	</div>
</div>
</body>
 <div id="myModal" class="modal fade" role="dialog">
                <div class="modal-dialog">
 
                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title"></h4>
                        </div>
                        <div class="modal-body">
                            <form>
                           <c:forEach items="${editch}" var="item">
         						 <div class="form-group">
           								 <label for="recipient-name" class="col-form-label">Nội dung</label>
            								<textarea class="form-control" id="editnd" >${item.noidung}</textarea>
         						 </div>
         						 <div class="form-group">
           							 <label for="message-text" class="col-form-label">Đáp án 1</label>
           							 <input type="text" class="form-control" id="editda1" value="${item.dapan1}">
          						</div>
          						 <div class="form-group">
           							 <label for="message-text" class="col-form-label">Đáp án 2</label>
           							 <input type="text" class="form-control" id="editda2" value="${item.dapan2}">
          						</div>
          						 <div class="form-group">
           							 <label for="message-text" class="col-form-label">Đáp án 3</label>
           							 <input type="text" class="form-control" id="editda3" value="${item.dapan3}">
          						</div>
          						 <div class="form-group">
           							 <label for="message-text" class="col-form-label">Đáp án 4</label>
           							 <input type="text" class="form-control" id="editda4" value="${item.dapan4}">
          						</div>
          						 <div class="form-group">
          						 <label for="message-text" class="col-form-label">Đáp án đúng</label>
								<select class="form-control" name="" id="editdad"  required>
									<option value="1">A</option>
									<option value="2">B</option>
									<option value="3">C</option>
									<option value="4">D</option>
								</select>
								</div>
							</c:forEach>	
       				 		</form>
                </div>
                  <div class="modal-footer">
                            <button type="button" class="btn btn-default" id="register-btn">Save</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
            </div>
				</div>
			</div>
			
</html>