package com.example.tddCoursework.production;

public class Module {
  private String code;
  private String title;
  private Integer mark;

  public Module(String code, String title, Integer mark) {
    this.code = code;
    this.title = title;
    this.mark = mark;
  }

  @Override
  public String toString() {
    return String.format("%s %s (%d/100)", code, title, mark);
  }

  public String getCode() {
    return this.code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Integer getMark() {
    return this.mark;
  }

  public void setMark(Integer mark) {
    this.mark = mark;
  }


}