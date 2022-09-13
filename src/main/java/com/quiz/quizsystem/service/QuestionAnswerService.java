package com.quiz.quizsystem.service;

import com.quiz.quizsystem.dto.RequestQuestionAnswer;
import com.quiz.quizsystem.model.QuestionAnswer;
import com.quiz.quizsystem.repository.QuestionAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionAnswerService {

    @Autowired
    private QuestionAnswerRepository questionAnswerRepository;

    public List<QuestionAnswer> getAll() {
        return this.questionAnswerRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Optional<QuestionAnswer> getById(int id) {
        return this.questionAnswerRepository.findById(id);
    }

    public QuestionAnswer addQuestionAnswer(RequestQuestionAnswer requestQuestionAnswer) {

        QuestionAnswer questionAnswer = new QuestionAnswer();

        questionAnswer.setName(requestQuestionAnswer.getName());
        questionAnswer.setScore(requestQuestionAnswer.getScore());
        questionAnswer.setOrder_number(requestQuestionAnswer.getOrder_number());
        questionAnswer.setAnswer_id(requestQuestionAnswer.getAnswer_id());
        questionAnswer.setUser_id(requestQuestionAnswer.getUser_id());

        return this.questionAnswerRepository.save(questionAnswer);
    }

    public void deleteQuestionAnswer(int id) {
        this.questionAnswerRepository.deleteById(id);
    }
}
