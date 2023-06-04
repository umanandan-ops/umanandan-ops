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
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/medicine_info")
public class medicine_info extends jakarta.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public medicine_info() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw=response.getWriter();

		String batch_code=request.getParameter("batch_code");
		String medicine_code=request.getParameter("medicine_code");
		String weight=request.getParameter("weight");
		String price=request.getParameter("price");
		String medicine_type=request.getParameter("medicine_type");
		String ref=request.getParameter("ref");


try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connection successful");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_data","root","Chrome@123");
			PreparedStatement p=con.prepareStatement("insert into medicine_info values(?,?,?,?,?,?);");

			p.setString(1,batch_code);
			p.setString(2,medicine_code);
			p.setString(3, weight);
			p.setString(4, price);
			p.setString(5, medicine_type);
			p.setString(6, ref);
			p.executeUpdate();
				con.close();	
}
catch (SQLException e) {
    e.printStackTrace();
}
catch(Exception e) {
	System.out.println(e);
}
			
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
