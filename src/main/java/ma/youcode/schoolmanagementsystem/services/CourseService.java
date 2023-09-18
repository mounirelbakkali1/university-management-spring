package ma.youcode.schoolmanagementsystem.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import ma.youcode.schoolmanagementsystem.dto.CourseDto;
import ma.youcode.schoolmanagementsystem.entities.Calendar;
import ma.youcode.schoolmanagementsystem.entities.Department;
import ma.youcode.schoolmanagementsystem.entities.Professor;
import ma.youcode.schoolmanagementsystem.utils.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.youcode.schoolmanagementsystem.entities.Course;
import ma.youcode.schoolmanagementsystem.repositories.CourseRepository;

@Service
public class CourseService {

    private CourseRepository courseRepository;
    private DepartmentService departmentService;
    private ProfessorService professorService;
    private CalendarService calendarService;
    @Autowired
    public CourseService(CourseRepository courseRepository, DepartmentService departmentService, ProfessorService professorService, CalendarService calendarService) {
        this.courseRepository = courseRepository;
        this.departmentService = departmentService;
        this.professorService = professorService;
        this.calendarService = calendarService;
    }

    public Course addCourse(CourseDto course) {
        Department department = departmentService.findDepartment(course.idDepartment()).orElseThrow(() -> new NotFoundException("Department not found"));
        Professor professor = professorService.findProfessor(course.idProfessor()).orElseThrow(() -> new NotFoundException("Professor not found"));
        Calendar calendar = calendarService.findCalendar(course.idCalendar()).orElseThrow(() -> new NotFoundException("Calendar not found"));
        Course newCourse = new Course();
        newCourse.setName(course.name());
        newCourse.setDepartment(department);
        newCourse.setProfessor(professor);
        newCourse.setCalendar(calendar);
        return courseRepository.save(newCourse);
    }

    public Optional<Course> findCourseByName(String courseName) {
        return courseRepository.findCourseByName(courseName);
    }

    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> findCourse(Long courseId) {
        return courseRepository.findById(courseId);
    }

    public Optional<Course> updateCourse(Long courseId, CourseDto course) {
        Course courseToUpdate = courseRepository.findById(courseId).orElseThrow(() -> new NotFoundException("Course not found"));
        Department department = departmentService.findDepartment(course.idDepartment()).orElseThrow(() -> new NotFoundException("Department not found"));
        Professor professor = professorService.findProfessor(course.idProfessor()).orElseThrow(() -> new NotFoundException("Professor not found"));
        Calendar calendar = calendarService.findCalendar(course.idCalendar()).orElseThrow(() -> new NotFoundException("Calendar not found"));
        courseToUpdate.setName(course.name());
        courseToUpdate.setDepartment(department);
        courseToUpdate.setProfessor(professor);
        courseToUpdate.setCalendar(calendar);
        return Optional.of(courseRepository.save(courseToUpdate));
    }

    public Optional<Course> deleteCourse(Long courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        course.ifPresent(courseRepository::delete);
        return course;
    }
}
