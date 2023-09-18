package ma.youcode.schoolmanagementsystem.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "registrations")
@Getter
@Setter
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "registrations_seq_gen")
    @SequenceGenerator(name = "registrations_seq_gen", sequenceName = "registrations_id_seq")
    private Long id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;

    @Temporal(TemporalType.DATE)
    private Date registrationDate;

    @Override
    public String toString() {
        return "Registration{" +
                "id=" + id +
                ", student=" + String.join(" ",student.getFirstName(), student.getLastName()) +
                ", course=" + course.getName() +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
