package ma.youcode.schoolmanagementsystem.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.youcode.schoolmanagementsystem.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findStudentByFirstName(String firstName);
}
