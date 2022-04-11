package com.topekox.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.topekox.spring.hibernate.entity.Course;
import com.topekox.spring.hibernate.entity.Instructor;
import com.topekox.spring.hibernate.entity.InstructorDetail;
import com.topekox.spring.hibernate.entity.Review;
import com.topekox.spring.hibernate.entity.Student;

public class CreateCourseAndStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			// create a course
			Course course = new Course("Pacman - How To Scoew One Milion Points");
			
			// save the course
			System.out.println("\nSaving the course...");
			session.save(course);
			System.out.println("Save the course: " + course);
			
			// create the student
			Student student1 = new Student("John", "Doe", "john@tutorialtimposu.com");
			Student student2 = new Student("Mary", "Public", "mary@tutorialtimposu.com");
			
			// add student to course			
			course.addStudent(student1);
			course.addStudent(student2);
			
			//save the students
			System.out.println("\nSaving students....");
			session.save(student1);
			session.save(student2);
			System.out.println("Saved student: " + course.getStudents());
						
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
