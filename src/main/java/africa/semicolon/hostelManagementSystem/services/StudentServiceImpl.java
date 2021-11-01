package africa.semicolon.hostelManagementSystem.services;

import africa.semicolon.hostelManagementSystem.data.Models.Student;
import africa.semicolon.hostelManagementSystem.data.repositories.Repository;
import africa.semicolon.hostelManagementSystem.dto.RegisterStudentRequest;

/**>>> DTO(Data Transfer Object)types:
    *- response DTO
    *- request DTO
    *-
 *
 */

public class StudentServiceImpl implements StudentService{
    private Repository studentRepository;
    public StudentServiceImpl(Repository repository){
        this.studentRepository = repository;
    }

    @Override
    public Student registerStudent(RegisterStudentRequest studentDto){
        Student optionalStudent= (Student)studentRepository.findById(studentDto.getMatricNumber());
        if(optionalStudent!= null){
            throw new IllegalArgumentException("Matric number is not unique");
        }
        optionalStudent=(Student) studentRepository.findByName(studentDto.getUserName());
        if(optionalStudent!=null){
            throw new IllegalArgumentException("Username is not unique");
        }

        Student newStudent = new Student();
        newStudent.setFirstName(studentDto.getFirstName());
        newStudent.setLastName(studentDto.getLastName());
        newStudent.setPassword(studentDto.getPassword());
        newStudent.setUserName(studentDto.getUserName());
        newStudent.setMatricNumber(studentDto.getMatricNumber());
        return (Student)studentRepository.save(newStudent);
    }
}
