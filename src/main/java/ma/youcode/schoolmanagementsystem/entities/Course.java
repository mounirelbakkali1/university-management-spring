package ma.youcode.schoolmanagementsystem.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cours")
public class Cours {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "courses_seq_gen")
    @SequenceGenerator(name = "courses_seq_gen", sequenceName = "courses_id_seq")
    private Long id;
    @Column(name = "name", length = 50, nullable = false, unique = true)
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private Department department;

    @OneToMany(mappedBy = "cours", cascade = CascadeType.MERGE)
    private List<Registration> registrations;

    @ManyToOne(cascade = CascadeType.ALL)
    private Professor professor;

    @ManyToOne(cascade = CascadeType.ALL)
    private Calendar calendar;

}
