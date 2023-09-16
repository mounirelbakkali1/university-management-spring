package ma.youcode.schoolmanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.youcode.schoolmanagementsystem.entities.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
