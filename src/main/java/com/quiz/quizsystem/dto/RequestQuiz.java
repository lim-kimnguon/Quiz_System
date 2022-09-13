package com.quiz.quizsystem.dto;


public class RequestQuiz {
  
  private String name;
  private String description;
  private int quiz_level_id;
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public int getQuiz_level_id() {
    return quiz_level_id;
  }
  public void setQuiz_level_id(int quiz_level_id) {
    this.quiz_level_id = quiz_level_id;
  }



}
