package com.quiz.quizsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.quiz.quizsystem.model.Question;
import com.quiz.quizsystem.repository.QuestionRepository;

@Service
@Transactional
public class QuestionService {
  @Autowired
    private QuestionRepository questionRepository;
  

    public List<Question> ListAllQuestion(){
      return questionRepository.findByDeleteFalse(Sort.by(Sort.Order.desc("id")));
    }


    public void saveQuestion(Question question){
      questionRepository.save(question);
    }
  
    public Question getQuestion(Integer id){
      return questionRepository.findById(id).get();
    }
    
    public int deleteQuestion(Integer id){
      return questionRepository.DeleteQuestion(id);
    }

    public List<Question> getQuestionByQuizId(Integer quizId){
       return questionRepository.findByQuizId(quizId);
    }

    public List<Question> getQuestionNotInQuizId(Integer quizId){
      return questionRepository.findAllQuestionNotInQuiz(quizId);
    }

}
