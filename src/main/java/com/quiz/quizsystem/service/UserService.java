package com.quiz.quizsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.quiz.quizsystem.model.User;
import com.quiz.quizsystem.repository.UserRepository;

@Service
@Transactional
public class UserService {
  
  @Autowired
  private UserRepository userRepository;

  public List<User> ListUser(){
    return userRepository.findByStatusFalse(Sort.by(Sort.Order.desc("id")));
  }

  public void saveUser(User user){
    userRepository.save(user);
  }


  public User getUser(Integer id){
    return userRepository.findById(id).get();
  }
  
  public int deleteUser(Integer id){
    return userRepository.DeleteUser(id);
  }
}
