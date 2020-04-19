package com.example.humanresourceserver.repository;

import com.example.humanresourceserver.model.Employe;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeRepository extends MongoRepository<Employe, String> {
}
