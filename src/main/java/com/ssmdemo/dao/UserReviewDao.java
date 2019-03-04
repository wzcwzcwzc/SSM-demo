package com.ssmdemo.dao;

import com.ssmdemo.dao.entity.UserReviewEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserReviewDao {

    List<UserReviewEntity> getReviewByDocId(@Param("docId") String docId);

    List<UserReviewEntity> getMarkByDocId(@Param("docId") String docId);

    List<UserReviewEntity> getDocReviewAndMarkByDocId(@Param("docId") String docId);

}
