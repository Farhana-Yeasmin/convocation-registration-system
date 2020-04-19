package com.example.convocation.repository;

import com.example.convocation.model.Convocation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConvocationRepository extends MongoRepository<Convocation,Integer> {
}
