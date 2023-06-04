package com.nandu.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/form")
public class form extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public form() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw=response.getWriter();

		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connection successful");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo","root","Chrome@123");
			PreparedStatement ps=con.prepareStatement("select * from user where username=?");
			ps.setString(1,username);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				
			System.out.println("inside else");
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.forward(request, response);
			}
			else {
				PreparedStatement p=con.prepareStatement("insert into user values(?,?,?);");

			p.setString(1,username);
			p.setString(2,email);
			p.setString(3, password);
			p.executeUpdate();
			System.out.println("inside if");
			}
				con.close();	
}
catch (SQLException e) {
    e.printStackTrace();
}
catch(Exception e) {
	System.out.println(e);
}
			
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
