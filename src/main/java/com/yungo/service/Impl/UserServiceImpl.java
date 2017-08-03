package com.yungo.service.Impl;

import com.yungo.dao.UserDao;
import com.yungo.entity.User;
import com.yungo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cx on 17-8-3.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao dao;

    @Override
    public User findByUsername(String username) {
        return dao.findByUsername(username);
    }
}
