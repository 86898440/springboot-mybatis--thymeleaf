package com.yungo.config;

import com.yungo.entity.User;
import com.yungo.service.UserService;
import com.yungo.util.MyUtil;
import java.util.HashSet;
import java.util.Set;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by cx on 17-8-9.
 */

public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    private UserService service;


    //授权方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        if (null == principals) {
            throw new AuthenticationException("principals can not be null");
        }
// 获取当前登录的用户名
        String phone = (String) super.getAvailablePrincipal(principals);
        SimpleAuthorizationInfo sainfo = new SimpleAuthorizationInfo();
        User user = service.findByPhone(phone);
        String userroles = user.getRoles();
        Set roles = new HashSet();
        roles.add(userroles);
        sainfo.addRoles(roles);


//        List<String> roles = new ArrayList<String>();
//
//
//        String[] result = userName.split("_");
//
//
//        Map<String, Object> groupParams = new HashMap<String, Object>();
//        groupParams.put("orgCode", result[0]);
//        List<PunGroupVO> groups = groupService.queryResult("eqQueryList",
//                groupParams);
//        Map<String,Object> userParams = new HashMap<String, Object>();
//        userParams.put("userIdCardNumber", result[1]);
//        List<PunUserBaseInfoVO> users = userService.queryResult("eqQueryList",
//                userParams);
//        Map<String,Object> roleParams = new HashMap<String, Object>();
//        List<PunRoleInfoVO> roleVos = roleService.queryResult("queryByMember", roleParams);
//        for(PunRoleInfoVO vo : roleVos){
//            roles.add(vo.getRoleName());//角色
//            System.out.println("roleName:"+vo.getRoleName());
//        }
//
//// 给当前用户设置角色
//        info.addRoles(roles);
//        info.addStringPermission("user:create");
//// 给当前用户设置权限
//// info.addStringPermissions(permissions);
        return sainfo;
    }


    //验证方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String pwd =new String(token.getPassword());
        String phone = new String(token.getUsername());

        User user = service.findByPhone(phone);

        try {
            if(null!=user||user.getPassword().equals(MyUtil.md5(pwd))){
                return new SimpleAuthenticationInfo(token.getUsername(),token.getPassword(),this.getName());
            }/*
            Jedis resource = jedisPool.getResource();
            resource.set(user.getUserName(), user.getPassWord(),"NX", "EX", 60 * 60 * 24 * 30);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;


//        String nameAndOrgcode = token.getUsername();
//        String[] result = nameAndOrgcode.split("_");
//
//        Map<String, Object> groupParams = new HashMap<String, Object>();
//        groupParams.put("orgCode", result[0]);
//        List<PunGroupVO> groups = groupService.queryResult("eqQueryList",groupParams);//组信息
//
//        List<PunUserBaseInfoVO> users = userService.selectByIDCard(result[1]);//用户基础信息
//        Map<String, Object> memParams = new HashMap<String, Object>();
//        memParams.put("userId", users.get(0).getUserId());
//        memParams.put("groupId", groups.get(0).getGroupId());
//        List<PunMembershipVO> members = memberService.queryResult("eqQueryList",memParams);//身份资格
//        if(null != members && members.size()>0){
//            return new SimpleAuthenticationInfo(token.getUsername(),users.get(0).getUserPwd(),this.getName());
//        }else{
//            return null;
//        }
    }

}



