package com.topekox.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.topekox.spring.hibernate.entity.Course;
import com.topekox.spring.hibernate.entity.Instructor;
import com.topekox.spring.hibernate.entity.InstructorDetail;

public class CreateCourseDemo {

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
			// create a object
			InstructorDetail instructorDetail =
					new InstructorDetail("http://youtube.com/sapi", "video gamer");
			
			Instructor instructor =
					new Instructor("Susan", "Putri", "susan@tutorialtimposu.com");	
			
			// assosiate the object
			instructor.setInstructorDetail(instructorDetail);
			
			// start a transaction
			session.beginTransaction();

			// save instructur
			System.out.println("Saving: " + instructor);
			session.save(instructor);
			
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
