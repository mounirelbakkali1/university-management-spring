package ma.youcode.schoolmanagementsystem.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.youcode.schoolmanagementsystem.entities.Cours;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Long> {

    Optional<Cours> findCoursByName(String coursName);
}
