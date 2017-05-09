package com.yana.home.repository;

import com.yana.home.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Admin on 27.04.2017.
 */
public interface UserRepo extends JpaRepository<User,Integer> {
//  @Query("select u from User u where u.login=:login")
//  User findByLogin(@Param("login") String login);
  User findByLogin(String login);

}
