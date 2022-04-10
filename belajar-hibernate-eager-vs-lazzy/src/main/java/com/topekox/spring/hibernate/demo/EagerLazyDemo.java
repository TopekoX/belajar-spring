package com.topekox.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.topekox.spring.hibernate.entity.Course;
import com.topekox.spring.hibernate.entity.Instructor;
import com.topekox.spring.hibernate.entity.InstructorDetail;

public class EagerLazyDemo {

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
						
			Instructor instructor =
						session.get(Instructor.class, id);
						
			System.out.println("tutorialtimposu: Instructor: " + instructor);
			
			// get course for the Instructor
			System.out.println("tutorialtimposu: Course: " + instructor.getCourses());
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("tutorialtimposu: Done!!!");

		} finally {
			// add clean up
			session.close();
			
			factory.close();
		}

	}

}
