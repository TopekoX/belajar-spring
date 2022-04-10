package com.topekox.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.topekox.spring.hibernate.entity.Course;
import com.topekox.spring.hibernate.entity.Instructor;
import com.topekox.spring.hibernate.entity.InstructorDetail;

public class CreateInstructorDemo {

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
			
			// get the instructor from db
			int id = 1;
			Instructor instructor = session.get(Instructor.class, id);
			
			// create some course
			Course course1 = new Course("Air Guitar - The Ultimate Guide");
			Course course2 = new Course("The Pinball Masterclass");
			
			// add course to instuctor
			instructor.add(course1);
			instructor.add(course2);
			
			// save the course
			session.save(course1);
			session.save(course2);

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
