

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;
public class Register extends HttpServlet {
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
         PrintWriter p = response.getWriter();
         response.setContentType("text/html");
         String firstname = request.getParameter("firstname");
         String lastname = request.getParameter("lastname");
         String username = request.getParameter("username");
         String email = request.getParameter("email");
         String password = request.getParameter("password");
         String confirm_password = request.getParameter("confirm_password");
             boolean success = isUserExist(request, response);
             if(success) {
      		    p.println("<script type=\"text/javascript\">"); 
     			p.println("alert('User already exists, please enter new Username');"); 
     			p.println("location='register.jsp';"); 
     			p.println("</script>"); 
                        	 
             }else {
            	 try {
            	      PreparedStatement ps = con.prepareStatement("insert into user values(?,?,?,?,?,?)");
            	      ps.setString(1,firstname);
            	      ps.setString(2,lastname);
            	      ps.setString(3,username);
            	      ps.setString(4,email);
            	      ps.setString(5,password);
            	      ps.setString(6,confirm_password);
            	      ps.executeUpdate(); 
            	      response.sendRedirect("login.jsp"); 
            	 }
                 catch(Exception e) {
                	 e.printStackTrace();
                 }
             }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private boolean isUserExist(HttpServletRequest request, HttpServletResponse response) {
		boolean status = false;
		String username = request.getParameter("username");
		try {
			PreparedStatement ps = con.prepareStatement("select * from user where username = ?");
			ps.setString(1,username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				status = true;
			}else {
				status = false;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
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
