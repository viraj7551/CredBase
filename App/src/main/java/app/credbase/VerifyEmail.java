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
import javax.servlet.http.HttpSession;


@WebServlet("/VerifyEmail")
public class VerifyEmail extends HttpServlet {

    private static final String email_pattern = "^[a-zA-Z0-9@]+$";
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
		
		String email = request.getParameter("email");
		
		//check for email empty value
		if(email == null) {
		    pw.println("<script type=\"text/javascript\">"); 
			pw.println("alert('email field cannot be empty, Please enter value');"); 
			pw.println("location='login.jsp';"); 
			pw.println("</script>"); 
		}else {
			//check for email length
			int email_length = email.length();
			if(email_length < 6 || email_length > 20) {
				if(email_length < 6) {
				    pw.println("<script type=\"text/javascript\">"); 
					pw.println("alert('email field value cannot be less than 7 characters');"); 
					pw.println("location='verify_email.jsp';"); 
					pw.println("</script>"); 
				}else {
				    pw.println("<script type=\"text/javascript\">"); 
					pw.println("alert('email field value cannot be more than 20 characters');"); 
					pw.println("location='verify_email.jsp';"); 
					pw.println("</script>");
				}
			}else {
					 //check for email
					 boolean IsEmailExist = check_for_email(email);
					 if(!IsEmailExist) {
						    pw.println("<script type=\"text/javascript\">"); 
							pw.println("alert('email address not exists, Please register again..!');"); 
							pw.println("location='verify_email.jsp';"); 
							pw.println("</script>");  
					 }else {
						 
							HttpSession session = request.getSession(true);
							session.setAttribute("emailId",email);
						    response.sendRedirect("reset_password.jsp");
					 }
		    }
		}
	}
	
	private boolean check_for_email(String email) {
		boolean flag = false;
		try {
			ps = con.prepareStatement("select * from user where email = ?;");
			ps.setString(1, email);
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
