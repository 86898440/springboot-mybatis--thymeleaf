package com.yungo.service;

import com.yungo.entity.User;

/**
 * Created by cx on 17-8-3.
 */

public interface UserService {
    void createUser(User user);

    User findByPhone(String phone);
  /*  User findByUsername(String username);

     User findBySessionId(String id);
*/
}
