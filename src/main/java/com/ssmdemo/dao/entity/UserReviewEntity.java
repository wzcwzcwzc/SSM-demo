package com.ssmdemo.dao.entity;

import org.springframework.stereotype.Component;

@Component
public class UserReviewEntity {

    private String uid;
    private String docid;
    private Integer mark;
    private String review;

    public UserReviewEntity(){

    }

    public UserReviewEntity(String uid, String docid, Integer mark, String review) {
        this.uid = uid;
        this.docid = docid;
        this.mark = mark;
        this.review = review;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
