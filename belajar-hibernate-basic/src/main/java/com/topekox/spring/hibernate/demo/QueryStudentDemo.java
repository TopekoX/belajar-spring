package com.topekox.spring.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.topekox.spring.hibernate.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// query student
			List<Student> theStudent = session.createQuery("from Student").getResultList();
			
			// display student
			displayStudents(theStudent);
			
			// query students: lastname Gray
			theStudent = session.createQuery("from Student s where s.lastName='Gray'").getResultList();
			
			// display student
			System.out.println("\nstudents by last name");
			displayStudents(theStudent);
			
			// query students: lastname topekox or firstname ucup
			theStudent = session.createQuery("from Student s where "
					+ "s.lastName='topekox' OR s.firstName='ucup'").getResultList();
									
			// display student where lastname topekox or firstname ucup
			System.out.println("\nstudents by students: lastname topekox or firstname ucup");
			displayStudents(theStudent);
			
			// query students where email LIKE @gmail.com
			theStudent = session.createQuery("from Student s where "
					+ "s.email LIKE '%gmail'").getResultList();
									
			// display student where email LIKE @gmail.com
			System.out.println("\nstudents by students email @gmail");
			displayStudents(theStudent);
			
			// commit transaction
			session.getTransaction().commit();
		
			System.out.println("Done");
			
		} finally {
			factory.close();
		}		

	}

	private static void displayStudents(List<Student> theStudent) {
		for ( Student student : theStudent ) {
			System.out.println(student);
		}
	}

}
