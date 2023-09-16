package ma.youcode.schoolmanagementsystem.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 50, nullable = false, unique = true)
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private Department department;

    @OneToMany(mappedBy = "cours", cascade = CascadeType.MERGE)
    private List<Registration> registrations;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Professor professor;

    @ManyToOne(cascade = CascadeType.ALL)
    private Calendar calendar;

}
