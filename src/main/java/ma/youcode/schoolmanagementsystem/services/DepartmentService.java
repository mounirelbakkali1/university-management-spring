package ma.youcode.schoolmanagementsystem.services;


import ma.youcode.schoolmanagementsystem.entities.Department;
import ma.youcode.schoolmanagementsystem.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    public Optional<Department> findDepartment(Long departmentId) {
        return departmentRepository.findById(departmentId);
    }
}
