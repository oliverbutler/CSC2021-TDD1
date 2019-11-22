package com.example.tddCoursework;

import java.util.ArrayList;
import java.time.LocalDate;

import com.example.tddCoursework.Student;
import com.example.tddCoursework.Module;

public class RecordManager {
  private ArrayList<Student> students = new ArrayList<>();

  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();
    for(Student s : students) {
      str.append(s);
    }
    return str.toString();
  }

  public ArrayList<Student> getStudents() {
    return this.students;
  }

  public void setStudents(ArrayList<Student> students) {
    this.students = students;
  }
  
  public void addStudent(Student student) {
    this.students.add(student);
  }

}