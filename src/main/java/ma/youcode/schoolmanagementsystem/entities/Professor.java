package ma.youcode.schoolmanagementsystem.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "professors")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Professor extends User {

    @OneToMany(mappedBy = "professor")
    private List<Cours> teachingCourses;

    @Builder
    public Professor(Long id, String firstName, String lastName, Role role,
            Address address, List<Cours> teachingCourses) {
        super(id, firstName, lastName, role, address);
        this.teachingCourses = teachingCourses;
    }

}
