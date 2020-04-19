package com.example.humanresourceserver.controller;

import com.example.humanresourceserver.exception.ResourceAlreadyExistsException;
import com.example.humanresourceserver.exception.ResourceDoesNotExistException;
import com.example.humanresourceserver.model.Employe;
import com.example.humanresourceserver.service.EmployeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeController {
    private EmployeService employeeService;

    public EmployeController(EmployeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public ResponseEntity<List<Employe>> getAll() {
        List<Employe> employeeList = employeeService.findAll();
        return ResponseEntity.ok(employeeList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employe> getById(@PathVariable String id) {
        try {
            Employe employee = employeeService.findById(id);
            return ResponseEntity.ok(employee);

        } catch (ResourceDoesNotExistException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Employe> insert(@RequestBody Employe employe) {
        try {
            Employe insertedEmployee = employeeService.insert(employe);
            return ResponseEntity.status(HttpStatus.CREATED).body(insertedEmployee);
        } catch (ResourceAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        try {
            boolean deleted = employeeService.deleteById(id);
            return ResponseEntity.ok(id);
        } catch (ResourceDoesNotExistException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employe> update(@PathVariable String id, @RequestBody Employe employee) {
        try {
            Employe updatedEmployee = employeeService.update(id, employee);
            return ResponseEntity.ok(updatedEmployee);
        } catch (ResourceDoesNotExistException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
