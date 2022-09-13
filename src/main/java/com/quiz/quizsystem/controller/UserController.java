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

import com.quiz.quizsystem.dto.RequestUser;
import com.quiz.quizsystem.model.User;
import com.quiz.quizsystem.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping
  List<User> List(){
    return userService.ListUser();
  }

  @GetMapping("/{id}")
  User ListByUserId(@PathVariable Integer id){
    return userService.getUser(id);
  }

  @PostMapping
  void CreateUser(@RequestBody RequestUser requestuser){
    User user = new User();

    user.setFirst_name(requestuser.getFirst_name());
    user.setLast_name(requestuser.getLast_name());
    user.setEmail(requestuser.getEmail());
    user.setPassword(requestuser.getPassword());
    user.setGender(requestuser.getGender());
    user.setPhone(requestuser.getPhone());
    user.setRoleId(requestuser.getRoleid());
    user.setPositionId(requestuser.getPositionid());
    user.setQuizdate(requestuser.getQuizdate());

    userService.saveUser(user);
  }

  @PutMapping("/{id}")
  ResponseEntity<?> UpdateUser(@RequestBody RequestUser requestuser, @PathVariable Integer id){
      try{
        User exiPosition = userService.getUser(id);
        User user = new User();

        user.setId(id);
        user.setFirst_name(requestuser.getFirst_name());
        user.setLast_name(requestuser.getLast_name());
        user.setEmail(requestuser.getEmail());
        user.setPassword(requestuser.getPassword());
        user.setGender(requestuser.getGender());
        user.setPhone(requestuser.getPhone());
        user.setRoleId(requestuser.getRoleid());
        user.setPositionId(requestuser.getPositionid());
        user.setQuizdate(requestuser.getQuizdate());

        userService.saveUser(user);

        return new ResponseEntity<>(HttpStatus.OK);
      }catch(NoSuchElementException e){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }

  }

  @DeleteMapping("/{id}")
  ResponseEntity<?> DeleteUser(@PathVariable Integer id){
    try{
      
      userService.deleteUser(id);

      return new ResponseEntity<>(HttpStatus.OK);
    }catch(NoSuchElementException e){
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

}
