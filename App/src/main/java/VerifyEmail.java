

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VerifyEmail extends HttpServlet {
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
		String email = request.getParameter("email");
		Boolean success = false;
		response.setContentType("text/html");
		try {
	     PreparedStatement p = con.prepareStatement("select * from user where email = '"+email+"';");
	   	 ResultSet rs = p.executeQuery();
	   	 if(rs.next()) {
	   		success = true; 
	   	 }else {
	   		success = false;
	   	 }
	   }
	   	catch(Exception e) {
	   		e.printStackTrace();
	   	}
		if(success) {
			HttpSession session = request.getSession(true);
			session.setAttribute("emailId",email);
		    response.sendRedirect("reset_password.jsp");
		}else {
			PrintWriter out = response.getWriter(); 
			out.println("<script type=\"text/javascript\">"); 
			out.println("alert('please enter correct email id');"); 
			out.println("location='verify_email.jsp';"); 
			out.println("</script>"); 
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
