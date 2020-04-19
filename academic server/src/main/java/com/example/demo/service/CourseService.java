package com.example.demo.service;

import com.example.demo.exception.ResourceAlreadyExistsException;
import com.example.demo.exception.ResourceDoesNotExistException;
import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course findById(String code) throws ResourceDoesNotExistException {
        Optional<Course> optionalCourse = courseRepository.findById(code);
        if (optionalCourse.isPresent()) {
            return optionalCourse.get();
        } else throw new ResourceDoesNotExistException(code + "");
    }


    public List<Course> findAll() {
        List<Course> courseList = courseRepository.findAll();
        return courseList;
    }
    
    public Course insert(Course course) throws ResourceAlreadyExistsException {
        Optional<Course> optionalCourse = courseRepository.findById(course.getCode());
        if (optionalCourse.isPresent()) {
            throw new ResourceAlreadyExistsException(course.getCode() + "");
        }
        return courseRepository.save(course);
    }

    public boolean deleteById(String code) throws ResourceDoesNotExistException {
        Optional<Course> optionalCourse = courseRepository.findById(code);
        if (optionalCourse.isPresent()) {
            courseRepository.deleteById(code);
        } else throw new ResourceDoesNotExistException(code + "");
        return true;
    }
    public boolean deleteAll() {
        courseRepository.deleteAll();
        return true;
    }

    public Course update(String code, Course course) throws ResourceDoesNotExistException {
        Optional<Course> optionalCourse = courseRepository.findById(code);
        if (optionalCourse.isPresent()) {
            course.setCode(code);
            return courseRepository.save(course);
        } else throw new ResourceDoesNotExistException(code + "");
    }
}