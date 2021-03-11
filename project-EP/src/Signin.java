import java.io.*;
import javax.servlet.*; 
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;

public class Signin extends HttpServlet {
	
    public Signin() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String v1 = request.getParameter("fname");
		String v2 = request.getParameter("lname");
		String v3 = request.getParameter("username");
		String v4 = request.getParameter("password");
		String v5 = request.getParameter("email");
		String v6 = request.getParameter("address");
		
		System.out.println("username : "+v3 +" "+"password : "+v4);
		try
		{
    		Class.forName("oracle.jdbc.driver.OracleDriver");
    		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system","vijayapl");
    		PreparedStatement pstmt=con.prepareStatement("insert into  project values(?,?,?,?,?,?)");
    		pstmt.setString(1, v1);
    		pstmt.setString(2, v2);
    		pstmt.setString(3, v3);
    		pstmt.setString(4, v4);
    		pstmt.setString(5, v5);
    		pstmt.setString(6, v6);
    		boolean n = pstmt.execute();   			
    		if(n)
    			System.out.println("- - - - One Record inserted successful - - - -");
    		else
    			System.out.println("- - - - One Record inserted successful - - - -");
    		
		}
		catch(ClassNotFoundException | SQLException e)
		{		
			System.out.println(e);  
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}