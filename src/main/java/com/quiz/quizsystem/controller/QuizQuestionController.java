package com.quiz.quizsystem.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.quiz.quizsystem.dto.RequestMultiQuizQuestion;
import com.quiz.quizsystem.dto.RequestQuizQuestion;
import com.quiz.quizsystem.model.QuizQuestion;
import com.quiz.quizsystem.service.QuizQuestionService;

@RestController
@RequestMapping("/quizquestion")
public class QuizQuestionController {

  @Autowired
  private QuizQuestionService quizquestionService;

  @GetMapping
  public List<QuizQuestion> listData(){
    return quizquestionService.Listall();
  }

  @PostMapping
  public void AddQuestionToQuiz(@RequestBody RequestQuizQuestion requestQuizQuestion){
    quizquestionService.AddQuestionToQuiz(requestQuizQuestion);
  }

  @DeleteMapping("/{quiz_id}/{question_id}")
  public void RemoveQuestionFromQuiz(@PathVariable Integer quiz_id,@PathVariable Integer question_id ){
    quizquestionService.DeleteQuestionFromQuiz(quiz_id,question_id);
  }

  @PostMapping("/multiple")
  public void AddMultipleQuestion(@RequestBody RequestMultiQuizQuestion requestMultiQuizQuestion){
    quizquestionService.addMultiQuestionToQuiz(requestMultiQuizQuestion.getQuiz_id(),requestMultiQuizQuestion.getQuestion_id());
  }

  @PostMapping("/deletemultiple")
  void DeleteMultipleQuestion(@RequestBody RequestMultiQuizQuestion requestMultiQuizQuestion) {
    try{
        quizquestionService.DeleteMutipleQuestionFromQuiz(requestMultiQuizQuestion.getQuiz_id(),requestMultiQuizQuestion.getQuestion_id());
    
    
    }catch(NoSuchElementException e){
      System.out.println(e);
    }
  }

}
