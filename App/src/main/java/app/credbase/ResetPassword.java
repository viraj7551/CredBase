package app.credbase;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ResetPassword")
public class ResetPassword extends HttpServlet {
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
		pw =  response.getWriter();
		
		String new_password = request.getParameter("new_password");
		String confirm_password = request.getParameter("confirm_new_password");
		
		
		HttpSession session = request.getSession(true);
		String email=  (String) session.getAttribute("emailId");
		
		//check for existing password / new password / confirm password nulll value
		if(new_password == null || confirm_password == null) {
             if(new_password == null) {
			    pw.println("<script type=\"text/javascript\">"); 
				pw.println("alert('new password field cannot be empty, Please enter value');"); 
				pw.println("location='login.jsp';"); 
				pw.println("</script>"); 
		   }else {
			    pw.println("<script type=\"text/javascript\">"); 
				pw.println("alert('confirm password field cannot be empty, Please enter value');"); 
				pw.println("location='login.jsp';"); 
				pw.println("</script>"); 
		   }
		}else {
			//check for length of existing password / new password / confirm password
			int new_password_length = new_password.length();
			int confirm_password_length = confirm_password.length();
			
			if((new_password_length < 7 || new_password_length > 15) || (confirm_password_length < 7 || confirm_password_length > 15)) {
                 if(new_password_length < 7 || new_password_length > 15) {
					if(new_password_length < 7) {
					    pw.println("<script type=\"text/javascript\">"); 
						pw.println("alert('new password field value cannot be less than 7 characters');"); 
						pw.println("location='login.jsp';"); 
						pw.println("</script>"); 
					}else {
					    pw.println("<script type=\"text/javascript\">"); 
						pw.println("alert('new password field value cannot be more than 15 characters');"); 
						pw.println("location='login.jsp';"); 
						pw.println("</script>"); 
					}
				}else {
					if(confirm_password_length < 7) {
					    pw.println("<script type=\"text/javascript\">"); 
						pw.println("alert('confirm-password field value cannot be less than 7 characters');"); 
						pw.println("location='login.jsp';"); 
						pw.println("</script>"); 
					}else {
					    pw.println("<script type=\"text/javascript\">"); 
						pw.println("alert('confirm-password field value cannot be more than 15 characters');"); 
						pw.println("location='login.jsp';"); 
						pw.println("</script>"); 
					}
				}
			}else {
				// update password
				boolean IsPasswordUpdated = update_new_password(new_password, confirm_password, email);
				if(!IsPasswordUpdated) {
				    pw.println("<script type=\"text/javascript\">"); 
					pw.println("alert('something went wrong while updating password, Please try again.!');"); 
					pw.println("location='reset_password.jsp';"); 
					pw.println("</script>"); 
				}else {
				    pw.println("<script type=\"text/javascript\">"); 
					pw.println("alert('password updated successfully..!');"); 
					pw.println("location='login.jsp';"); 
					pw.println("</script>"); 
				}
			}
		}
	}
	
	private boolean update_new_password(String password, String confirm_password,String email) {
		boolean flag = false;
		try {
			ps = con.prepareStatement("update user set password = ? ,"
					+ " confirm_password= ? "
					+ "where email= ?;");
			ps.setString(1, password);
			ps.setString(2, confirm_password);
			ps.setString(3, email);
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
