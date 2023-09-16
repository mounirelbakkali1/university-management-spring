package ma.youcode.schoolmanagementsystem;

import ma.youcode.schoolmanagementsystem.services.CourseService;
import ma.youcode.schoolmanagementsystem.services.ProfessorService;
import ma.youcode.schoolmanagementsystem.services.RegistrationService;
import ma.youcode.schoolmanagementsystem.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

/*	@Bean
	@Order(10)
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
			Cours cours_2 = Cours.builder()
					.name("Java")
					.department(Department.builder().name("Java").build())
					.professor(professor)
					.calendar(
							Calendar.builder().starDate(Date.valueOf("2023-09-01")).endDate(Date.valueOf("2024-07-30"))
									.registrationEndDate(Date.valueOf("2023-09-20")).holdays(2).build())
					.build();
			Cours cours_3 = Cours.builder()
					.name("Hibernate")
					.department(Department.builder().name("Java").build())
					.professor(professor)
					.calendar(
							Calendar.builder().starDate(Date.valueOf("2023-09-01")).endDate(Date.valueOf("2024-07-30"))
									.registrationEndDate(Date.valueOf("2023-09-20")).holdays(9).build())
					.build();

			courseService.addCourse(cours);
			courseService.addCourse(cours_2);
			courseService.addCourse(cours_3);
			studentService.addStudent(student);

		};
	}

	@Bean
	@Order(9)
	CommandLineRunner runner() {
		return args -> {

			Student student = studentService.addStudent(Student.builder()
					.firstName("Rachid")
					.lastName("Daoudi")
					.role(Role.builder().name("STUDENT").build())
					.build());

			Optional<Cours> cours = courseService.findCourseByName("Java");

			if (cours.isPresent()) {
				registrationService.addRegistration(Registration.builder()
						.cours(cours.get())
						.student(student)
						.registrationDate(Date.valueOf("2021-01-01"))
						.build());
			}
		};
	}*/
}
