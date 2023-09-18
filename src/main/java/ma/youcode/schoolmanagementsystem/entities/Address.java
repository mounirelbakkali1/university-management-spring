package ma.youcode.schoolmanagementsystem.entities;

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
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addresses_seq_gen")
    @SequenceGenerator(name = "addresses_seq_gen", sequenceName = "addresses_id_seq")
    private Long id;
    private String street;
    private String city;
    private String state;
    private String zipCode;

}
