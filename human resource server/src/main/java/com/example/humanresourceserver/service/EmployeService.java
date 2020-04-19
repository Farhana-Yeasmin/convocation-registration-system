package com.example.humanresourceserver.service;

import com.example.humanresourceserver.exception.ResourceAlreadyExistsException;
import com.example.humanresourceserver.exception.ResourceDoesNotExistException;
import com.example.humanresourceserver.model.Employe;
import com.example.humanresourceserver.repository.EmployeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeService {
    private EmployeRepository employeRepository;

    public EmployeService(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    public Employe findById(String id) throws ResourceDoesNotExistException {
        Optional<Employe> optionalEmployee = employeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            return optionalEmployee.get();
        } else throw new ResourceDoesNotExistException(id + "");
    }

    public List<Employe> findAll() {
        List<Employe> employeeList = employeRepository.findAll();
        return employeeList;
    }


    public Employe insert(Employe employee) throws ResourceAlreadyExistsException {
        Optional<Employe> optionalEmployee = employeRepository.findById(employee.getId());
        if (optionalEmployee.isPresent()) {
            throw new ResourceAlreadyExistsException(employee.getId() + "");
        }
        return employeRepository.save(employee);
    }
    public boolean deleteById(String id) throws ResourceDoesNotExistException {
        Optional<Employe> optionalEmployee = employeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            employeRepository.deleteById(id);
        } else throw new ResourceDoesNotExistException(id + "");
        return true;
    }
    public boolean deleteAll() {
        employeRepository.deleteAll();
        return true;
    }

    public Employe update(String id, Employe employee) throws ResourceDoesNotExistException {
        Optional<Employe> optionalEmployee = employeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            employee.setId(id);
            return employeRepository.save(employee);
        } else throw new ResourceDoesNotExistException(id + "");
    }
}
