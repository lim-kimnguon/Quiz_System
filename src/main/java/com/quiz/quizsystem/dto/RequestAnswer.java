package com.quiz.quizsystem.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class RequestAnswer {
    private String name;
    private int score;
    private boolean is_correct;
    private int question_id;

    public String getName() {
      return name;
    }
    public void setName(String name) {
      this.name = name;
    }
    public int getScore() {
      return score;
    }
    public void setScore(int score) {
      this.score = score;
    }
    public boolean getIs_correct() {
      return is_correct;
    }
    public void setIs_correct(boolean is_correct) {
      this.is_correct = is_correct;
    }
    public int getQuestion_id() {
      return question_id;
    }
    public void setQuestion_id(int question_id) {
      this.question_id = question_id;
    }


}
