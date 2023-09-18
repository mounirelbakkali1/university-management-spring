package ma.youcode.schoolmanagementsystem.controllers;

import jakarta.validation.Valid;
import ma.youcode.schoolmanagementsystem.dto.StudentDto;
import ma.youcode.schoolmanagementsystem.entities.Student;
import ma.youcode.schoolmanagementsystem.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentController {




        private final StudentService studentService;

        @Autowired
        public StudentController(StudentService studentService){
            this.studentService = studentService;
        }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public ResponseEntity<Student> createStudent(@RequestBody @Valid StudentDto student){
            return ResponseEntity.ok(studentService.addStudent(student));
        }


        @GetMapping
        public ResponseEntity<List<StudentDto>> getAllStudents(){
            return ResponseEntity.ok(studentService.findAllStudents().stream().map(Student::toDto).collect(Collectors.toList()));
        }


        @GetMapping("/{studentId}")
        public ResponseEntity<Student> getStudentById(@PathVariable Long studentId){
            Optional<Student> student = studentService.findStudent(studentId);
            return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }


        @PutMapping("/{studentId}")
        public ResponseEntity<Student> updateStudent(@PathVariable Long studentId, @RequestBody StudentDto student){
            Optional<Student> updatedStudent = studentService.updateStudent(studentId, student);
            return updatedStudent.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }


        @DeleteMapping("/{studentId}")
        public ResponseEntity<Student> deleteStudent(@PathVariable Long studentId){
            Optional<Student> student = studentService.deleteStudent(studentId);
            return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }
}
