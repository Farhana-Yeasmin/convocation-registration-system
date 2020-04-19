package com.example.convocation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Program {

        private int id;
        private String coordinatorId;
        private String title;
        private double minCGPA;
        private int minCredit;
        private List<Course> courseList;


}
