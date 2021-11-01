package africa.semicolon.hostelManagementSystem.data.repositories;

import africa.semicolon.hostelManagementSystem.data.Models.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

class StudentRepositoryTest {
    private Repository repository;

    @BeforeEach
    void setUp() {
        repository = new StudentRepository();
    }
    @AfterEach
    void tearDown() {
        repository = null;
    }

    @Test
    void save() {
        Student student = new Student();
        student.setFirstName("Confidence");
        student.setLastName("Ti");
        student.setMatricNumber("Mat111");
        student.setUserName("IyawoPastor");
        student.setPassword("I Love Jesu222");
        //when
        Student savedStudent=(Student) repository.save(student);
        //assert
        assertThat(savedStudent, is(student));
    }

    @Test
    void findById() {
        Student student = new Student();
        student.setFirstName("Confidence");
        student.setLastName("Ti");
        student.setMatricNumber("Mat111");
        student.setUserName("IyawoPastor");
        student.setPassword("I Love Jesu222");
        //given
        repository.save(student);
        //when
        Student returnedStudent = (Student)repository.findById("Mat111");
        assertThat(returnedStudent, is(student));
    }

    @Test
    void findByName() {
//        Student student = new Student();
//        student.setFirstName("Confidence");
//        student.setLastName("Ti");
//        student.setMatricNumber("Mat111");
//        student.setUserName("IyawoPastor");
//        student.setPassword("I Love Jesu222");
//        //given
//        repository.save(student);
//        //when
//        Student returnedStudent = (Student)repository.findByName("Confidence");
//        assertThat(returnedStudent, is(student));
    }

    @Test
    void deleteById() {
        Student student = new Student();
        student.setFirstName("Confidence");
        student.setLastName("Ti");
        student.setMatricNumber("Mat111");
        student.setUserName("IyawoPastor");
        student.setPassword("I Love Jesu222");
        //given
        repository.save(student);
        //when
        repository.delete("Mat111");
        Student deletedStudent = (Student)repository.findById("Mat111");
        //assert
        assertThat(deletedStudent, is(nullValue()));
    }

    @Test
    void testDeleteByObject() {
        Student student = new Student();
        student.setFirstName("Confidence");
        student.setLastName("Ti");
        student.setMatricNumber("Mat111");
        student.setUserName("IyawoPastor");
        student.setPassword("I Love Jesu222");
        //given
        repository.save(student);
        //when
        repository.delete(student);
        Student deletedStudent = (Student)repository.findById("Mat111");
        //assert
        assertThat(deletedStudent, is(nullValue()));
    }

    @Test
    void findAll() {
        Student student1 = new Student();
        student1.setFirstName("Confidence");
        student1.setLastName("Ti");
        student1.setMatricNumber("Mat111");
        student1.setUserName("IyawoPastor");
        student1.setPassword("I Love Jesu222");
        //given
        repository.save(student1);

        Student student2 = new Student();
        student2.setFirstName("Confidence");
        student2.setLastName("Ti");
        student2.setMatricNumber("Mat222");
        student2.setUserName("IyawoPastor");
        student2.setPassword("I Love Jesu222");
        //given
        repository.save(student2);

        List<Object>allStudent = repository.findAll();
        //assert
        assertThat(allStudent.size(), is(2));
        assertThat(allStudent,contains(student1,student2));
    }
}