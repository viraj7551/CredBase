<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CredBase Application | Generate Password</title>
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
				<a href="#">CredBase</a>
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
				<li><a href="login.jsp">Log Out</a></li>
			</ul>
		</div>
	</nav>	
	<section>
		<div class="container">
			<div class="section-tab-list">
				<ul>
					<li><a class="active" href="#">Generate Password</a></li>
					<li><a href="add_credentials.jsp">Add Credential</a></li>
					<li><a href="get_credentials.jsp">Credentials List</a></li>
				</ul>
			</div>
			<div class="section-filter-container">
				<div class="left-section">
					<div class="filtered-value">
						<span id="value"></span> <span id="value-alert">Neutral</span> <span><img
							id="refresh" src="./images/refresh.png" alt="tt"
							onclick="reset()"></span>
					</div>
					<div class="image-section">
						<img id="filtered-value-emoji" src="./images/sleepy.png"
							alt="test">
					</div>
				</div>
				<div class="credentials-length">
					<label class="filter-form-label">Password Length: </label> <span
						id="lengthVal"></span> <br>
					<br> <select id="filter_dropdown_list">
						<option value="6">6</option>
						<option value="9">9</option>
						<option value="12">12</option>
					</select>
				</div>
				<div class="check-options">
					<label class="filter-form-label">Select Character: </label><br>
					<br> <span><input type="checkbox" id="check-value1" />AA</span>
					<span><input type="checkbox" id="check-value2" />aa</span> <span><input
						type="checkbox" id="check-value3" />123</span> <span><input
						type="checkbox" id="check-value4" />#$&</span>
				</div>
				<div class="btn-section">
					<input type="submit" class="btn" id="generate_Password_Submit"
						value="Generate Password" onclick="generateVal();"><br>
					<input type="submit" class="btn" id="copy_Password"
						value="Copy Password" onclick="copyClipboard();"><br>
				</div>
			</div>
		</div>
	</section>
	<script type="text/javascript" src="./js/index.js"></script>
</body>
</html>