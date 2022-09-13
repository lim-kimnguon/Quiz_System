package com.quiz.quizsystem.controller;

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

import com.quiz.quizsystem.dto.RequestName;
import com.quiz.quizsystem.model.QuestionType;
import com.quiz.quizsystem.service.QuestionTypeService;

@RestController
@RequestMapping("/question/type")
public class QuestionTypeController {
  
  @Autowired
  private QuestionTypeService questionTypeService;

  @GetMapping
  List<QuestionType> List(){
    return questionTypeService.ListAllQuestionType();
  }

  @GetMapping("/{id}")
  QuestionType ListById(@PathVariable Integer id){
    return questionTypeService.getQuestionType(id);
  }

  @PostMapping
  void CreateQuestionLevel(@RequestBody RequestName getName){
    QuestionType questionType = new QuestionType();
    questionType.setName(getName.getName());
    questionTypeService.saveQuestionType(questionType);
  }

  @PutMapping("/{id}")
  ResponseEntity<?> UpdateQuestionType(@RequestBody RequestName getName, @PathVariable Integer id){
      try{
        QuestionType exitQuestionLevel = questionTypeService.getQuestionType(id);
        QuestionType questionType = new QuestionType();
        questionType.setId(id);
        questionType.setName(getName.getName());
        questionTypeService.saveQuestionType(questionType);
        return new ResponseEntity<>(HttpStatus.OK);
      }catch(NoSuchElementException e){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }

  }
  @DeleteMapping("/{id}")
  ResponseEntity<?> DeleteQuestionType(@PathVariable Integer id){
    try{
      questionTypeService.deleteQuestionType(id);
      return new ResponseEntity<>(HttpStatus.OK);
    }catch(NoSuchElementException e){
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
