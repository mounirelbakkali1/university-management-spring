package ma.youcode.schoolmanagementsystem.repositories;

import ma.youcode.schoolmanagementsystem.entities.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long> {
}
