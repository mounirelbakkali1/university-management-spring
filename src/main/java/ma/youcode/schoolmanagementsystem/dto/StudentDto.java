package ma.youcode.schoolmanagementsystem.dto;

import ma.youcode.schoolmanagementsystem.entities.Address;

public record StudentDto(String firstName, String lastName, Address address) {
}
