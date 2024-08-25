<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CredBase Application | Sign in</title>
<link rel="stylesheet" href="./css/styles.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Grey+Qo&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
	rel="stylesheet">
</head>
<body>
	<%
    session.invalidate(); 
%>
	<div class="container">
		<div class="brand-loggo">
			<h3 class="brand-name grey-qo-regular">CredBase</h3>
		</div>
		<div class="login-form-container">
			<form name="f1" action="/App/Login" autocomplete="off"
				method="post" onSubmit="return validate1();">
				<div class="input-field">
					<input type="text" placeholder="Enter username*" name="username"
						required />
				</div>
				<div class="input-field">
					<span class="alert-label" id="username-alert-label">Invalid
						username</span>
				</div>
				<div class="input-field">
					<input id="mypassword" type="password" placeholder="Enter password*" name="password"
						required />	
				</div>
				<div class="input-field">
					<span class="alert-label" id="password-alert-label">Invalid
						password</span>
				</div>
				<div class="showPasswordCheck">
				      <div class="check">
				         <input type="checkbox" onclick="showPassword();">Show Password
				      </div>
				</div>
				<div class="loginsubmit">
					<input class="formsubmit" id="signinSubmit" type="submit"
						value="Login" />
				</div>
				<div class="additional-section">
					<a href="register.jsp">Don't have account ? Sign-Up</a>
				</div>
				<div class="additional-section">
					<a href="verify_email.jsp">Reset Password</a>
				</div>
			</form>
		</div>
	</div>
</body>
<script src="./js/index.js"></script>
</html>