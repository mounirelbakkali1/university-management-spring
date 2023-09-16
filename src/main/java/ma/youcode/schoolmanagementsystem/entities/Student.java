package ma.youcode.schoolmanagementsystem.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Table(name = "students")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Student extends User {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<Registration> registrations;

    @Builder
    public Student(Long id, String firstName, String lastName, Role role,
            Address address, List<Registration> registrations) {
        super(id, firstName, lastName, role, address);
        this.registrations = registrations;
    }

}
