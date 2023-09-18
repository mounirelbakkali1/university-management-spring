package ma.youcode.schoolmanagementsystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Builder
@Table(name = "academic_calendar")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "calendar_seq_gen")
    @SequenceGenerator(name = "calendar_seq_gen", sequenceName = "calendar_id_seq")
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date starDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Temporal(TemporalType.DATE)
    private Date registrationEndDate;

    private int holidays;
}
