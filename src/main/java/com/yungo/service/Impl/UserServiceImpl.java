package com.yungo.service.Impl;

import com.yungo.dao.UserDao;
import com.yungo.entity.User;
import com.yungo.service.UserService;
import com.yungo.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisKeyValueTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by cx on 17-8-3.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

  /*  @Autowired
    private RedisKeyValueTemplate redisTemplate;
*/
    @Autowired
    private UserDao dao;
/*
    @Autowired
    private RedisTemplate template;*/

 /*   public User findByUsername(String username) {
        return dao.findByUsername(username);
    }*/

  @Override
  public void createUser(User user) {
    dao.create(user.getNickname(), MyUtil.md5(user.getPassword()),user.getPhone());
  }

  @Override
  public User findByPhone(String phone) {
    return dao.findByPhone(Long.parseLong(phone));
  }

    /*@Override
    public User findBySessionId(String sessionId) {
     *//*这里是存redis*//*
      User user = (User) template.opsForValue().get(sessionId);
        return user;
    }*/


}
