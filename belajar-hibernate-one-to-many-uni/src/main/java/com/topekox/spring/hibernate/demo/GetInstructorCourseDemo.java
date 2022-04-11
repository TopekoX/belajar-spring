package com.topekox.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.topekox.spring.hibernate.entity.Course;
import com.topekox.spring.hibernate.entity.Instructor;
import com.topekox.spring.hibernate.entity.InstructorDetail;

public class GetInstructorCourseDemo {

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
			
			// get course for the instructor
			System.out.println("Instructor: " + instructor);
			
			// get course for the Instructor
			System.out.println("Course: " + instructor.getCourses());
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!!!");

		} finally {
			// add clean up
			session.close();
			
			factory.close();
		}

	}

}
