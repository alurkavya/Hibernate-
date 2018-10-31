package com.caps.dev;
	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.caps.dev.beans.Person;
	
	public class SearchPerson {
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
		search(p);
	    }
	    
	    public static void search(Person p) {
	    	Connection connection = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
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
				connection = DriverManager.getConnection(dbUrl,"root","root"); //1st version of getConnection

				System.out.println("Connected...");
				
				/*
				 * 3. Issue the SQL query via connection
				 */
				String sql = "select person_id,person_name,person_age,person_mail,from person_info "
						+ "where person_id=?";

				pstmt = connection.prepareStatement(sql);
				rs = pstmt.executeQuery();

				/*
				 * 4. Process the results
				 */

				if(rs.next()){
					int person_id= rs.getInt("person_id");
					String person_name= rs.getString("person_name");
					int person_age= rs.getInt("person_age");
					String person_email = rs.getString("person_email");
					String person_add = rs.getString("person_add");
					System.out.println(person_id);
					System.out.println(person_name);
					System.out.println(person_age);
					System.out.println(person_email);
					System.out.println(person_add);
				System.out.println("*********************");
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
				
				if(connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					/*if(rs != null) {
						try {
							rs.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}*/
			}
	    }
	    }}
