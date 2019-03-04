package com.ssmdemo.controller;

import com.ssmdemo.common.ServerResponse;
import com.ssmdemo.dao.entity.UserReviewEntity;
import com.ssmdemo.service.DoctorService;
import com.ssmdemo.service.UserReviewService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


@Component
@Controller
@RequestMapping("/review")

public class UserReviewController {

    @Autowired
    private DoctorService doctorService;


    @RequestMapping(value = "/modelFilter.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Map<String, Double>> modelFilter(@RequestParam("department") String department, @RequestParam("userLat") String userLat,
                                                           @RequestParam("userLng") String userLng, @RequestParam("startTime") String startTime,
                                                           @RequestParam("endTime") String endTime, @RequestParam("language") String language){


        ServerResponse<Map<String, Double>> response = doctorService.getDocReviewAndMarkWithModel(department, Double.parseDouble(userLat), Double.parseDouble(userLng), startTime, endTime, language);
        return response;
    }
}
