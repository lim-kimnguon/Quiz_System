package com.quiz.quizsystem.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quiz.quizsystem.model.User;


@Repository
public interface UserRepository  extends JpaRepository<User,Integer>{
  
  List<User> findByStatusFalse(Sort sort);

  @Modifying
  @Query(value ="UPDATE quiz.users set is_delete=true where id= :id",nativeQuery = true)
  int DeleteUser(@Param("id") Integer id);

  


}
