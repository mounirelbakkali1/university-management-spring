package ma.youcode.schoolmanagementsystem;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ma.youcode.schoolmanagementsystem.entities.Calendar;
import ma.youcode.schoolmanagementsystem.entities.Cours;
import ma.youcode.schoolmanagementsystem.entities.Department;
import ma.youcode.schoolmanagementsystem.entities.Professor;
import ma.youcode.schoolmanagementsystem.entities.Registration;
import ma.youcode.schoolmanagementsystem.entities.Role;
import ma.youcode.schoolmanagementsystem.entities.Student;
import ma.youcode.schoolmanagementsystem.services.CourseService;
import ma.youcode.schoolmanagementsystem.services.ProfessorService;
import ma.youcode.schoolmanagementsystem.services.RegistrationService;
import ma.youcode.schoolmanagementsystem.services.StudentService;

@SpringBootApplication
public class SchoolManagementSystemApplication {

	@Autowired
	private CourseService courseService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private ProfessorService professorService;

	@Autowired
	private RegistrationService registrationService;

	public static void main(String[] args) {
		SpringApplication.run(SchoolManagementSystemApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			Student student = Student.builder()

					.firstName("Mounir")
					.lastName("El Bakkali")
					.role(Role.builder().name("STUDENT").build())
					.build();

			Professor professor = Professor.builder().firstName("Anas").lastName("Reda")
					.role(Role.builder().name("TEACHER").build()).build();

			professorService.saveProfessor(professor);

			Cours cours = Cours.builder()
					.name("React")
					.department(Department.builder().name("JS").build())
					.professor(professor)
					.calendar(
							Calendar.builder().starDate(Date.valueOf("2023-10-01")).endDate(Date.valueOf("2024-07-30"))
									.registrationEndDate(Date.valueOf("2023-10-20")).holdays(6).build())
					.build();
			cours = courseService.addCourse(cours);
			student = studentService.addStudent(student);

			Student _student = studentService.getAllStudents().get(0);
			Cours _cours = courseService.getCourseByName("React");
			Registration registration = new Registration();
			registration.setCours(_cours);
			registration.setStudent(_student);
			registration.setRegistrationDate(Date.valueOf("2021-09-01"));
			registrationService.addRegistration(registration);

		};
	}
}
