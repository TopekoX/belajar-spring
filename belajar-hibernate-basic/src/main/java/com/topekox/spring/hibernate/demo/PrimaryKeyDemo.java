package com.topekox.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.topekox.spring.hibernate.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = 
				new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save Java Object
			System.out.println("create 3 student object");
			Student student1 = new Student("Sasa", "Gray", "sasa@tutorialtimposu.com");
			Student student2 = new Student("Aldi", "FF", "aldi@tutorialtimposu.com");
			Student student3 = new Student("Aldo", "Ganteng", "aldo@tutorialtimposu.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the students");
			session.save(student1);
			session.save(student2);
			session.save(student3);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done");

		} finally {
			factory.close();
		}

	}

}
