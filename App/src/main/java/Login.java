

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Login extends HttpServlet {
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
	  boolean success= false;
	  PrintWriter p = response.getWriter();
	  response.setContentType("text/html");
	  String username = request.getParameter("username");
	  String password = request.getParameter("password");
	  try {
		  PreparedStatement ps = con.prepareStatement("Select * from user where username= ? and password = ?");
		  ps.setString(1,username);
		  ps.setString(2, password);
		  ResultSet rs = ps.executeQuery();
		  if(rs.next()) {
             success=true;
		  }else {
			  success= false;
		  }
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }
	  if(success) {
		HttpSession session = request.getSession(true);
		session.setAttribute("username",username);
	    response.sendRedirect("generate_password.jsp");    
	  }else {
		    request.getSession(false);
			PrintWriter out = response.getWriter(); 
			out.println("<script type=\"text/javascript\">"); 
			out.println("alert('Invalid Credentials');"); 
			out.println("location='login.jsp';"); 
			out.println("</script>"); 
	  }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void destroy() {
		try {
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
