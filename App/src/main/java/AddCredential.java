

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
import javax.servlet.http.HttpSession;


public class AddCredential extends HttpServlet {
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
	  String sitename = request.getParameter("sitename");
	  String username = request.getParameter("username");
	  String credVal1 = request.getParameter("credval1");
	  String credVal2 = request.getParameter("credval2");
	  
	  HttpSession  session = request.getSession();
	  String uname = (String) session.getAttribute("username");
	  boolean success = false;
	  try {
		  PreparedStatement ps = con.prepareStatement("insert into credential values(?,?,?,?,?)");
		  ps.setString(1,sitename);
		  ps.setString(2,username);
		  ps.setNString(3,credVal1);
		  ps.setNString(4,credVal2);
		  ps.setString(5,uname);
		  ps.executeUpdate();
		  success = true;
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }
	  if(success) {
		    pw.println("<script type=\"text/javascript\">"); 
			pw.println("alert('record added successfully....');"); 
			pw.println("location='add_credentials.jsp';"); 
			pw.println("</script>");   
	  }else {
		    pw.println("<script type=\"text/javascript\">"); 
			pw.println("alert('something went wrong....');"); 
			pw.println("location='add_credentials.jsp';"); 
			pw.println("</script>");		  
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

