package ma.youcode.schoolmanagementsystem.services;

import ma.youcode.schoolmanagementsystem.TestEnvironmentConfiguration;
import ma.youcode.schoolmanagementsystem.dto.CourseDto;
import ma.youcode.schoolmanagementsystem.entities.*;
import ma.youcode.schoolmanagementsystem.repositories.CourseRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestEnvironmentConfiguration.class)
class CourseServiceTest {


    @Autowired
    private WebTestClient webTestClient ;

    @MockBean
    private CourseRepository courseRepository;


    @MockBean
    private DepartmentService departmentService;

    @MockBean
    private ProfessorService professorService;

    @MockBean
    private CalendarService calendarService;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addCourse() {
        Professor professor = Professor.builder().id(1L).firstName("Anas").lastName("Reda")
                .role(Role.builder().id(1L).name("TEACHER").build()).build();
        Department department = Department.builder().id(1L).name("IT").build();
        Calendar calendar = Calendar.builder().id(1L).build();
        Course course = Course.builder().id(1L).name("INTRO TO JAVA").professor(professor).department(department).calendar(calendar).build();

        Mockito.when(courseRepository.save(Mockito.any(Course.class))).thenReturn(course);
        Mockito.when(departmentService.findDepartment(1L)).thenReturn(Optional.of(department));
        Mockito.when(professorService.findProfessor(1L)).thenReturn(Optional.of(professor));
        Mockito.when(calendarService.findCalendar(1L)).thenReturn(Optional.of(calendar));
        CourseDto courseDto = new CourseDto("INTRO TO JAVA",1L,1L,1L);
        Course expectedCourse = webTestClient
                .post()
                .uri("/courses")
                .bodyValue(courseDto)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Course.class).value(c-> assertThat(c).isNotNull())
                .returnResult().getResponseBody();

        // other assertions
        assertThat(expectedCourse).isNotNull();
        assertThat(expectedCourse.getId()).isEqualTo(1L);
        assertThat(expectedCourse.getName()).isEqualTo("INTRO TO JAVA");
        assertThat(expectedCourse.getProfessor().getId()).isEqualTo(1L);
        assertThat(expectedCourse.getDepartment().getId()).isEqualTo(1L);
        assertThat(expectedCourse.getCalendar().getId()).isEqualTo(1L);


    }

    @Test
    void findCourseByName() {
        Professor professor = Professor.builder().id(1L).firstName("Anas").lastName("Reda")
                .role(Role.builder().id(1L).name("TEACHER").build()).build();
        Department department = Department.builder().id(1L).name("IT").build();
        Calendar calendar = Calendar.builder().id(1L).build();
        Course course = Course.builder().id(1L).name("Java").professor(professor).department(department).calendar(calendar).build();

        Mockito.when(courseRepository.findCourseByName("Java")).thenReturn(Optional.ofNullable(course));
        Mockito.when(departmentService.findDepartment(1L)).thenReturn(Optional.of(department));
        Mockito.when(professorService.findProfessor(1L)).thenReturn(Optional.of(professor));
        Mockito.when(calendarService.findCalendar(1L)).thenReturn(Optional.of(calendar));
        Course ExpCourse = webTestClient.get()
                .uri("/courses?courseName=Java")
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(Course.class).value(c -> assertThat(c).isNotNull())
                .returnResult().getResponseBody();
        // assertions
        assertThat(ExpCourse).isNotNull();
        assertThat(ExpCourse.getId()).isEqualTo(1L);
        assertThat(ExpCourse.getName()).isEqualTo("Java");
        assertThat(ExpCourse.getProfessor().getId()).isEqualTo(1L);
        assertThat(ExpCourse.getDepartment().getId()).isEqualTo(1L);
        assertThat(ExpCourse.getCalendar().getId()).isEqualTo(1L);
    }

    @Test
    void getAllCourses() {
        Professor professor = Professor.builder().id(1L).firstName("Anas").lastName("Reda")
                .role(Role.builder().id(1L).name("TEACHER").build()).build();
        Department department = Department.builder().id(1L).name("IT").build();
        Calendar calendar = Calendar.builder().id(1L).build();
        Course course = Course.builder().id(1L).name("Java").professor(professor).department(department).calendar(calendar).build();

        Mockito.when(courseRepository.findAll()).thenReturn(List.of(course));

        List<Course> ExpCourses = webTestClient
                .get()
                .uri("/courses/all")
                .exchange()
                .expectStatus().is2xxSuccessful()
                    .expectBodyList(Course.class).value(c -> assertThat(c).isNotNull())
                .returnResult().getResponseBody();
        assertThat(ExpCourses).isNotNull();
        assertThat(ExpCourses.size()).isEqualTo(1);
        assertThat(ExpCourses.get(0).getId()).isEqualTo(1L);


    }
}