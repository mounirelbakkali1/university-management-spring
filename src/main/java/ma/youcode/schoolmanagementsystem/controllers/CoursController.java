package ma.youcode.schoolmanagementsystem.controllers;

import lombok.extern.slf4j.Slf4j;
import ma.youcode.schoolmanagementsystem.entities.Cours;
import ma.youcode.schoolmanagementsystem.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@Slf4j
public class CoursController {

    private CourseService courseService;

    @Autowired
    public CoursController(CourseService courseService){
        this.courseService = courseService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cours createCours(@RequestBody Cours cours){
        log.info("Creating new cours");
        return courseService.addCourse(cours);
    }


    @GetMapping
    public List<Cours> getAllCourses(){
        return courseService.getAllCourses();
    }

}
