package africa.semicolon.hostelManagementSystem.services;

import africa.semicolon.hostelManagementSystem.data.Models.Student;
import africa.semicolon.hostelManagementSystem.data.repositories.StudentRepository;
import africa.semicolon.hostelManagementSystem.dto.RegisterStudentRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceImplTest {
    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() {
        studentService= null;
    }

    @Test
    void registerUniqueStudent() {
        studentService = new StudentServiceImpl(new MockUniqueStudentRegistrationRepo());
        RegisterStudentRequest registerStudentRequest = new RegisterStudentRequest();
        registerStudentRequest.setFirstName("Titobi");
        registerStudentRequest.setLastName("Ligali");
        registerStudentRequest.setMatricNumber("MAT419");
        registerStudentRequest.setPassword("securedPassword");
        registerStudentRequest.setUserName("tiNoStrings");
        //when
        Student savedStudent= studentService.registerStudent(registerStudentRequest);
        //assert
        assertThat(savedStudent.getMatricNumber(),is("MAT419"));
    }

    @Test
    void registerNonUniqueMatricNumberThrowsException(){
        studentService = new StudentServiceImpl(new MockUniqueStudentRegistrationRepo());
        RegisterStudentRequest registerStudentRequest = new RegisterStudentRequest();
        registerStudentRequest.setFirstName("Titobi");
        registerStudentRequest.setLastName("Ligali");
        registerStudentRequest.setMatricNumber("MAT419");
        registerStudentRequest.setPassword("securedPassword");
        registerStudentRequest.setUserName("tiNoStrings");
        studentService.registerStudent(registerStudentRequest);
        studentService= new StudentServiceImpl(new MockDuplicateRegistrationRepo());

        assertThrows(IllegalArgumentException.class,()->studentService.registerStudent(registerStudentRequest));
    }

    @Test
    void registerNonUniqueUsernameThrowsException(){
        studentService = new StudentServiceImpl(studentRepository);
        Mockito.when(studentRepository.save(any(Student.class))).thenReturn(new Student());

        RegisterStudentRequest registerStudentRequest = new RegisterStudentRequest();
        registerStudentRequest.setFirstName("Titobi");
        registerStudentRequest.setLastName("Ligali");
        registerStudentRequest.setMatricNumber("MAT419");
        registerStudentRequest.setPassword("securedPassword");
        registerStudentRequest.setUserName("tiNoStrings");

      studentService.registerStudent(registerStudentRequest);

        Mockito.when(studentRepository.findByName("tiNoStrings")).thenReturn(new Student());

        assertThrows(IllegalArgumentException.class,()->studentService.registerStudent(registerStudentRequest));
    }
}