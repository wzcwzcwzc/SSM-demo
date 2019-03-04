package com.ssmdemo.dao;

import com.ssmdemo.dao.entity.DoctorEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DoctorDao {


    List<DoctorEntity> getDocByUserFilter(@Param("department") String department, @Param("userLat") Double userLat,
                                          @Param("userLng") Double userLng, @Param("startTime") String startTime,
                                          @Param("endTime") String endTime, @Param("language") String language);

    List<DoctorEntity> getDocByUserPosition(@Param("userLat") Double userLat, @Param("userLng") Double userLng);


    List<DoctorEntity> getDocInfoByLanguage(@Param("language") String language);

}
