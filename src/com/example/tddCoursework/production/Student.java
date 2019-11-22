package com.example.tddCoursework.production;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import com.example.tddCoursework.production.Module;

public class Student {
  final private UUID id;
  private String name;
  private String email;
  private String postalAddr;
  private String courseTitle;
  private LocalDate dateEnrolled;
  private ArrayList<Module> modules = new ArrayList<>();

  public Student(String name, String email, String postalAddr, String courseTitle, LocalDate dateEnrolled) {
    this.id = UUID.randomUUID();
    this.name = name;
    this.email = email;
    this.postalAddr = postalAddr;
    this.courseTitle = courseTitle;
    this.dateEnrolled = dateEnrolled;
  }

  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();
    Integer paddingLength = ( 40 - name.length() ) / 2;
    str.append("=".repeat(paddingLength));
    str.append(String.format("[ %s ]", name));
    str.append("=".repeat(paddingLength));
    str.append(String.format("\nID %s\nEmail: %s\nAddress: %s\nCourse Title: %s\nDate Enrolled: %s\n", id, email, postalAddr, courseTitle, dateEnrolled));
    str.append("Modules: \n");
    for(Module m : modules) {
      str.append("  " + m + "\n");
    }
    str.append("\n");
    return str.toString();
  }

  public Double getAverageMark() {
    Double total = 0.0;
    for(Module m : modules)
      total += m.getMark();
    return total /= modules.size();
  }

  public UUID getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPostalAddr() {
    return this.postalAddr;
  }

  public void setPostalAddr(String postalAddr) {
    this.postalAddr = postalAddr;
  }

  public String getCourseTitle() {
    return this.courseTitle;
  }

  public void setCourseTitle(String courseTitle) {
    this.courseTitle = courseTitle;
  }

  public LocalDate getDateEnrolled() {
    return this.dateEnrolled;
  }

  public void setDateEnrolled(LocalDate dateEnrolled) {
    this.dateEnrolled = dateEnrolled;
  }

  public ArrayList<Module> getModules() {
    return this.modules;
  }

  public void addModule(Module module) {
    this.modules.add(module);
  }




}