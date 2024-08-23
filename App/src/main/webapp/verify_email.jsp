<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CredBase | Verify Email</title>
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
			<form name="f1" autocomplete="off" action="/App/VerifyEmail" method="post"
				onSubmit="return validate3();">
				<div class="input-field">
					<input type="text" placeholder="Enter email*" name="email"
						required />
				</div>
				<div class="input-field">
					<span class="alert-label" id="email-alert"></span>
				</div>
				<div class="loginsubmit">
					<input class="formsubmit" id="signinSubmit" type="submit"
						value="Verify Email" />
				</div>
				<div class="additional-section">
					<a href="login.jsp"> Back</a></a>
				</div>
			</form>
		</div>
	</div>
	<script src="./js/index.js"></script>
</body>
</html>