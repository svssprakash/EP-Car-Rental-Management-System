

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String v3 = request.getParameter("username");
		String v4 = request.getParameter("password");
		
		System.out.println("username : "+v3 +" "+"password : "+v4);

		try
		{

			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","vijayapl");
			
			PreparedStatement  pstmt= con.prepareStatement("select * from project");
			
			ResultSet rs = pstmt.executeQuery();
			
				while (rs.next())
				{
					if(rs.getString(1).equals(v3) && rs.getString(3).equals(v4)) {
						System.out.println(rs.getString(1)+" "+rs.getString(3));
						System.out.println("Login Successful");
					}
					else
					{
						System.out.println(rs.getString(1)+" "+rs.getString(3));
						System.out.println("Login Fail");
					}
				}
				
			con.close();
		}
		catch(ClassNotFoundException | SQLException e)
		{		
			System.out.println(e);  
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
