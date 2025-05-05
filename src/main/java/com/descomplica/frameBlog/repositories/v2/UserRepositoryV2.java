package com.descomplica.frameBlog.repositories.v2;

import org.springframework.data.jpa.repository.JpaRepository;

import com.descomplica.frameBlog.models.v2.UserV2;

public interface UserRepositoryV2 extends JpaRepository<UserV2,Long>  {

    UserV2 findByUsername(String login);

}
