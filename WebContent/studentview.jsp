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
<link rel="stylesheet" type="text/css" href="css/form-style.css">

<link rel="stylesheet"
	href="fontawesome/fontawesome-free-5.3.1-web/css/all.min.css">
<script src="js/jquery.min.js"></script>
<script src="js/exam.js"></script>
<script type="text/javascript" src="js/timer.js"></script>

<script type="text/javascript" src="js/mainframe.js"></script>
</head>
<body>
	<div class="canvas">
		<t:header>
		</t:header>
		<div class="body">
			<a href="javascript:void(0);" class="icon" id="menubtn"> <i
				class="fa fa-bars"></i>
			</a>
			<div class="container-main" id="myContainer" style="width:100%;">
				<form id="form_online_test" class="online-test">
					<ol class="questions" id="student-questions-table">
						<c:forEach items="${questions}" var="i" varStatus="loop">
							<li class="question hidden" id="question${loop.index}"><label
								class="questionLabel" id="question_2_${loop.index}"
								for="question_${loop.index}">${loop.index + 1}.
									${i.noidung} </label>
								<div class="answerSet">
									<span> <input id="question_${loop.index}_1"
										name="question_${loop.index}" class="element radio"
										type="radio" value="1"> <label class="choice"
										id="question_3_${loop.index}" for="question_${loop.index}_1">${i.dapan1}</label>
									</span> <span> <input id="questioni_${loop.index}_2"
										name="question_${loop.index}" class="element radio"
										type="radio" value="2"> <label class="choice"
										id="question_4_${loop.index}" for="question_${loop.index}_2">${i.dapan2}</label>
									</span> <span> <input id="questioni_${loop.index}_3"
										name="question_${loop.index}" class="element radio"
										type="radio" value="3"> <label class="choice"
										id="question_5_${loop.index}" for="question_${loop.index}_3">${i.dapan3}</label>
									</span> <span> <input id="questioni_${loop.index}_4"
										name="question_${loop.index}" class="element radio"
										type="radio" value="4"> <label class="choice"
										id="question_6_${loop.index}" for="question_${loop.index}_4">${i.dapan4}</label>
									</span>
								</div></li>
						</c:forEach>
					</ol>
					<div class="submit">
						<button type="button" class="btn" id="nopbaibtn">Nộp bài</button>
					</div>
					<ul class="pagination justify-content-center">
						<li id="prev" class="page-item"><button type="button" class="page-link">Previous</button></li>
						<li id="next" class="page-item"><button type="button" class="page-link" >Next</button></li>
					</ul>
				</form>
				<div class="indexer" style="display: inline-grid;">
					<div id="clock">
						<c:out value="${clock}" />
					</div>
					<ul class="list-inline question-index">
						<c:forEach items="${questions}" var="i" varStatus="loop">
							<li class="question-num list-inline-item"
								id="index-question_${loop.index}"><a class="question-link" href="#question${loop.index}"
								>${loop.index + 1}</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>