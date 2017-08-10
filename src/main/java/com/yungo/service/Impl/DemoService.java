
package com.yungo.service.Impl;

import com.yungo.dao.UserDao;
import com.yungo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


/**
 * Created by cx on 17-8-4.
 */


    public class DemoService {

    @Autowired
    private UserDao dao;

    @Cacheable(value = "usercache",keyGenerator = "wiselyKeyGenerator")
        public User findByPhone(String username){
            System.out.println("无缓存的时候调用这里");
            return null;
        }

/*   @Cacheable(value = "addresscache",keyGenerator = "wiselyKeyGenerator")
        public Address findAddress(Long id,String province,String city){
            System.out.println("无缓存的时候调用这里");
            return new Address(id,province,city);
        }*/


}

