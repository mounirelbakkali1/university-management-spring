package ma.youcode.schoolmanagementsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.youcode.schoolmanagementsystem.entities.Professor;
import ma.youcode.schoolmanagementsystem.repositories.ProfessorRepository;

import java.util.Optional;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    @Autowired
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public Professor saveProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public Optional<Professor> findProfessor(Long id) {
        return professorRepository.findById(id);
    }
}
