package com.descomplica.frameBlog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.descomplica.frameBlog.models.User;

@Repository

public interface UserRepository extends JpaRepository<User, Long>{

    User findByUsername(String login);



}
