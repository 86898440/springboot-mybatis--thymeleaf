package com.yungo.service;

import com.yungo.entity.User;

/**
 * Created by cx on 17-8-3.
 */

public interface UserService {
    User findByUsername(String username);
}
