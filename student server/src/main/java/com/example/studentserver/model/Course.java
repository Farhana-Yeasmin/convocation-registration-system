package com.example.studentserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

        private String code;
        private String title;
        private double creditHour;
        private int programId;
        private String programTitle;

}
