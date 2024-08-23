<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import = "java.sql.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CredBase Application | Get Credentials</title>
<link rel="stylesheet" href="./css/styles.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Grey+Qo&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
	rel="stylesheet">
<script type="text/javascript" src="./js/index.js"></script>
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
					<li><a href="add_credentials.jsp">Add Credential</a></li>
					<li><a class="active" href="#">Credentials List</a></li>
				</ul>
			</div>
			<div class="table-container">
                   <table>
                         <thead>
                            <tr>
                               <td class="tbl-header">site name</td>
                               <td class="tbl-header">username</td>
                               <td class="tbl-header">credential 1</td>
                               <td class="tbl-header">credential 2</td>
                               <td class="tbl-header">remove credential</td> 
                           </tr>
                        </thead>
                   <tbody>
        <%
               String driver = "com.mysql.cj.jdbc.Driver";
               String url = "jdbc:mysql://localhost:3306/credbase";
               String uname = "root";
               String password = "root"; 
               try{
            	  Class.forName(driver);
            	  Connection con = DriverManager.getConnection(url,uname,password);
            	  PreparedStatement ps = con.prepareStatement("select * from credential");
            	  ResultSet rs = ps.executeQuery();
            	  while(rs.next()){
                  String userId = rs.getString("userId");
                  if(userId.equals(session.getAttribute("username"))){
       %>
       
                  <tr class="resultset">
                      <td><%= rs.getString("sitename") %></td>
                      <td><%= rs.getString("username") %></td>
                      <td><%= rs.getString("credential1") %></td>
                      <td><%= rs.getString("credential2") %></td> 
                      <td><a href="/App/DeleteRecord?<%=rs.getString("sitename")%>"><i class="material-icons">delete</i></a></td>
                  <tr>
            		  
       <%      	  
       
                  }
                }
               }
               catch(Exception e){
            	   e.printStackTrace();
               }
   %>
   
                   </tbody>
               </table>
			</div>
		</div>
	</section>
	<script src="./js/index.js"></script>
</body>
</html>