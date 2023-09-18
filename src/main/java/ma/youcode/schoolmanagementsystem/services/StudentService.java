package ma.youcode.schoolmanagementsystem.services;

import ma.youcode.schoolmanagementsystem.dto.StudentDto;
import ma.youcode.schoolmanagementsystem.entities.Student;
import ma.youcode.schoolmanagementsystem.repositories.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Student addStudent(StudentDto student) {
        Student newStudent = modelMapper.map(student, Student.class);
        return studentRepository.save(newStudent);
    }

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> findStudent(Long studentId) {
        return studentRepository.findById(studentId);
    }

    public Optional<Student> updateStudent(Long studentId, StudentDto student) {
        Optional<Student> studentToUpdate = studentRepository.findById(studentId);
        if (studentToUpdate.isPresent()) {
            Student updatedStudent = studentToUpdate.get();
            updatedStudent.setFirstName(student.firstName());
            updatedStudent.setLastName(student.lastName());
            updatedStudent.setAddress(student.address());
            return Optional.of(studentRepository.save(updatedStudent));
        }
        return Optional.empty();
    }

    public Optional<Student> deleteStudent(Long studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        if (student.isPresent()) {
            studentRepository.deleteById(studentId);
            return student;
        }
        return Optional.empty();
    }
}
