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


@WebServlet("/AddCredential")
public class AddCredential extends HttpServlet {
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
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void destory() {
		try {
			ps.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
