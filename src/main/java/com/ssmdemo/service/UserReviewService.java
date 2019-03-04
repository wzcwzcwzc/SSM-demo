package com.ssmdemo.service;

import com.ssmdemo.common.ServerResponse;
import com.ssmdemo.dao.entity.DoctorEntity;
import com.ssmdemo.dao.entity.UserReviewEntity;

import java.util.List;
import java.util.Map;

public interface UserReviewService {

    ServerResponse<List<UserReviewEntity>> getDocReviewByDocId(String docId);

    ServerResponse<List<UserReviewEntity>> getDocMarkByDocId(String docId);

    double getDocReviewAndMarkByDocId(String docId);

    Map<String, Double> getDocReviewAndMarkWithListDocId(List<String> doctorEntityList);

}
