package ma.youcode.schoolmanagementsystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.youcode.schoolmanagementsystem.dto.StudentDto;

import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "students")
@Getter
@Setter
public class Student extends AppUser {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Registration> registrations;

    @Builder
    public Student(Long id, String firstName, String lastName, Role role,
            Address address, List<Registration> registrations) {
        super(id, firstName, lastName, role, address);
        this.registrations = registrations;
    }


    public Student toEntity(StudentDto studentDto) {
        return Student.builder()
                .firstName(studentDto.firstName())
                .lastName(studentDto.lastName())
                .address(studentDto.address())
                .build();
    }

    public StudentDto toDto() {
        return new StudentDto(
                this.getFirstName(),
                this.getLastName(),
                this.getAddress()
        );
    }

    @Override
    public String toString() {
        return "Student{" +
                    "id=" + getId() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", role=" + getRole().getName() +
                ", address=" + getAddress() + '\'' +
                "}";
    }
}
