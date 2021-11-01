package africa.semicolon.hostelManagementSystem.services;

import africa.semicolon.hostelManagementSystem.data.Models.Student;
import africa.semicolon.hostelManagementSystem.dto.RegisterStudentRequest;

public interface StudentService {

    Student registerStudent(RegisterStudentRequest studentDto);
}
