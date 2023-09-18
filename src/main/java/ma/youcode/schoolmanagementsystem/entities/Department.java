package ma.youcode.schoolmanagementsystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Table(name = "departments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departments_seq_gen")
    @SequenceGenerator(name = "departments_seq_gen", sequenceName = "departments_id_seq")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Course> courses;


    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '}' ;
    }
}
