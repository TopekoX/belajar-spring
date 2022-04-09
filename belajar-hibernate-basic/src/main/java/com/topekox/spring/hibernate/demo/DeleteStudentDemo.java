package com.topekox.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.topekox.spring.hibernate.entity.Student;

public class DeleteStudentDemo {

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
			
			// cara 1
			// delete the student
//			System.out.println("Deleting student : " + student);
//			session.delete(student);
			
			// cara 2
			// delete student id=2
			System.out.println("Deleting student id = 2");
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} finally {
			factory.close();
		}		

	}

}
