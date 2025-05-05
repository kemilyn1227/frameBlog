package com.descomplica.frameBlog.services.v2;

import java.util.List;

import com.descomplica.frameBlog.models.v2.UserV2;

public interface UserServiceV2 {
    UserV2  save (final UserV2 user);
    List<UserV2> getAll();

    UserV2 get(Long id);

    UserV2 update(Long id, UserV2 user);

    void delete(Long id);
}
