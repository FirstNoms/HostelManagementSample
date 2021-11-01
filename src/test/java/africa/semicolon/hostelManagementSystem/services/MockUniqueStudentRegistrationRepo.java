package africa.semicolon.hostelManagementSystem.services;

import africa.semicolon.hostelManagementSystem.data.Models.Student;
import africa.semicolon.hostelManagementSystem.data.repositories.Repository;

import java.util.List;

public class MockUniqueStudentRegistrationRepo implements Repository {

    @Override
    public Object findById(String id) {
        return null;
    }

    @Override
    public Object findByName(String name) {
        return null;
    }

    @Override
    public Object save(Object o) {
        return o;
    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<Object> findAll() {
        return null;
    }
}
