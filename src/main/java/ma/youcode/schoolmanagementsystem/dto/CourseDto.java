package ma.youcode.schoolmanagementsystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CoursDto(@NotBlank @NotNull String name, Long idDepartment, Long idProfessor, Long idCalendar) {
}
