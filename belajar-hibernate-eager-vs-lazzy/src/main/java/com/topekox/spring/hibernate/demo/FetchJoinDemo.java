package com.topekox.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.topekox.spring.hibernate.entity.Course;
import com.topekox.spring.hibernate.entity.Instructor;
import com.topekox.spring.hibernate.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
				
			// start a transaction
			session.beginTransaction();
			
			// get the instructor detail object
			int id=1;
			
			// Option 2: Hibernate query with HQL
			Query<Instructor> query =
					session.createQuery("select i from Instructor i "
							+ "JOIN FETCH i.courses "
							+ "where i.id=:theInstructorId", 
							Instructor.class);

			// set parameter on query
			query.setParameter("theInstructorId", id);			
									
			Instructor instructor =
						query.getSingleResult();
						
			System.out.println("tutorialtimposu: Instructor: " + instructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			// close session
			session.close();
			
			System.out.println("\ntutuorialtimposu: The session is now closed!\n");
							
			// get course for the Instructor
			System.out.println("tutorialtimposu: Course: " + instructor.getCourses());
					

			System.out.println("tutorialtimposu: Done!!!");

		} finally {
			// add clean up
			session.close();
			
			factory.close();
		}

	}

}
