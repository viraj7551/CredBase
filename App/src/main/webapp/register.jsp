<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CredBase Application | Sign up</title>
<link rel="stylesheet" href="./css/styles.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Grey+Qo&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="brand-loggo">
			<h3 class="brand-name grey-qo-regular">CredBase</h3>
		</div>
		<div class="login-form-container">
			<form name="f1" autocomplete="off" action="/App/Register" method="post"
				autocomplete="off" onSubmit="return validate2();">
				<div class="input-field">
					<input id="firstname" type="text" placeholder="Enter firstname*"
						name="firstname" required /> <input id="lastname" type="text"
						placeholder="Enter lastname*" name="lastname" required />
				</div>
				<div class="input-field">
					<span class="alert-label" id="name-alert-label">Invalid name</span>
				</div>

				<div class="input-field">
					<input type="text" placeholder="Enter username123*" name="username" required />
				</div>
				<div class="input-field">
					<span class="alert-label" id="username-alert-label"></span>
				</div>
				<div class="input-field">
					<input type="text" placeholder="Enter email@gmail.com*" name="email"
						required />
				</div>
				<div class="input-field">
					<span class="alert-label" id="email-alert-label"></span>
				</div>
				<div class="input-field">
					<input type="password" placeholder="Enter password*" name="password"
						required />
				</div>
				<div class="input-field">
					<span class="alert-label" id="password-alert-label"></span>
				</div>
				<div class="input-field">
					<input type="password" placeholder="Retype confirm password*"
						name="confirm_password" required />
				</div>
				<div class="input-field">
					<span class="alert-label" id="confirm-password-alert-label"></span>
				</div>
				<div class="loginsubmit">
					<input class="formsubmit" id="signinSubmit" type="submit"
						value="Register" />
				</div>
				<div class="additional-section">
					<a href="login.jsp"> Already have an account ? Click here to
						sign in</a></a>
				</div>
			</form>
		</div>
	</div>
	<script src="./js/index.js"></script>
</body>
</html>