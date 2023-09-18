package ma.youcode.schoolmanagementsystem.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.youcode.schoolmanagementsystem.entities.Course;

@Repository
public interface CoursRepository extends JpaRepository<Course, Long> {

    Optional<Course> findCoursByName(String coursName);
}
