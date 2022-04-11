package com.topekox.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.topekox.spring.hibernate.entity.Course;
import com.topekox.spring.hibernate.entity.Instructor;
import com.topekox.spring.hibernate.entity.InstructorDetail;
import com.topekox.spring.hibernate.entity.Review;

public class GetCourseAndReviewDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();
			
			// get the course
			int id = 10;
			Course course = session.get(Course.class, id);
			
			// print the course
			System.out.println(course);
			
			// print the course reviews
			System.out.println(course.getReviews());
			
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
