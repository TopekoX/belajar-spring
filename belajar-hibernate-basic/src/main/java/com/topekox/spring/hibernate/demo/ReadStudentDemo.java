package com.topekox.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.topekox.spring.hibernate.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save Java Object
			System.out.println("create new student object");
			Student student = new Student("Moh", "Rizki", "rizky@tutorialtimposu.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student");
			System.out.println(student);
			
			session.save(student);
			
			// commit transaction
			session.getTransaction().commit();
			
			// find out the student id: primary key
			System.out.println("Saved student. Generated id: " + student.getId());		
			
			// now get new session & start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrive student base on id: primary key
			System.out.println("\nGetting student whit id: " + student.getId());
			
			Student myStudent = session.get(Student.class, student.getId());
			
			System.out.println("Complete!!! : " + myStudent);
			
			// commit the transaction
			session.getTransaction().commit();
						
			// find out student id: primary key
			System.out.println("Done");
			
		} finally {
			factory.close();
		}		

	}

}
