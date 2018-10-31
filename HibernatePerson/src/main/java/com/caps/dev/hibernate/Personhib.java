package com.caps.dev.hibernate;

import java.util.Scanner;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.caps.dev.beans.Person;

/**
 * Hello world!
 *
 */
public class Personhib 
{
	public static void main( String[] args )
	{
		System.out.println("Enter the details of the person");
		System.out.println("-------------------");
		Person p = new Person();
		Scanner in = new Scanner(System.in);

		System.out.println("Enter person id: ");
		p.setPersonId(Integer.parseInt(in.nextLine()));

		System.out.println("Enter person name: ");
		p.setPersonName(in.nextLine());

		System.out.println("Enter person age: ");
		p.setPersonage(Double.parseDouble(in.nextLine()));

		System.out.println("Enter the person's mailID: ");
		p.setPersonmail(in.nextLine());
		save(p);
		System.out.println("Details of the person is saved");
	}
	
	private void setmail(String nextLine) {
		// TODO Auto-generated method stub
		
	}

	private void setage(double parseDouble) {
		// TODO Auto-generated method stub
		
	}

	private void setPersonName(String nextLine) {
		// TODO Auto-generated method stub
		
	}

	private void setPersonId(int parseInt) {
		// TODO Auto-generated method stub
		
	}

	public static void save(Person p) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistanceUnit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(p);
		tx.commit();
	}
}