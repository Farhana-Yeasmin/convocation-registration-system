package com.example.demo.service;

import com.example.demo.exception.ResourceAlreadyExistsException;
import com.example.demo.exception.ResourceDoesNotExistException;
import com.example.demo.model.Program;
import com.example.demo.repository.ProgramRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramService {
    private ProgramRepository programRepository;


    public ProgramService(ProgramRepository programRepository)
    {
        this.programRepository =programRepository;
    }
    public Program findById(int id) throws ResourceDoesNotExistException {
        Optional<Program> optionalProgram = programRepository.findById(id);
        if (optionalProgram.isPresent()) {
            return optionalProgram.get();
        } else throw new ResourceDoesNotExistException(id + "");
    }
    public List<Program> findAll() {
        List<Program> programList = programRepository.findAll();
        return programList;
    }
    public Program insert(Program program) throws ResourceAlreadyExistsException {
        Optional<Program> optionalProgram = programRepository.findById(program.getId());
        if (optionalProgram.isPresent()) {
            throw new ResourceAlreadyExistsException(program.getId() + "");
        }
        return programRepository.save(program);
    }

    public boolean deleteById(int id) throws ResourceDoesNotExistException {
        Optional<Program> optionalProgram = programRepository.findById(id);
        if (optionalProgram.isPresent()) {
            programRepository.deleteById(id);
        } else throw new ResourceDoesNotExistException(id + "");
        return true;
    }

    public boolean deleteAll() {
        programRepository.deleteAll();
        return true;
    }


    public Program update(int id, Program program) throws ResourceDoesNotExistException {
        Optional<Program> optionalProgram = programRepository.findById(id);
        if (optionalProgram.isPresent()) {
            program.setId(id);
            return programRepository.save(program);
        } else throw new ResourceDoesNotExistException(id + "");
    }
}