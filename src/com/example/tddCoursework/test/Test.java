package com.example.tddCoursework.test;

import java.time.LocalDate;

import com.example.tddCoursework.production.Student;
import com.example.tddCoursework.production.RecordManager;
import com.example.tddCoursework.production.Module;

public class Test {
  public static void main(String[] args) {
    Student oliver = new Student("Oliver Butler", "oliver@oliverbutler.uk", "Laurel Cottage", "Computer Science", LocalDate.of(2018, 9, 20));
    oliver.addModule(new Module("CSC2023", "Algorithms", 83));
    oliver.addModule(new Module("CSC2021", "Software Engineering", 69));
    

    Student jack = new Student("Jack Tweddell", "email@jack.com", "Durham", "Computer Science", LocalDate.of(2017, 9, 23));
    jack.addModule(new Module("DURA2021", "Some module", 98));


    RecordManager record = new RecordManager();
    record.addStudent(oliver);
    record.addStudent(jack);

    System.out.println(record.getStudentByID(jack.getId()));
  }
}