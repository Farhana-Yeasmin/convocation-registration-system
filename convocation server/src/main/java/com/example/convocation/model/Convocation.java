package com.example.convocation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Convocation {
    private int id;
    private Student student;
    private String payment;
    private String confirmation;

}