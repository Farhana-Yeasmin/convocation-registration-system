package com.example.studentserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Program {



        private int id;
        private String title;
        private String coordinatorId;
        private double minCGPA;
        private int minCredit;
        private List<Course> courseList;


}
