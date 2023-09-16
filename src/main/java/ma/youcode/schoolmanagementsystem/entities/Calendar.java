package ma.youcode.schoolmanagementsystem.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Table(name = "academic_calendar")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calendar {

    @Id
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date starDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Temporal(TemporalType.DATE)
    private Date registrationEndDate;

    private int holdays;
}
