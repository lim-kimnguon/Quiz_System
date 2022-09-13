package com.quiz.quizsystem.controller;

import com.quiz.quizsystem.dto.RequestQuestionAnswer;
import com.quiz.quizsystem.model.QuestionAnswer;
import com.quiz.quizsystem.service.QuestionAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/questionAnswer")
public class QuestionAnswerController {

    @Autowired
    private QuestionAnswerService questionAnswerService;

    @GetMapping("/get")
    public List<QuestionAnswer> getQuestionAnswer() {
        return this.questionAnswerService.getAll();
    }

    @GetMapping("/getBy/{id}")
    public Optional<QuestionAnswer> getById(@PathVariable int id) {
        return this.questionAnswerService.getById(id);
    }

    @PostMapping("/add")
    public void addQuestionAnswer(@RequestBody RequestQuestionAnswer requestQuestionAnswer) {
        this.questionAnswerService.addQuestionAnswer(requestQuestionAnswer);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteQuestionAnswer(@PathVariable int id) {
        this.questionAnswerService.deleteQuestionAnswer(id);
    }
}
