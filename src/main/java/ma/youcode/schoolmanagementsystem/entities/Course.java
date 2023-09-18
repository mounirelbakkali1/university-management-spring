package ma.youcode.schoolmanagementsystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "courses")
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "courses_seq_gen")
    @SequenceGenerator(name = "courses_seq_gen", sequenceName = "courses_id_seq")
    private Long id;
    @Column(name = "name", length = 50, nullable = false, unique = true)
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private Department department;

    @OneToMany(mappedBy = "course", cascade = CascadeType.MERGE)
    @JsonIgnore
    private List<Registration> registrations;

    @ManyToOne(cascade = CascadeType.ALL)
    private Professor professor;

    @ManyToOne(cascade = CascadeType.ALL)
    private Calendar calendar;

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
