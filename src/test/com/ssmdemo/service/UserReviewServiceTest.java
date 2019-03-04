package com.ssmdemo.service;

import com.ssmdemo.common.ServerResponse;
import com.ssmdemo.dao.entity.UserEntity;
import com.ssmdemo.dao.entity.UserReviewEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

public class UserReviewServiceTest {

    @Resource
    private UserReviewService userReviewService;
    @Autowired
    private ServerResponse<List<UserReviewEntity>> userReviewEntityList;

    @Test
    public void getDocReviewByDocId() {
//        userReviewEntityList = userReviewService.getDocReviewByDocId("1");
//        System.out.println(userReviewEntityList);
    }

    @Test
    public void getDocMarkByDocId() {
    }
}