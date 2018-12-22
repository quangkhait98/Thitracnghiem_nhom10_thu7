<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<div class="row">
	<div class="col-sm-3"></div>
	<div class="col-sm-6">
		<div class="body-function">
			<div class="socaudung">
				<h4 class="socaudung-title">Số câu đúng: ${soCauDung}/${soCau}</h4>
			</div>

			<div class="diem">
				<h4 class="diem-title">Điểm: ${diem}/10</h4>
			</div>
			<div class="thoigiannop">
				<h4 class="thoigiannop-title">
					Thời gian bắt đầu: ${starttime}</h4>
			</div>
			<div class="thoigianlambai">
				<h4 class="thoigianlambai-title">Thời gian nộp bài: ${time} </h4>
			</div>

			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-4" style="text-align: center">				
					<a href="showmark" target="_blank" id="mofile">	<button type="button" id="export" class="btn btn-primary">Xuất kết quả</button></a>
				</div>
				<div class="col-sm-4" style="text-align: center">
					<a href="student" class="btn btn-primary">Quay về</a>
				</div>
				<div class="col-sm-2"></div>
			</div>
		</div>
		<div class="col-sm-3"></div>
	</div>
</div>