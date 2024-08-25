<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CredBase Application | Add Credential</title>
<link rel="stylesheet" href="./css/styles.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Grey+Qo&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
	rel="stylesheet">
</head>
<body>
	<%
   if(session.getAttribute("username") == null){
	   response.sendRedirect("login.jsp");
   }
 %>

	<nav class="navbar">
		<div class="brand-loggo">
			<h3 class="brand-name grey-qo-regular">
				<a href="generate_password.jsp">CredBase</a>
			</h3>
		</div>

		<div class="menu-items">
			<ul>
				<li><a id="myaccount" class="menu-disable" href="javascript:submenu();"> <img
						class="profile-icon" src="./images/profile_icon.png"
						alt="profile picture">
						<h3><%= session.getAttribute("username")%></h3>
				</a></li>
			</ul>
		</div>
		<div id="submenu_list_option" class="nav-sub-list">
			<ul>
				<li><a href="login.jsp">LogOut</a></li>
			</ul>
		</div>
	</nav>
	<section>
		<div class="container">
			<div class="section-tab-list">
				<ul>
					<li><a href="generate_password.jsp">Generate Password</a></li>
					<li><a class="active" href="#">Add Credential</a></li>
					<li><a href="get_credentials.jsp">Credentials List</a></li>
				</ul>
			</div>
			<div class="section-filter-container">
				<div class="add_credentials_container">
					<form class="f1" autocomplete="off" action="/App/AddCredential"
						method="post" onSubmit="return validate3();">
						<div class="inputfield">
							<input style="width:60%" type="text" placeholder="site name * " name="sitename">
							<input style="width:60%" type="text" placeholder="username * " name="username" />
						</div>
						<div class="inputfield">
							<input style="width:100%" type="password" placeholder="credential value 1 * "
								name="credval1" /> 
						</div>
						<div class="formSubmit">
							<input type="submit" value="ADD CREDENTIAL">
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
	<script src="./js/index.js"></script>
</body>
</html>