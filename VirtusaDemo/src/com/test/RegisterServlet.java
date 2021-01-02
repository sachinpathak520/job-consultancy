package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dest.dbcon.DBConnection;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("rtetre");
		int temp = 0;
		try {

			if (request.getParameter("cand").equals("emp")) {
				System.out.println("candidate");
				String Firstname = request.getParameter("c_fname").trim();
				String Lastname = request.getParameter("c_lname").trim();
				String Gender = request.getParameter("c_gender").trim();
				String ContactNumber = request.getParameter("c_phone").trim();
				String Email = request.getParameter("c_email").trim();
				String Address = request.getParameter("c_add").trim();
				String Qualification = request.getParameter("c_quali").trim();
				String password = request.getParameter("c_password").trim();
				
				String Experince = request.getParameter("c_exp").trim();
				String DOB = request.getParameter("c_dob").trim();
				String resume = request.getParameter("c_resume").trim();
				System.out.println("rtetre");
				try {
					if (DBConnection.getConnection() != null) {
						String count = "select count(*)+1 from candidate";
						PreparedStatement ps1 = DBConnection.getPrepStatement(count);
						ResultSet r = ps1.executeQuery();

						String pcount = "";
						while (r.next()) {
							pcount = String.valueOf(r.getString(1));
						}
						System.out.println(pcount);
						String uname1 = 's' + pcount;

						System.out.println(uname1);
						String sql = "insert into candidate values(?,?,?,?,?,?,?,?,?,?,?)";
						PreparedStatement ps = DBConnection.getPrepStatement(sql);
						ps.setString(2, Firstname);
						ps.setString(3, Lastname);
						ps.setString(4, Gender);
						ps.setString(5, ContactNumber);
						ps.setString(6, Email);
						ps.setString(7, Address);
						ps.setString(8, Qualification);
						ps.setString(9, password);
						ps.setString(8, Experince);
						ps.setString(8, DOB);
						ps.setString(8, resume);

						ps.execute();

						RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
						PrintWriter out = response.getWriter();
						out.println("<h3><font color=green>Registration successful! You can login now.</font></h3>");
						out.println("<h3><font color=green> Your username is: " + uname1 + "</font></h3>");
						rd.include(request, response);

					}
					if (DBConnection.getConnection() == null) {
						System.out.println("No databse connection");
						PrintWriter out1 = response.getWriter();
						out1.println("<h2>No databse connection</h2>");
					}

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
			}

		} catch (NullPointerException e) {
			temp = 1;
			System.out.print("NullPointerException Caught");
		}

	}
}
