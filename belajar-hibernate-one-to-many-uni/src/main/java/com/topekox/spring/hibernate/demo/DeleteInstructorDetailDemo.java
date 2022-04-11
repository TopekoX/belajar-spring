package com.topekox.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.topekox.spring.hibernate.entity.Instructor;
import com.topekox.spring.hibernate.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

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
			
			// get the instructor detail object
			int id=9;
			
			InstructorDetail instructorDetail =
					session.get(InstructorDetail.class, id);
			
			// print the instructor detail
			System.out.println("Istructor Detail : " + instructorDetail);
			
			// now lets delete the instructor detail
			System.out.println("Delete intructordetail: " + instructorDetail);
			
			// remove the associated object reference
			// break bi-directional link
			instructorDetail.getInstructor().setInstructorDetail(null);
			
			session.delete(instructorDetail);
			
			// print the associated instructor
			System.out.println("Instructor yang terhubung : " + instructorDetail.getInstructor());
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!!!");

		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			// handle connection leak
			session.close();
			
			factory.close();
		}

	}

}
