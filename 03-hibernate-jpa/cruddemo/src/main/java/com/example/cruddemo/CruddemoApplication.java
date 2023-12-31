package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			//readStudent(studentDAO);
			//readAllStudents(studentDAO);
			//getStudentsByLastName(studentDAO);
			updateStudent(studentDAO);
		};
	}

	private void updateStudent(StudentDAO studentDAO) {
		// Get Student from DB
		int studentId = 5;
		Student s = studentDAO.findById(studentId);
		if (s == null) {
			System.out.println("No student found with id: " + studentId);
			return;
		}

		// Update object
		s.setFirstName("Alberto");
		// Update record in Database
		studentDAO.update(s);

		// Display updated Object Student 's'
		System.out.println("Updated student record:");
		System.out.println(s);

	}

	private void getStudentsByLastName(StudentDAO studentDAO) {
		List<Student> listStudents = studentDAO.findByLastName("Mottaa");
		System.out.println("List of students by Lastname:");
		for (Student s : listStudents) {
			System.out.println(s);
		}
	}

	private void readAllStudents(StudentDAO studentDAO) {
		List<Student> listStudents = studentDAO.findAll();
		System.out.println("List result:");
		for (Student s : listStudents) {
			System.out.println(s);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		Student s = new Student("Mayra", "Chavez", "mayra@gmail.com");
		System.out.println("New student created");
		System.out.println(s);

		studentDAO.save(s);
		System.out.println("New student successfully stored in Database");
		System.out.println(s);
		int idStudent = s.getId();

		Student retrievedStudent = studentDAO.findById(idStudent);
		System.out.println("Retrieved student from Database");
		System.out.println(retrievedStudent);
	}

	private void createStudent(StudentDAO studentDAO) {
		Student s = new Student("Angel", "Motta", "angel@gmail.com");
		System.out.println("Student object created:");
		System.out.println(s);
		studentDAO.save(s);
		System.out.println("Student created with ID: " + s.getId() + " -> successfully saved in Database");
	}
}
