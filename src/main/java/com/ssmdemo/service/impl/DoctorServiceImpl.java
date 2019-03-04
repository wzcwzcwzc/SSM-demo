package com.ssmdemo.service.impl;

import com.ssmdemo.common.ServerResponse;
import com.ssmdemo.dao.DoctorDao;
import com.ssmdemo.dao.UserReviewDao;
import com.ssmdemo.dao.entity.DoctorEntity;
import com.ssmdemo.dao.entity.UserReviewEntity;
import com.ssmdemo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Resource
    private DoctorDao doctorDao;
    @Resource
    private UserReviewDao userReviewDao;
    @Autowired
    private List<DoctorEntity> doctorEntityList;
    @Autowired
    private List<UserReviewEntity> userReviewEntityList;

    @Override
    public ServerResponse<List<DoctorEntity>> getDocByUserFilter(String department, Double userLat, Double userLng, String startTime, String endTime, String language){

        doctorEntityList = doctorDao.getDocByUserFilter(department, userLat, userLng, startTime, endTime, language);

        if(!doctorEntityList.isEmpty()) {
            return ServerResponse.createBySuccess(doctorEntityList);
        }else{
            return  ServerResponse.createByErrorMessage("getDocByUserFilter failed");
        }

    }

    @Override
    public ServerResponse<Map<String, Double>> getDocReviewAndMarkWithModel(String department, Double userLat, Double userLng, String startTime, String endTime, String language) {

        //第一步筛选工作
        doctorEntityList = doctorDao.getDocByUserFilter(department, userLat, userLng, startTime, endTime, language);


        //加入算法模型进行第二步筛选
        if (doctorEntityList != null) {
            //通过医生的ID再进行二次筛选，从数据库中将对医生ID对应的数据作为对象取出放到对象数组里
            //数组的每个元素都是一个UserReviewEntity对象，通过把对象的Mark和review取出放入数组
            //model接收的数据将是Mark与review的两个数组，模型返回的值是Mark与review的综合值

            List<String> docIdList = doctorEntityList.stream().map(DoctorEntity::getDocid).collect(Collectors.toList());
            Map<String, Double> finalDocIdMarkMap = new HashMap<>(docIdList.size());
            double totalMark;
            Integer[] markArray;
            String[] reviewArray;

            int k = 0;
            while(k < docIdList.size()){

                userReviewEntityList = userReviewDao.getDocReviewAndMarkByDocId(docIdList.get(k));

                markArray = new Integer[userReviewEntityList.size()];
                reviewArray = new String[userReviewEntityList.size()];

                for(int i = 0; i < userReviewEntityList.size(); i++){

                    markArray[i] = userReviewEntityList.get(i).getMark();
                    reviewArray[i] = userReviewEntityList.get(i).getReview();
                    System.out.println("docId: " + docIdList.get(k) + " " + "Mark: " + markArray[i] + " " + "review: " + reviewArray[i]);

                }

//                double totalMark = modelFunction(markArray[i], reviewArray[i]))
                try {
                    System.out.println("start");

                    String[] args = new String[]{"python", "/Users/wzc/Library/Preferences/PyCharm2018.2/scratches/scratch.py"};
                    Process pr = Runtime.getRuntime().exec(args);

                    BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
                    String line;
                    while ((line = in.readLine()) != null) {
                        System.out.println(line);
                    }

                    in.close();
                    pr.waitFor();
                    System.out.println("end");
                }catch(Exception e){
                    e.printStackTrace();
                }

                k++;
            }

//            boolean[] boolArray = new boolean[] { true, false, true };
//
//            JSONArray jsonArray = JSONArray.fromObject(boolArray);
//            //JSONArray.
//            String s = jsonArray.toString();
//            System.out.println(s);
//
//            // 通过json获取数组中的数据
//            String result = readJson("configdata");
//
//            JSONArray jsonR = JSONArray.fromObject(result);
//            int size = jsonR.size();
//            for (int i = 0; i < size; i++) {
//                System.out.println(jsonR.get(i));
//            }


            Iterator iter = finalDocIdMarkMap.entrySet().iterator();
            while(iter.hasNext()){
                Map.Entry entry = (Map.Entry) iter.next();
                Object docId = entry.getKey();
                Object finalDocMark = entry.getValue();
                System.out.println(docId+":"+finalDocMark);
            }

            return ServerResponse.createBySuccess(finalDocIdMarkMap);

        } else {
            return ServerResponse.createByErrorMessage("getDocReviewAndMarkWithModel failed");
        }
    }

    @Override
    public ServerResponse<List<DoctorEntity>> getDocInfoByLanguage(String language) {

        doctorEntityList = doctorDao.getDocInfoByLanguage(language);

        if (doctorEntityList != null) {

            return ServerResponse.createBySuccess(doctorEntityList);
        } else {
            return ServerResponse.createByErrorMessage("getDocInfoByLanguage failed");
        }
    }

    //内部实现距离的测算，在一定范围内的医生从数据库中选择出来

    @Override
    public ServerResponse<List<DoctorEntity>> addressFilter(Double userLat, Double userLng) {

        doctorEntityList = doctorDao.getDocByUserPosition(userLat, userLng);

        if (doctorEntityList != null) {
            return ServerResponse.createBySuccess(doctorEntityList);
        } else {
            return ServerResponse.createByErrorMessage("addressFilter failed");
        }
    }

}


