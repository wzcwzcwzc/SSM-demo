package com.ssmdemo.service.impl;

import com.ssmdemo.common.ServerResponse;
import com.ssmdemo.dao.UserReviewDao;
import com.ssmdemo.dao.entity.UserReviewEntity;
import com.ssmdemo.service.UserReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserReviewServiceImpl implements UserReviewService {

    @Resource
    private UserReviewDao userReviewDao;
    @Autowired
    private List<UserReviewEntity> userReviewEntityList;

    @Override
    public ServerResponse<List<UserReviewEntity>> getDocReviewByDocId(String docId){

        userReviewEntityList = userReviewDao.getReviewByDocId(docId);
        if(docId != null){
            return ServerResponse.createBySuccess(userReviewEntityList);
        }else{
            return ServerResponse.createByErrorMessage("getDocReviewByDocId failed");
        }
    }

    @Override
    public ServerResponse<List<UserReviewEntity>> getDocMarkByDocId(String docId){

        userReviewEntityList = userReviewDao.getMarkByDocId(docId);
        //将获取的List的每个值传到Model里进行处理
        if(docId != null){
            return ServerResponse.createBySuccess(userReviewEntityList);
        }else {
            return ServerResponse.createByErrorMessage("getDocMarkByDocId failed");
        }
    }

    //第一步筛选结束后，将第一步筛选的结果逐个传递到getDocReviewAndMarkByDocId

    @Override
    public double getDocReviewAndMarkByDocId(String docId) {
///        userReviewEntityList = userReviewDao.getDocReviewAndMarkByDocId(docId);
//        if(docId != null){
//            int[] markArray = new int[userReviewEntityList.size()];
//            String[] reviewArray = new String[userReviewEntityList.size()];
//            for(int i= 0; i < userReviewEntityList.size(); i++){
//                markArray[i] = userReviewEntityList.get(i).getMark();
//                reviewArray[i] = userReviewEntityList.get(i).getReview();
//            }
//            //todo 调用语义分析函数，将参数传入之后返回语义分析得分，至于传入参数的格式为数组,java内调用python函数
//            return 1.1;
//        }else{
//            return 0.0;
//    }
        return 1.1;
    }

    @Override
    public Map<String, Double> getDocReviewAndMarkWithListDocId(List<String> docIdList) {

        Map<String, Double> modelResultMap = new HashMap<>(docIdList.size());

        if(!docIdList.isEmpty()) {
            for (int i = 0; i < docIdList.size(); i++) {
                modelResultMap.put(docIdList.get(i), getDocReviewAndMarkByDocId(docIdList.get(i)));
            }
        }
        return modelResultMap;
    }

}
