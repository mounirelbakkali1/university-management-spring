package ma.youcode.schoolmanagementsystem.services;

import ma.youcode.schoolmanagementsystem.TestEnvironmentConfiguration;
import ma.youcode.schoolmanagementsystem.entities.*;
import ma.youcode.schoolmanagementsystem.entities.Department;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.sql.Date;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestEnvironmentConfiguration.class)
class CourseServiceTest {


    @Autowired
    private WebTestClient webTestClient ;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addCourse() {
        Professor professor = Professor.builder().firstName("Anas").lastName("Reda")
                .role(Role.builder().name("TEACHER").build()).build();
        Cours cours = Cours.builder()
                .id(1L)
                .name("React")
                .department(Department.builder().name("JS").build())
                .professor(professor)
                .calendar(
                        Calendar.builder().starDate(Date.valueOf("2023-10-01")).endDate(Date.valueOf("2024-07-30"))
                                .registrationEndDate(Date.valueOf("2023-10-20")).holdays(6).build())
                .build();
        Cours expectedCours = webTestClient
                .post()
                .uri("/courses")
                .bodyValue(cours)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Cours.class).value(c-> assertThat(c).isNotNull())
                .returnResult().getResponseBody();

    }

    @Test
    void findCourseByName() {
    }

    @Test
    void getAllCourses() {

    }
}