package ma.youcode.schoolmanagementsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.youcode.schoolmanagementsystem.entities.Cours;
import ma.youcode.schoolmanagementsystem.repositories.CoursRepository;

@Service
public class CourseService {

    @Autowired
    private CoursRepository coursRepository;

    public Cours addCourse(Cours cours) {
        return coursRepository.save(cours);
    }

    public Optional<Cours> findCourseByName(String coursName) {
        return coursRepository.findCoursByName(coursName);
    }

    public List<Cours> getAllCourses() {
        return coursRepository.findAll();
    }
}
