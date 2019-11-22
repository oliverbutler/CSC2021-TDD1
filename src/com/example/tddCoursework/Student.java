package com.example.tddCoursework;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import com.example.tddCoursework.Module;

public class Student {
  final private UUID id;
  private String postalAddr;
  private String email;
  private String courseTitle;
  private LocalDate dateEnrolled;
  private ArrayList<Module> modules;

  public Student(String postalAddr, String email, String courseTitle, LocalDate dateEnrolled, ArrayList<Module> modules) {
    this.id = UUID.randomUUID();
    this.postalAddr = postalAddr;
    this.email = email;
    this.courseTitle = courseTitle;
    this.dateEnrolled = dateEnrolled;
    this.modules = modules;
  }

  public UUID getId() {
    return this.id;
  }

  public String getPostalAddr() {
    return this.postalAddr;
  }

  public void setPostalAddr(String postalAddr) {
    this.postalAddr = postalAddr;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
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

  public void setModules(ArrayList<Module> modules) {
    this.modules = modules;
  }




}