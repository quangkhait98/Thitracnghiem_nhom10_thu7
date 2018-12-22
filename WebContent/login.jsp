<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="../fontawesome/fontawesome-free-5.3.1-web/css/all.min.css">
	<script src="js/jquery.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.bundle.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="css/login.css">
    <title>Login</title>
</head>
<body>
<%
String err="";
if(request.getAttribute("err")!=null)
{
    err=(String) request.getAttribute("err"); 
}
%>
	<div class="container-main">
		<div class="header">
			<div class="center-header">
				<div class="logo">
					<img src="images/logo1.png"> 
				</div>
				<div class="cover-app-title">
					<div class="app-name">
						<h2>LUYỆN THI TRẮC NGHIỆM</h2>
					</div>
					<div class="app-title">
						<h1>HKT-L</h1>
					</div>
				</div>	
				<div class="contact">
					<div class="email">
						<span class="gmail">
							<a href="gmail.com"><img src="images/icongmail.png"></a>
						</span>
						<span class="facebook">
							<a href="facebook.com"><img src="images/fb.png"></a>
						</span>
					</div>
					<div class="phone">
						<h4>19008198</h4>
					</div>
				</div>
			</div>		
		</div>
		
		<div class="login-form-main">
			<div class="form">
				<h2>Đăng nhập</h2>
			   <form class="register-form">
			      <input type="text" placeholder="name"/>
			      <input type="password" placeholder="password"/>
			      <input type="text" placeholder="email address"/>
			      <button>Tạo</button>
			      <p class="message">Already registered? <a href="#">Đăng kí</a></p>
			   </form>

			   <!-- <div class="choose-role">
			   		Group of default radios - option 1
					<div class="custom-control custom-radio">
					  <input type="radio" class="custom-control-input" id="defaultGroupExample1" name="groupOfDefaultRadios">
					  <label class="custom-control-label" for="defaultGroupExample1">Giảng viên</label>
					</div>

					Group of default radios - option 2
					<div class="custom-control custom-radio">
					  <input type="radio" class="custom-control-input" id="defaultGroupExample2" name="groupOfDefaultRadios" checked>
					  <label class="custom-control-label" for="defaultGroupExample2">Sinh viên</label>
					</div>
			   </div> -->
	
			   <form class="login-form" action="dangnhapservlet" method="POST">
			   	<p style="color:red"><%=err  %></p>
			      <input type="text" name="taikhoan" placeholder="Tài khoản"/>
			      <input type="password" name="password" placeholder="Mật khẩu"/>
			      <button >Đăng nhập</button>
			      <!-- <p class="sign-up message">Chưa có tài khoản? <a href="#">Tạo tài khoản</a></p>
			      <p class="forget-pass  message">Quên mật khẩu?<a href="#">Lấy lại mật khẩu</a></p> -->
			   </form>
			</div>
		</div>
	</div>
</body>
</html>