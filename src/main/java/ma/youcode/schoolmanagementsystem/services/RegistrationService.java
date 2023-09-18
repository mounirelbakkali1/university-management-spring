package ma.youcode.schoolmanagementsystem.services;

import java.time.LocalDate;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import ma.youcode.schoolmanagementsystem.entities.Course;
import ma.youcode.schoolmanagementsystem.entities.Registration;
import ma.youcode.schoolmanagementsystem.repositories.RegistrationRepository;

@Service
@Slf4j
public class RegistrationService {

    @Autowired
    RegistrationRepository registrationRepository;

    public void addRegistration(Registration registration) {
        if (isRegistrationOpen(registration.getCourse())) {
            registrationRepository.save(registration);
            log.info("Registration is saved");
        } else {
            log.info("Registration is closed");
        }

    }

    private boolean isRegistrationOpen(Course course) {
        return course.getCalendar().getRegistrationEndDate().after(Date.valueOf(LocalDate.now()));
    }
}
