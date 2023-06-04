package com.nandu.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connection successful");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo","root","Chrome@123");
			PreparedStatement ps=con.prepareStatement("select * from user where username=?;");
			ps.setString(1,username);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				System.out.println("Entered into first if");
				String pass=rs.getString("password");
				System.out.println(password);
				System.out.println(pass);
				if(pass.equals(password)) {
					System.out.println("password equals");
					RequestDispatcher rd=request.getRequestDispatcher("success.html");
					System.out.println(rd);
					rd.include(request, response);
					
					}
				else {
					
					RequestDispatcher rd=request.getRequestDispatcher("passwordwrong.html");
					rd.include(request, response);
					System.out.println(rd);

				}
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("unamenotfound.html");
				rd.include(request, response);
				System.out.println(rd);

			}
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
