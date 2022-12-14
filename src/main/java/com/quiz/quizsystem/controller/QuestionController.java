package com.quiz.quizsystem.controller;

import java.io.Console;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.quizsystem.dto.RequestQuestion;
import com.quiz.quizsystem.model.Question;
import com.quiz.quizsystem.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
  @Autowired
  private QuestionService questionService;


  @GetMapping
  List<Question> List(){
    return questionService.ListAllQuestion();
  }

  @GetMapping("/{id}")
  Question ListById(@PathVariable Integer id){
    return questionService.getQuestion(id);
  }

  @GetMapping("/in/{quizid}")
  List<Question> ListQuestionByQuizId(@PathVariable Integer quizid){
    return questionService.getQuestionByQuizId(quizid);
  }

  @GetMapping("/notin/{quizid}")
  List<Question> ListQuestionNoInQuizId(@PathVariable Integer quizid){
    return questionService.getQuestionNotInQuizId(quizid);
  }

  @PostMapping
  void CreateQuestion(@RequestBody RequestQuestion requestQuestion){
    Question question = new Question();

    question.setName(requestQuestion.getName());
    question.setTimeout(requestQuestion.getTimeout());
    question.setScore(requestQuestion.getScore());
    question.setQuestion_level_id(requestQuestion.getQuestion_level_id());
    question.setQuestion_type_id(requestQuestion.getQuestion_type_id());

    questionService.saveQuestion(question);
  }

  @PutMapping("/{id}")
  ResponseEntity<?> UpdateQuestionLevel(@RequestBody RequestQuestion requestQuestion, @PathVariable Integer id){
      try{
        Question exitQuestionLevel = questionService.getQuestion(id);
        Question question = new Question();
        question.setId(id);
        
        question.setName(requestQuestion.getName());
        question.setTimeout(requestQuestion.getTimeout());
        question.setScore(requestQuestion.getScore());
        question.setQuestion_level_id(requestQuestion.getQuestion_level_id());
        question.setQuestion_type_id(requestQuestion.getQuestion_type_id());

        questionService.saveQuestion(question);
        return new ResponseEntity<>(HttpStatus.OK);
      }catch(NoSuchElementException e){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }

  }

  @DeleteMapping("/{id}")
  ResponseEntity<?> deleteQuestionResponseEntity(@PathVariable Integer id){
    try{
      questionService.deleteQuestion(id);
      return new ResponseEntity<>(HttpStatus.OK);
    }catch(NoSuchElementException e){
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
