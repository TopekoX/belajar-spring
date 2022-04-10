package com.topekox.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.topekox.spring.hibernate.entity.Instructor;
import com.topekox.spring.hibernate.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();
			
			// get instrctor id by primary key
			int id = 1;
			
			Instructor instructor =
					session.get(Instructor.class, id);
			
			System.out.println("Found Instructor: " + instructor);
			
			// delete the instructor
			if (instructor != null) {
				System.out.println("deleting : " + instructor);
				session.delete(instructor);;
			}
			
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!!!");

		} finally {
			factory.close();
		}

	}

}
