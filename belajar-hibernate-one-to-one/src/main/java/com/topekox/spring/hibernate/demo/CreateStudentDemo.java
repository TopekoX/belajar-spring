package com.topekox.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.topekox.spring.hibernate.entity.Instructor;
import com.topekox.spring.hibernate.entity.InstructorDetail;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create a object
			InstructorDetail instructorDetail =
					new InstructorDetail("http://youtube.com/tutorialtimposu", "hiking");
			
			Instructor instructor =
					new Instructor("Ucup", "Topekox", "ucup@tutorialtimposu.com");
			
			// associate the objects
			instructor.setInstructorDetail(instructorDetail);
			
			// start a transaction
			session.beginTransaction();

			// save the instructor
			//
			// Note: this will ALSO save the details object
			// because of CascadeType.ALL
			//
			System.out.println("Saving Instructor: " + instructor);
			session.save(instructor);
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!!!");

		} finally {
			factory.close();
		}

	}

}
