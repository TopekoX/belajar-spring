package com.topekox.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.topekox.spring.hibernate.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session;
		
		try {
			
			int id = 1;
			
			// start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// mengambil student by id: primary key
			System.out.println("\nGetting student with id: " + id);
			
			Student student = session.get(Student.class, id);
			
			System.out.println("Updating student");
			student.setFirstName("Mamat");
			
			// commit transaction
			session.getTransaction().commit();
			
			// new code
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// update email for all student
			System.out.println("Update email for all student");
			
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} finally {
			factory.close();
		}		

	}

}
