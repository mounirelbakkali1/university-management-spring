package ma.youcode.schoolmanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.youcode.schoolmanagementsystem.entities.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {

}
