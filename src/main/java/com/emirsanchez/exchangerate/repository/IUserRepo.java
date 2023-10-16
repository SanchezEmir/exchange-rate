package com.emirsanchez.exchangerate.repository;

import com.emirsanchez.exchangerate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User, Integer> {

    //FROM User WHERE username = ?
    //Derived Query
    User findOneByUsername(String username);
}
