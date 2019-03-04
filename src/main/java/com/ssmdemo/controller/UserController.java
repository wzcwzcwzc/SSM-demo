package com.ssmdemo.controller;

import com.ssmdemo.common.ServerResponse;
import com.ssmdemo.dao.entity.UserEntity;
import com.ssmdemo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * @author Barry Wang
 * */

@Component

@Controller

@RequestMapping(value = "/user")

public class UserController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserEntity userEntity;



    @RequestMapping(value = "/checkUser.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<UserEntity> checkUser(@RequestParam("id") String id, @RequestParam("username") String username, @RequestParam("password") String password){

        userEntity.setId(Integer.parseInt(id));
        userEntity.setUsername(username);
        userEntity.setPassword(password);

        if(userEntity != null){
            ServerResponse<UserEntity> response = userService.checkLogin(userEntity);
            return response;
        }else{
            return ServerResponse.createByErrorMessage("checkUser error in controller");
        }
    }


//    @RequestMapping(value = "/delUserById.do", method = RequestMethod.POST)
//    @ResponseBody
//    public ServerResponse<UserEntity> checkUserById(int id){
//        return new ServerResponse<UserEntity>(userService.deleteUser(id));
//    }


    @RequestMapping(value = "/addUser.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<UserEntity> addUser(@RequestParam("userid") String userid, @RequestParam("username") String username, @RequestParam("password") String password) throws IOException {

        userEntity.setId(Integer.parseInt(userid));
        userEntity.setUsername(username);
        userEntity.setPassword(password);

        if(userEntity != null){
            ServerResponse<UserEntity> response = userService.addUser(Integer.parseInt(userid), username, password);
            return response;
        }else{
            return ServerResponse.createByErrorMessage("add fail in controller");
        }
    }

    @RequestMapping(value = "/delUserById.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<UserEntity> delUser(@RequestParam("user_id") String user_id) throws IOException{

        if(user_id != null){
            ServerResponse<UserEntity> response = userService.deleteUser(Integer.parseInt(user_id));
            System.out.println("Msg:"+response.getMsg()+"\tstatus:"+response.getStatus()+"\tdata:"+response.getData());
            return response;
        }else{
            System.out.println("delete fail");
            return ServerResponse.createByErrorMessage("delete wrong");
        }
    }

    @RequestMapping(value = "/updateUser.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<UserEntity> updateUser(@RequestParam("user_id") String user_id, @RequestParam("username") String username, @RequestParam("password") String password) throws IOException{

        userEntity.setId(Integer.parseInt(user_id));
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        ServerResponse<UserEntity> response = userService.updateUser(userEntity);
        return response;
    }

//  使用Spring MVC 来接收前端传递到的数据。
//    //todo the return json value is ["id"=0, "username"="barry", "password"="123456"].
//    //get post put delete = search update add delete
//
//    @RequestMapping(value = "/checkUser.do", method = RequestMethod.POST)
//    @ResponseBody
//    public String checkUser(UserEntity userEntity, Model model){
//
//        userEntity = userService.checkLogin(userEntity.getId(), userEntity.getUsername(), userEntity.getPassword());
//        if (userEntity != null){
//            model.addAttribute("user", userEntity);
//            return "success";
//        } else{
//            return "fail";
//        }
//    }

}
