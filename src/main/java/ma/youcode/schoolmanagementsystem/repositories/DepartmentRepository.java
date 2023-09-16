package ma.youcode.schoolmanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.youcode.schoolmanagementsystem.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
