package com.caps.dev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.caps.dev.beans.Person;

public class DeletePerson {
	 public static void main( String[] args )
	    {
	    	System.out.println("Enter Person Details");
	       System.out.println("-------------------");
	       Person p = new Person();
	       Scanner in = new Scanner(System.in);
	       
	   	System.out.println("Enter person id: ");
		p.setPersonId(Integer.parseInt(in.nextLine()));
		/*System.out.println("Enter person name: ");
		persondetails.setPersonName(in.nextLine());
		System.out.println("Enter person age: ");
		persondetails.setPersonAge(Integer.parseInt(in.nextLine()));
		System.out.println("Enter person email: ");
		persondetails.setPersonEmail(in.nextLine());
		System.out.println("Enter person address: ");
		persondetails.setPersonAddress(in.nextLine());*/
		delete(p);
	    }
	    
	    public static void delete(Person p) {
	    	Connection con = null;
			PreparedStatement pstmt = null;

			try {
				/*
				 * 1. Load the Driver
				 */
				Class.forName("com.mysql.jdbc.Driver");

				/*
				 * 2. Get the DB Connection via Driver
				 */
				
				String dbUrl="jdbc:mysql://localhost:3306/capsv4_db";

				//3rd version of getConnnecton()
				con = DriverManager.getConnection(dbUrl,"root","root"); //1st version of getConnection


				/*
				 * 3. Issue the SQL query via connection
				 */
				String sql = "delete from person_info where person_id=?";

				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, p.getPersonId());
				//pstmt.setString(2,persondetails.getPersonName());
				//pstmt.setInt(3, persondetails.getPersonAge());
				//pstmt.setString(4, persondetails.getPersonEmail());
				//pstmt.setString(5, persondetails.getPersonAddress());
				
				int count = pstmt.executeUpdate();
				
				/*
				 * 4. Process the results
				 */

				if(count > 0) {
					System.out.println("Person details are deleted");
				}else {
					System.out.println("Failed!!!");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				if(con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
	    }


}
