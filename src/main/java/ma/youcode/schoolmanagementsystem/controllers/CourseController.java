package ma.youcode.schoolmanagementsystem.controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import ma.youcode.schoolmanagementsystem.dto.CourseDto;
import ma.youcode.schoolmanagementsystem.entities.Course;
import ma.youcode.schoolmanagementsystem.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
@Slf4j
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Course createCourse(@RequestBody @Valid CourseDto course){
        log.info("Creating new course..");
        Course addedCourse = courseService.addCourse(course);

        return addedCourse;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Course>> getAllCourses(){
        return ResponseEntity.ok(courseService.findAllCourses());
    }


    @GetMapping("/{courseId}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long courseId){
        Optional<Course> course = courseService.findCourse(courseId);
        return course.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @GetMapping
    public ResponseEntity<Course> getCourseByName(@RequestParam String courseName){
        Optional<Course> course = courseService.findCourseByName(courseName);
        return course.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PutMapping("/{courseId}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long courseId, @RequestBody CourseDto course){
        Optional<Course> updatedCourse = courseService.updateCourse(courseId, course);
        return updatedCourse.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{courseId}")
    public ResponseEntity<Course> deleteCourse(@PathVariable Long courseId){
        Optional<Course> course = courseService.deleteCourse(courseId);
        return course.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
