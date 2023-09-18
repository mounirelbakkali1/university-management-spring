package ma.youcode.schoolmanagementsystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "professors")
public class Professor extends AppUser {

    @OneToMany(mappedBy = "professor")
    @JsonIgnore
    private List<Course> teachingCourses;

    @Builder
    public Professor(Long id, String firstName, String lastName, Role role,
            Address address, List<Course> teachingCourses) {
        super(id, firstName, lastName, role, address);
        this.teachingCourses = teachingCourses;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + getId() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", role=" + getRole().getName() +
                ", address=" + getAddress() +
                '}';
    }

}
