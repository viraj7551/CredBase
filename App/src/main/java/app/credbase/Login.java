package app.credbase;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.util.regex.Pattern;
import java.io.*;

@WebServlet("/Login")
public class Login extends HttpServlet {

    private static final String username_pattern = "^[a-zA-Z0-9]+$";
    private static final String password_pattern = "^[a-zA-Z0-9@]+$";
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/credbase";
	private static String username = "root";
	private static String password = "<<Your Database Password >>";
    PreparedStatement ps = null;
    Connection con = null;
    PrintWriter pw = null;

    
	public void init() {

		try {
           Class.forName(driver);
           con = DriverManager.getConnection(url, username, password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		 pw = response.getWriter();
		
		 String username = request.getParameter("username");
		 String password = request.getParameter("password");
		 
		 //check for username and password field null value
		 if(username == null || password == null) {
			 if(username == null) {
				    pw.println("<script type=\"text/javascript\">"); 
					pw.println("alert('username field cannot be empty, Please enter value');"); 
					pw.println("location='login.jsp';"); 
					pw.println("</script>"); 
			 }else {
				    pw.println("<script type=\"text/javascript\">"); 
					pw.println("alert('password field cannot be empty, Please enter value');"); 
					pw.println("location='login.jsp';"); 
					pw.println("</script>"); 				 
			 }
		 }else { 
			 //check for username and password field length
			 int username_field_length = username.length();
			 int password_field_length = password.length();
			 
			 if(username_field_length < 5 || username_field_length > 10) {
				 if(username_field_length < 5) {
					    pw.println("<script type=\"text/javascript\">"); 
						pw.println("alert('username field value cannot be less than 5 characters, Please enter correct value');"); 
						pw.println("location='login.jsp';"); 
						pw.println("</script>");  
				 }else {
					    pw.println("<script type=\"text/javascript\">"); 
						pw.println("alert('username field value cannot be more than 10 characters, Please enter correct value');"); 
						pw.println("location='login.jsp';"); 
						pw.println("</script>"); 
				 }
			 }else if(password_field_length < 7 || password_field_length > 15) {
				 if(password_field_length < 7) {
					    pw.println("<script type=\"text/javascript\">"); 
						pw.println("alert('password field value cannot be less than 7 characters, Please enter correct value');"); 
						pw.println("location='login.jsp';"); 
						pw.println("</script>");  
				 }else {
					    pw.println("<script type=\"text/javascript\">"); 
						pw.println("alert('password field value cannot be more than 10 characters, Please enter correct value');"); 
						pw.println("location='login.jsp';"); 
						pw.println("</script>");  
				 }
				 
			 }else {
				//check for special character  values - username and password
				 if(!username.matches(username_pattern) || !password.matches(password_pattern)) {
					 if(!username.matches(username_pattern)) {
						    pw.println("<script type=\"text/javascript\">"); 
							pw.println("alert('please enter correct username pattern');"); 
							pw.println("location='login.jsp';"); 
							pw.println("</script>"); 
					 }else {
						    pw.println("<script type=\"text/javascript\">"); 
							pw.println("alert('please enter correct password pattern');"); 
							pw.println("location='login.jsp';"); 
							pw.println("</script>"); 
					 }
				 }else {
					 //check for correct username and password
					 boolean is_Valid_User = get_user_details(username, password);
					 if(!is_Valid_User) {
						    pw.println("<script type=\"text/javascript\">"); 
							pw.println("alert('Invalid credentials! Please enter correct username or password');"); 
							pw.println("location='login.jsp';"); 
							pw.println("</script>"); 
					 }else {
							HttpSession session = request.getSession(true);
							session.setAttribute("username",username);
						    response.sendRedirect("generate_password.jsp");
					 }
				 }
			 }
		 }
	}

	private boolean get_user_details(String username, String password) {
	   boolean flag = false;
		try {
			ps = con.prepareStatement("select * from user where username = ? and password = ?; ");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				flag = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}  
		return flag;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void detroy() {
		try {
			ps.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
