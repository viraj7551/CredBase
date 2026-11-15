package app.credbase;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	
    private static final String username_pattern = "^[a-zA-Z0-9]+$";
    private static final String password_pattern = "^[a-zA-Z0-9@]+$";
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/credbase";
	private static String username = "root";
	private static String password = "Viraj@6937";
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
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password  = request.getParameter("password");
		String confirm_password = request.getParameter("confirm_password");
		
		//check for field null values
		if(firstname == null || lastname == null || username == null || email == null || password == null || confirm_password ==null) {
			if(firstname == null) {
			    pw.println("<script type=\"text/javascript\">"); 
				pw.println("alert('firstname field cannot be empty, Please enter firstname');"); 
				pw.println("location='register.jsp';"); 
				pw.println("</script>");
			}else if(lastname == null) {
			    pw.println("<script type=\"text/javascript\">"); 
				pw.println("alert('lastname field cannot be empty, Please enter lastname');"); 
				pw.println("location='register.jsp';"); 
				pw.println("</script>");				
			}else if(username == null) {
			    pw.println("<script type=\"text/javascript\">"); 
				pw.println("alert('username field cannot be empty, Please enter username');"); 
				pw.println("location='register.jsp';"); 
				pw.println("</script>");
			}else if(email == null) {
			    pw.println("<script type=\"text/javascript\">"); 
				pw.println("alert('email field cannot be empty, Please enter username');"); 
				pw.println("location='register.jsp';"); 
				pw.println("</script>");
			}else if(password == null) {
			    pw.println("<script type=\"text/javascript\">"); 
				pw.println("alert('password field cannot be empty, Please enter password');"); 
				pw.println("location='register.jsp';"); 
				pw.println("</script>");
			}else {
			    pw.println("<script type=\"text/javascript\">"); 
				pw.println("alert('confirm password field cannot be empty, Please enter password');"); 
				pw.println("location='register.jsp';"); 
				pw.println("</script>");				
			}
		}else {
			 //check for the field length
             int firstname_length = firstname.length();
             int lastname_length = lastname.length();
             int username_length = username.length();
             int email_length = email.length();
             int password_length = password.length();
             int confirm_password_length = confirm_password.length();
             
             if((firstname_length < 5 || firstname_length > 10) || (lastname_length < 5 || lastname_length > 10) || (username_length < 5 || username_length > 10) || (email_length < 9 || email_length > 20) || (password_length < 6 || password_length > 15) || (confirm_password_length < 6 || confirm_password_length > 15)) {
            	 if(firstname_length < 5 || firstname_length > 10) {
            		 if(firstname_length < 5) {
         			    pw.println("<script type=\"text/javascript\">"); 
        				pw.println("alert('firstname field value cannot be less than 5 characters..!');"); 
        				pw.println("location='register.jsp';"); 
        				pw.println("</script>");	
            		 }else {
          			    pw.println("<script type=\"text/javascript\">"); 
         				pw.println("alert('firstname field value cannot be more than 10 characters..!');"); 
         				pw.println("location='register.jsp';"); 
         				pw.println("</script>");            			 
            		 }
            	 }else if(lastname_length < 5 || lastname_length > 10) {
            		 if(lastname_length < 5) {
          			    pw.println("<script type=\"text/javascript\">"); 
         				pw.println("alert('lastname field value cannot be less than 5 characters..!');"); 
         				pw.println("location='register.jsp';"); 
         				pw.println("</script>");
            		 }else {
          			    pw.println("<script type=\"text/javascript\">"); 
         				pw.println("alert('lastname field value cannot be more than 10 characters..!');"); 
         				pw.println("location='register.jsp';"); 
         				pw.println("</script>");
            		 }
            	 }else if(username_length < 5 || username_length > 10) {
            		 if(username_length < 5) {
          			    pw.println("<script type=\"text/javascript\">"); 
         				pw.println("alert('username field value cannot be less than 5 characters..!');"); 
         				pw.println("location='register.jsp';"); 
         				pw.println("</script>");
            		 }else {
          			    pw.println("<script type=\"text/javascript\">"); 
         				pw.println("alert('username field value cannot be more than 10 characters..!');"); 
         				pw.println("location='register.jsp';"); 
         				pw.println("</script>");
            		 }
            	 }else if(email_length < 9 || email_length > 20) {
            		 if(email_length < 9) {
          			    pw.println("<script type=\"text/javascript\">"); 
         				pw.println("alert('email field value cannot be less than 9 characters..!');"); 
         				pw.println("location='register.jsp';"); 
         				pw.println("</script>");
            		 }else {
           			    pw.println("<script type=\"text/javascript\">"); 
          				pw.println("alert('email field value cannot be more than 20 characters..!');"); 
          				pw.println("location='register.jsp';"); 
          				pw.println("</script>");            			 
            		 }
            	 }else {
                      
            		 if((password != confirm_password) || (confirm_password != password)) {
                         if(password != confirm_password) {
             			    pw.println("<script type=\"text/javascript\">"); 
               				pw.println("alert('password and confirm-password are mismatched !');"); 
               				pw.println("location='register.jsp';"); 
               				pw.println("</script>");            			 
                         }else {
             			    pw.println("<script type=\"text/javascript\">"); 
               				pw.println("alert('password and confirm-password are mismatched !');"); 
               				pw.println("location='register.jsp';"); 
               				pw.println("</script>");            			 
                         }
            		 }else {
            			 if(password_length < 6 || password_length > 15){
            				 if(password_length < 6) {
                  			    pw.println("<script type=\"text/javascript\">"); 
                   				pw.println("alert('password field value cannot be less than 6 characters.!');"); 
                   				pw.println("location='register.jsp';"); 
                   				pw.println("</script>");            					 
            				 }else {
                   			    pw.println("<script type=\"text/javascript\">"); 
                    			pw.println("alert('password field value cannot be more than 15 characters.!');"); 
                    			pw.println("location='register.jsp';"); 
                    			pw.println("</script>");            					             					 
            				 }
            			 }else {
            				 if(confirm_password_length < 6) {
                   			    pw.println("<script type=\"text/javascript\">"); 
                    			pw.println("alert('confirm-password field value cannot be less than 6 characters.!');"); 
                    			pw.println("location='register.jsp';"); 
                    			pw.println("</script>");            					 
            				 }else {
                   			    pw.println("<script type=\"text/javascript\">"); 
                    			pw.println("alert('confirm-password field value cannot be more than 15 characters.!');"); 
                    			pw.println("location='register.jsp';"); 
                    			pw.println("</script>");            					 
            				 }
            			 }
            		 }
            	 }
            	 
             }else {
            	 //check if user entry exists
            	 boolean IsUserExists = check_for_user_entry(username);
            	 if(!IsUserExists) {
            		 boolean IsUserRegistered = insert_entry_into_register_table(firstname, lastname, username, email, password, confirm_password);
            		 if(!IsUserRegistered) {
             			pw.println("<script type=\"text/javascript\">"); 
             			pw.println("alert('something went wrong while registering..! Please try again');"); 
             			pw.println("location='register.jsp';"); 
             			pw.println("</script>");              			 
            		 }else {
              			pw.println("<script type=\"text/javascript\">"); 
              			pw.println("alert('user registered successfully...!');"); 
              			pw.println("location='login.jsp';"); 
              			pw.println("</script>");   
            		 }    
            	 }else {
         			pw.println("<script type=\"text/javascript\">"); 
         			pw.println("alert('user entry already exists, Please register with new credentials..!');"); 
         			pw.println("location='register.jsp';"); 
         			pw.println("</script>");
            	 }
             }
		}
		
	}
	
	
	private boolean check_for_user_entry(String username) {
		boolean flag = false;
		try {
			ps = con.prepareStatement("select * from user where username = ?;");
			ps.setString(1, username);
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
	
	private boolean insert_entry_into_register_table(String firstname, String lastname, String username, String email, String password, String confirm_password) {
		boolean flag = false;
		try {
			ps = con.prepareStatement("insert into user(firstname,lastname,username,email,password,confirm_password)Values(?,?,?,?,?,?);");
		    ps.setString(1, firstname);
		    ps.setString(2, lastname);
		    ps.setString(3, username);
		    ps.setString(4, email);
		    ps.setString(5, password);
		    ps.setString(6,confirm_password);
		    ps.executeUpdate();
		    flag = true;
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
	
	public void destroy() {
		try {
			ps.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
