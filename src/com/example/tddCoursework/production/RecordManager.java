package com.example.tddCoursework.production;

import java.util.ArrayList;
import java.util.UUID;

import com.example.tddCoursework.production.Student;
import com.example.tddCoursework.production.Module;

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

  public ArrayList<Student> getStudentByName(String search) {
    ArrayList<Student> searchResult = new ArrayList<>();
    for(Student s : students) {
      if(s.getName().equalsIgnoreCase(search))
        searchResult.add(s);
    }
    return searchResult;
  }

  public Student getStudentByID(UUID id) {
    for(Student s : students)
      if(s.getId() == id)
        return s;
    return null;
  }

  public void setStudentName(UUID id, String name) {
    getStudentByID(id).setName(name);
  }

  public void setStudentAddress(UUID id, String address) {
    getStudentByID(id).setPostalAddr(address);
  }

  public void setStudentAddModule(UUID id, Module module) {
    getStudentByID(id).addModule(module);
  }

  public Double getStudentAverageMark(UUID id) {
    return getStudentByID(id).getAverageMark();
  }



  public ArrayList<Student> getStudents() {
    return this.students;
  }
  
  public void addStudent(Student student) {
    this.students.add(student);
  }

}