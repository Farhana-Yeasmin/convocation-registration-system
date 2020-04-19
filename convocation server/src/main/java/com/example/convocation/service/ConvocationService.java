package com.example.convocation.service;

import com.example.convocation.exception.ResourceAlreadyExistsException;
import com.example.convocation.exception.ResourceDoesNotExistException;
import com.example.convocation.model.Convocation;
import com.example.convocation.repository.ConvocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConvocationService {
    private ConvocationRepository convocationRepository;

    public ConvocationService(ConvocationRepository convocationRepository) {
        this.convocationRepository = convocationRepository;
    }

    public Convocation findById(int id) throws ResourceDoesNotExistException {
        Optional<Convocation> optionalConvocation = convocationRepository.findById(id);
        if (optionalConvocation.isPresent()) {
            return optionalConvocation.get();
        } else throw new ResourceDoesNotExistException(id + "");
    }


    public List<Convocation> findAll() {
        List<Convocation> convocationList = convocationRepository.findAll();
        return convocationList;
    }

    public Convocation insert(Convocation convocation) throws ResourceAlreadyExistsException {
        Optional<Convocation> optionalConvocation = convocationRepository.findById(convocation.getId());
        if (optionalConvocation.isPresent()) {
            throw new ResourceAlreadyExistsException(convocation.getId() + "");
        }
        return convocationRepository.save(convocation);
    }

    public boolean deleteById(int id) throws ResourceDoesNotExistException {
        Optional<Convocation> optionalConvocation = convocationRepository.findById(id);
        if (optionalConvocation.isPresent()) {
            convocationRepository.deleteById(id);
        } else throw new ResourceDoesNotExistException(id + "");
        return true;
    }


    public boolean deleteAll() {
        convocationRepository.deleteAll();
        return true;
    }


    public Convocation update(int id, Convocation convocation) throws ResourceDoesNotExistException {
        Optional<Convocation> optionalConvocation = convocationRepository.findById(id);
        if (optionalConvocation.isPresent()) {
            convocation.setId(id);
            return convocationRepository.save(convocation);
        } else throw new ResourceDoesNotExistException(id + "");
    }
}