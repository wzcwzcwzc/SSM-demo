package com.ssmdemo.service;

import com.ssmdemo.common.ServerResponse;
import com.ssmdemo.dao.entity.UserEntity;

public interface UserService {

    ServerResponse<UserEntity> addUser(int id, String username, String password);

    ServerResponse<UserEntity> updateUser(UserEntity userEntity);

    ServerResponse<UserEntity> deleteUser(int id);

    ServerResponse<UserEntity> checkLogin(UserEntity userEntity);

}
