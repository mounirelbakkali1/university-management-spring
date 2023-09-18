package ma.youcode.schoolmanagementsystem.services;

import ma.youcode.schoolmanagementsystem.entities.Calendar;
import ma.youcode.schoolmanagementsystem.repositories.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CalendarService {

    private CalendarRepository calendarRepository;

    @Autowired
    public CalendarService(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    public Optional<Calendar> findCalendar(Long id) {
        return calendarRepository.findById(id);
    }
}
