package com.example.tddCoursework;

import com.example.tddCoursework.RecordManager;
import com.example.tddCoursework.Student;
import com.example.tddCoursework.Module;

import java.time.LocalDate;

public class Test {
  public static void main(String[] args) {
    Student oliver = new Student("Oliver Butler", "oliver@oliverbutler.uk", "Laurel Cottage", "Computer Science", LocalDate.of(2018, 9, 20));
    oliver.addModule(new Module("CSC2023", "Algorithms", 83));
    oliver.addModule(new Module("CSC2021", "Software Engineering", 69));
    
    RecordManager record = new RecordManager();
    record.addStudent(oliver);

    System.out.println( record.getStudentAverageMark(oliver.getId()));
  }
}