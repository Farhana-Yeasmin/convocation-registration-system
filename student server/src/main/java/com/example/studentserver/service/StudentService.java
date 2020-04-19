package com.example.studentserver.service;
import com.example.studentserver.exception.ResourceAlreadyExistsException;
import com.example.studentserver.exception.ResourceDoesNotExistException;
import com.example.studentserver.model.Student;
import com.example.studentserver.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student findById(String id) throws ResourceDoesNotExistException {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            return optionalStudent.get();
        } else throw new ResourceDoesNotExistException(id + "");
    }

    public List<Student> findAll() {
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }


    public Student insert(Student student) throws ResourceAlreadyExistsException {
        Optional<Student> optionalStudent = studentRepository.findById(student.getId());
        if (optionalStudent.isPresent()) {
            throw new ResourceAlreadyExistsException(student.getId() + "");
        }
        return studentRepository.save(student);
    }

    public boolean deleteById(String id) throws ResourceDoesNotExistException {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            studentRepository.deleteById(id);
        } else throw new ResourceDoesNotExistException(id + "");
        return true;
    }

    public boolean deleteAll() {
        studentRepository.deleteAll();
        return true;
    }


    public Student update(String id, Student student) throws ResourceDoesNotExistException {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            student.setId(id);
            return studentRepository.save(student);
        } else throw new ResourceDoesNotExistException(id + "");
    }

}

