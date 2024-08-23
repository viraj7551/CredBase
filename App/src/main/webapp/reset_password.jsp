<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CredBase Application | Reset Password</title>
<link rel="stylesheet" href="./css/styles.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Grey+Qo&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
	rel="stylesheet">
</head>
<body>
	<% 
    if(session.getAttribute("emailId") == null){
    	response.sendRedirect("verify_email.jsp");
    }
 %>

	<div class="container">
		<div class="brand-loggo">
			<h3 class="brand-name grey-qo-regular">CredBase</h3>
		</div>
		<div class="login-form-container">
			<form name="f1" autocomplete="off" action="/App/ResetPassword" method="post"
				onSubmit="return validate4();">
				<div class="input-field">
					<input type="password" placeholder="Enter New Password*"
						name="newpassword" required />
				</div>
				<div class="input-field">
					<span class="alert-label" id="newpassword-alert-label"></span>
				</div>
				<div class="input-field">
					<input type="password" placeholder="Enter Existing Password*"
						name="existing_password" required />
				</div>
				<div class="input-field">
					<span class="alert-label" id="existing_password-alert-label"></span>
				</div>
				<div class="input-field">
					<input type="password" placeholder="Retype Existing Password*"
						name="confirm_existing_password" required />
				</div>
				<div class="input-field">
					<span class="alert-label" id="confirm_existing_password-alert-label"></span>
				</div>
				<div class="loginsubmit">
					<input class="formsubmit" id="signinSubmit" type="submit"
						value="Reset Password" />
				</div>
				<div class="additional-section">
					<a href="verify_email.jsp"> Back</a>
				</div>
			</form>
		</div>
	</div>
	<script src="./js/index.js"></script>
</body>
</html>