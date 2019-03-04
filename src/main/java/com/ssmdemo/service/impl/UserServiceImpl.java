package com.ssmdemo.service.impl;

import com.ssmdemo.common.ServerResponse;
import com.ssmdemo.dao.UserDao;
import com.ssmdemo.dao.entity.UserEntity;
import com.ssmdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author superman
 * @date
 * */
    @Service
    public class UserServiceImpl implements UserService {

        @Resource
        private UserDao userDao;
        @Autowired
        private UserEntity userEntity;


        //todo 对于register之类的可以使用依赖注入的设计方式完成降低耦合的效果

        @Override
        public ServerResponse<UserEntity> checkLogin(UserEntity checkUserEntity){
            userEntity = userDao.selectByid(checkUserEntity.getId());
            if(userEntity != null && checkUserEntity.getPassword().equals(userEntity.getPassword())
                    && checkUserEntity.getUsername().equals(userEntity.getUsername())){
                return ServerResponse.createBySuccess("success login", checkUserEntity);
            }
            return ServerResponse.createByErrorMessage("login failed");
        }

        @Override
        public ServerResponse<UserEntity> addUser(int id, String username, String password) {

            if(username != null && password != null) {
                 userDao.addUser(id, username, password);
                 userEntity.setId(id);
                 userEntity.setUsername(username);
                 userEntity.setPassword(password);
                 return ServerResponse.createBySuccess("add success in serviceImpl", userEntity);
            }
            return ServerResponse.createByErrorMessage("add failed in serviceImpl");
        }

        @Override
        public ServerResponse<UserEntity> updateUser(UserEntity userEntity) {
            userEntity = userDao.selectByid(userEntity.getId());
            if(userEntity != null){
                userDao.update(userEntity.getId(), userEntity.getUsername(), userEntity.getPassword());
                return ServerResponse.createBySuccess("update success", userEntity);
            }else{
                return ServerResponse.createByErrorMessage("update wrong");
            }
        }

        @Override
        public ServerResponse<UserEntity> deleteUser(int id) {
            userEntity = userDao.selectByid(id);
            if(userEntity != null){
                userDao.delete(id);
                return ServerResponse.createBySuccess("delete success", userEntity);
            }else{
                return ServerResponse.createByErrorMessage("delete wrong");
            }

        }
    }

