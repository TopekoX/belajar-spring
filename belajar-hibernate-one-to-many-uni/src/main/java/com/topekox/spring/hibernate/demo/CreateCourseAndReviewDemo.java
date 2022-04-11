package com.topekox.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.topekox.spring.hibernate.entity.Course;
import com.topekox.spring.hibernate.entity.Instructor;
import com.topekox.spring.hibernate.entity.InstructorDetail;
import com.topekox.spring.hibernate.entity.Review;

public class CreateCourseAndReviewDemo {

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

			// create a course
			Course course = new Course("Pacman - How To Scoew One Milion Points");
			
			// add some review
			course.addReview(new Review("Great Course.. I love it"));
			course.addReview(new Review("Cool Course, job well done"));
			course.addReview(new Review("So Fucking Dump.. Stupid course"));
			
			// save course ... anda leverage the cascade all :-)
			System.out.println("Saving the course");
			System.out.println(course);
			System.out.println(course.getReviews());

			session.save(course);
			
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
