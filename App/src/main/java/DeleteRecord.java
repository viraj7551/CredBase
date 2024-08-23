

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

public class DeleteRecord extends HttpServlet {
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
	  String sitename = request.getQueryString();
	  boolean success=false;
	  try {
		    PreparedStatement p = con.prepareStatement("delete from credential where sitename = ?");
		    p.setString(1,sitename);
		    p.executeUpdate();
            success=true;
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }
	  
	  if(success) {
		    pw.println("<script type=\"text/javascript\">"); 
			pw.println("alert('record deleted successfully...."+sitename+"');"); 
			pw.println("location='add_credentials.jsp';"); 
			pw.println("</script>"); 
	  }else {
		    pw.println("<script type=\"text/javascript\">"); 
			pw.println("alert('something went wrong, record is not deleted');"); 
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
