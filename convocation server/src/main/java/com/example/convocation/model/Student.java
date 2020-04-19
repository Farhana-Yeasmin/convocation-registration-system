package com.example.convocation.model;

import lombok.*;

import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Student {


        private String id;
        private String name;
        private int batch;
        private Program program;
        private LocalDate admissionDate;
        private int creditCompleted;
        private double cgpa;
        private List<Course> registeredCourseList;
        private List<Grade> gradedCourseList;
        @Email
        private String email;

        public void calculateCGPA() {
            double totalGradePoints = 0;
            double totalCredits = 0;
            int creditCompleted = 0;

            for (Grade g : gradedCourseList) {
                totalGradePoints += (g.getGrade() * g.getCourse().getCreditHour());
                totalCredits += g.getCourse().getCreditHour();
                if (g.getGrade() > 0)
                    creditCompleted += g.getCourse().getCreditHour();

            }
            this.cgpa = totalGradePoints / totalCredits;
            this.creditCompleted = (int) creditCompleted;
        }
    }



