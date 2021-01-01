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

public class RegisterServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	   
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	System.out.println(request.getParameter("custId"));
    	int temp=0;
    	try
    	{
    	
        if(request.getParameter("custId").equals("stu")) 
        {
        	System.out.println("Student");
            String firstname=request.getParameter("s_fname").trim();
            String lastname=request.getParameter("s_lname").trim();
            String email=request.getParameter("s_email");
            String contactNumber=request.getParameter("s_phone").trim();
            String qualification=request.getParameter("s_qualification").trim();
            String password=request.getParameter("s_password").trim();
            String password1=request.getParameter("s_password1").trim();
            String errorMessage = null; 
           if(firstname==null || firstname.equals("")) {
            errorMessage+="First name should not be null or empty";
            } 
            if(lastname==null || lastname.equals("")) {
            errorMessage+="Last name should not be null or empty";
            } 
            if(email==null || email.equals("")) {
            errorMessage+="Email should not be null or empty";
            }
            if(qualification==null || qualification.equals("")) {
            errorMessage+="Qualification should not be null or empty";
            } 
            if(contactNumber==null || contactNumber.equals("")) {
            errorMessage+="Contact Number should not be null or empty";
            }
            if(password==null || password.equals("")) {
            errorMessage+="Password should not be null or empty";
            }
            if(password1==null || password1.equals("")) {
            errorMessage+="Confirm Password should not be null or empty";
            }

           if(errorMessage!=null) {
                        RequestDispatcher rd=getServletContext().getRequestDispatcher("/register.html");
                        PrintWriter out=response.getWriter();
                        out.println("<h3><font color=red>"+errorMessage+"</font></h3>");
                        rd.include(request, response);
                    }else {
                        try {
                            if(DBConnection.getConnection()!=null) {
                            String count="select count(*)+1 from student";
                            PreparedStatement ps1=DBConnection.getPrepStatement(count);
                            ResultSet r=ps1.executeQuery();
                          
                           String pcount="";
                           while(r.next())
                           {
                            pcount=String.valueOf(r.getString(1));
                           }
                            System.out.println(pcount);
                            String uname1='s'+pcount;
             
                            System.out.println(uname1);
                            String sql="insert into student(firstname,lastname,username,password,email,contact_no,qualification) values(?,?,?,?,?,?,?)";
                            PreparedStatement ps=DBConnection.getPrepStatement(sql);
                            ps.setString(1, firstname);
                            ps.setString(2, lastname);
                            ps.setString(3,uname1);
                            ps.setString(4,password);
                            ps.setString(5, email);
                            ps.setString(6, contactNumber);
                            ps.setString(7, qualification);

                            ps.execute();
                            
                            
                            
                            RequestDispatcher rd=getServletContext().getRequestDispatcher("/login.html");
                            PrintWriter out=response.getWriter();
                            out.println("<h3><font color=green>Registration successful! You can login now.</font></h3>");
                            out.println("<h3><font color=green> Your username is: "+uname1+"</font></h3>");
                            rd.include(request, response);
                            
                            }
                            if(DBConnection.getConnection()==null) {
                                System.out.println("No databse connection");
                                PrintWriter out1=response.getWriter();
                                out1.println("<h2>No databse connection</h2>");
                            }
                            
                            
                   
        }
                        catch(Exception e) {
                            e.printStackTrace();
                        }
                    }
        }
    	
                    
        else 
        {
       }
    	} 
    	catch(NullPointerException e) 
        { 
    		temp=1;
            System.out.print("NullPointerException Caught"); 
        } 
    	finally
    	{
    		if (temp==1)
    		{
    			 System.out.println("Employee");
    		        String firstname1=request.getParameter("e_fname").trim();
    		        String lastname1=request.getParameter("e_lname").trim();
    		        String password3=request.getParameter("e_password").trim();
    		        String email1=request.getParameter("e_email");
    		        String company=request.getParameter("e_company").trim();
    		        String password4=request.getParameter("e_password1").trim();
    		        String contact_no1=request.getParameter("e_phone").trim();
    		        String errorMessage1 = null;
    		       
    		        if(firstname1==null || firstname1.equals("")) {
    		            errorMessage1+="first name should not be null or empty";
    		        }
    		        
    		        if(lastname1==null || lastname1.equals("")) {
    		            errorMessage1+="last name should not be null or empty";
    		        }
    		       
    		        if(password3==null || password3.equals("")) {
    		            errorMessage1+="Password should not be null or empty";
    		        }
    		       
    		        if(email1==null || email1.equals("")) {
    		            errorMessage1+="Email should not be null or empty";
    		        }
    		        if(contact_no1==null || contact_no1.equals("")) {
    		            errorMessage1+="contact_no should not be null or empty";
    		        }
    		       
    		        if(password4==null || password4.equals("")) {
    		            errorMessage1+="password1 should not be null or empty";
    		        }
    		       
    		        if(company==null || company.equals("")) {
    		            errorMessage1+="company should not be null or empty";
    		        }
    		        if(errorMessage1!=null) {
    		            RequestDispatcher rd=getServletContext().getRequestDispatcher("/register.html");
    		            PrintWriter out=response.getWriter();
    		            out.println("<h3><font color=red>"+errorMessage1+"</font></h3>");
    		            rd.include(request, response);
    		        }else {
    		            try {
    		                if(DBConnection.getConnection()!=null) {
    		                String count="select count(*)+1 from employee";
    		                PreparedStatement ps1=DBConnection.getPrepStatement(count);
    		               ResultSet r=ps1.executeQuery();
    		              
    		               String pcount="";
    		               while(r.next())
    		               {
    		                pcount=String.valueOf(r.getString(1));
    		               }
    		                System.out.println(pcount);
    		                String uname='e'+pcount;

    		 

    		                System.out.println(uname);
    		                String sql="insert into employee(firstname, lastname, username ,password, email ,contact_no,company) values(?,?,?,?,?,?,?)";
    		                PreparedStatement ps=DBConnection.getPrepStatement(sql);
    		                ps.setString(1, firstname1);
    		                ps.setString(2, lastname1);
    		                ps.setString(3,uname);
    		                ps.setString(4,password3);
    		                ps.setString(5, email1);
    		                ps.setString(6, contact_no1);
    		                ps.setString(7, company);
    		               
    		                ps.execute();
    		                
    		    
    		                response.sendRedirect("login.jsp");
    		                RequestDispatcher rd=getServletContext().getRequestDispatcher("/login.html");
    		                PrintWriter out=response.getWriter();
    		                out.println("<h3><font color=green>Registration successful! You can login now.</font></h3>");
    		                out.println("<h3><font color=green> Your username is: "+uname+"</font></h3>");
    		                rd.include(request, response);
    		                }
    		               
    		                if(DBConnection.getConnection()==null) {
    		                    System.out.println("No databse connection");
    		                    PrintWriter out1=response.getWriter();
    		                    out1.println("<h2>No databse connection</h2>");
    		                }
    		                }
    		            catch(Exception e) {
    		                e.printStackTrace();
    		            }
    		        }
    		       
    		    }
    		else {
    			
    		}
    			
    		
    	}
        
    }
}


    
