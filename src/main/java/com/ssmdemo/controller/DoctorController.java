package com.ssmdemo.controller;

import com.ssmdemo.common.ServerResponse;
import com.ssmdemo.dao.entity.DoctorEntity;
import com.ssmdemo.service.DoctorService;
import com.ssmdemo.service.UserReviewService;
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
@RequestMapping("/doc")

public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @RequestMapping(value = "/userFilter.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<DoctorEntity>> getDocByUserFilter(@RequestParam("department") String department, @RequestParam("userLat") String userLat,
                                                                 @RequestParam("userLng") String userLng, @RequestParam("startTime") String startTime,
                                                                 @RequestParam("endTime") String endTime, @RequestParam("language") String language) {
        ServerResponse<List<DoctorEntity>> response =
                doctorService.getDocByUserFilter(department, Double.parseDouble(userLat), Double.parseDouble(userLng), startTime, endTime, language);
        return response;
    }

    @RequestMapping(value = "/modelFilter.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Map<String, Double>> getModelFilterResult(@RequestParam("department") String department, @RequestParam("userLat") String userLat,
                                                                     @RequestParam("userLng") String userLng, @RequestParam("startTime") String startTime,
                                                                     @RequestParam("endTime") String endTime, @RequestParam("language") String language){
        ServerResponse<Map<String, Double>> response =
                doctorService.getDocReviewAndMarkWithModel(department, Double.parseDouble(userLat), Double.parseDouble(userLng), startTime, endTime, language);
        return response;
    }


    @RequestMapping(value = "/languageFilter.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<DoctorEntity>> languageFilter(@RequestParam("language") String language){
        ServerResponse<List<DoctorEntity>> response =  doctorService.getDocInfoByLanguage(language);
        return response;
    }

    @RequestMapping(value = "/addressFilter.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<DoctorEntity>> addressFilter(@RequestParam("userLat") String userLat, @RequestParam("userLng") String userLng){
        //需要先从列表里获取到医生的地理位置信息
        ServerResponse<List<DoctorEntity>> response =
                doctorService.addressFilter(Double.parseDouble(userLat), Double.parseDouble(userLng));
        return response;
    }
}
