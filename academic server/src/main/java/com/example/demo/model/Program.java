package com.example.demo.model;

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

//        public Program(int id, String title, String coordinatorId, double minCGPA, int minCredit, List<Course> courseList) {
//                this.id = id;
//                this.title = title;
//                this.coordinatorId = coordinatorId;
//                this.minCGPA = minCGPA;
//                this.minCredit = minCredit;
//                this.courseList = courseList;
//        }
//
//        public int getId() {
//                return id;
//        }
//
//        public String getTitle() {
//                return title;
//        }
//
//        public String getCoordinatorId() {
//                return coordinatorId;
//        }
//
//        public double getMinCGPA() {
//                return minCGPA;
//        }
//
//        public int getMinCredit() {
//                return minCredit;
//        }
//
//        public List<Course> getCourseList() {
//                return courseList;
//        }
//
//        public void setId(int id) {
//                this.id = id;
//        }
//
//        public void setTitle(String title) {
//                this.title = title;
//        }
//
//        public void setCoordinatorId(String coordinatorId) {
//                this.coordinatorId = coordinatorId;
//        }
//
//        public void setMinCGPA(double minCGPA) {
//                this.minCGPA = minCGPA;
//        }
//
//        public void setMinCredit(int minCredit) {
//                this.minCredit = minCredit;
//        }
//
//        public void setCourseList(List<Course> courseList) {
//                this.courseList = courseList;
//        }
//
//        @Override
//        public String toString() {
//                return "Program{" +
//                        "id=" + id +
//                        ", title='" + title + '\'' +
//                        ", coordinatorId='" + coordinatorId + '\'' +
//                        ", minCGPA=" + minCGPA +
//                        ", minCredit=" + minCredit +
//                        ", courseList=" + courseList +
//                        '}';
//        }
}
