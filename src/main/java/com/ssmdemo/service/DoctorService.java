package com.ssmdemo.service;

import com.ssmdemo.common.ServerResponse;
import com.ssmdemo.dao.entity.DoctorEntity;

import java.util.List;
import java.util.Map;

public interface DoctorService {

    ServerResponse<List<DoctorEntity>> getDocByUserFilter(String department, Double userLat, Double userLng, String startTime, String endTime, String language);

    ServerResponse<List<DoctorEntity>> addressFilter(Double userLat, Double userLng);

    ServerResponse<List<DoctorEntity>> getDocInfoByLanguage(String language);

    ServerResponse<Map<String, Double>> getDocReviewAndMarkWithModel(String department, Double userLat, Double userLng, String startTime, String endTime, String language);


}
