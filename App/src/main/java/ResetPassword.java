

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResetPassword extends HttpServlet {

	Connection con;
	
	public void init(ServletConfig config) {
		String driver = config.getInitParameter("driver");
		String url = config.getInitParameter("url");
		String username = config.getInitParameter("username");
		String password = config.getInitParameter("password");
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,username,password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   PrintWriter pw = response.getWriter();
	   response.setContentType("text/html");
	   String newpassword = request.getParameter("newpassword");
	   String existing_password = request.getParameter("existing_password");
	   Boolean success=false;
	   try {
		   PreparedStatement ps = con.prepareStatement("update user set password=?, confirm_password=? where password=?");
		   ps.setString(1,newpassword);
		   ps.setString(2,newpassword);
		   ps.setString(3,existing_password);
		   ps.executeUpdate();
           success=true;
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	   
	   if(success) {
           response.sendRedirect("login.jsp");
	   }else {
		   response.sendRedirect("verify_email.jsp");
	   }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public void destroy() {
		try {
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
